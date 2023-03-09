package com.plateformeweb.orientation.etudiant.ml.Services;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.AbstractFileResolvingResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.plateformeweb.orientation.etudiant.ml.Entity.ConstUtil;
import com.plateformeweb.orientation.etudiant.ml.Entity.Users;
import com.plateformeweb.orientation.etudiant.ml.Entity.UsersComplet;
import com.plateformeweb.orientation.etudiant.ml.Exception.UserNotFoundException;
import com.plateformeweb.orientation.etudiant.ml.Repository.StorageService;
import com.plateformeweb.orientation.etudiant.ml.Repository.UsersRepository;
import com.plateformeweb.orientation.etudiant.ml.Security.SecurityConfig;


@Service
public class UsersService<ServletContext> implements StorageService{
	private Path rootLocation = null;
	@Autowired
	UsersRepository usersRepository;

	@Autowired
	public UsersService() {
		this.rootLocation = Paths.get("./Stockage/");
	}
	public Users getUserByEmailAndPassword(String email,String password) {
		
		Users user = usersRepository.findUsersByAdresseEmailUserAndPasswordUser(email,SecurityConfig.crypt(password)).orElseThrow (() -> new UserNotFoundException("User d'addresse Email : " + email+" Password :"+password+ "not found"));
		return user;
	}
	public String getTypeUserByEmailAndPassword(String email,String password) {
			Users user = getUserByEmailAndPassword(email,password);
			
			if(user.getTypeUsers().equalsIgnoreCase("etudiant")) {
				return "{\"message\":\"Etudiant\"}";
			}else if(user.getTypeUsers().equalsIgnoreCase("entreprise")) {
				return "{\"message\":\"Entreprise\"}";
			}else if(user.getTypeUsers().equalsIgnoreCase("universite")) {
				return "{\"message\":\"Universite\"}";
			}
			else if(user.getTypeUsers().equalsIgnoreCase("administrateur"))
				return "{\"message\":\"Administrateur\"}";
			
			else
				return "null";
	}
	public Users addUser(Users users) {
		return usersRepository.save(users);
	}
	public Users addUsers(UsersComplet users) {
		Users user = new Users();
		user.setAdresseEmailUser(users.getAdresseEmailUser());
		user.setAdresseUsers(users.getAdresseUsers());
		user.setPasswordUser(users.getPasswordUser());
		user.setNameUsers(users.getNameUsers());
		user.setTelUsers(users.getTelUsers());
		user.setTypeUsers(users.getTypeUsers());
		String originalFileName = StringUtils.cleanPath(users.getImageUser().getOriginalFilename());
		String fileExtension = "";
        try {
            fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        } catch (Exception e) {
            fileExtension = "";
        }
		String fileName = "image" + UUID.randomUUID().toString().replace("-", "") + "" + fileExtension;
        FileManageService.saveFile(fileName,users.getImageUser());
        user.setImageUser(fileName);
		return usersRepository.save(user);
	}
	public String passwordUserCrypt(Users users) {
		return SecurityConfig.crypt(users.getPasswordUser()); 
	}
	public Users updateUsers(Users users) {
		return usersRepository.save(users);
	}

	public List<Users> getAllUsers(){
		return usersRepository.findAll();
	}
	public Users getUsersById(Long id) {
		return usersRepository.findUsersById(id)
				.orElseThrow(() ->new UserNotFoundException("Cet User d'identifiant : " + id + "n'existe pas sorry"));
	}
	public Users getUsersByEmails(String email) {
		Users users = usersRepository.findUsersByAdresseEmailUser(email).orElseThrow(() -> new UserNotFoundException("L'utilisateur d'addresse email :" + email + "n'existe pas sorry"));
		return users;
	}
	public Users getUsersByPassword(String password) {
		return usersRepository.findUsersByPasswordUser(SecurityConfig.crypt(password)).orElseThrow(() -> new UserNotFoundException("L'utilisateur de Mot de passe :" + password +"n'existe pas sorry"));
	}
	public void deleteUsers(Long id) {
		usersRepository.deleteById(id);
	}
	@Override
	@PostConstruct
	public void init() {
		try {
			Files.createDirectories(rootLocation);
		    } catch (IOException e) {}
	}
	@Override
	public String store(MultipartFile file) {
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		  try {
		  if (file.isEmpty()) {}  
		  if (filename.contains("..")) { }
		   try (InputStream inputStream = file.getInputStream()) {
		    Files.copy(inputStream, this.rootLocation.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
		    }
		   } catch (IOException e) {	}
		   return filename;
	}
	@Override
	public Stream<Path> loadAll() {
		try {
		    return Files.walk(this.rootLocation, 1).filter(path -> !path.equals(this.rootLocation)).map(this.rootLocation::relativize);
		 } catch (IOException e) {	return null; }
	}
	@Override
	public Path load(String filename) {
		return rootLocation.resolve(filename);
	}
	@Override
	public Resource loadAsResource(String filename) {
		Path file = load(filename);
		  Resource resource = null;
		  try {
		     resource = (Resource) new UrlResource(file.toUri());
		   if (((AbstractFileResolvingResource) resource).exists() || ((AbstractFileResolvingResource) resource).isReadable()) {
		      return resource;
		   } else {
		     System.out.println("File not found " + filename); 
		   }
		  } catch (MalformedURLException e) { }
				return resource;
	}
	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}
}

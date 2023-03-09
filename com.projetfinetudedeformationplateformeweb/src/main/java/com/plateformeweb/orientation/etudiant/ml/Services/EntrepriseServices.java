package com.plateformeweb.orientation.etudiant.ml.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.plateformeweb.orientation.etudiant.ml.Entity.Entreprise;
import com.plateformeweb.orientation.etudiant.ml.Entity.EntrepriseComplet;
import com.plateformeweb.orientation.etudiant.ml.Entity.Users;
import com.plateformeweb.orientation.etudiant.ml.Exception.UserNotFoundException;
import com.plateformeweb.orientation.etudiant.ml.Repository.EntrepriseRepository;

@Service
public class EntrepriseServices {
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private UsersService usersService;
	
	public Entreprise ajouterEntreprise(Entreprise entreprise) {
		entreprise.setTypeUsers("Entreprise");
		//entreprise.setPasswordUser(SecurityConfig.crypt(entreprise.getPasswordUser()));
		return entrepriseRepository.save(entreprise);
	}
	public Entreprise ajouterEntreprises(EntrepriseComplet entreprises) {
		Entreprise entreprise =new Entreprise();
		entreprise.setNameUsers(entreprises.getNameUsers());
		entreprise.setAdresseEmailUser(entreprises.getAdresseEmailUser());
		entreprise.setPasswordUser(entreprises.getPasswordUser());
		entreprise.setAdresseUsers(entreprises.getAdresseUsers());
		entreprise.setTelUsers(entreprises.getTelUsers());
		entreprise.setDescriptionEntreprise(entreprises.getDescriptionEntreprise());
		entreprise.setSecteurActivite(entreprises.getSecteurActivite());
		entreprise.setSiren(entreprises.getSiren());
		entreprise.setSitesEntreprise(entreprises.getSitesEntreprise());
		entreprise.setSlogantEntreprise(entreprises.getSlogantEntreprise());
		entreprise.setRegion(entreprises.getRegion());
		entreprise.setTypeUsers(entreprises.getTypeUsers());
		String originalFileName = StringUtils.cleanPath(entreprises.getImageUser().getOriginalFilename());
		String fileExtension = "";
        try {
            fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        } catch (Exception e) {
            fileExtension = "";
        }
		String fileName = "image" + UUID.randomUUID().toString().replace("-", "") + "" + fileExtension;
        FileManageService.saveFile(fileName,entreprises.getImageUser());
        entreprise.setImageUser(fileName);
		return entrepriseRepository.save(entreprise);
	}
	public List<Entreprise> getEntreprises()
	{
		return entrepriseRepository.findAll();
	}
	public Entreprise getEntreprisesById(Long id) {
		return entrepriseRepository.findEntrepriseById(id).orElseThrow(() -> new UserNotFoundException("Cette entreprise d'identifiant" + id+ "n'existe pas..."));
	}
	public Entreprise updateEntreprises(Entreprise entreprise) {
		return entrepriseRepository.save(entreprise);
	}
	public void deleteEntrepriseById(Long id) {
		entrepriseRepository.deleteById(id);
	}
	public Entreprise findEntrepriseByEmail(String email) {
		Users user = usersService.getUsersByEmails(email);
		System.out.println(user);
		if(user.getTypeUsers().compareTo("Entreprise") == 0) {
			Entreprise entreprise = (Entreprise) usersService.getUsersByEmails(email);
			return entreprise;
		}
		return null;
	
	}
	
}

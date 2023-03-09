package com.plateformeweb.orientation.etudiant.ml.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.plateformeweb.orientation.etudiant.ml.Entity.Universite;
import com.plateformeweb.orientation.etudiant.ml.Entity.UniversiteComplet;
import com.plateformeweb.orientation.etudiant.ml.Exception.UserNotFoundException;
import com.plateformeweb.orientation.etudiant.ml.Repository.UniversiteRepository;

@Service
public class UniversiteServices {
	@Autowired
	private UniversiteRepository universiteRepository;
	
	public Universite getUniversitesById(Long id) {
		return universiteRepository.findUniversiteById(id).orElseThrow(() ->new UserNotFoundException("Cette universite d'identifiant :" + id+ "n'existe pas sorry..."));
	}
	public List<Universite> getUniversite() {
		return universiteRepository.findAll();
	}
	public Universite addUniversite(Universite universite) {
		universite.setTypeUsers("Universite");
		return universiteRepository.save(universite);
	}
	public Universite addUniversites(UniversiteComplet universites) {
		Universite universite = new Universite();
		universite.setNameUsers(universites.getNameUsers());
		universite.setAdresseEmailUser(universites.getAdresseEmailUser());
		universite.setAdresseUsers(universites.getAdresseUsers());
		universite.setPasswordUser(universites.getPasswordUser());
		universite.setTelUsers(universites.getTelUsers());
		universite.setDescriptionuniversite(universites.getDescriptionuniversite());
		universite.setAbregeUniversite(universites.getAbregeUniversite());
		universite.setSiret(universites.getSiret());
		universite.setSiteUniversite(universites.getSiteUniversite());
		universite.setRegion(universites.getRegion());
		universite.setVilleUniversite(universites.getVilleUniversite());;
		universite.setTypeUsers(universites.getTypeUsers());
		String originalFileName = StringUtils.cleanPath(universites.getImageUser().getOriginalFilename());
		String fileExtension = "";
        try {
            fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        } catch (Exception e) {
            fileExtension = "";
        }
		String fileName = "image" + UUID.randomUUID().toString().replace("-", "") + "" + fileExtension;
        FileManageService.saveFile(fileName,universites.getImageUser());
        universite.setImageUser(fileName);
		return universiteRepository.save(universite);
	}
	public Universite updateUniversite(Universite universite) {
		universite.setTypeUsers("Universite");
		return universiteRepository.save(universite);
	}
	public Universite getUniversiteByEmail(String email) {
		return universiteRepository.findUniversiteByAdresseEmailUser(email).orElseThrow(() -> new UserNotFoundException("Cette universite d'emeil :"+ email+ "n'existe pas sorry"));
	}
	public void deleteUniversite(Long id) {
		universiteRepository.deleteById(id);
	}
}

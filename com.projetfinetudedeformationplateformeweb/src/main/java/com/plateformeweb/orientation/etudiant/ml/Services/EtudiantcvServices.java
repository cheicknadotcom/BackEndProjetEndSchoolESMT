package com.plateformeweb.orientation.etudiant.ml.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.plateformeweb.orientation.etudiant.ml.Entity.Etudiant;
import com.plateformeweb.orientation.etudiant.ml.Entity.EtudiantCv;
import com.plateformeweb.orientation.etudiant.ml.Entity.EtudiantCvComplet;
import com.plateformeweb.orientation.etudiant.ml.Exception.UserNotFoundException;
import com.plateformeweb.orientation.etudiant.ml.Repository.EtudiantCvRepository;

@Service
public class EtudiantcvServices {
	@Autowired
	EtudiantCvRepository etudiantcvRepository;
	
	Etudiant etudiant;
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	
	public EtudiantCv addEtudiantcv(EtudiantCv etudiantcv) {
		return etudiantcvRepository.save(etudiantcv);
	}
	public EtudiantCv addEtudiantscv(EtudiantCvComplet etudiant) {
		EtudiantCv etudiantcv = new EtudiantCv();
		etudiantcv.setExperience(etudiant.getExperience());
		etudiantcv.setConnaissance(etudiant.getConnaissance());
		etudiantcv.setDiplome(etudiant.getDiplome());
		etudiantcv.setSpecialite(etudiant.getSpecialite());
		etudiantcv.setTel(etudiant.getTel());
		etudiantcv.setEtudiant(etudiant.getEtudiant());
		String originalFileName = StringUtils.cleanPath(etudiant.getFichierCv().getOriginalFilename());
		String fileExtension = "";
        try {
            fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        } catch (Exception e) {
            fileExtension = "";
        }
		String fileName = "image" + UUID.randomUUID().toString().replace("-", "") + "" + fileExtension;
        FileManageService.saveFile(fileName,etudiant.getFichierCv());
        etudiantcv.setFichierCv(fileName);
		return etudiantcvRepository.save(etudiantcv);
	}
	public EtudiantCv updateEtudiantCv(EtudiantCv etudiantcv) {
		return etudiantcvRepository.save(etudiantcv);
	}
	public List<EtudiantCv> getAllEtudiantCv(){
		return etudiantcvRepository.findAll();
	}
	public EtudiantCv findEtudiantCvByDiplome(String diplome) {
	 return etudiantcvRepository.findEtudiantCvByDiplome(diplome).orElseThrow(() -> new UserNotFoundException("Cet Cv d'etudiant de diplome :" + diplome+ "n'existe pas ...."));
	}
	public EtudiantCv findEtudiantByExperience(String experience) {
		return etudiantcvRepository.findEtudiantCvByExperience(experience).orElseThrow(() -> new UserNotFoundException("Cet Cv d'etudiant d'experience :" + experience+ "n'existe pas ...."));
	}
}

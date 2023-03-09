package com.plateformeweb.orientation.etudiant.ml.Entity;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class EtudiantCvComplet {
	private Long id;
	private String diplome;
	private String specialite;
	private String experience;
	private String connaissance;
	private String tel;
	private MultipartFile fichierCv;
	private Etudiant etudiant;
	public EtudiantCvComplet(String diplome, String specialite, String experience, String connaissance, String tel,
			MultipartFile fichierCv) {
		super();
		this.diplome = diplome;
		this.specialite = specialite;
		this.experience = experience;
		this.connaissance = connaissance;
		this.tel = tel;
		this.fichierCv = fichierCv;
	}
}

package com.plateformeweb.orientation.etudiant.ml.Entity;

import java.io.File;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name = "TableEtudiantcv")
@Data @AllArgsConstructor @NoArgsConstructor
public class EtudiantCv implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "Diplome")
	private String diplome;
	@Column(name = "Specialite")
	private String specialite;
	@Column(name = "Experience")
	private String experience;
	@Column(name = "Connaissance")
	private String connaissance;
	@Column(name = "Telephone")
	private String tel;
	@Column(name = "FichierCv")
	private String fichierCv;
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn (name="etudiant_cv_id")
	private Etudiant etudiant;
	public EtudiantCv(String diplome,String specialite,String experience,String connaissance,String phone,String file) {
		this.diplome = diplome;
		this.specialite = specialite;
		this.experience = experience;
		this.connaissance = connaissance;
		this.tel = phone;
		this.fichierCv = file;
	}

	public EtudiantCv(Long id,String diplome,String specialite,String experience,String connaissance,String phone,String file) {
		this(diplome,specialite,experience,connaissance,phone,file);
		this.id = id;
	}

}

package com.plateformeweb.orientation.etudiant.ml.Entity;

import java.io.File;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name = "T_DemandesEmploi")
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class DemandeEmploi extends Demande implements Serializable {
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn (name="demande_emploi_id")
	EtudiantCv etudiantcv;
	String tel;
	File cv;
	String emailEntreprise;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone = "GMT")
	private Date dateDepot;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn (name="demande_emploi_lettreDeMotivation")
	LettreDeMotivation lettreDeMotivation;
	@JoinColumn (name="demande_emploi_entreprise")
	Entreprise entreprise;
	@SuppressWarnings("static-access")
	public DemandeEmploi(String type,String emailEtudiant,Etudiant etudiant,EtudiantCv etudiantcv,Entreprise entreprise) {
		super(type,emailEtudiant, etudiant);
		this.etudiantcv = etudiantcv;
		this.entreprise = entreprise;
		this.setDateDepot(Date.from(Calendar.getInstance().toInstant().now()));
	}
	public DemandeEmploi(String type,Date date,String emailEtudiant,Etudiant etudiant,EtudiantCv etudiantcv,LettreDeMotivation lettreDeMotivation,Entreprise entreprise) {
		this(type,emailEtudiant,etudiant,etudiantcv,entreprise);
		this.lettreDeMotivation = lettreDeMotivation;
	}
	@SuppressWarnings("static-access")
	public DemandeEmploi(String nom,String prenom,String emailEtudiant,String type,File cv,String emailUniversite) {
		super(nom,prenom,emailEtudiant,type);
		this.cv =cv;
		this.emailEntreprise = emailUniversite;
		this.setDateDepot(Date.from(Calendar.getInstance().toInstant().now()));
	}

	public DemandeEmploi(String nom,String prenom,String emailEtudiant,String type,File cv,String emailUniversite,String tel) {
		this(nom,prenom,emailEtudiant,type,cv,emailUniversite);
		this.tel = tel;
		this.setDateDepot(Calendar.getInstance().getTime());
	}
}

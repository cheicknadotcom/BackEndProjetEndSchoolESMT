package com.plateformeweb.orientation.etudiant.ml.Entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name = "T_DemandesInscription")
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class DemandeInscription extends Demande implements Serializable {
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone = "GMT")
	private Date dateInscription;
	@Column(name = "CodeClasse")
	private String codeClasse;
	@Column(name = "Montant")
	private double montant;
	@Column(name = "NomFiliere")
	private String nomFiliere;
	@Column(name = "Specialite")
	String specialite;
	@Column(name = "NiveauEtude")
	String niveauEtude;
	@Column(name = "NomUniversite")
	String nomniversite;
	@Column(name = "EmailUniversite")
	String emailUniversite;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone = "GMT")
	private Date dateVersement;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "universite_id",referencedColumnName = "id")
	private Universite universite;
	@SuppressWarnings("static-access")
	public DemandeInscription(Long id,String typeDemande,Etudiant etudiant,Universite universite) {
		super(id,typeDemande,etudiant);
		this.setDateInscription(Date.from(Calendar.getInstance().toInstant().now()));
		this.universite = universite;
	}
	@SuppressWarnings("static-access")
	public DemandeInscription(String nom,String prenom,String specialite,String niveau,Date datedepot,String emailEtudiant,String type,String nomFiliere,String nomniversite,String emailUniversite) {
		super(nom,prenom,type,emailEtudiant);
		this.specialite =specialite;
		this.niveauEtude = niveau;
		this.universite = new Universite(nomniversite,emailUniversite,nomFiliere);
		this.setDateInscription(Date.from(Calendar.getInstance().toInstant().now()));
	}

@SuppressWarnings("static-access")
public DemandeInscription(String nom,String prenom,String specialite,String niveau,Date datedepot,String statut,String type,String emailEtudiant,String nomFiliere,String nomniversite,String emailUniversite) {
	super(nom,prenom,type,emailEtudiant);
	this.specialite =specialite;
	this.niveauEtude = niveau;
	this.universite = new Universite(nomniversite,emailUniversite,nomFiliere);
	this.setDateInscription(Date.from(Calendar.getInstance().toInstant().now()));
}
}

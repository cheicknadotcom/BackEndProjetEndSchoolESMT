package com.plateformeweb.orientation.etudiant.ml.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@SuppressWarnings("serial")
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Demande implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	String nomEtudiant;
	String prenomEtudiant;
	private String typeDemande;
	@Column(name = "Status")
	private String status;
	@Column(name = "EmailEtudiant")
	private String emailEtudiant;
	@JoinColumn (name="demande_id")
	Etudiant etudiant;
	public Demande(Long id,String type,Etudiant etudiant) {
		this.id = id;
		this.typeDemande = type;
		this.etudiant = etudiant;
	}
	public Demande(String type,String emailEtudiante,Etudiant etudiant) {
		this.typeDemande = type;
		this.etudiant = etudiant;
		this.emailEtudiant = emailEtudiante;
		this.setStatus("Nouveau");
		
	}
	
//	public Demande(String nomEtudiant,String prenomEtudiant,String specialite,String niveau,String status,String type) {
//		this(type,status,new Etudiant(nomEtudiant,prenomEtudiant,specialite,niveau));
//	}
	public Demande(String nomEtudiant, String prenomEtudiant, String typeDemande, String emailEtudiant) {
		super();
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
		this.typeDemande = typeDemande;
		this.emailEtudiant = emailEtudiant;
		this.setStatus("Nouveau");
	}
	
}

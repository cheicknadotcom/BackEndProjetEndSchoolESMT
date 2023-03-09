package com.plateformeweb.orientation.etudiant.ml.Entity;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor @NoArgsConstructor
public class EtudiantComplet extends UsersComplet{

	private String matricule;
	private String prenomEtudiant;
	private String codePostal;
	private String villeEtudiant;
	private String lieuDeNaissance;
	private TypeEtudiant typeEtudiant;
	private String nomPere;
	private String profPere;
	private String nomMere;
	private String profMere;
	private String tuteur;
	private String profTuteur;
	private String quartier;
	private String carre;
	private String concession;
	private String codeClasse;
	private String codeEtablissement;
	private String etablissement;
	private String classe;
	private String cintuteur;
	private Genre genre;
	private String codeNationalite;
	private String telTuteur;
	private int anneeEntreEtudiant;
	private String domaineExercer;
	private String specialite;
	private String niveauEtude;
}

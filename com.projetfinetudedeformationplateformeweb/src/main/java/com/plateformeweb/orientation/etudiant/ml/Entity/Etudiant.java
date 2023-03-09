package com.plateformeweb.orientation.etudiant.ml.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name = "T_Etudiant",uniqueConstraints = {@UniqueConstraint(columnNames = "matricule"),@UniqueConstraint(columnNames = "codeNationalite")})
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Etudiant extends Users {
	@Column(name = "matricule")
	private String matricule;
	@Column(name = "prenomEtudiant")
	private String prenomEtudiant;
	@Column(name = "codePostal")
	private String codePostal;
	@Column(name = "ville")
	private String villeEtudiant;
	@Column(name = "lieuNaissance")
	private String lieuDeNaissance;
	@Column(name = "TypeEtudiant")
	private TypeEtudiant typeEtudiant;
	@Column(name = "nomPere")
	private String nomPere;
	@Column(name = "profPere")
	private String profPere;
	@Column(name = "nomMere")
	private String nomMere;
	@Column(name = "profMere")
	private String profMere;
	@Column(name = "tuteur")
	private String tuteur;
	@Column(name = "profTuteur")
	private String profTuteur;
	@Column(name = "quartier")
	private String quartier;
	@Column(name = "carre")
	private String carre;
	@Column(name = "concession")
	private String concession;
	@Column(name = "codeClasse")
	private String codeClasse;
	@Column(name = "codeEtablissmente")
	private String codeEtablissement;
	@Column(name = "etablissement")
	private String etablissement;
	@Column(name = "classe")
	private String classe;
	@Column(name = "cintuteur")
	private String cintuteur;
	@Column(name = "Genre")
	private Genre genre;
	@Column(name = "codeNationalite")
	private String codeNationalite;
	@Column(name = "telTuteur")
	private String telTuteur;
	@Column(name = "anneeEntreEtudiant")
	private int anneeEntreEtudiant;
	@Column(name = "DomaineExercer")
	private String domaineExercer;
	@Column(name = "Specialite")
	private String specialite;
	@Column(name = "NiveauEtude")
	private String niveauEtude;
	//private File imageFile;
	public Etudiant(String adresseEmailUser, String passwordUser, String prenomEtudiant, String villeEtudiant,
			String lieuDeNaissance, String classe, Genre genre, String codeNationalite, String telTuteur,
			int anneeEntreEtudiant, String domaineExercer) {
		super(adresseEmailUser, passwordUser);
		this.prenomEtudiant = prenomEtudiant;
		this.villeEtudiant = villeEtudiant;
		this.lieuDeNaissance = lieuDeNaissance;
		this.classe = classe;
		this.genre = genre;
		this.codeNationalite = codeNationalite;
		this.telTuteur = telTuteur;
		this.anneeEntreEtudiant = anneeEntreEtudiant;
		this.domaineExercer = domaineExercer;
	}
	public Etudiant(String nom,String type,String addresse,String tel,String adresseEmailUser, String passwordUser, String prenomEtudiant, String villeEtudiant,
			String lieuDeNaissance, Genre genre, String specialite, String niveauEtude,String  imageUser) {
		super(nom,type,addresse,tel,adresseEmailUser, passwordUser,imageUser);
		this.prenomEtudiant = prenomEtudiant;
		this.villeEtudiant = villeEtudiant;
		this.lieuDeNaissance = lieuDeNaissance;
		this.genre = genre;
		this.specialite = specialite;
		//this.imageFile = imageFile;
	}
	public Etudiant(String nom,String type,String addresse,String tel,String adresseEmailUser, String passwordUser,String  imageUser, String matricule, String prenomEtudiant,
			String codePostal, String villeEtudiant, String lieuDeNaissance, TypeEtudiant typeEtudiant, String nomPere,
			String profPere, String nomMere, String profMere, String tuteur, String profTuteur, String quartier,
			String carre, String concession, String codeClasse, String codeEtablissement, String etablissement,
			String classe, String cintuteur, Genre genre, String codeNationalite, String telTuteur,
			int anneeEntreEtudiant, String domaineExercer, String specialite, String niveauEtude) {
		this(nom,type,addresse,tel,adresseEmailUser,passwordUser,prenomEtudiant,villeEtudiant,lieuDeNaissance,genre,specialite,niveauEtude,imageUser);
		this.matricule = matricule;
		this.prenomEtudiant = prenomEtudiant;
		this.codePostal = codePostal;
		this.villeEtudiant = villeEtudiant;
		this.lieuDeNaissance = lieuDeNaissance;
		this.typeEtudiant = typeEtudiant;
		this.nomPere = nomPere;
		this.profPere = profPere;
		this.nomMere = nomMere;
		this.profMere = profMere;
		this.tuteur = tuteur;
		this.profTuteur = profTuteur;
		this.quartier = quartier;
		this.carre = carre;
		this.concession = concession;
		this.codeClasse = codeClasse;
		this.codeEtablissement = codeEtablissement;
		this.etablissement = etablissement;
		this.classe = classe;
		this.cintuteur = cintuteur;
		this.genre = genre;
		this.codeNationalite = codeNationalite;
		this.telTuteur = telTuteur;
		this.anneeEntreEtudiant = anneeEntreEtudiant;
		this.domaineExercer = domaineExercer;
		this.specialite = specialite;
		this.niveauEtude = niveauEtude;
	}
	public Etudiant(String nom,String adresseEmailUser, String passwordUser, String prenomEtudiant, String villeEtudiant,
			String lieuDeNaissance, String classe, Genre genre, String domaineExercer) {
		super(nom,adresseEmailUser);
		this.prenomEtudiant = prenomEtudiant;
		this.villeEtudiant = villeEtudiant;
		this.lieuDeNaissance = lieuDeNaissance;
		this.classe = classe;
		this.genre = genre;
		this.domaineExercer = domaineExercer;
	}
	public Etudiant(String adresse, String nom, String type,String tel, String prenomEtudiant, String villeEtudiant,
			String lieuDeNaissance, String classe, Genre genre, String domaineExercer) {
		super(adresse, nom, type, tel);
		this.prenomEtudiant = prenomEtudiant;
		this.villeEtudiant = villeEtudiant;
		this.lieuDeNaissance = lieuDeNaissance;
		this.classe = classe;
		this.genre = genre;
		this.domaineExercer = domaineExercer;
	}
	public Etudiant(String nomEtudiant, String prenomEtudiant2, String specialite2, String niveau) {
		super.setNameUsers(nomEtudiant);
		this.prenomEtudiant = prenomEtudiant2;
		this.specialite = specialite2;
		this.niveauEtude = niveau;
	}
	public Etudiant(String nom,String add,String type,String tel,String  image,String adresseEmailUser, String passwordUser, String prenomEtudiant, String lieuDeNaissance,
			Genre genre) {
		super(nom,type,add,tel,adresseEmailUser, passwordUser,image);
		this.prenomEtudiant = prenomEtudiant;
		this.lieuDeNaissance = lieuDeNaissance;
		this.genre = genre;
	}
	
}

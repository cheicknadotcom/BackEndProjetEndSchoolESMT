package com.plateformeweb.orientation.etudiant.ml.Entity;

import java.io.File;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import groovy.transform.ToString;
import lombok.Data;
import lombok.NoArgsConstructor;
@SuppressWarnings("serial")
@Entity
@Table(name = "T_OffresEmploi")
@Data @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class OffresEmploi extends EmploiOffres implements Serializable{
	@Column(name = "Horaire")
	private String horaire;
	@Column(name = "Telephone")
	private String tel;
	@Column(name = "EmailEntreprise")
	private String email;
	@Column(name = "Salaire")
	private double salaire;
	@Column(name = "SiteWebEntreprise")
	private String site;
	@Column(name = "Entreprise")
	private Entreprise entreprise;
	public OffresEmploi(String titre,String ref,String typePoste,String description,String diplome,String typeContrat,String horaire,Date dateEmbauche,String niveau,String connaissance,
			String region,Double salaire,Date dateOffres,String type) {
		super(titre,ref,typePoste,description,diplome,typeContrat,connaissance,region,niveau,dateOffres,dateEmbauche,type);
		this.horaire= horaire;
		this.salaire = salaire;
	}
	public OffresEmploi(String titre,String ref,String typePoste,String description,String diplome,String typeContrat,String horaire,Date dateEmbauche,String niveau,String connaissance,
			String region,Double salaire,Date dateOffres,String phoneEntreprise,String email,String siteweb,String  logo,String type) {
		this(titre,ref,typePoste,description,diplome,typeContrat,horaire,dateEmbauche,niveau,connaissance,region,salaire,dateOffres,type);
		this.entreprise.setAdresseEmailUser(email);
		this.entreprise.setSitesEntreprise(siteweb);
		this.entreprise.setImageUser(logo);
		this.entreprise.setTelUsers(phoneEntreprise);
	}
}

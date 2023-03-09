package com.plateformeweb.orientation.etudiant.ml.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import groovy.transform.ToString;
import lombok.Data;
import lombok.NoArgsConstructor;
@SuppressWarnings("serial")
@Entity
@Table(name = "T_OffresStage")
@Data  @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class OffresStage extends EmploiOffres implements Serializable {
	@Column(name = "DureStage")
	private String dureStage;
	@Column(name = "Entreprise")
	private Entreprise entreprise;
	public OffresStage(String titre,String ref,String typePoste,String description,String diplome,String typeContrat,String dureStage,Date dateEmbauche,String niveau,String connaissance,
			String region,Date dateOffres,String type) {
		super(titre,ref,typePoste,description,diplome,typeContrat,connaissance,region,niveau,dateOffres,dateEmbauche,type);
				this.dureStage = dureStage;
	}

	public OffresStage(String titre,String ref,String typePoste,String description,String diplome,String typeContrat,String dureStage,Date dateEmbauche,String niveau,String connaissance,
			String region,Date dateOffres,String phone,String site,String  logo,String email,String type) {
		this(titre,ref,typePoste,description,diplome,typeContrat,dureStage,dateEmbauche,niveau,connaissance,region,dateOffres,type);
		this.entreprise.setAdresseEmailUser(email);
		this.entreprise.setImageUser(logo);
		this.entreprise.setSitesEntreprise(site);
		this.dureStage= dureStage;
		this.entreprise.setTelUsers(phone);
	}
}

package com.plateformeweb.orientation.etudiant.ml.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name = "T_Universite",uniqueConstraints = {@UniqueConstraint(columnNames = "descriptionUniversite"),@UniqueConstraint(columnNames = "Siret")})
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Universite extends Users {
	@Column(name = "descriptionUniversite")
	private String descriptionuniversite;
	@Column(name = "siteUniversite")
	private String siteUniversite;
	@Column(name = "Siret")
	private String siret;
	@Column(name = "Region")
	private String region;
	@Column(name = "AbregeUniversite")
	private String abregeUniversite;
	@Column(name = "VilleUniversite")
	private String villeUniversite;
	@JsonIgnore
	@OneToMany(mappedBy = "universite",fetch = FetchType.EAGER)
	private Set<FiliereUniversite> filieres = new HashSet<>();
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "Orientation_etudiant_id",referencedColumnName = "id")
	private OrientationEtudiant orientation;
	@JsonIgnore
	@OneToMany(mappedBy = "universite",fetch = FetchType.EAGER)
	private Set<DemandeInscription> demandeInscription = new HashSet<>();
	public Universite(Long id,String name,String type,String addresse,String tel,String email,String password,String description) {
		super(id,name,type,addresse,tel,email,password);
		this.descriptionuniversite = description;
	}
	public Universite(String addresseEmail,String password,String siret) {
		super(addresseEmail,password);
		this.siret = siret;
	}
	public Universite(String addresseEmail,String password,String tel,String siret) {
		super(addresseEmail,password,tel);
		this.siret = siret;
	}
	
	public Universite(String nom,String type,String addresse,String adresseEmailUser, String passwordUser, String descriptionuniversite, String siteUniversite,
			String siret, String region, String abregeUniversite, String villeUniversite) {
		super(adresseEmailUser, passwordUser);
		this.descriptionuniversite = descriptionuniversite;
		this.siteUniversite = siteUniversite;
		this.siret = siret;
		this.region = region;
		this.abregeUniversite = abregeUniversite;
		this.villeUniversite = villeUniversite;
	}
	public Universite(Long id,String nom,String adresseUser,String numTel,String type,String adresseEmailUser, String passwordUser, String descriptionuniversite, String siteUniversite,
			String siret, String region, String abregeUniversite) {
		super(id,nom,type,adresseUser,numTel,adresseEmailUser, passwordUser);
		this.descriptionuniversite = descriptionuniversite;
		this.siteUniversite = siteUniversite;
		this.siret = siret;
		this.region = region;
		this.abregeUniversite = abregeUniversite;
	}
	
}
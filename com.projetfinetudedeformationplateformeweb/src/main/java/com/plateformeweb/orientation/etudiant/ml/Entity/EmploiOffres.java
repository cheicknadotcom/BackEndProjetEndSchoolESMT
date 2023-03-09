
package com.plateformeweb.orientation.etudiant.ml.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Table(name = "TableEmploiOffres")
@Data @AllArgsConstructor @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmploiOffres implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "Titre")
	private String titre;
	@Column(name = "Reference")
	private String reference;
	@Column(name = "TypePoste")
	private String typePoste;
	@Column(name = "Description")
	private String description;
	@Column(name = "Diplome")
	private String diplome;
	@Column(name = "TypeContrat")
	private String typeContract;
	@Column(name = "Connaissance")
	private String connaissanceTechnique;
	@Column(name = "Region")
	private String region;
	@Column(name = "TypeOffres")
	private String typeOffres;
	@Column(name = "Niveau")
	private String niveau;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOffres;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateEmbauche;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "entreprise_id",referencedColumnName = "id")
	private Entreprise entreprise;
	public EmploiOffres(Long id, String titre, String description, String diplome, String connaissanceTechnique,
			String region, Date dateoffre,String type, Entreprise entreprise) {
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.diplome = diplome;
		this.connaissanceTechnique = connaissanceTechnique;
		this.region = region;
		this.dateOffres = dateoffre;
		this.entreprise = entreprise;
		this.typeOffres = type;
	}
	public EmploiOffres(String titre, String reference, String typePoste, String description, String diplome,
			String typeContract, String connaissanceTechnique, String region, String niveau, Date dateOffres,
			Date dateEmbauche) {
		this.titre = titre;
		this.reference = reference;
		this.typePoste = typePoste;
		this.description = description;
		this.diplome = diplome;
		this.typeContract = typeContract;
		this.connaissanceTechnique = connaissanceTechnique;
		this.region = region;
		this.niveau = niveau;
		this.dateOffres = dateOffres;
		this.dateEmbauche = dateEmbauche;
	}
	public EmploiOffres(String titre, String reference, String typePoste, String description, String diplome,
			String typeContract, String connaissanceTechnique, String region, String niveau, Date dateOffres,
			Date dateEmbauche,String typeOffres) {
		this(titre,reference,typePoste,description,diplome,typeContract,connaissanceTechnique,region,niveau,dateOffres,dateEmbauche);
		this.typeOffres = typeOffres;
		
	}
	public EmploiOffres(String titre, String reference, String typePoste, String description, String diplome,
			String typeContract, String connaissanceTechnique, String region, String niveau, Date dateOffres,
			Date dateEmbauche, Entreprise entreprise) {
		this(titre,reference,typePoste,description,diplome,typeContract,connaissanceTechnique,region,niveau,dateOffres,dateEmbauche);
		this.titre = titre;
		this.reference = reference;
		this.typePoste = typePoste;
		this.description = description;
		this.diplome = diplome;
		this.typeContract = typeContract;
		this.connaissanceTechnique = connaissanceTechnique;
		this.region = region;
		this.niveau = niveau;
		this.dateOffres = dateOffres;
		this.dateEmbauche = dateEmbauche;
		this.entreprise = entreprise;
	}
	
	
}

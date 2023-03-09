package com.plateformeweb.orientation.etudiant.ml.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class EntrepriseComplet extends UsersComplet {
	private String secteurActivite;
	private String descriptionEntreprise;
	private String sitesEntreprise;
	private String slogantEntreprise;
	private String siren;
	private String villeEntreprise;
	private String region;
}

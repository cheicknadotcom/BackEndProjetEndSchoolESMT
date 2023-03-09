package com.plateformeweb.orientation.etudiant.ml.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class UniversiteComplet extends UsersComplet{
	private String descriptionuniversite;
	private String siteUniversite;
	private String siret;
	private String region;
	private String abregeUniversite;
	private String villeUniversite;
}

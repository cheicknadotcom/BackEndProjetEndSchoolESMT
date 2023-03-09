package com.plateformeweb.orientation.etudiant.ml.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "T_postulations")
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class PostulationOffres {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "EtudiantCV")
	EtudiantCv etudiantCv;
//	@Column(name = "Lettre")
//	LettreDeMotivation lettre;
}

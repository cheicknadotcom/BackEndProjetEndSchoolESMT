package com.plateformeweb.orientation.etudiant.ml.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plateformeweb.orientation.etudiant.ml.Entity.EmploiOffres;


public interface EmploiOffresRepository extends JpaRepository<EmploiOffres, Long> {

	Optional<EmploiOffres> findEmploiOffresByTitre(String titre);

	Optional<EmploiOffres> findEmploiOffresByDiplome(String diplome);

	Optional<EmploiOffres> findEmploiOffresByDateOffres(Date dateOffres);

	List<EmploiOffres> findEmploiOffresByTypeOffres(String name);

}

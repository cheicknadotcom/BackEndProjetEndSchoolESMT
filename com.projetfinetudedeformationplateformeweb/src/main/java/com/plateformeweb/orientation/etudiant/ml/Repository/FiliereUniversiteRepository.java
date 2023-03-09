package com.plateformeweb.orientation.etudiant.ml.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plateformeweb.orientation.etudiant.ml.Entity.FiliereUniversite;

public interface FiliereUniversiteRepository extends JpaRepository<FiliereUniversite, Long> {

	Optional<FiliereUniversite> findFiliereUniversiteByNameFiliere(String nom);

	Optional<List<FiliereUniversite>> findFiliereUniversiteByNomFaculte(String nom);

}

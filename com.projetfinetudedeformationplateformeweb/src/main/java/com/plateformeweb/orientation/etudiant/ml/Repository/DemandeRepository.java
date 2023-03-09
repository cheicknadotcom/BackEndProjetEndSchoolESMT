package com.plateformeweb.orientation.etudiant.ml.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plateformeweb.orientation.etudiant.ml.Entity.Demande;

public interface DemandeRepository extends JpaRepository<Demande,Long> {

	Optional<List<Demande>> findByEmailEtudiant(String email);

}

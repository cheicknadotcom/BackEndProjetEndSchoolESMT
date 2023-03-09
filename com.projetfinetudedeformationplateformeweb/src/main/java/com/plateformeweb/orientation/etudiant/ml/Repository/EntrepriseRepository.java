package com.plateformeweb.orientation.etudiant.ml.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plateformeweb.orientation.etudiant.ml.Entity.Entreprise;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {

	Optional<Entreprise> findEntrepriseById(Long id);

	//void deleteEntrepriseById(Long id);

}

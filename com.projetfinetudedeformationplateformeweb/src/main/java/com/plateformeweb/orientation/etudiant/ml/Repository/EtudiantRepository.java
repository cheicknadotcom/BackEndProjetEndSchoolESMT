package com.plateformeweb.orientation.etudiant.ml.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plateformeweb.orientation.etudiant.ml.Entity.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

	Optional<Etudiant> findEtudiantById(Long id);

	//void deleteEtudiantById(Long id);

}

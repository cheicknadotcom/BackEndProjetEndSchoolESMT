package com.plateformeweb.orientation.etudiant.ml.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plateformeweb.orientation.etudiant.ml.Entity.EtudiantCv;

public interface EtudiantCvRepository extends JpaRepository<EtudiantCv, Long> {

	Optional<EtudiantCv> findEtudiantCvByDiplome(String diplome);

	Optional<EtudiantCv> findEtudiantCvByExperience(String experience);

}

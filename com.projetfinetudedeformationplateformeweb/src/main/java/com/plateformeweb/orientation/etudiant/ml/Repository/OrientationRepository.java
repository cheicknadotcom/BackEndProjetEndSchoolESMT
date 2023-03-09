package com.plateformeweb.orientation.etudiant.ml.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plateformeweb.orientation.etudiant.ml.Entity.OrientationEtudiant;

public interface OrientationRepository extends JpaRepository<OrientationEtudiant, Long> {

}

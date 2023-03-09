package com.plateformeweb.orientation.etudiant.ml.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plateformeweb.orientation.etudiant.ml.Entity.Universite;

public interface UniversiteRepository extends JpaRepository<Universite, Long> {

	Optional<Universite> findUniversiteById(Long id);

	Optional<Universite> findUniversiteByAdresseEmailUser(String email);

}

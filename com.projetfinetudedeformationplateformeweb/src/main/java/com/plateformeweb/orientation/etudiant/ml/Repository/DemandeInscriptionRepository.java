package com.plateformeweb.orientation.etudiant.ml.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plateformeweb.orientation.etudiant.ml.Entity.DemandeInscription;

public interface DemandeInscriptionRepository extends JpaRepository<DemandeInscription, Long> {

	Optional<List<DemandeInscription>> findByEmailUniversite(String email);

}

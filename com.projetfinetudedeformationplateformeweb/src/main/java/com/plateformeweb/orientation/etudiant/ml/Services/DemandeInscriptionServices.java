package com.plateformeweb.orientation.etudiant.ml.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plateformeweb.orientation.etudiant.ml.Entity.DemandeInscription;
import com.plateformeweb.orientation.etudiant.ml.Exception.DemandeNotFoundException;
import com.plateformeweb.orientation.etudiant.ml.Repository.DemandeInscriptionRepository;

@Service
public class DemandeInscriptionServices {
	@Autowired
	DemandeInscriptionRepository demandeInscriptionRepository;
	
	public DemandeInscription creerDemandeInscription(DemandeInscription demandeInscription) {
		return demandeInscriptionRepository.save(demandeInscription);
	}
	public DemandeInscription updateDamandeInscription(DemandeInscription updatedemandeInscription) {
		return  demandeInscriptionRepository.save(updatedemandeInscription);
	}
	public DemandeInscription getDemandeInscriptionById(Long id) {
		return demandeInscriptionRepository.findById(id).orElseThrow(() ->new DemandeNotFoundException("Cette demande identifiant"+id +"n'existe pas"));
	}
	public List<DemandeInscription> getAllDemandeInscription(){
		return demandeInscriptionRepository.findAll();
	}
	public void deleteDemandeInscriptionById(Long id) {
		demandeInscriptionRepository.deleteById(id);
	}
	public void deleteDemandeInscription(DemandeInscription demande) {
		demandeInscriptionRepository.delete(demande);
	}
	public List<DemandeInscription> getDemandeInscriptionByEmail(String email) {
		return demandeInscriptionRepository.findByEmailUniversite(email).orElseThrow(() ->new DemandeNotFoundException("Cette demande identifiant"+email +"n'existe pas"));
	}
	
}

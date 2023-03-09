package com.plateformeweb.orientation.etudiant.ml.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plateformeweb.orientation.etudiant.ml.Entity.DemandeEmploi;
import com.plateformeweb.orientation.etudiant.ml.Entity.TypeDemande;
import com.plateformeweb.orientation.etudiant.ml.Exception.DemandeNotFoundException;
import com.plateformeweb.orientation.etudiant.ml.Repository.DemandeEmploiRepository;

@Service
public class DemandeEmploiServices {
	@Autowired
	DemandeEmploiRepository demandeEmploiRepository;
	public DemandeEmploi creerDemandeEmploi(DemandeEmploi demandeEmploi) {
		
		return demandeEmploiRepository.save(demandeEmploi);
	}
	public DemandeEmploi updateDemandeEmpoi(DemandeEmploi demandeEmploi) {
		return demandeEmploiRepository.save(demandeEmploi);
	}
	public DemandeEmploi getDemandeEmploiById(Long id) {
		return demandeEmploiRepository.findById(id).orElseThrow(() -> new DemandeNotFoundException("Cette demande d'identifiant "+ id +"n'existe pas"));
	}
	public List<DemandeEmploi> getAllDemandeEmploi(){
		return demandeEmploiRepository.findAll();
	}
	public void deleteDemandeEmploiById(Long id) {
		demandeEmploiRepository.deleteById(id);
	}
	public void deleteDemandeEmploi(DemandeEmploi demande) {
		demandeEmploiRepository.delete(demande);
	}

//	public List<DemandeEmploi> getListDemandeEmploiByDate(Date date){
//		return demandeEmploiRepository.findAllDemandeEmploiByDate(date);
//	}
	public List<DemandeEmploi> getListDemandeEmploiByTypeOffres(TypeDemande type){
		return demandeEmploiRepository.findAllDemandeEmploiByTypeDemande(type.name().concat("EMPLOI"));
	}
	public List<DemandeEmploi> getDemandeEmploiByEmail(String email) {
		// TODO Auto-generated method stub
		return demandeEmploiRepository.findByEmailEntreprise(email).orElseThrow(() -> new DemandeNotFoundException("Cette demande dont email : "+ email +"n'existe pas"));

	}
	
}

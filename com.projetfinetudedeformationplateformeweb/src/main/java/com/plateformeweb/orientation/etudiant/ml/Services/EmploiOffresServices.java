package com.plateformeweb.orientation.etudiant.ml.Services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plateformeweb.orientation.etudiant.ml.Entity.EmploiOffres;
import com.plateformeweb.orientation.etudiant.ml.Entity.TypeOffres;
import com.plateformeweb.orientation.etudiant.ml.Exception.UserNotFoundException;
import com.plateformeweb.orientation.etudiant.ml.Repository.EmploiOffresRepository;

@Service
public class EmploiOffresServices {
	@Autowired
	EmploiOffresRepository emploiOffresRepository;
	
	public EmploiOffres ajouterEmploiOffres(EmploiOffres emploiOffres) {
		return emploiOffresRepository.save(emploiOffres);
	}
	public EmploiOffres updateEmploiOffres(EmploiOffres emploiOffres) {
		return emploiOffresRepository.save(emploiOffres);
	}
	public void deleteEmploiOffres(Long id) {
		emploiOffresRepository.deleteById(id);
	}
	public List<EmploiOffres> getAllOffresEmploi(){
		return emploiOffresRepository.findAll();
	}
	public EmploiOffres findEmploiOffresByTitre(String titre) {
		return emploiOffresRepository.findEmploiOffresByTitre(titre).orElseThrow(() -> new UserNotFoundException("Cette Offres de Titre:" + titre + "n'existe pas"));
	}
	public EmploiOffres findEmploiOffresByDiplome(String diplome) {
		return emploiOffresRepository.findEmploiOffresByDiplome(diplome).orElseThrow(() -> new UserNotFoundException("Cette Offres de Diplome:" + diplome + "n'existe pas"));
	}
	public EmploiOffres findEmploiOffresByDateOffres(Date dateOffres) {
		return emploiOffresRepository.findEmploiOffresByDateOffres(dateOffres).orElseThrow(() -> new UserNotFoundException("Cette Offres de Diplome:" + dateOffres + "n'existe pas"));
	}
	@SuppressWarnings("static-access")
	public List<EmploiOffres> getListEmploiOffres(TypeOffres type){
		return emploiOffresRepository.findEmploiOffresByTypeOffres(type.EMPLOI.name());
	}
	@SuppressWarnings("static-access")
	public List<EmploiOffres> getListEmploiOffresStage(TypeOffres type){
		return emploiOffresRepository.findEmploiOffresByTypeOffres(type.STAGE.name());
	}
}

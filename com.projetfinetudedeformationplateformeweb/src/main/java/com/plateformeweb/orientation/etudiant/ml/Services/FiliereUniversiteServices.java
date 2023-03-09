package com.plateformeweb.orientation.etudiant.ml.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plateformeweb.orientation.etudiant.ml.Entity.FiliereUniversite;
import com.plateformeweb.orientation.etudiant.ml.Exception.UserNotFoundException;
import com.plateformeweb.orientation.etudiant.ml.Repository.FiliereUniversiteRepository;

@Service
public class FiliereUniversiteServices {
	@Autowired
	FiliereUniversiteRepository filiereUniversiteRepository;
	public FiliereUniversite creeFiliereUniversite(FiliereUniversite filiereUniversite) {
		return filiereUniversiteRepository.save(filiereUniversite);
	}
	public FiliereUniversite updateFiliereUniversite(FiliereUniversite filiereUniversite) {
		return filiereUniversiteRepository.save(filiereUniversite);
	}
	public void deleteFiliereUniversiteById(Long id) {
		filiereUniversiteRepository.deleteById(id);
	}
	public void deleteFiliereUniversite(FiliereUniversite filiere) {
		filiereUniversiteRepository.delete(filiere);
	}
	public FiliereUniversite getFiliereUniversiteByNom(String nom) {
		return filiereUniversiteRepository.findFiliereUniversiteByNameFiliere(nom).orElseThrow(() -> new UserNotFoundException("Cette Filiere de Nom :"+ nom+ "n'existe pas sorry"));
	}
	public List<FiliereUniversite> getAllFiliereUniversite(){
		return filiereUniversiteRepository.findAll();
	}
	public List<FiliereUniversite> getFiliereUniversiteByNomFaculte(String nom) {
		return filiereUniversiteRepository.findFiliereUniversiteByNomFaculte(nom).orElseThrow(() -> new UserNotFoundException("Cette Filiere de Nom :"+ nom+ "n'existe pas sorry"));
	}
}

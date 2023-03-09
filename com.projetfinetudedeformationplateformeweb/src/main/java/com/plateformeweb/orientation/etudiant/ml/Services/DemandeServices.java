package com.plateformeweb.orientation.etudiant.ml.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plateformeweb.orientation.etudiant.ml.Entity.Demande;
import com.plateformeweb.orientation.etudiant.ml.Exception.UserNotFoundException;
import com.plateformeweb.orientation.etudiant.ml.Repository.DemandeRepository;

@Service
public class DemandeServices {
	@Autowired
	DemandeRepository demandeRepository;
	public List<Demande> getDemandeByEmailEtudiant(String email) {
		return demandeRepository.findByEmailEtudiant(email).orElseThrow(() ->new UserNotFoundException("Cette demande n'existe pas sorry..."));
	}
}

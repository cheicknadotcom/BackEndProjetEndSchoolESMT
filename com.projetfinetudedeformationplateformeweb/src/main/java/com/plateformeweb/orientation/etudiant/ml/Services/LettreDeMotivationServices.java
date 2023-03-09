package com.plateformeweb.orientation.etudiant.ml.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plateformeweb.orientation.etudiant.ml.Entity.LettreDeMotivation;
import com.plateformeweb.orientation.etudiant.ml.Repository.LettreDeMotivationRepository;

@Service
public class LettreDeMotivationServices {
	@Autowired
	LettreDeMotivationRepository lettreDeMotivationRepository;
	public LettreDeMotivation creerLettreDeMotivation(LettreDeMotivation lettreDeMotivation) {
		return lettreDeMotivationRepository.save(lettreDeMotivation);
	}
	public LettreDeMotivation updateLettreDeMotivation(LettreDeMotivation lettreDeMotivation) {
		return lettreDeMotivationRepository.save(lettreDeMotivation);
	}
}

package com.plateformeweb.orientation.etudiant.ml.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plateformeweb.orientation.etudiant.ml.Entity.OffresEmploi;
import com.plateformeweb.orientation.etudiant.ml.Repository.OffresEmploiRepository;

@Service
public class OffresEmploiServices {
	@Autowired
	OffresEmploiRepository offresEmploiRepository;
	public OffresEmploi creerOffresEmploi(OffresEmploi offresEmploi) {
		return offresEmploiRepository.save(offresEmploi);
	}
	public OffresEmploi updateOffresEmploi(OffresEmploi offresEmploi) {
		return offresEmploiRepository.save(offresEmploi);
	}
	public void deleteOffresEmploiById( Long id) {
		offresEmploiRepository.deleteById(id);
	}
	public void deleteOffresEmploi(OffresEmploi offresEmploi) {
		offresEmploiRepository.delete(offresEmploi);
	}
	public List<OffresEmploi> getAllOffresEmdploi(){
		return offresEmploiRepository.findAll();
	}
	
}

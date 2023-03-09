package com.plateformeweb.orientation.etudiant.ml.Services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plateformeweb.orientation.etudiant.ml.Entity.OffresStage;
import com.plateformeweb.orientation.etudiant.ml.Repository.OffresStageRepository;

@Service
public class OffresStageServices {
	@Autowired
	OffresStageRepository offresStagerepository;
	public OffresStage creerOffresStage(OffresStage offresStage) {
		return offresStagerepository.save(offresStage);
	}
	public OffresStage updateOffresStage(OffresStage offresStage) {
		return offresStagerepository.save(offresStage);
	}
	public void deleteOffresStageById(Long id) {
		offresStagerepository.deleteById(id);
	}
	public void deleteOffresStage(OffresStage offresStage) {
		offresStagerepository.delete(offresStage);
	}
	public  List<OffresStage> getAllOffresStage(){
		return offresStagerepository.findAll();
	}
}

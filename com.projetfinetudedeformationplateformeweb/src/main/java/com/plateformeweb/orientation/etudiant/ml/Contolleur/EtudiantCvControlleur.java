package com.plateformeweb.orientation.etudiant.ml.Contolleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plateformeweb.orientation.etudiant.ml.Entity.EtudiantCv;
import com.plateformeweb.orientation.etudiant.ml.Services.EtudiantcvServices;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/studentCompany")
public class EtudiantCvControlleur {
	@Autowired
	EtudiantcvServices etudiantcvService;
	@PostMapping("/Etudiant/Etudiantcv/add")
	public ResponseEntity<EtudiantCv> ajouterEtudiantcv(@RequestBody EtudiantCv etudiantcv){
		EtudiantCv etudiantCv = etudiantcvService.addEtudiantcv(etudiantcv);
		
		return new ResponseEntity<EtudiantCv>(etudiantCv,HttpStatus.CREATED);
	}
}

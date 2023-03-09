package com.plateformeweb.orientation.etudiant.ml.Services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.plateformeweb.orientation.etudiant.ml.Entity.Etudiant;
import com.plateformeweb.orientation.etudiant.ml.Entity.EtudiantComplet;
import com.plateformeweb.orientation.etudiant.ml.Entity.TypeEtudiant;
import com.plateformeweb.orientation.etudiant.ml.Entity.Users;
import com.plateformeweb.orientation.etudiant.ml.Exception.UserNotFoundException;
import com.plateformeweb.orientation.etudiant.ml.Repository.EtudiantRepository;

@Service
public class EtudiantServices {
	@Autowired
	EtudiantRepository etudiantRepository;
	
	Etudiant etudiant;
	
	Users users; 
	
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
////////////////////////////////////////////////////////////////////////////////////////////

// compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
		int count = deflater.deflate(buffer);
		outputStream.write(buffer, 0, count);
		}
		try {
		outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
		
		return outputStream.toByteArray();
	}

// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
		while (!inflater.finished()) {
		int count = inflater.inflate(buffer);
		outputStream.write(buffer, 0, count);
		}
		outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}
///////////////////////////////////////////////////////////////////////////////////////////
	public Etudiant addEtudiant(Etudiant etudiant) {
		etudiant.setTypeUsers("Etudiant");
		return etudiantRepository.save(etudiant);
	}
	public Etudiant addEtudiants(EtudiantComplet etudiantComplet) {
		Etudiant etudiant = new Etudiant();
		etudiant.setNameUsers(etudiantComplet.getNameUsers());
		etudiant.setPrenomEtudiant(etudiantComplet.getPrenomEtudiant());
		etudiant.setAdresseEmailUser(etudiantComplet.getAdresseEmailUser());
		etudiant.setPasswordUser(etudiantComplet.getPasswordUser());
		etudiant.setAdresseUsers(etudiantComplet.getAdresseUsers());
		etudiant.setAnneeEntreEtudiant(etudiantComplet.getAnneeEntreEtudiant());
		etudiant.setCarre(etudiantComplet.getCarre());
		etudiant.setTelUsers(etudiantComplet.getTelUsers());
		etudiant.setTelTuteur(etudiantComplet.getTelTuteur());
		etudiant.setTuteur(etudiantComplet.getTuteur());
		etudiant.setTypeEtudiant(TypeEtudiant.REGULIER);
		etudiant.setTypeUsers("Etduiant");
		etudiant.setClasse(etudiantComplet.getClasse());
		etudiant.setCodeClasse(etudiantComplet.getCodeClasse());
		etudiant.setCodeEtablissement(etudiantComplet.getCodeEtablissement());
		etudiant.setCintuteur(etudiantComplet.getCintuteur());
		etudiant.setGenre(etudiantComplet.getGenre());
		etudiant.setLieuDeNaissance(etudiantComplet.getLieuDeNaissance());
		etudiant.setCodeNationalite(etudiantComplet.getCodeNationalite());
		etudiant.setCodePostal(etudiantComplet.getCodePostal());
		etudiant.setConcession(etudiantComplet.getConcession());
		etudiant.setMatricule(etudiantComplet.getMatricule());
		etudiant.setNomMere(etudiantComplet.getNomMere());
		etudiant.setNomPere(etudiantComplet.getNomPere());
		etudiant.setProfMere(etudiantComplet.getProfMere());
		etudiant.setProfPere(etudiantComplet.getProfPere());
		etudiant.setProfTuteur(etudiantComplet.getProfTuteur());
		etudiant.setDomaineExercer(etudiantComplet.getDomaineExercer());
		etudiant.setSpecialite(etudiantComplet.getSpecialite());
		etudiant.setNiveauEtude(etudiantComplet.getNiveauEtude());
		etudiant.setVilleEtudiant(etudiantComplet.getVilleEtudiant());
		etudiant.setEtablissement(etudiantComplet.getEtablissement());
		etudiant.setQuartier(etudiantComplet.getQuartier());
		String originalFileName = StringUtils.cleanPath(etudiantComplet.getImageUser().getOriginalFilename());
		String fileExtension = "";
        try {
            fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        } catch (Exception e) {
            fileExtension = "";
        }
		String fileName = "image" + UUID.randomUUID().toString().replace("-", "") + "" + fileExtension;
        FileManageService.saveFile(fileName,etudiantComplet.getImageUser());
        etudiant.setImageUser(fileName);
		return etudiantRepository.save(etudiant);
	}
	public List<Etudiant> listEtudiantService(){
		return etudiantRepository.findAll();
	}
	public Etudiant updateEtudiant(Etudiant etudiant)
	{return etudiantRepository.save(etudiant);}

	public Etudiant findEtudiantsById(Long id) {
		Etudiant etudiant = etudiantRepository.findEtudiantById(id).orElseThrow(() -> new UserNotFoundException("Cet etudiant d'identifiant" + id +" n'exist pas"));
		//etudiant.setImageUser(decompressBytes(etudiant.getImageUser()));
		return etudiant;
	}
	public void deleteEtudiant(Long id) {
		etudiantRepository.deleteById(id);
	}
}

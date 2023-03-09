package com.plateformeweb.orientation.etudiant.ml.Contolleur;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.locationtech.jts.algorithm.Orientation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.plateformeweb.orientation.etudiant.ml.Entity.Demande;
import com.plateformeweb.orientation.etudiant.ml.Entity.DemandeEmploi;
import com.plateformeweb.orientation.etudiant.ml.Entity.DemandeInscription;
import com.plateformeweb.orientation.etudiant.ml.Entity.EmailDetails;
import com.plateformeweb.orientation.etudiant.ml.Entity.EmploiOffres;
import com.plateformeweb.orientation.etudiant.ml.Entity.Entreprise;
import com.plateformeweb.orientation.etudiant.ml.Entity.EntrepriseComplet;
import com.plateformeweb.orientation.etudiant.ml.Entity.Etudiant;
import com.plateformeweb.orientation.etudiant.ml.Entity.EtudiantComplet;
import com.plateformeweb.orientation.etudiant.ml.Entity.EtudiantCv;
import com.plateformeweb.orientation.etudiant.ml.Entity.EtudiantCvComplet;
import com.plateformeweb.orientation.etudiant.ml.Entity.FiliereUniversite;
import com.plateformeweb.orientation.etudiant.ml.Entity.OffresEmploi;
import com.plateformeweb.orientation.etudiant.ml.Entity.OffresStage;
import com.plateformeweb.orientation.etudiant.ml.Entity.OrientationEtudiant;
import com.plateformeweb.orientation.etudiant.ml.Entity.Universite;
import com.plateformeweb.orientation.etudiant.ml.Entity.UniversiteComplet;
import com.plateformeweb.orientation.etudiant.ml.Entity.Users;
import com.plateformeweb.orientation.etudiant.ml.Entity.UsersComplet;
import com.plateformeweb.orientation.etudiant.ml.Repository.EmailService;
import com.plateformeweb.orientation.etudiant.ml.Repository.EntrepriseRepository;
import com.plateformeweb.orientation.etudiant.ml.Repository.EtudiantRepository;
import com.plateformeweb.orientation.etudiant.ml.Repository.UniversiteRepository;
import com.plateformeweb.orientation.etudiant.ml.Repository.UsersRepository;
import com.plateformeweb.orientation.etudiant.ml.Services.DemandeEmploiServices;
import com.plateformeweb.orientation.etudiant.ml.Services.DemandeInscriptionServices;
import com.plateformeweb.orientation.etudiant.ml.Services.DemandeServices;
import com.plateformeweb.orientation.etudiant.ml.Services.EmploiOffresServices;
import com.plateformeweb.orientation.etudiant.ml.Services.EntrepriseServices;
import com.plateformeweb.orientation.etudiant.ml.Services.EtudiantServices;
import com.plateformeweb.orientation.etudiant.ml.Services.EtudiantcvServices;
import com.plateformeweb.orientation.etudiant.ml.Services.FiliereUniversiteServices;
import com.plateformeweb.orientation.etudiant.ml.Services.OffresEmploiServices;
import com.plateformeweb.orientation.etudiant.ml.Services.OffresStageServices;
import com.plateformeweb.orientation.etudiant.ml.Services.OrientationServices;
import com.plateformeweb.orientation.etudiant.ml.Services.UniversiteServices;
import com.plateformeweb.orientation.etudiant.ml.Services.UsersService;
//@Controller
@RestController
@CrossOrigin(originPatterns = "http://localhost:4200")
@RequestMapping("/studentCompany")
public class MyPagesControlleur {
	@Autowired
	UsersRepository usersRepository;
	@SuppressWarnings("rawtypes")
	@Autowired
	UsersService usersService;
	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	EtudiantServices etudiantServices;
	@Autowired
	EntrepriseRepository entrepriseRepository;
	@Autowired
	EntrepriseServices entrepriseServices;
	@Autowired
	UniversiteRepository universiteRepository;
	@Autowired
	UniversiteServices universiteServices;
	@Autowired
	EmploiOffresServices emploiOffresServices;
	@Autowired
	OffresStageServices offresStageServices;
	@Autowired
	OffresEmploiServices offresEmploiServices;
	@Autowired
	OrientationServices orientationServices;
	@Autowired
	EtudiantcvServices etudiantcvServices;
	@Autowired
	FiliereUniversiteServices filiereUniversiteServices;
	@Autowired
	DemandeInscriptionServices demandeInscriptionServices;
	@Autowired
	DemandeEmploiServices demandeEmploiServices;
	@Autowired
	DemandeServices demandeServices;
	@Autowired
	private EmailService emailService;
	Users users;
	Etudiant etudiant;
	Universite universite;
	Entreprise entreprise;
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Universite getUniversite() {
		return universite;
	}
	public void setUniversite(Universite universite) {
		this.universite = universite;
	}
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	//*******************************************************************************************************
	/*
	 * Toutes les methodes de gestion des etudiants du projets sont elaborer dans cette partie
	 * 
	 * */
	//*******************************************************************************************************
	@PostMapping("/Etudiant/Etudiantsave")
	public ResponseEntity<Etudiant> ajouterEtudiant(@RequestBody Etudiant etudiant){
		//etudiant.setImageUser(usersService.store(etudiant.getImageUser()));
		return new ResponseEntity<Etudiant>(etudiantServices.addEtudiant(etudiant), HttpStatus.CREATED);
	}
	
	@PostMapping("/Etudiant/Etudiantsaves")
	public ResponseEntity<Etudiant> ajouterEtudiants(@RequestParam("Etudiant") Etudiant etudiant,@RequestParam("Image") MultipartFile file){
		//etudiant.setImageUser(usersService.store(file));
		return new ResponseEntity<Etudiant>(etudiantServices.addEtudiant(etudiant), HttpStatus.CREATED);
	}
	@RequestMapping(path = "/Etudiant/Etudiantsave", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	public ResponseEntity<Etudiant> ajouterEtudiant(@RequestAttribute EtudiantComplet etudiant){
	
		return new ResponseEntity<Etudiant>(etudiantServices.addEtudiants(etudiant), HttpStatus.CREATED);
	}
	@PutMapping("/Etudiant/Etudiantupdate")
	public ResponseEntity<Etudiant> updateEtudiant(@RequestBody Etudiant etudiant){
		return new ResponseEntity<Etudiant>(etudiantServices.updateEtudiant(etudiant),HttpStatus.CREATED);
	}
	@GetMapping("/Etudiant/getAllEtudiant")
	public ResponseEntity<List<Etudiant>> listeEtudiantControlleur(){
		return new ResponseEntity<List<Etudiant>>(etudiantServices.listEtudiantService(),HttpStatus.OK);
	}
	@GetMapping("/Etudiant/getEtudiantById/{id}")
	public ResponseEntity<Etudiant> listeEtudiantByIdControlleur(@PathVariable("id") Long id){
		return new ResponseEntity<Etudiant>(etudiantServices.findEtudiantsById(id), HttpStatus.OK);
	}
	@DeleteMapping("/Etudiant/deleteEtudiantById/{id}")
	public ResponseEntity<HttpStatus> deleteEtudiant(@PathVariable("id") Long id){
		etudiantServices.deleteEtudiant(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}	
	//*******************************************************************************************************
	/*
	 * Toutes les methodes de gestion des entreprises du projets sont elaborer dans cette partie
	 * 
	 * */
	//*******************************************************************************************************
	@GetMapping("/Entreprise/getEntrepriseById/{id}")
	public ResponseEntity<Entreprise> getEntrepriseById(@PathVariable("id") Long id){
		return new ResponseEntity<Entreprise>(entrepriseServices.getEntreprisesById(id),HttpStatus.OK);
	}
	@GetMapping("/Entreprise/getAllEntreprise")
	public ResponseEntity<List<Entreprise>> getAllEntreprise(){
		return new ResponseEntity<List<Entreprise>>(entrepriseServices.getEntreprises(),HttpStatus.OK);
	}
	@PostMapping("/Entreprise/addEntreprise")
	public ResponseEntity<Entreprise> ajouterEntreprise(@RequestBody Entreprise entreprise) {
		return new ResponseEntity<Entreprise>(entrepriseServices.ajouterEntreprise(entreprise),HttpStatus.CREATED);
	}
	@RequestMapping(path = "/Entreprise/addEntreprise", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	public ResponseEntity<Entreprise> ajouterEntreprises(@RequestAttribute EntrepriseComplet entreprise) {
		return new ResponseEntity<Entreprise>(entrepriseServices.ajouterEntreprises(entreprise),HttpStatus.CREATED);
	}
	@PutMapping("/Entreprise/updateEntreprise")
	public ResponseEntity<Entreprise> updateEntreprise(@RequestBody Entreprise entreprise){
		return new ResponseEntity<Entreprise>(entrepriseServices.updateEntreprises(entreprise), HttpStatus.CREATED);
	}
	@DeleteMapping("/Entreprise/deleteEntreprise/{id}")
	public ResponseEntity<HttpStatus> deleteEntrepriseById(@PathVariable("id") Long id){
		entrepriseServices.deleteEntrepriseById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	@GetMapping("/Entreprise/findEntrepriseByEmail")
	public ResponseEntity<Entreprise> findEntrepriseByEmail(@RequestParam String email){
		return new ResponseEntity<Entreprise>(entrepriseServices.findEntrepriseByEmail(email),HttpStatus.OK);
	}
	//*******************************************************************************************************
	/*
	 * Toutes les methodes de gestion pour l'administrateur du projets sont elaborer dans cette partie
	 * 
	 * */
	//*******************************************************************************************************
	
	
	
	//*******************************************************************************************************
	/*
	 * Toutes les methodes de gestion des Universites du projets sont elaborer dans cette partie
	 * 
	 * */
	//*******************************************************************************************************
	@PostMapping("/Universite/addUniversite")
	public ResponseEntity<Universite> ajouterUniversite(@RequestBody Universite universite){
		return new ResponseEntity<Universite>(universiteServices.addUniversite(universite),HttpStatus.CREATED);
	}
	@RequestMapping(path = "/Universite/addUniversites", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	public ResponseEntity<Universite> ajouterUniversites(@RequestAttribute UniversiteComplet universite){
		return new ResponseEntity<Universite>(universiteServices.addUniversites(universite),HttpStatus.CREATED);
	}
	@PostMapping("/Universite/updateUniversite")
	public ResponseEntity<Universite> updateUniversite(@RequestBody Universite universite){
		return new ResponseEntity<Universite>( universiteServices.updateUniversite(universite),HttpStatus.CREATED);
	}
	@GetMapping("/Universite/getAllUniversite")
	public ResponseEntity<List<Universite>> getAllUniversite(){	
		return new ResponseEntity<List<Universite>>(universiteServices.getUniversite(),HttpStatus.OK);
	}
	@GetMapping("/Universite/getUniversite/{id}")
	public ResponseEntity<Universite> getUniversiteById(@PathVariable("id") Long id){
		return new ResponseEntity<Universite>(universiteServices.getUniversitesById(id),HttpStatus.OK);
	}
	@GetMapping("/Universite/getUniversiteByEmail/{email}")
	public ResponseEntity<Universite> getUniversiteByAdresseEmail(@PathVariable("email") String email){
		return new ResponseEntity<Universite>(universiteServices.getUniversiteByEmail(email),HttpStatus.OK);
	}
	@DeleteMapping("Universite/deleteUniversite/{id}")
	public ResponseEntity<HttpStatus> deleteUniversiteById(@PathVariable("id") Long id){
		universiteServices.deleteUniversite(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	//*******************************************************************************************************
	/*
	 * Toutes les methodes de gestion d'authentification du projets sont elaborer dans cette partie
	 * 
	 * */
	//*******************************************************************************************************
	@GetMapping(value="/Users/getUserByEmailAndPassword/",params= {"email","password"})
	public ResponseEntity<Users> getUsersByEmailAndPassword(@PathVariable("email") String email,@PathVariable("password") String password){
		return new ResponseEntity<Users>(usersService.getUserByEmailAndPassword(email, password),HttpStatus.OK);
	}
	@GetMapping(value="/Users/authentification")
	public ResponseEntity<String> getUserType(@RequestBody Users users){
		return new  ResponseEntity<String>(usersService.getTypeUserByEmailAndPassword(users.getAdresseEmailUser(), users.getPasswordUser()),HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value="/Users/getUserTypeByEmailAndPassword")
	public ResponseEntity getUsersTypeByEmailAndPassword(@RequestParam("email") String email,@RequestParam("password") String password){
		return new ResponseEntity(usersService.getTypeUserByEmailAndPassword(email, password),HttpStatus.OK);
	}
	@GetMapping("/Users/getUsersById/{id}")
	public ResponseEntity<Users> getUsersById(@PathVariable("id") Long id){
		return new ResponseEntity<Users>(usersService.getUsersById(id),HttpStatus.OK);
	}
	@GetMapping("/Users/getUsersByEmail/{email}")
	public ResponseEntity<Users> getUsersByEmail(@PathVariable("email") String email){
		return new ResponseEntity<Users>(usersService.getUsersByEmails(email),HttpStatus.OK);
	}
	@PostMapping("/Users/addusers")
	public ResponseEntity<Users> ajouterUser(@RequestBody Users users){
		//usersService.store((MultipartFile)users.getImageUser());
		return new ResponseEntity<Users>(usersService.addUser(users),HttpStatus.OK);
	}
	//@RequestMapping("/Users/adduser")
	@RequestMapping(path = "/Users/adduser", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	public ResponseEntity<Users> ajouterUser(@ModelAttribute UsersComplet users){
		return new ResponseEntity<Users>(usersService.addUsers(users),HttpStatus.OK);
	}
	@PutMapping("/Users/updateUser")
	public ResponseEntity<Users> updateUser(@RequestBody Users users){
		return new ResponseEntity<Users>(usersService.updateUsers(users),HttpStatus.OK);
	}
	@DeleteMapping("/Users/deleteUser/{id}")
	public ResponseEntity<HttpStatus> deleteUsers(@PathVariable("id") Long id){
		usersService.deleteUsers(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	@GetMapping("/Users/getAllUsers")
	public ResponseEntity<List<Users>> getAllUsers(){
		  //Resource file = StorageService.loadAsResource(users.getImageUser().toString());
		 // String mimeType = URLConnection.guessContentTypeFromName(file.getFilename());
		return new ResponseEntity<>(usersService.getAllUsers(),HttpStatus.OK);
	}
	//*******************************************************************************************************
		/*
		 * Toutes les methodes de gestion des Offres du projets sont elaborer dans cette partie
		 * 
		 * */
	//*******************************************************************************************************
	@PostMapping("/EmploiOffres/addoffres")
	public ResponseEntity<EmploiOffres> creerEmploiOffres(@RequestBody EmploiOffres offresEmploi){
		offresEmploi.setEntreprise(entreprise);
		return new ResponseEntity<EmploiOffres>(emploiOffresServices.ajouterEmploiOffres(offresEmploi),HttpStatus.OK);
	}
	@PutMapping("/EmploiOffres/updateoffres")
	public ResponseEntity<EmploiOffres> updateEmploiOffres(@RequestBody EmploiOffres offresEmploi){
		return new ResponseEntity<EmploiOffres>(emploiOffresServices.updateEmploiOffres(offresEmploi),HttpStatus.OK);
	}
	@DeleteMapping("/EmploiOffres/deleteoffres/{id}")
	public ResponseEntity<?> deleteEmploiOffresById(@PathVariable("id") Long id){
		emploiOffresServices.deleteEmploiOffres(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	@GetMapping("/EmploiOffres/getAllEmploiOffres")
	public ResponseEntity<List<EmploiOffres>> getEmploiOffres(){
		return new ResponseEntity<List<EmploiOffres>>(emploiOffresServices.getAllOffresEmploi(),HttpStatus.OK);
	}
	@GetMapping("/EmploiOffres/getEmploiOffresByDate/{date}")
	public ResponseEntity<EmploiOffres> getEmploiOffresByDate(@PathVariable("date") Date date){
		return new ResponseEntity<EmploiOffres>(emploiOffresServices.findEmploiOffresByDateOffres(date),HttpStatus.OK);
	}
	@GetMapping("/EmploiOffres/getEmploiOffresByDate/{diplome}")
	public ResponseEntity<EmploiOffres> getEmploiOffresByDiplome(@PathVariable("diplome") String diplome){
		return new ResponseEntity<EmploiOffres>(emploiOffresServices.findEmploiOffresByDiplome(diplome),HttpStatus.OK);
	}
	@GetMapping("/EmploiOffres/getEmploiOffresByDate/{titre}")
	public ResponseEntity<EmploiOffres> getEmploiOffresByDate(@PathVariable("titre") String titre){
		return new ResponseEntity<EmploiOffres>(emploiOffresServices.findEmploiOffresByTitre(titre),HttpStatus.OK);
	}
	@PostMapping("/OffresEmploi/addoffres")
	public ResponseEntity<OffresEmploi> creerOffresEmploi(@RequestBody  OffresEmploi offresEmploi){
		offresEmploi.setEntreprise(entreprise);
		return new ResponseEntity<OffresEmploi>(offresEmploiServices.creerOffresEmploi(offresEmploi),HttpStatus.OK);
	}
	@PutMapping("/OffresEmploi/updateoffres")
	public ResponseEntity<OffresEmploi> updateOffresEmploi(@RequestBody OffresEmploi offresEmploi){
		return new ResponseEntity<OffresEmploi>(offresEmploiServices.updateOffresEmploi(offresEmploi),HttpStatus.OK);
	}
	@GetMapping("/OffresEmploi/getAllOffresEmploi")
	public ResponseEntity<List<OffresEmploi>> getAllOffresEmploi(){
		return new ResponseEntity<List<OffresEmploi>>(offresEmploiServices.getAllOffresEmdploi(),HttpStatus.OK);
	}
	@DeleteMapping("/OffresEmploi/deleteoffres/{id}")
	public ResponseEntity<HttpStatus> deleteOffresEmploiById(@PathVariable("Id") Long id){
		offresEmploiServices.deleteOffresEmploiById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	@DeleteMapping("/OffresEmploi/deleteoffres")
	public ResponseEntity<HttpStatus> deleteOffresEmploi(@RequestBody OffresEmploi offresEmploi){
		offresEmploiServices.deleteOffresEmploi(offresEmploi);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	@PostMapping("/OffresStage/addoffres")
	public ResponseEntity<OffresStage> creerOffresStage(@RequestBody OffresStage offresStage){
		return new ResponseEntity<OffresStage>(offresStageServices.creerOffresStage(offresStage),HttpStatus.OK);
	}
	@PutMapping("/OffresStage/updateoffres")
	public ResponseEntity<OffresStage> updateOffresStage(@RequestBody OffresStage offresStage){
		return new ResponseEntity<OffresStage>(offresStageServices.updateOffresStage(offresStage),HttpStatus.OK);
	} 
	@DeleteMapping("/OffresStage/deleteoffres/{id}")
	public ResponseEntity<HttpStatus> deleteOffresStageById(@PathVariable("Id") Long id) {
		offresStageServices.deleteOffresStageById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	@DeleteMapping("/OffresStage/deleteoffres")
	public ResponseEntity<HttpStatus> deleteOffresStage(@RequestBody OffresStage offresStage) {
		offresStageServices.deleteOffresStage(offresStage);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	@GetMapping("/OffresStage/getAllOffresStage")
	public ResponseEntity<List<OffresStage>> getAllOffresStage(){
		return new ResponseEntity<List<OffresStage>>(offresStageServices.getAllOffresStage(),HttpStatus.OK);
	}
	//*******************************************************************************************************
	/*
	 * Toutes les methodes de gestion d'Orientation des etudiants du projets sont elaborer dans cette partie
	 * 
	 * */
	 //*******************************************************************************************************
	@PostMapping("/OrientationEtudiant/orienter")
	public ResponseEntity<Orientation> doOrientationEtudiant(@RequestBody OrientationEtudiant orientation){
		orientation.setEtudiant(getEtudiant());
		orientation.setListeUniversite(null);
		return new ResponseEntity<Orientation>(HttpStatus.OK);
	}
	@GetMapping("/OrientationEtudiant/oriente/{etudiant}")
	public ResponseEntity<Set<Universite>> getOrientitionUniversite(@PathVariable("etudiant") Etudiant etudiant){
		List<Universite> listeUniversite =universiteRepository.findAll();
		return new ResponseEntity<Set<Universite>>(orientationServices.orientationEtudiants(etudiant,listeUniversite),HttpStatus.OK);
	}
	@GetMapping("/OrientationEtudiant/orienteFaculte/{etudiant}")
	public ResponseEntity<Set<FiliereUniversite>> getOrientitionUniversiteFilieres(@PathVariable("etudiant") Etudiant etudiant){
		List<Universite> listeUniversite =universiteRepository.findAll();
		return new ResponseEntity<Set<FiliereUniversite>>(orientationServices.OrienterEtudiant(etudiant,listeUniversite),HttpStatus.OK);
	}
	@GetMapping("/OrientationEtudiant/orienteFaculte")
	public ResponseEntity<List<FiliereUniversite>> getOrientitionUniversiteFiliere(@RequestParam("Serie")String serie,@RequestParam("Domaine") String domaine){
		return new ResponseEntity<List<FiliereUniversite>>(orientationServices.orienteEtudiantFilieresUniversites(serie, domaine),HttpStatus.OK);
	}
	//*******************************************************************************************************
	//*******************************************************************************************************
		/*
		 * Toutes les methodes de gestion  le Cv des etudiants du projets sont elaborer dans cette partie
		 * 
		 * */
	//*******************************************************************************************************
	@PostMapping("/EtudiantsCv/addEtudiantCv")
	public ResponseEntity<EtudiantCv> creerEtudiantCv(@RequestBody EtudiantCv etudiantCv){
		etudiantCv.setEtudiant(getEtudiant());
		return new ResponseEntity<EtudiantCv>(etudiantcvServices.addEtudiantcv(etudiantCv),HttpStatus.OK);
	}

	@RequestMapping(path = "/EtudiantCv/addEtudiantsCv", method = RequestMethod.POST, consumes = {"multipart/form-data"})
	public ResponseEntity<EtudiantCv> creerEtudiantsCv(@RequestAttribute EtudiantCvComplet etudiantCv){
		return new ResponseEntity<EtudiantCv>(etudiantcvServices.addEtudiantscv(etudiantCv),HttpStatus.OK);
	}
	@PutMapping("/EtudiantCv/updateEtudiantCv")
	public ResponseEntity<EtudiantCv> updateEtudiantCv(@RequestBody EtudiantCv etudiantCv){
		return new ResponseEntity<EtudiantCv>(etudiantcvServices.updateEtudiantCv(etudiantCv),HttpStatus.OK);
	}
	@GetMapping("/EtudiantCv/getAllEtudiantCv")
	public ResponseEntity<List<EtudiantCv>> getAllEtudiantCv(){
		return new ResponseEntity<List<EtudiantCv>>(etudiantcvServices.getAllEtudiantCv(),HttpStatus.OK);
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	@GetMapping("/EtudiantCv/getEtudiantCvByDiplome/{diplome}")
	public ResponseEntity<EtudiantCv> getEtudiantCvByDiplome(@PathVariable("diplome") String diplome){
		return new ResponseEntity<EtudiantCv>(etudiantcvServices.findEtudiantCvByDiplome(diplome),HttpStatus.OK);
	}
	@GetMapping("/EtudiantCv/getEtudiantCvByExperience/{experience}")
	public ResponseEntity<EtudiantCv> getEtudiantCvByExperience(@PathVariable("experience") String experience){
		return new ResponseEntity<EtudiantCv>(etudiantcvServices.findEtudiantByExperience(experience),HttpStatus.OK);
	}
	//*******************************************************************************************************
	/*
	 * Toutes les methodes de gestion  des filiere des Universites du projets sont elaborer dans cette partie
	 * 
	 * */
	//*******************************************************************************************************
	@PostMapping("/FiliereUniversite/addFiliereUniversite")
	public ResponseEntity<FiliereUniversite> creerFiliereUniversite(@RequestBody FiliereUniversite filiereUniversite){
		filiereUniversite.setUniversite(universite);
		return new ResponseEntity<FiliereUniversite>(filiereUniversiteServices.creeFiliereUniversite(filiereUniversite),HttpStatus.CREATED);
	}
	@PutMapping("/FiliereUniversite/updateFiliereUniversite")
	public ResponseEntity<FiliereUniversite> updateFiliereUniversite(@RequestBody FiliereUniversite filiereUniversite){
		return new ResponseEntity<FiliereUniversite>(filiereUniversiteServices.updateFiliereUniversite(filiereUniversite),HttpStatus.CREATED);
	}
	@GetMapping("/FiliereUniversite/addFiliereUniversiteByNom/{nom}")
	public ResponseEntity<FiliereUniversite> getFiliereUniversiteByNom(@PathVariable("nom") String nom){
		return new ResponseEntity<FiliereUniversite>(filiereUniversiteServices.getFiliereUniversiteByNom(nom),HttpStatus.OK);
	}
	@GetMapping("/FiliereUniversite/addFiliereUniversiteByNomFaculte/{nom}")
	public ResponseEntity<List<FiliereUniversite>> getFiliereUniversiteByNomFaculte(@PathVariable("nom") String nom){
		return new ResponseEntity<List<FiliereUniversite>>(filiereUniversiteServices.getFiliereUniversiteByNomFaculte(nom),HttpStatus.OK);
	} 
	@GetMapping("/Demande/getAllDemandeEtudiantByEmailEtudiant/{email}")
	public ResponseEntity<List<Demande>> getAllDemandeEtudiantByEmail(@PathVariable("email") String email){
		return new ResponseEntity<List<Demande>>(demandeServices.getDemandeByEmailEtudiant(email),HttpStatus.OK);
	}
	@GetMapping("/FiliereUniversite/getAllFiliereUniversite")
	public ResponseEntity<List<FiliereUniversite>> getAllFiliereUniversite(){
		return new ResponseEntity<List<FiliereUniversite>>(filiereUniversiteServices.getAllFiliereUniversite(),HttpStatus.OK);
	}
	@DeleteMapping("/FiliereUniversite/deleteFiliereUniversiteById/{id}")
	public ResponseEntity<HttpStatus> deleteFiliereUniversiteById(@PathVariable("id") Long id){
		filiereUniversiteServices.deleteFiliereUniversiteById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	@DeleteMapping("/FiliereUniversite/deleteFiliereUniversite")
	public ResponseEntity<HttpStatus> deleteFiliereUniversite(@RequestBody FiliereUniversite filiereUniversite){
		filiereUniversiteServices.deleteFiliereUniversite(filiereUniversite);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	//*******************************************************************************************************
	/*
	 * Toutes les methodes des demande d'inscription du projets sont elaborer dans cette partie
	 * 
	 * */
	//*******************************************************************************************************
	@PostMapping("/DemandeInscription/addDemandeInscription")
	public ResponseEntity<DemandeInscription> creerDemandeInscription(@RequestBody DemandeInscription demandeInscription) {
		demandeInscription.setEtudiant(getEtudiant());
		return new ResponseEntity<DemandeInscription>(demandeInscriptionServices.creerDemandeInscription(demandeInscription),HttpStatus.CREATED);
	}
	@PutMapping("/DemandeInscription/updateDemandeInscription")
	public ResponseEntity<DemandeInscription> updateDemandeInscription(@RequestBody DemandeInscription demandeInscription) {
		return new ResponseEntity<DemandeInscription>(demandeInscriptionServices.updateDamandeInscription(demandeInscription),HttpStatus.CREATED);
	}
	@DeleteMapping("/DemandeInscription/deleteDemandeInscriptionById/{id}")
	public ResponseEntity<HttpStatus> deleteDemandeInscriptionBy(@PathVariable("id") Long id){
		demandeInscriptionServices.deleteDemandeInscriptionById(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	@DeleteMapping("/DemandeInscription/getDemandeInscriptionById/{id}")
	public ResponseEntity<DemandeInscription> getDemandeInscriptionById(@PathVariable("id") Long id){
		return new ResponseEntity<DemandeInscription>(demandeInscriptionServices.getDemandeInscriptionById(id),HttpStatus.OK);
	}
	@DeleteMapping("/DemandeInscription/deleteDemandeInscription")
	public ResponseEntity<HttpStatus> deleteDemandeInscription(@RequestBody DemandeInscription demandeInscription){
		demandeInscriptionServices.deleteDemandeInscription(demandeInscription);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	@GetMapping("/DemandeInscription/getAllDemandeInscription")
	public ResponseEntity<List<DemandeInscription>> getAllDemandeInscription(){
		return new ResponseEntity<List<DemandeInscription>>(demandeInscriptionServices.getAllDemandeInscription(),HttpStatus.OK);
	}
	@GetMapping("/DemandeInscription/getDemandeInscriptionByEmail/{email}")
	public ResponseEntity<List<DemandeInscription>> getDemandeInscriptionByEmail(@PathVariable("email") String email){
		return new ResponseEntity<List<DemandeInscription>>(demandeInscriptionServices.getDemandeInscriptionByEmail(email),HttpStatus.OK);
	}
	//*******************************************************************************************************
		/*
		 * Toutes les methodes des demande d'emploi du projets sont elaborer dans cette partie
		 * 
		 * */
	//*******************************************************************************************************
	@PostMapping("/DemandeEmploi/addDemandeEmploi")
	public ResponseEntity<DemandeEmploi> creerDemandeEmploi(@RequestBody DemandeEmploi demandeEmploi){
		//demandeEmploi.setEntreprise(entreprise);
		//demandeEmploi.setEtudiant(etudiant);
		return new ResponseEntity<DemandeEmploi>(demandeEmploiServices.creerDemandeEmploi(demandeEmploi),HttpStatus.CREATED);
	}
	@PutMapping("/DemandeEmploi/updateDemandeEmploi")
	public ResponseEntity<DemandeEmploi> updateDemandeEmploi(@RequestBody DemandeEmploi demandeEmploi){
		return new ResponseEntity<DemandeEmploi>(demandeEmploiServices.updateDemandeEmpoi(demandeEmploi),HttpStatus.CREATED);
	}
	@GetMapping("/DemandeEmploi/getDemandeEmploiById/{id}")
	public ResponseEntity<DemandeEmploi> getDemandeEmploi(@PathVariable("id") Long id){
		return new ResponseEntity<DemandeEmploi>(demandeEmploiServices.getDemandeEmploiById(id),HttpStatus.OK);
	}
	@GetMapping("/DemandeEmploi/getAllDemandeEmploi")
	public ResponseEntity<List<DemandeEmploi>> getAllDemandeEmploi(){
		return new ResponseEntity<List<DemandeEmploi>>(demandeEmploiServices.getAllDemandeEmploi(),HttpStatus.OK);
	}
	@GetMapping("/DemandeEmploi/getDemandeEmploiByEmail/{email}")
	public ResponseEntity<List<DemandeEmploi>> getDemandeEmploiByEmail(@PathVariable("email") String email){
		return new ResponseEntity<List<DemandeEmploi>>(demandeEmploiServices.getDemandeEmploiByEmail(email),HttpStatus.OK);
	}
	//*******************************************************************************************************
	/*
	 * Toutes les methodes des gestion des email du projets sont elaborer dans cette partie
	 * 
	 * */
	//******************************************************************************************************* 
	@PostMapping("/sendMail")
	public ResponseEntity<String> sendMail(@RequestBody EmailDetails details){
		String status = emailService.sendSimpleMail(details);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}
	
	@PostMapping("/sendMailWithAttachment")
	public ResponseEntity<String> sendMailWithAttachment(@RequestBody EmailDetails details){
		String status = emailService.sendMailWithAttachment(details);
		return new ResponseEntity<>(status, HttpStatus.CREATED);
	}
	
}

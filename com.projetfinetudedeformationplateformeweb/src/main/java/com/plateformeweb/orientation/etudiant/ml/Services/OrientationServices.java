package com.plateformeweb.orientation.etudiant.ml.Services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.plateformeweb.orientation.etudiant.ml.Entity.Etudiant;
import com.plateformeweb.orientation.etudiant.ml.Entity.FiliereUniversite;
import com.plateformeweb.orientation.etudiant.ml.Entity.Universite;
import com.plateformeweb.orientation.etudiant.ml.Repository.FiliereUniversiteRepository;
import com.plateformeweb.orientation.etudiant.ml.Repository.OrientationRepository;
import com.plateformeweb.orientation.etudiant.ml.Repository.UniversiteRepository;

@Service
public class OrientationServices {
	@Autowired
	OrientationRepository orientationRepository;
	@Autowired
	UniversiteRepository universiteRepository;
	@Autowired
	FiliereUniversiteRepository filiereUniversiteRepository;
	Set<FiliereUniversite> listeFiliere = new HashSet<>();
	Set<Universite> listeUniversite;
	public Set<FiliereUniversite> OrienterEtudiant(Etudiant etudiant,List<Universite> listeUniversite){
		listeUniversite = universiteRepository.findAll();
		if(etudiant.getClasse().compareTo("TSE") == 0 || (etudiant.getClasse().compareTo("TEXP") == 0 || etudiant.getClasse().compareTo("Texperimental") == 0)||etudiant.getClasse().compareTo("MTE") == 0||etudiant.getClasse().compareTo("MTGC") == 0) {
			for (int i=0; i < listeUniversite.size(); i++) {
				if(listeUniversite.get(i).getAbregeUniversite().compareTo("FST")==0||listeUniversite.get(i).getAbregeUniversite().compareTo("ENI")==0 || listeUniversite.get(i).getAbregeUniversite().compareTo("IPR")==0 || listeUniversite.get(i).getAbregeUniversite().compareTo("IUG")==0) {
					listeFiliere = listeUniversite.get(i).getFilieres();
					return listeFiliere;
				}
			}
		}else if(etudiant.getClasse().compareTo("TLL") == 0 || (etudiant.getClasse().compareTo("TAL") == 0 || etudiant.getClasse().compareTo("Terminal Art et Langue") == 0)||etudiant.getClasse().compareTo("TSS") == 0||etudiant.getClasse().compareTo("TSEco") == 0) {
			listeUniversite = universiteRepository.findAll();
			for (int i=0; i < listeUniversite.size(); i++) {
				if(listeUniversite.get(i).getAbregeUniversite().compareTo("Philosophie")==0 || listeUniversite.get(i).getAbregeUniversite().compareTo("Science-Education")==0) {
					listeFiliere = listeUniversite.get(i).getFilieres();
					return listeFiliere;
				}
			}
		}else if(etudiant.getClasse().compareTo("TSS") == 0||etudiant.getClasse().compareTo("TSEco") == 0) {
			
			for (int i=0; i < listeUniversite.size(); i++) {
				if(listeUniversite.get(i).getAbregeUniversite().compareTo("FHG")==0 || listeUniversite.get(i).getAbregeUniversite().compareTo("IUG")==0) {
					listeFiliere = listeUniversite.get(i).getFilieres();
					return listeFiliere;
				}
			}
		}else if(etudiant.getClasse().compareTo("TLL") == 0 || (etudiant.getClasse().compareTo("TAL") == 0 || etudiant.getClasse().compareTo("Terminal Art et Langue") == 0)) {
			listeUniversite = universiteRepository.findAll();
			for (int i=0; i < listeUniversite.size(); i++) {
				if(listeUniversite.get(i).getAbregeUniversite().compareTo("FLAH")==0 || listeUniversite.get(i).getAbregeUniversite().compareTo("IUG")==0) {
					listeFiliere = listeUniversite.get(i).getFilieres();
					return listeFiliere;
				}
			}
		}
		return null;
	}
	public Set<Universite> orientationEtudiants(Etudiant etudiant,List<Universite> list){
		Set<Universite> liste = new HashSet<>();
		if(etudiant.getClasse().compareTo("TSE")==0 || etudiant.getClasse().compareTo("TExp")==0||etudiant.getClasse().compareTo("MTI")==0 || etudiant.getClasse().compareTo("MTGC")==0) {
			for(Universite universite:list) {
				if(universite.getAbregeUniversite().compareTo("ISA")==0||universite.getAbregeUniversite().compareTo("FST")==0 ||universite.getAbregeUniversite().compareTo("IUG")==0||universite.getAbregeUniversite().compareTo("FMPOS")==0||universite.getAbregeUniversite().compareTo("ENI")==0 || universite.getAbregeUniversite().compareTo("FSEG")==0) {
					liste.add(universite);
				}
			}
		}else if(etudiant.getClasse().compareTo("TLL")==0 || etudiant.getClasse().compareTo("TAL")==0||etudiant.getClasse().compareTo("TSS")==0 || etudiant.getClasse().compareTo("TSECO")==0) {
			for(Universite universite:list) {
				if(universite.getAbregeUniversite().compareTo("FHG")==0 ||universite.getAbregeUniversite().compareTo("FSJP")==0||universite.getAbregeUniversite().compareTo("FLASH")==0||universite.getAbregeUniversite().compareTo("")==0 || universite.getAbregeUniversite().compareTo("FSEG")==0) {
					liste.add(universite);
				}
			}
		}
		
		return liste;
	}
	public List<FiliereUniversite> orienteEtudiantFilieresUniversites(String serie,String domaine){
		List<FiliereUniversite> listeFilieres = new ArrayList<>();
		List<FiliereUniversite> listeFiliereUniversite = filiereUniversiteRepository.findAll();
		System.out.println(listeFiliereUniversite.size());
		if(serie.compareTo("TSE") == 0 || serie.compareTo("MTI") == 0 ||serie.compareTo("TSExp") == 0) {
			for(FiliereUniversite filiere: listeFiliereUniversite) {
				if((filiere.getAbrege().compareTo("Math-Phys") == 0 || filiere.getAbrege().compareTo("Phys-Info") == 0 || filiere.getAbrege().compareTo("Pharmacie") == 0
						|| filiere.getAbrege().compareTo("Math-Info") == 0 || filiere.getAbrege().compareTo("Phys-Chimie") == 0 ||filiere.getAbrege().compareTo("Telecom") == 0
						||filiere.getAbrege().compareTo("Informatique") == 0||filiere.getAbrege().compareTo("gestion-Informatique") == 0)) {
					listeFilieres.add(filiere);
				}else if((filiere.getAbrege().compareTo("Energie-Renouvelable") == 0 || filiere.getAbrege().compareTo("Télécommunication") == 0 || filiere.getAbrege().compareTo("Developpement-informatique") == 0
						|| filiere.getAbrege().compareTo("Math-Info") == 0 || filiere.getAbrege().compareTo("Réseau-Télécommunication") == 0 ||filiere.getAbrege().compareTo("programation") == 0
						||filiere.getAbrege().compareTo("Informatique") == 0||filiere.getAbrege().compareTo("gestion-Informatique") == 0) && filiere.getDebaucheFiliere().compareTo(domaine)==0) {
					listeFilieres.add(filiere);
				}
			}
		}else if(serie.compareTo("TLL") == 0 || serie.compareTo("TAL") == 0) {
			for(FiliereUniversite filiere: listeFiliereUniversite) {
				if((filiere.getAbrege().compareTo("Anglais") == 0 || filiere.getAbrege().compareTo("Arabe") == 0 || filiere.getAbrege().compareTo("Allemand") == 0
						|| filiere.getAbrege().compareTo("Science-Education") == 0 || filiere.getAbrege().compareTo("Japonais") == 0 ||filiere.getAbrege().compareTo("Droit") == 0
						||filiere.getAbrege().compareTo("Droit-Affaire") == 0||filiere.getAbrege().compareTo("Droit-Privee") == 0||filiere.getAbrege().compareTo("Droit-Publique") == 0) && filiere.getDebaucheFiliere().compareTo(domaine)==0) {
					listeFilieres.add(filiere);
				}else if((filiere.getAbrege().compareTo("Energie-Renouvelable") == 0 || filiere.getAbrege().compareTo("Télécommunication") == 0 || filiere.getAbrege().compareTo("Developpement-informatique") == 0
						|| filiere.getAbrege().compareTo("Math-Info") == 0 || filiere.getAbrege().compareTo("Réseau-Télécommunication") == 0 ||filiere.getAbrege().compareTo("programation") == 0
						||filiere.getAbrege().compareTo("Informatique") == 0||filiere.getAbrege().compareTo("gestion-Informatique") == 0) && filiere.getDebaucheFiliere().compareTo(domaine)==0) {
					listeFilieres.add(filiere);
				}
			}
		}else if(serie.compareTo("TSE") == 0 ||serie.compareTo("TSExp") == 0 || serie.compareTo("TSECO") == 0){
			for(FiliereUniversite filiere: listeFiliereUniversite) {
				if((filiere.getAbrege().compareTo("Comptabilite") == 0 || filiere.getAbrege().compareTo("Economie") == 0 || filiere.getAbrege().compareTo("Statistique") == 0
						|| filiere.getAbrege().compareTo("Math-Info") == 0 || filiere.getAbrege().compareTo("Phys-Chimie") == 0 ||filiere.getAbrege().compareTo("Telecom") == 0
						||filiere.getAbrege().compareTo("Informatique") == 0||filiere.getAbrege().compareTo("gestion-Informatique") == 0) && filiere.getDebaucheFiliere().compareTo(domaine)==0) {
					listeFilieres.add(filiere);
				}else if((filiere.getAbrege().compareTo("Energie-Renouvelable") == 0 || filiere.getAbrege().compareTo("Télécommunication") == 0 || filiere.getAbrege().compareTo("Developpement-informatique") == 0
						|| filiere.getAbrege().compareTo("Math-Info") == 0 || filiere.getAbrege().compareTo("Réseau-Télécommunication") == 0 ||filiere.getAbrege().compareTo("programation") == 0
						||filiere.getAbrege().compareTo("Informatique") == 0||filiere.getAbrege().compareTo("gestion-Informatique") == 0) && filiere.getDebaucheFiliere().compareTo(domaine)==0) {
					listeFilieres.add(filiere);
				}
			}
		}else if(serie.compareTo("BAT") == 0 || serie.compareTo("TRAVAIL-BAT") == 0) {
			for(FiliereUniversite filiere: listeFiliereUniversite) {
				if((filiere.getAbrege().compareTo("Math-Phys") == 0 || filiere.getAbrege().compareTo("ENI") == 0 || filiere.getAbrege().compareTo("IUG") == 0
						|| filiere.getAbrege().compareTo("Math-Info") == 0 || filiere.getAbrege().compareTo("Phys-Chimie") == 0 ||filiere.getAbrege().compareTo("Telecom") == 0
						||filiere.getAbrege().compareTo("Informatique") == 0||filiere.getAbrege().compareTo("gestion-Informatique") == 0) && filiere.getDebaucheFiliere().compareTo(domaine)==0) {
					listeFilieres.add(filiere);
				}else if((filiere.getAbrege().compareTo("Energie-Renouvelable") == 0 || filiere.getAbrege().compareTo("Télécommunication") == 0 || filiere.getAbrege().compareTo("Developpement-informatique") == 0
						|| filiere.getAbrege().compareTo("Math-Info") == 0 || filiere.getAbrege().compareTo("Réseau-Télécommunication") == 0 ||filiere.getAbrege().compareTo("programation") == 0
						||filiere.getAbrege().compareTo("Informatique") == 0||filiere.getAbrege().compareTo("gestion-Informatique") == 0) && filiere.getDebaucheFiliere().compareTo(domaine)==0) {
					listeFilieres.add(filiere);
				}
			}
		}else if(serie.compareTo("ELECTRICITE") == 0 || serie.compareTo("ElECTROMECANIQUE") == 0 ||serie.compareTo("ELECTROCINETIQUE") == 0) {
			for(FiliereUniversite filiere: listeFiliereUniversite) {
				if((filiere.getAbrege().compareTo("Electricite") == 0 || filiere.getAbrege().compareTo("Mecanique") == 0 || filiere.getAbrege().compareTo("Mecatronique") == 0
						|| filiere.getAbrege().compareTo("Math-Info") == 0 || filiere.getAbrege().compareTo("Physique") == 0 ||filiere.getAbrege().compareTo("Telecom") == 0
						||filiere.getAbrege().compareTo("Informatique") == 0||filiere.getAbrege().compareTo("gestion-Informatique") == 0) && filiere.getDebaucheFiliere().compareTo(domaine)==0) {
					listeFilieres.add(filiere);
				}else if((filiere.getAbrege().compareTo("Energie-Renouvelable") == 0 || filiere.getAbrege().compareTo("Télécommunication") == 0 || filiere.getAbrege().compareTo("Developpement-informatique") == 0
						|| filiere.getAbrege().compareTo("Math-Info") == 0 || filiere.getAbrege().compareTo("Réseau-Télécommunication") == 0 ||filiere.getAbrege().compareTo("programation") == 0
						||filiere.getAbrege().compareTo("Informatique") == 0||filiere.getAbrege().compareTo("gestion-Informatique") == 0) && filiere.getDebaucheFiliere().compareTo(domaine)==0) {
					listeFilieres.add(filiere);
				}
			}
		}else if(serie.compareTo("TSE") == 0) {
			for(FiliereUniversite filiere: listeFiliereUniversite) {
				if((filiere.getAbrege().compareTo("Math-Phys") == 0 || filiere.getAbrege().compareTo("Phys-Chimie") == 0 || filiere.getAbrege().compareTo("Math-Info") == 0
						|| filiere.getAbrege().compareTo("Topographie") == 0 || filiere.getAbrege().compareTo("Phys-Info") == 0 ||filiere.getAbrege().compareTo("Réseau-Télécommunication") == 0|| filiere.getAbrege().compareTo("Economie") == 0|| filiere.getAbrege().compareTo("Statistique") == 0
						||filiere.getAbrege().compareTo("Informatique") == 0||filiere.getAbrege().compareTo("gestion-Informatique") == 0||filiere.getAbrege().compareTo("Mine") == 0||filiere.getAbrege().compareTo("Télécommunication") == 0||filiere.getAbrege().compareTo("Pharmacie") == 0||filiere.getAbrege().compareTo("Comptabilite") == 0)) {
					listeFilieres.add(filiere);
				}
			}
		}else if(serie.compareTo("TSExp") == 0) {
			for(FiliereUniversite filiere: listeFiliereUniversite) {
				if((filiere.getAbrege().compareTo("Histoire-Grographie") == 0 || filiere.getAbrege().compareTo("Histoire") == 0 || filiere.getAbrege().compareTo("Economie") == 0
						|| filiere.getAbrege().compareTo("Geographie") == 0 || filiere.getAbrege().compareTo("Gestion-Ressources-Humaines") == 0 ||filiere.getAbrege().compareTo("Réseau-Télécommunication") == 0
						||filiere.getAbrege().compareTo("Informatique") == 0||filiere.getAbrege().compareTo("gestion-Informatique") == 0||filiere.getAbrege().compareTo("Comptabilite") == 0||filiere.getAbrege().compareTo("Gestion-Projet") == 0||filiere.getAbrege().compareTo("Télécommunication") == 0||filiere.getAbrege().compareTo("Econometrie") == 0||filiere.getAbrege().compareTo("Statistique") == 0)) {
					listeFilieres.add(filiere);
				}
			}
		}else if(serie.compareTo("TSS") == 0) {
			for(FiliereUniversite filiere: listeFiliereUniversite) {
				if((filiere.getAbrege().compareTo("Philosophie") == 0 || filiere.getAbrege().compareTo("Geographie") == 0 || filiere.getAbrege().compareTo("Science-Education") == 0
						|| filiere.getAbrege().compareTo("Histoire") == 0 || filiere.getAbrege().compareTo("Litterature") == 0 ||filiere.getAbrege().compareTo("Geopolitique") == 0
						||filiere.getAbrege().compareTo("Droit-Affaire") == 0||filiere.getAbrege().compareTo("Droit-Public") == 0||filiere.getAbrege().compareTo("Droit-Privee") == 0||filiere.getAbrege().compareTo("Science-Politique") == 0||filiere.getAbrege().compareTo("gestion-informatique") == 0)) {
					listeFilieres.add(filiere);
				}
			}
		}else if(serie.compareTo("TLL") == 0) {
			for(FiliereUniversite filiere: listeFiliereUniversite) {
				if((filiere.getAbrege().compareTo("Philosophie") == 0 || filiere.getAbrege().compareTo("Anglais") == 0 || filiere.getAbrege().compareTo("Science-Education") == 0
						|| filiere.getAbrege().compareTo("Russe") == 0 || filiere.getAbrege().compareTo("Litterature") == 0 ||filiere.getAbrege().compareTo("Anlais-Arabe") == 0
						||filiere.getAbrege().compareTo("Anglais-Russe") == 0||filiere.getAbrege().compareTo("Allemand") == 0||filiere.getAbrege().compareTo("Anglais-Allemand") == 0||filiere.getAbrege().compareTo("Science-Politique") == 0||filiere.getAbrege().compareTo("gestion-informatique") == 0)) {
					listeFilieres.add(filiere);
				} 
			}
		}else if(serie.compareTo("TAL") == 0) {
			for(FiliereUniversite filiere: listeFiliereUniversite) {
				if((filiere.getAbrege().compareTo("Philosophie") == 0 || filiere.getAbrege().compareTo("Anglais") == 0 || filiere.getAbrege().compareTo("Science-Education") == 0 ||filiere.getAbrege().compareTo("Theatre") == 0||filiere.getAbrege().compareTo("Musique") == 0
						|| filiere.getAbrege().compareTo("Russe") == 0 || filiere.getAbrege().compareTo("Litterature") == 0 ||filiere.getAbrege().compareTo("Anlais-Arabe") == 0||filiere.getAbrege().compareTo("Comedie") == 0 ||filiere.getAbrege().compareTo("Peintre") == 0
						||filiere.getAbrege().compareTo("Anglais-Russe") == 0||filiere.getAbrege().compareTo("Allemand") == 0||filiere.getAbrege().compareTo("Anglais-Allemand") == 0||filiere.getAbrege().compareTo("Science-Politique") == 0||filiere.getAbrege().compareTo("gestion-informatique") == 0)) {
					listeFilieres.add(filiere);
				}
			}
		}else if(serie.compareTo("MTI") == 0) {
			for(FiliereUniversite filiere: listeFiliereUniversite) {
				if((filiere.getAbrege().compareTo("Math-Phys") == 0 || filiere.getAbrege().compareTo("Phys-Chimie") == 0 || filiere.getAbrege().compareTo("Math-Info") == 0 || filiere.getAbrege().compareTo("Indistrie") == 0 || filiere.getAbrege().compareTo("Maintenance-Indistrielle") == 0
						|| filiere.getAbrege().compareTo("Topographie") == 0 || filiere.getAbrege().compareTo("Phys-Info") == 0 ||filiere.getAbrege().compareTo("Réseau-Télécommunication") == 0 || filiere.getAbrege().compareTo("Manutention") == 0
						||filiere.getAbrege().compareTo("Informatique") == 0||filiere.getAbrege().compareTo("gestion-Informatique") == 0||filiere.getAbrege().compareTo("Mine") == 0||filiere.getAbrege().compareTo("Télécommunication") == 0||filiere.getAbrege().compareTo("Pharmacie") == 0||filiere.getAbrege().compareTo("Comptabilite") == 0)) {
					listeFilieres.add(filiere);
				}
			}
		}else if(serie.compareTo("MTGC") == 0) {
			for(FiliereUniversite filiere: listeFiliereUniversite) {
				if((filiere.getAbrege().compareTo("Math-Phys") == 0 || filiere.getAbrege().compareTo("Phys-Chimie") == 0 || filiere.getAbrege().compareTo("Math-Info") == 0 || filiere.getAbrege().compareTo("Indistrie") == 0 || filiere.getAbrege().compareTo("Maintenance-Indistrielle") == 0
						|| filiere.getAbrege().compareTo("Topographie") == 0 || filiere.getAbrege().compareTo("Phys-Info") == 0 ||filiere.getAbrege().compareTo("Réseau-Télécommunication") == 0 || filiere.getAbrege().compareTo("Manutention") == 0|| filiere.getAbrege().compareTo("Economie") == 0|| filiere.getAbrege().compareTo("Statistique") == 0
						||filiere.getAbrege().compareTo("Informatique") == 0||filiere.getAbrege().compareTo("gestion-Informatique") == 0||filiere.getAbrege().compareTo("Mine") == 0||filiere.getAbrege().compareTo("Télécommunication") == 0||filiere.getAbrege().compareTo("Genie-Civil") == 0||filiere.getAbrege().compareTo("Comptabilite") == 0)) {
					listeFilieres.add(filiere);
				}
			}
		}
		System.out.println(listeFilieres.size());
		System.out.println("Nom : Moussa\nPrenom : Diakite\nNote du Bac :14\n GoutScolaire :Science\n+  ");
		return listeFilieres;
	}
}

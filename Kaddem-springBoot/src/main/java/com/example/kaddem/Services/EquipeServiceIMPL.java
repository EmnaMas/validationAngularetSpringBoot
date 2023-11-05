package com.example.kaddem.Services;

import com.example.kaddem.Entity.Equipe;
import com.example.kaddem.Entity.Etudiant;
import com.example.kaddem.Entity.Niveau;
import com.example.kaddem.repository.EquipeRepository;
import com.example.kaddem.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
@Service
public class EquipeServiceIMPL implements EquipeService{
    @Autowired
    EquipeRepository equipeRepository;
    EtudiantRepository etudiantRepository;
    @Override
    public List<Equipe> retrieveAllEquipe() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return equipeRepository.save(e);
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return equipeRepository.findById(idEquipe).get();
    }

    @Override
    public void removeEquipe(Integer idEquipe) {
        equipeRepository.deleteById(idEquipe);
    }

    @Override
    public Equipe getEquipeByid(int id) {
       return equipeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEquipeByNiveau(Niveau niveau) {
         equipeRepository.deleteEquipeByNiveau(niveau);
    }

    @Override
    public List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau, String thematique) {
        return equipeRepository.retriveEquipeByNiveauAndThematique(niveau,thematique);
    }


    @Scheduled(cron = "*/10 * * * * *")
    public void faireEvoluerEquipes(){

        Iterator<Equipe> le = equipeRepository.findAll().iterator(); // tsajel l equipet lkol f iterator
        while (le.hasNext()) { //boolan taralek fama valeur baadha walaaa
            Equipe equipe = le.next() ; // trajaalek l valeur li f westha

            if (equipe.getNiveau().equals(Niveau.JUNIOR) || equipe.getNiveau().equals(Niveau.SENIOR)){

                if (TrouverAncienMembre(equipe) >= 3){
                    if (equipe.getNiveau().equals(Niveau.JUNIOR)){
                        equipe.setNiveau(Niveau.SENIOR);

                        System.out.println("passage de l'equipe "+equipe.getIdEquipe()+" de JUNIOR vers SENIOR");
                    }
                    else{ equipe.setNiveau(Niveau.EXPERT);
                        System.out.println("passage de l'equipe "+equipe.getIdEquipe()+" de SENIOR vers EXPERT");}
                    equipeRepository.save(equipe);
                }
            }
        }
    }



    private int TrouverAncienMembre(Equipe equipe) {

        int count = 0 ;

        for (Etudiant etudiant :equipe.getEtudiants() ) {
            if(etudiant.getContrat()!=null && etudiant.getContrat().getDateDebutContrat()!=null ){
                LocalDate dateContrat = etudiant.getContrat().getDateDebutContrat();
                 if(ChronoUnit.YEARS.between((Temporal) dateContrat,LocalDate.now())>=1)

                count++ ;
            }
        }
        return count ;
    }




    @Override
    public void assignEtudiantToEquipe(Integer idEtudiant, Integer idEquipe) {
        Equipe equipe=equipeRepository.findById(idEquipe).orElse(null);
        Etudiant etudiant=etudiantRepository.findById(idEtudiant).orElse(null);
        etudiant.getEquipes().add(equipe);
        etudiantRepository.save(etudiant);
    }



}

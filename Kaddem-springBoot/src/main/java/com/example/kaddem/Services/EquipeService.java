package com.example.kaddem.Services;

import com.example.kaddem.Entity.Departement;
import com.example.kaddem.Entity.Equipe;
import com.example.kaddem.Entity.Etudiant;
import com.example.kaddem.Entity.Niveau;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EquipeService {

    List<Equipe> retrieveAllEquipe();

    //Ajouter seulement
    Equipe addEquipe (Equipe e);

    Equipe updateEquipe (Equipe e);

    Equipe retrieveEquipe(Integer idEquipe);

    void removeEquipe(Integer idEquipe);
    Equipe getEquipeByid(int id);

    void deleteEquipeByNiveau(Niveau niveau);

     List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau,String thematique);
    void faireEvoluerEquipes();

    void assignEtudiantToEquipe(Integer idEtudiant, Integer idEquipe);


}

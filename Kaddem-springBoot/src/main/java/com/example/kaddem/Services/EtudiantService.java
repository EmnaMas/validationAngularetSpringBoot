package com.example.kaddem.Services;

import com.example.kaddem.Entity.Departement;
import com.example.kaddem.Entity.Domain;
import com.example.kaddem.Entity.Etudiant;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EtudiantService {
    List<Etudiant> retrieveAllEtudiants();

    //Ajouter seulement
    Etudiant addEtudiant (Etudiant e);

    //Ajouter et affecter
    Etudiant addAndAssignEtudiant (Etudiant e, Departement id );

    Etudiant updateEtudiant (Etudiant e);
    Etudiant retrieveEtudiant(Integer idEtudiant);

    void removeEtudiant(Integer idEtudiant);

}

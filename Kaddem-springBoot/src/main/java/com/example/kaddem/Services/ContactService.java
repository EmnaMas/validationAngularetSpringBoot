package com.example.kaddem.Services;

import com.example.kaddem.Entity.Contrat;
import com.example.kaddem.Entity.Departement;
import com.example.kaddem.Entity.Etudiant;

import java.util.List;

public interface ContactService {
    List<Contrat> retrieveAllContrats();

    //Ajouter seulement
    Contrat addContrat (Contrat e);

    //Ajouter et affecter
    Etudiant addAndAssignContrat (Contrat c);

    Etudiant updateContrat (Contrat contrat);

    Etudiant retrieveContrat(Integer id);

    void removeContrat(Integer id);
}

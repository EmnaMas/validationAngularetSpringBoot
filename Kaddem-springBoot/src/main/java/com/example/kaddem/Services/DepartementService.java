package com.example.kaddem.Services;

import com.example.kaddem.Entity.Departement;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartementService {
    List<Departement> retrieveAllDepartement();

    //Ajouter seulement
    Departement addDepartement (Departement e);

    Departement updateDepartement (Departement e);

    Departement retrieveDepartement(Integer idDepartement);

    void removeDepartement(Integer idDepartement);
}

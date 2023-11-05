package com.example.kaddem.Services;
import com.example.kaddem.Entity.Universite;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UniversiteService {
    List<Universite> retrieveAllUniversite();

    //Ajouter seulement
    Universite addUniversite (Universite e);

    Universite updateUniversite (Universite e);

    Universite retrieveUniversite(Integer idUniversite);

    void removeUniversite(Integer idUniversite);
}

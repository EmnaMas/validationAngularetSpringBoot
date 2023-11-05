package com.example.kaddem.Services;
import com.example.kaddem.Entity.DetailEquipe;
import org.springframework.stereotype.Service;

import java.util.List;



public interface DetailsEquipe {
    List<DetailEquipe> retrieveAllEquipe();

    //Ajouter seulement
    DetailEquipe addDetailEquipe (DetailEquipe e);

    DetailEquipe updateEquipe (DetailEquipe e);

    DetailEquipe retrieveEquipe(Integer idDetailsEquipe);

    void removeDetailsEquipe(Integer idDetailsEquipe);

    DetailEquipe getDetailEquipeById(Integer idDetailEquipe) ;

    public List<DetailEquipe> findByThematique(String thematique);

    void assignDetailEquipeToEquipe (Integer idDetailEquipe , Integer idEquipe  );

}

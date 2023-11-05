package com.example.kaddem.Services;

import com.example.kaddem.Entity.DetailEquipe;
import com.example.kaddem.Entity.Equipe;
import com.example.kaddem.repository.DetailEquipeRepository;
import com.example.kaddem.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetailsEquipeIMPL implements DetailsEquipe{
    @Autowired
    DetailEquipeRepository detailEquipeRepository;
    EquipeRepository equipeRepository;
    @Override
    public List<DetailEquipe> retrieveAllEquipe() {
        return detailEquipeRepository.findAll();
    }

    @Override
    public DetailEquipe addDetailEquipe(DetailEquipe e) {
        return detailEquipeRepository.save(e);
    }

    @Override
    public DetailEquipe updateEquipe(DetailEquipe e) {
        return detailEquipeRepository.save(e);
    }

    @Override
    public DetailEquipe retrieveEquipe(Integer idDetailsEquipe) {
        return detailEquipeRepository.findById(idDetailsEquipe).get();
    }

    @Override
    public void removeDetailsEquipe(Integer idDetailsEquipe) {
        detailEquipeRepository.deleteById(idDetailsEquipe);
    }

    @Override
    public DetailEquipe getDetailEquipeById(Integer idDetailEquipe) {
        return detailEquipeRepository.findById(idDetailEquipe).orElse(null);
    }

    @Override
    public List<DetailEquipe> findByThematique(String thematique) {
        return detailEquipeRepository.findByThematique(thematique);
    }

    @Override
    public void assignDetailEquipeToEquipe(Integer idDetailEquipe, Integer idEquipe) {

        Equipe equipe=equipeRepository.findById(idEquipe).orElse(null);
        DetailEquipe detailEquipe=getDetailEquipeById(idDetailEquipe);
        equipe.setDetailEquipe(detailEquipe);
        equipeRepository.save(equipe);
    }


}

package com.example.kaddem.Services;

import com.example.kaddem.Entity.Universite;
import com.example.kaddem.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UniversiteServiceIMPL implements UniversiteService{
    @Autowired
    UniversiteRepository universiteRepository;

    @Override
    public List<Universite> retrieveAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite e) {
        return universiteRepository.save(e);
    }

    @Override
    public Universite updateUniversite(Universite e) {
        return universiteRepository.save(e);
    }

    @Override
    public Universite retrieveUniversite(Integer idUniversite) {
        return universiteRepository.findById(idUniversite).get();
    }

    @Override
    public void removeUniversite(Integer idUniversite) {
        universiteRepository.deleteById(idUniversite);
    }
}

package com.example.kaddem.repository;

import com.example.kaddem.Entity.DetailEquipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailEquipeRepository extends JpaRepository<DetailEquipe,Integer> {

    List<DetailEquipe> findByThematique(String thematique);

}

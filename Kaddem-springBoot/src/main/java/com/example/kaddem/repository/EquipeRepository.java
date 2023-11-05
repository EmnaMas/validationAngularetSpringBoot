package com.example.kaddem.repository;

import com.example.kaddem.Entity.Equipe;
import com.example.kaddem.Entity.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface EquipeRepository extends JpaRepository<Equipe,Integer> {
    @Query("Select e From Equipe e , DetailEquipe d where e.detailEquipe.idDetailEquie=d.idDetailEquie and e.niveau=?1 and d.thematique=?2")
    List<Equipe> retrieveEquipeByNiveauAndThematique(Niveau niveau , String thematique);

    @Modifying
    @Transactional
    @Query("DELETE FROM Equipe e WHERE e.niveau=:niveau")
    void deleteEquipeByNiveau(@Param("niveau") Niveau niveau);


    @Query("SELECT  equipe from Equipe equipe , DetailEquipe deq where equipe.idEquipe = deq.equipe.idEquipe and deq.thematique= :thematique and equipe.niveau= :niveau")
    List<Equipe> retriveEquipeByNiveauAndThematique(@Param("niveau") Niveau niveau ,@Param("thematique") String thematique);


}

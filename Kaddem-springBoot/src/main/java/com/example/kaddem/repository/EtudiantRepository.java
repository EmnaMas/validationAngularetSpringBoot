package com.example.kaddem.repository;

import com.example.kaddem.Entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {

   // @Query("SELECT e from Etudiant et"

          //  + " INNER JOIN Departement departement"
            //+ " ON  et.idEtdiant= departement.idDepartement"
         //   + " INNER JOIN Universite universite"
            // + " ON departement.idDepartement = universite.idUni"
        //    + " where et.departement =:departement")
          //  + " and departement.universite =:universite")
   // public List<Etudiant>findEByUniDEP(@Param("departement") String departement,@Param("universite") String universite);


}

package com.example.kaddem.Controllers;

import com.example.kaddem.Entity.Equipe;
import com.example.kaddem.Entity.Niveau;
import com.example.kaddem.Services.EquipeService;
import com.example.kaddem.repository.EquipeRepository;
import lombok.EqualsAndHashCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/Equipe")
public class EquipeController {
    @Autowired
    EquipeService equipeService;



    @GetMapping("/getAll")
    public List<Equipe> getAllEquipe(){
        return equipeService.retrieveAllEquipe();
    }
    @PostMapping("/add")
    public Equipe addEquipe(@RequestBody Equipe equipe){
        return equipeService.addEquipe(equipe);
    }

    @PutMapping("/update")
    public Equipe updateEquipe(@RequestBody Equipe equipe){
        return equipeService.updateEquipe(equipe);
    }

    @DeleteMapping("/delete/{idE}")
    public String deleteEquipe(@PathVariable int idE){
        try {
            equipeService.removeEquipe(idE);
            return "done";
        }catch(Exception e)
        {
            return "Failed";
        }
    }

    @GetMapping("/getbyid/{idEquipe}")
    public Equipe getEquipeById (@PathVariable("idEquipe") int idEquipe) {
        return equipeService.getEquipeByid(idEquipe);
    }

   // @GetMapping("/getEquipeByNiveauAndThematique/{niveau}/{thematique}")
   // public List<Equipe> retriveEquipeByNiveauAndThematique(@PathVariable("niveau") Niveau niveau , @PathVariable("thematique") String thematique){
    //    return equipeRepository.retrieveEquipeByNiveauAndThematique(niveau,thematique);
  //  }


    @DeleteMapping("/DeleteEquipeByNiveau/{niveau}")
    public void deleteEquipeByNiveau(@PathVariable Niveau niveau){
        equipeService.deleteEquipeByNiveau(niveau);
    }

    @GetMapping("/findByNiveauAndThematique/{niv}/{th}")
    public List<Equipe> retriveEquipeByNiveauAndThematique(@PathVariable("niv") Niveau niveau, @PathVariable("th") String thematique) {
        return equipeService.retriveEquipeByNiveauAndThematique(niveau, thematique);
    }
@PostMapping("/faireEvoluerEquipes")
    public void  faireEvoluerEquipes(){
        equipeService.faireEvoluerEquipes();
}
    @PutMapping("/assignEtudiantEquipe/{idEtudiant}/{idEquipe}")
    @ResponseBody
    public void assignetu(@PathVariable("idEtudiant") Integer idEtudiant , @PathVariable("idEquipe") Integer idEquipe)
    {
        equipeService.assignEtudiantToEquipe(idEtudiant,idEquipe);
    }


}

package com.example.kaddem.Controllers;

import com.example.kaddem.Entity.DetailEquipe;
import com.example.kaddem.Entity.Equipe;
import com.example.kaddem.Services.DetailsEquipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detailEquipe")
public class DetailEquipeController {
    @Autowired
    DetailsEquipe detailsEquipe;
    @GetMapping("/getAll")
    public List<DetailEquipe> getAll(){
        return detailsEquipe.retrieveAllEquipe();
    }
    @PostMapping("/add")
    public DetailEquipe add(@RequestBody DetailEquipe detailEquipe){
        return detailsEquipe.addDetailEquipe(detailEquipe);
    }
    @PutMapping("/update")
    public DetailEquipe update(@RequestBody DetailEquipe detailEquipe){
        return detailsEquipe.updateEquipe(detailEquipe);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        detailsEquipe.removeDetailsEquipe(id);
    }

    @GetMapping("/getbyidDetailEquipe/{idDetailEquipe}")
    public DetailEquipe getDetailEquipeById(@PathVariable("idDetailEquipe") int idDetailEquipe) {
        return detailsEquipe.getDetailEquipeById(idDetailEquipe);
   }

    @GetMapping("/getDetailByThematique/{thematique}")
    public List<DetailEquipe> getDetailByThematique(@PathVariable("thematique")String thematique){
        return detailsEquipe.findByThematique(thematique);
    }



}

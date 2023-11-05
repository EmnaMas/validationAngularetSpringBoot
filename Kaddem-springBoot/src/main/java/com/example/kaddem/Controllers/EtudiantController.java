package com.example.kaddem.Controllers;

import com.example.kaddem.Entity.Etudiant;
import com.example.kaddem.Services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Etudiant")
public class EtudiantController {
    @Autowired
    EtudiantService etudiantService;

    @GetMapping("/getAllE")
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantService.retrieveAllEtudiants();
    }
    @PostMapping("/AddEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        return etudiantService.addEtudiant(e);
    }

    @PutMapping("/updateEtudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant)
    {
        return etudiantService.updateEtudiant(etudiant);
    }
    @DeleteMapping("/deleteE/{id}")
    public String removeEtudiant(@PathVariable("id") int idEtudiant){
        etudiantService.removeEtudiant(idEtudiant);
        return "delete success";
    }
}
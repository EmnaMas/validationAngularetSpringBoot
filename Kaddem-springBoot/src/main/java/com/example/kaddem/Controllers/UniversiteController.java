package com.example.kaddem.Controllers;


import com.example.kaddem.Entity.Universite;
import com.example.kaddem.Services.UniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/Universite")
public class UniversiteController {

    @Autowired
    UniversiteService universiteService;

    @GetMapping("/getAll")
    public List<Universite> getAll(){
        return universiteService.retrieveAllUniversite();
    }

    @PostMapping("/add")
    public Universite add(@RequestBody Universite universite){
        return universiteService.addUniversite(universite);
    }

    @PutMapping("/update")
    public Universite update(@RequestBody Universite universite){
        return universiteService.updateUniversite(universite);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        universiteService.removeUniversite(id);
    }
}

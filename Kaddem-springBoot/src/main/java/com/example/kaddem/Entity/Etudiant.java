package com.example.kaddem.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude="equipes")
@Getter
@Setter
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idEtdiant;
    String nomEtudiant;
    String prenomEtudiant;
    @Enumerated(EnumType.STRING)
    Domain domain;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "etudiants")
    Set<Equipe> equipes;
    @ManyToOne(cascade = CascadeType.ALL)
    Contrat contrat;
    @ManyToOne
    Departement departement;

}

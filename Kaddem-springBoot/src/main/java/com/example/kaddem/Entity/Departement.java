package com.example.kaddem.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Departement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idDepartement;
    String nomDepartement;
    @OneToMany(mappedBy = "departement")
    Set<Etudiant> etudiants;

   }


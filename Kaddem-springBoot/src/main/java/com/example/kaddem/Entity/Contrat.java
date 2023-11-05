package com.example.kaddem.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "etudiants")
@Getter
@Setter
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idContrat;
    LocalDate dateDebutContrat;
    LocalDate dateFinContrat;
    Specialite specialite;
    boolean archive;
    @OneToMany(mappedBy = "contrat")
            @JsonIgnore
    Set<Etudiant> etudiants;
}

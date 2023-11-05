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
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int idEquipe;
    private String nomEquipe;
    @Enumerated(EnumType.ORDINAL)
    private Niveau niveau;
    @OneToOne(cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    private DetailEquipe detailEquipe;
    @ManyToMany(fetch= FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "equipe_etudiant",
            joinColumns = @JoinColumn(name = "equipe_id"),
            inverseJoinColumns = @JoinColumn(name = "etudiant_id")
    )
    @EqualsAndHashCode.Exclude
    Set<Etudiant> etudiants;


}


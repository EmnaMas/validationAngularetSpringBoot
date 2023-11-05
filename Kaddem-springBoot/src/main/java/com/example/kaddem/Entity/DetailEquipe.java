package com.example.kaddem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "equipe")
@Getter
@Setter
public class DetailEquipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idDetailEquie;
    private int salle;
    private String thematique;
    @OneToOne(mappedBy = "detailEquipe")
    @JsonIgnore
    private Equipe equipe;
}

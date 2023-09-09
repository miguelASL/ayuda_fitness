package com.example.musculacion.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "musculacion")
public class MusculacionDB {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private int peso;
    private float altura;
    private int edad;

    @ElementCollection
    private final List<String> sexo = new ArrayList<>();

    @ElementCollection
    private final List<String> actividad = new ArrayList<>();

    public MusculacionDB() {
        sexo.add("hombre");
        sexo.add("mujer");

        actividad.add("sedentario");
        actividad.add("ligera");
        actividad.add("moderada");
        actividad.add("intensa");
        actividad.add("muy intensa");
    }
}



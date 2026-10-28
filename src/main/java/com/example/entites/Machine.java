package com.example.entites;

import javax.persistence.*;

@Entity
@Table(name = "machines")
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ref;
    private String marque;

    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;

    // Constructeur par défaut (obligatoire pour Hibernate)
    public Machine() {
    }

    // Constructeur sans id (pour créer une nouvelle machine)
    public Machine(String ref, String marque, Salle salle) {
        this.ref = ref;
        this.marque = marque;
        this.salle = salle;
    }

    // Constructeur complet
    public Machine(int id, String ref, String marque, Salle salle) {
        this.id = id;
        this.ref = ref;
        this.marque = marque;
        this.salle = salle;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    @Override
    public String toString() {
        return "Machine{id=" + id + ", ref='" + ref + "', marque='" + marque + "'}";
    }
}
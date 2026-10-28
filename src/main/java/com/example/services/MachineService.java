package com.example.services;

import com.example.dao.MachineDao;
import com.example.entites.Machine;
import com.example.entites.Salle;
import java.util.Collections;
import java.util.List;


public class MachineService {

    private final MachineDao machineDao;

    public MachineService() {
        this.machineDao = new MachineDao();
    }

    // Créer une machine (ref et marque obligatoires)
    public boolean create(Machine machine) {
        if (machine == null || isBlank(machine.getRef()) || isBlank(machine.getMarque())) {
            System.out.println("Erreur : la référence et la marque sont obligatoires.");
            return false;
        }
        return machineDao.create(machine);
    }

    // Modifier une machine existante
    public boolean update(Machine machine) {
        if (machine == null || machine.getId() <= 0) {
            System.out.println("Erreur : machine invalide ou inexistante.");
            return false;
        }
        if (isBlank(machine.getRef()) || isBlank(machine.getMarque())) {
            System.out.println("Erreur : la référence et la marque sont obligatoires.");
            return false;
        }
        return machineDao.update(machine);
    }

    // Supprimer une machine
    public boolean delete(Machine machine) {
        if (machine == null || machine.getId() <= 0) {
            System.out.println("Erreur : machine invalide ou inexistante.");
            return false;
        }
        return machineDao.delete(machine);
    }

    // Supprimer une machine à partir de son id
    public boolean deleteById(int id) {
        Machine machine = machineDao.getById(id);
        if (machine == null) {
            System.out.println("Erreur : aucune machine avec l'id " + id);
            return false;
        }
        return machineDao.delete(machine);
    }

    // Chercher une machine par id (retourne null si elle n'existe pas)
    public Machine findById(int id) {
        return machineDao.getById(id);
    }

    // Liste de toutes les machines
    public List<Machine> findAll() {
        return machineDao.getAll();
    }

    // Liste des machines d'une salle
    public List<Machine> findBySalle(Salle salle) {
        if (salle == null) {
            return Collections.emptyList();
        }
        return machineDao.getBySalle(salle);
    }

    // Nombre de machines dans une salle
    public int countBySalle(Salle salle) {
        return findBySalle(salle).size();
    }

    // Méthode privée : vérifie qu'un texte n'est pas vide
    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
}
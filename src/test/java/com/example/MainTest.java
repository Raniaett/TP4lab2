package com.example;

import com.example.entites.Machine;
import com.example.entites.Salle;
import com.example.services.MachineService;
import com.example.services.SalleService;

public class MainTest {
    public static void main(String[] args) {
        SalleService salleService = new SalleService();
        MachineService machineService = new MachineService();

        Salle salleA = new Salle();
        salleA.setCode("S1");
        salleA.setLibelle("Salle Informatique");

        salleService.create(salleA);

        Machine machine = new Machine();
        machine.setRef("M-101");
        machine.setMarque("Dell");
        machine.setSalle(salleA);

        machineService.create(machine);

        System.out.println("Données insérées avec succès !");
    }
}
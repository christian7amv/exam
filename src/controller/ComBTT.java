/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import Models.CiclistaConTiempo;

/**
 *
 * @author chris
 */
public class ComBTT {

    // Atributos privados según el examen
    private List<CiclistaConTiempo> ciclistas; // Lista de ciclistas
    private TreeSet<String> equipos; // Listado ordenado de equipos en mayúsculas 
    private int[] ciclistasPorEquipo; // Vector de enteros 

    // Constructor
    public ComBTT() {
        this.ciclistas = new ArrayList<>(); // Puedes usar el tipo de lista que quieras
        this.equipos = new TreeSet<>();
    }

    // Método añadir: Si no existe, inserta y devuelve true 
    public boolean añadir(CiclistaConTiempo c) {
        if (!ciclistas.contains(c)) {
            ciclistas.add(c);
            return true;
        }
        return false; // Si ya existe, no inserta y devuelve false 
    }

    // MostrarCiclistas usando un ITERADOR DE LISTAS 
    public void mostrarCiclistas() {
        Iterator<CiclistaConTiempo> it = ciclistas.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    // Método borrarCiclista sobrecargado 
    // Versión por posición (int) 
    public void borrarCiclista(int posicion) {
        if (posicion >= 0 && posicion < ciclistas.size()) {
            ciclistas.remove(posicion);
        }
    }

    // Versión por objeto [cite: 98]
    public void borrarCiclista(CiclistaConTiempo c) {
        ciclistas.remove(c);
    }

    // Generar listado de equipos sin repetir 
    public void generarListadoEquipos() {
        equipos.clear();
        for (CiclistaConTiempo c : ciclistas) {
            equipos.add(c.getEquipo()); // TreeSet evita duplicados y ordena 
        }
        contarCiclistasPorEquipo(); // Una vez finaliza, llama a contar 
    }

    // Método para contar ciclistas (solo accesible en el paquete o libBTT) 
    private void contarCiclistasPorEquipo() {
        ciclistasPorEquipo = new int[equipos.size()];
        int i = 0;
        for (String equipo : equipos) {
            int contador = 0;
            for (CiclistaConTiempo c : ciclistas) {
                if (c.getEquipo().equals(equipo)) {
                    contador++;
                }
            }
            ciclistasPorEquipo[i] = contador;
            i++;
        }
    }

    // Mostrar todos los equipos y sus participantes 
    public void mostrarEquipos() {
        int i = 0;
        for (String equipo : equipos) {
            System.out.println(equipo + " (" + ciclistasPorEquipo[i] + " ciclista/s)");
            i++;
        }
    }

    // Devuelve el ciclista con mejor tiempo (no puede ser sobreescrito)
    public final CiclistaConTiempo ciclistaConMejorTiempo() {
        if (ciclistas.isEmpty()) {
            return null;
        }

        CiclistaConTiempo mejor = ciclistas.get(0);
        for (CiclistaConTiempo c : ciclistas) {
            // Comparamos usando el método que creaste antes o sumando tiempos
            if (c.getTiempoTotalSegundos() < mejor.getTiempoTotalSegundos()) {
                mejor = c;
            }
        }
        return mejor;
    }
}

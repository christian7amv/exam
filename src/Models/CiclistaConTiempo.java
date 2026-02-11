/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Random;

/**
 *
 * @author chris
 */
public class CiclistaConTiempo extends Persona implements Moverse {
    // Constante compartida

    public static final int HORASMAX = 10;

    // Atributos
    private int dorsal;
    private String equipo;
    private int horas;
    private int minutos;
    private int segundos;

    // Constructores
    public CiclistaConTiempo() {
    }

    public CiclistaConTiempo(int dorsal, String equipo, int horas, int minutos, int segundos, String nombre, Sexo sexo, String email) {
        super(nombre, sexo, email);
        this.dorsal = dorsal;
        this.equipo = equipo;
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    

    // Getters y Setters
    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo.toUpperCase();
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        if (minutos >= 0 && minutos <= 59) {
            this.minutos = minutos;
        } else {
            System.out.println("Error: Minutos deben estar entre 0 y 59");
        }
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        if (segundos >= 0 && segundos <= 59) {
            this.segundos = segundos;
        } else {
            System.out.println("Error: Segundos deben estar entre 0 y 59");
        }
    }

    // Método para obtener tiempo total en segundos (útil para comparar)
    public int getTiempoTotalSegundos() {
        return horas * 3600 + minutos * 60 + segundos;
    }

    @Override
    public String toString() {
        return "Ciclista {"+ "dorsal=" + dorsal + ", "+ super.toString()+ ", equipo=" + equipo+ ", horas=" + horas+ ", minutos=" + minutos+ ", segundos=" + segundos+"}";
    }

    @Override
    public void presentarInfo() {
        System.out.println(this.toString());
    }

    // Métodos de la interfaz Moverse
    @Override
    public boolean avanzar() {
        System.out.println(getNombre() + " avanzando.");
        Random rand = new Random();
        return rand.nextBoolean(); // true o false aleatorio
    }

    @Override
    public void girar() {
        Random rand = new Random();
        int grados = rand.nextInt(361); //esto hara que gire
        System.out.println(getNombre() + " girando " + grados);
    }

    @Override
    public void girar(int grados) {
        System.out.println(getNombre() + " girando " + grados);
    }

    @Override
    public void frenar() {
        System.out.println(getNombre() + " parando.");
    }

    @Override
    public void saludar() {
        System.out.println("Holaaaaaa");
    }
    
}

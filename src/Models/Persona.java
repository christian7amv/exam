/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author chris
 */
public abstract class Persona {

    private String nombre;
    private Sexo sexo;
    private String email;

    public enum Sexo {
        HOMBRE, MUJER
    }

    // Constructores
    public Persona() {
    }

    public Persona(String nombre, Sexo sexo, String email) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.email = email;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", sexo=" + sexo + ", email=" + email;
    }

    // Métodos
    public void saludar() {
        System.out.println("hola");
    }

    public abstract void presentarInfo();
}

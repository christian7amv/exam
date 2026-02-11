/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Models;

/**
 *
 * @author chris
 */
public interface Moverse {

    String VERSION = "Release 1.0";

    boolean avanzar();

    void girar();

    void girar(int grados);

    void frenar();
}

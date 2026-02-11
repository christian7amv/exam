/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;

import controller.ComBTT;
import Models.CiclistaConTiempo;
import Models.Persona;
import Lib.Leer;
import java.io.IOException;

/**
 *
 * @author chris
 */
public class main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
// 1. Crea un objeto de la clase CompeticionBTT [cite: 125]
        ComBTT btt = new ComBTT();

        // 2. Añade un ciclista mediante lectura de datos por teclado [cite: 127]
        System.out.println("INTRODUCCIÓN DE DATOS DE UN NUEVO CICLISTA (c1)");
        System.out.println("----------------------------------------------");
        int d1 = Leer.enteroMayorACero("Introduce dorsal: ");
        String n1 = Leer.leerTexto("Introduce nombre del ciclista: ");
        String e1 = Leer.LeerEmail("Introduce email del ciclista: ");

        // --- CAMBIO AQUÍ: Selección de sexo con if-else estándar ---
        String s1 = Leer.leerTexto("Introduce sexo (hombre/mujer): ");
        Persona.Sexo sexo1;
        if (s1.equalsIgnoreCase("mujer")) {
            sexo1 = Persona.Sexo.MUJER;
        } else {
            sexo1 = Persona.Sexo.HOMBRE;
        }

        String eq1 = Leer.leerTexto("Introduce equipo: ");

        System.out.println("Tiempo del ciclista:");
        int h1 = Leer.enteroMayorACero("Horas: ");
        int m1 = Leer.enteroMayorACero("Minutos: ");
        int seg1 = Leer.enteroMayorACero("Segundos: ");

        CiclistaConTiempo c1 = new CiclistaConTiempo(d1, eq1, h1, m1, seg1, n1, sexo1, e1);
        btt.añadir(c1);

        // 3. Añade varios ciclistas automáticamente (mínimo 2 equipos distintos) [cite: 127]
        System.out.println("\n(AÑADIENDO 3 CICLISTAS DE FORMA AUTOMÁTICA)");
        btt.añadir(new CiclistaConTiempo(128, "Mancha BTT", 3, 12, 3, "Juan", Persona.Sexo.HOMBRE, "juanito@btt.com"));
        btt.añadir(new CiclistaConTiempo(342, "Mancha BTT", 1, 22, 7, "Ana", Persona.Sexo.MUJER, "ana@btt.com"));
        btt.añadir(new CiclistaConTiempo(454, "Quijote", 2, 8, 40, "Pablo", Persona.Sexo.HOMBRE, "pablo@btt.com"));

        // 4. Muestra la información de los ciclistas [cite: 128]
        System.out.println("\nVISUALIZACIÓN DE CICLISTAS");
        btt.mostrarCiclistas();

        // 5. Genera el listado de equipos [cite: 129]
        btt.generarListadoEquipos();

        // 6. Muestra el listado de equipos junto al número de participantes [cite: 130]
        System.out.println("\nVISUALIZACIÓN DE EQUIPOS");
        btt.mostrarEquipos();

        // 7. Prueba el método borrar ciclista pasando el OBJETO (c1) [cite: 131]
        System.out.println("\n(BORRANDO CICLISTA c1 por objeto)");
        btt.borrarCiclista(c1);

        // 8. Visualiza de nuevo los ciclistas para comprobar el resultado [cite: 132]
        System.out.println("VISUALIZACIÓN DE CICLISTAS");
        btt.mostrarCiclistas();

        // 9. Prueba el método borrar ciclista indicando la POSICIÓN (ej: 1) [cite: 133]
        System.out.println("\n(ELIMINANDO CICLISTA de la posición 1)");
        btt.borrarCiclista(1);

        // 10. Visualiza de nuevo los ciclistas para comprobar el resultado [cite: 134]
        System.out.println("VISUALIZACIÓN DE CICLISTAS");
        btt.mostrarCiclistas();

        // 11. Obtén el mejor ciclista e invoca métodos [cite: 135]
        System.out.println("\nMEJOR CICLISTA");
        CiclistaConTiempo mejor = btt.ciclistaConMejorTiempo();

        if (mejor != null) {
            System.out.println(mejor.toString());
            // Invoca métodos de Moverse y Persona 
            mejor.saludar();
            mejor.avanzar();
            mejor.girar(45);
            mejor.girar();
            mejor.frenar();
        }
    }
}

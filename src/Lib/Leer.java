/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author chris
 */
public class Leer {

    private static String leerDeTeclado() throws Exception {
        InputStreamReader flujo = new InputStreamReader(System.in, "ISO-8859-1");
        BufferedReader teclado = new BufferedReader(flujo);
        return teclado.readLine();
    }

    public static int enteroMayorACero(String mensaje) {
        try {
            System.out.print(mensaje);
            int numero = Integer.parseInt(leerDeTeclado());
            if (numero <= 0) {
                throw new Exception("El valor debe ser igual o mayor que uno"); 
            }
            return numero;
        } catch (NumberFormatException e) {
            System.err.println("Lectura.enteroMayorACero: Error en el formato del numero"); 
            return enteroMayorACero(mensaje);
        } catch (Exception e) {
            return enteroMayorACero(mensaje);
        }
    }

    public static String leerTexto(String mensaje) {
        try {
            System.out.print(mensaje);
            String resultado = leerDeTeclado();
            if (resultado.trim().isEmpty()) {
                System.out.print("Debe introducir al menos una letra");
            }
            return resultado;
        } catch (Exception e) {
            return leerTexto(mensaje);
        }
    }

    public static int leerMinYSeg(String mensaje) {
        try {
            System.out.print(mensaje);
            int valor = Integer.parseInt(leerDeTeclado());
            if (valor < 0 || valor > 59) {
                throw new Exception("Error: El valor debe estar entre 0 y 59"); 
            }
            return valor;
        } catch (Exception e) {
            System.err.println("Lectura.minutos/segundos: Error en el formato del numero");
            return leerMinYSeg(mensaje);
        }
    }

    /**
     * Lee una cadena de texto
     *
     * @param mensaje
     * @return
     * @throws java.io.IOException
     */
    public static String LeerCadena(String mensaje) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in, "ISO-8859-1");
        BufferedReader teclado = new BufferedReader(flujo);
        System.out.print(mensaje);
        return teclado.readLine();
    }

    /**
     * Lee un número entero con control de error
     *
     * @param mensaje
     * @return
     * @throws java.io.IOException
     */
    public static int LeerEntero(String mensaje) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in, "ISO-8859-1");
        BufferedReader teclado = new BufferedReader(flujo);
        String texto;
        int numero = 0;
        boolean error;
        do {
            error = false;
            System.out.print(mensaje);
            texto = teclado.readLine();
            try {
                numero = Integer.parseInt(texto.trim());
            } catch (NumberFormatException e) {
                System.err.println("Error: formato de número entero no válido.");
                error = true;
            }
        } while (error);
        return numero;
    }

    /**
     * Lee un número decimal con validación
     *
     * @param mensaje
     * @return
     * @throws java.io.IOException
     */
    public static double LeerDecimal(String mensaje) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in, "ISO-8859-1");
        BufferedReader teclado = new BufferedReader(flujo);
        String texto;
        double numero = 0;
        boolean error;
        do {
            error = false;
            System.out.print(mensaje);
            texto = teclado.readLine();
            try {
                numero = Double.parseDouble(texto.replace(',', '.').trim());
            } catch (NumberFormatException e) {
                System.err.println("Error: formato de número decimal no válido.");
                error = true;
            }
        } while (error);
        return numero;
    }

    /**
     * Método para leer un correo electrónico válido. Acepta formatos tipo
     * usuario@dominio.com
     *
     * @param mensaje
     * @return
     * @throws java.io.IOException
     */
    public static String LeerEmail(String mensaje) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in, "ISO-8859-1");
        BufferedReader teclado = new BufferedReader(flujo);

        String email = "";
        boolean lecturaCorrecta;

        do {
            lecturaCorrecta = true;
            System.out.print(mensaje);
            try {
                email = teclado.readLine();
            } catch (IOException ex) {
                System.out.println("\tError: fallo en la lectura");
            }

            // Expresión regular para validar email
            String regex = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);

            if (!matcher.matches()) {
                System.err.println("\tError: formato de email incorrecto. Ejemplo: usuario@mail.com");
                lecturaCorrecta = false;
            }
        } while (!lecturaCorrecta);

        return email;
    }

    /**
     * Método para leer un número de teléfono válido. Acepta formatos tipo
     * 123456789 o +** 123456789
     *
     * @param mensaje
     * @return
     * @throws java.io.IOException
     */
    public static String LeerTelefono(String mensaje) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in, "ISO-8859-1");
        BufferedReader teclado = new BufferedReader(flujo);

        String telefono = "";
        boolean lecturaCorrecta;

        do {
            lecturaCorrecta = true;
            System.out.print(mensaje);
            try {
                telefono = teclado.readLine();
            } catch (IOException ex) {
                System.out.println("\tError: fallo en la lectura");
            }

            // Expresión regular para validar teléfono (9?14 dígitos, opcional '+')
            String regex = "^[\\+]?\\d{9,14}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(telefono);

            if (!matcher.matches()) {
                System.err.println("\tError: formato de teléfono incorrecto. Ejemplo: +34600123456 o 600123456");
                lecturaCorrecta = false;
            }
        } while (!lecturaCorrecta);

        return telefono;
    }

    public static char confirmarSoN(String mensaje) throws IOException {
        char letra = 0;
        do {
            letra = LeerCaracter(mensaje);
        } while (letra != 's' && letra != 'n'
                && letra != 'S' && letra != 'N');

        return letra;
    }

    // ============================
    //  MÉTODO DE LECTURA DE CARÁCTER
    // ============================
    /**
     * Lee un solo carácter (char) desde teclado.
     *
     * @param mensaje
     * @return
     * @throws java.io.IOException
     */
    public static char LeerCaracter(String mensaje) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in, "ISO-8859-1");
        BufferedReader teclado = new BufferedReader(flujo);

        String texto;
        char caracter = ' ';
        boolean error;

        do {
            error = false;
            System.out.print(mensaje);
            texto = teclado.readLine().trim();

            if (texto.length() != 1) {
                System.err.println("Error: introduce solo un carácter.");
                error = true;
            } else {
                caracter = texto.charAt(0);
            }

        } while (error);

        return caracter;
    }

}

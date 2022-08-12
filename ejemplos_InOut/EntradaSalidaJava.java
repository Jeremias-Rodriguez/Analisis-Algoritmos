/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos_InOut;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author jeremias.rodriguez
 */
public class EntradaSalidaJava {
    static final String archivoEntrada = "./src/ejemplos_InOut/entrada.txt";
    static String archivoSalida = "./src/ejemplos_InOut/sinEspacios.txt";
    static Random generador = new Random();
    
    public static void main(String[] args) {
        //borrarEspacios();
        //lineasImpares();
        //generarArchivoCon100Numeros();
        generarCadenasRandomDe10Char();
    }
    
    /**
     * TOMA UN ARCHIVO Y GENERA COMO SALIDA UN ARCHIVO SIN ESPACIOS.
     */
    public static void borrarEspacios(){
        archivoSalida = "./src/ejemplos_InOut/sinEspacios.txt";
        String linea = null;
        
        try {
            FileReader lectorArchivo = new FileReader(archivoEntrada);
            FileWriter escritorArchivo = new FileWriter(archivoSalida);

            BufferedReader bufferLectura = new BufferedReader(lectorArchivo);
            BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);
            
            int i = 0;
            
            while ((linea = bufferLectura.readLine()) != null) {
                linea = linea.replace(" ", "");
                System.out.println(linea);
                bufferEscritura.write(linea +"\n");
            }
            
            bufferLectura.close();
            bufferEscritura.close();
        }
        catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }
    
    /**
     * TOMA UN ARCHIVO DE N LINEAS Y CREA UN ARCHIVO DE SALIDA CON LAS LINEAS
     * EN POSICIONES IMPARES.
     */
    public static void lineasImpares(){
        archivoSalida = "./src/ejemplos_InOut/lineasImpares.txt";
        String linea = null;
        
        try {
            FileReader lectorArchivo = new FileReader(archivoEntrada);
            FileWriter escritorArchivo = new FileWriter(archivoSalida);

            BufferedReader bufferLectura = new BufferedReader(lectorArchivo);
            BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);
            
            int numeroDeLineaActual = 0;
            
            while ((linea = bufferLectura.readLine()) != null) {
                numeroDeLineaActual++;
                if(numeroDeLineaActual%2 == 1){
                    linea = linea.replace(" ", "");
                    System.out.println(linea);
                    bufferEscritura.write(linea +"\n");
                }
            }
            
            bufferLectura.close();
            bufferEscritura.close();
        }
        catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }
    
    /**
     * GENERA ARCHIVO CON 100 NUMEROS ENTRE 100 Y -100.
     */
    public static void generarArchivoCon100Numeros(){
        final int CANTNUMEROS = 100;
        final int MIN_VALOR = -100;
        final int MAX_VALOR = 100;
        final String NOMBRE_ARCHIVO = "./src/ejemplos_InOut/numerosEntre100y-100.txt";

        try{
                BufferedWriter buff = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO));
                
                for (int i = 0; i < CANTNUMEROS ; i++){
                        double num = MIN_VALOR + generador.nextDouble() * (MAX_VALOR - MIN_VALOR);
                        buff.write( num +"\n");
                        System.out.println(num);
                }
                buff.close();

        }
        catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }
    
    /**
     * GENERA ARCHIVO CON CADENAS DE 10 CARACTERES.
     */
    public static void generarCadenasRandomDe10Char() {
        final int CANTCADENAS = 0;
        char[] caracteres = {'0', 'a','z', 'A','Z'};
        archivoSalida = "./src/ejemplos_InOut/cadenasAleatorias.txt";
        String linea = "";
        
        try {
            FileWriter escritorArchivo = new FileWriter(archivoSalida);

            BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);
            char caracter;
            for (int j = 0; j <= CANTCADENAS; j++) {
                for(int k = 0; k < 10; k++){
                    linea += caracter;
                }
                bufferEscritura.write(linea +"\n");
                linea = "";
            }
            
            bufferEscritura.close();
        }
        catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        }
        catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }
    
    //public static void 
}

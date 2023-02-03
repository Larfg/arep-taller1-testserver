package edu.escuelaing.app;

import java.io.*;
import java.lang.reflect.Array;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Aplicación que nos permite probar el funcionamiento de un servidor de consulta de peliculas concurrentemente
 * @author Luis Giraldo
 * @version 1.0
 */
public class App{
    /**
     * Metodo principal que ejecuta las consultas e inicializa los elementos de estas
     */
    public static void main(String[] args)  {
        Boolean ok = true;
        System.out.print( "Cuantas busquedas desea hacer:");
        //Se le pregunta al usuario la cantidad de consultas que se desean hacer
        Scanner myInput = new Scanner( System.in );
        int hilos = myInput.nextInt();
        ArrayList<String> peliculas = new ArrayList<String>(Arrays.asList("die+hard", "indiana+jones","harry+potter"));
        //Creamos una lista con los hilos de busqueda
        ArrayList<Busqueda> busquedas = new ArrayList<>();
        for(int i = 0; i < hilos; i++){
            Busqueda busqueda = new Busqueda();
            Random r = new Random();
            //Elegimos un elemento aleatorio de las 3 consultas de prueba
            busqueda.setTitulo(peliculas.get(r.nextInt(3)));
            //Iniciamos los hilos
            busqueda.run();
            busquedas.add(busqueda);
        }
        //Comprobamos que cada busqueda fuera exitosa
        for(Busqueda busqueda : busquedas){
            if (busqueda.isOk() == false){
                ok = false;
            }
        }
        System.out.println("==========================================================");
        if (ok == true){
            System.out.println("El servidor funciona correctamente");
        }
        else{
            System.out.println("El servidor no funciona correctamente");
        }
        System.out.println("==========================================================");

    }


}

package edu.escuelaing.app;

import java.io.*;
import java.lang.reflect.Array;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App{
    public static void main(String[] args)  {
        Boolean ok = true;
        System.out.print( "Cuantas busquedas desea hacer:");
        Scanner myInput = new Scanner( System.in );
        int hilos = myInput.nextInt();
        ArrayList<String> peliculas = new ArrayList<String>(Arrays.asList("die+hard", "indiana+jones","harry+potter"));
        ArrayList<Busqueda> busquedas = new ArrayList<>();
        for(int i = 0; i < hilos; i++){
            Busqueda busqueda = new Busqueda();
            Random r = new Random();
            busqueda.setTitulo(peliculas.get(r.nextInt(3)));
            busqueda.run();
            busquedas.add(busqueda);
        }
        for(Busqueda busqueda : busquedas){
            if (busqueda.isOk() == false){
                ok = false;
            }
        }
        if (ok == true){
            System.out.println("El servidor funciona correctamente");
        }
        else{
            System.out.println("El servidor no funciona correctamente");
        }

    }


}

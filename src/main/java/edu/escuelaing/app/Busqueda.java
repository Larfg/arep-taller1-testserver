package edu.escuelaing.app;

import java.io.*;
import java.net.*;
/**
 * Hilo de busqueda de una pelicula con un titulo
 * @author Luis Giraldo
 * @version 1.0
 */
public class Busqueda extends Thread {
    private boolean ok = false;
    private String titulo = "";

    /**
     * Metodo que nos ejecuta el hilo, y nos realiza una consulta al servidor retornando los datos de la pelicula
     */
    @Override
    public void run() {
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            echoSocket = new Socket("localhost", 35000);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don’t know about host!.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn’t get I/O for "
                    + "the connection to: localhost.");
            System.exit(1);
        }
        out.println("titulo:"+titulo);
        String inputLine;
        String lastLine = "";
        try {
            while ((inputLine = in.readLine()) != null) {
                lastLine = inputLine;
            }
        } catch (IOException e) {
            inputLine = "";
            System.out.println("fallo");
        }
        System.out.println("consulta" + lastLine);
        if (lastLine != "" || lastLine!= null) {
            ok = true;
        }
        out.close();
        try{
            in.close();
            echoSocket.close();
        }
        catch (IOException e) {
            System.out.println("fallo");
        }
    }

    public boolean isOk() {
        return ok;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProcesosYeray;

/**
 *
 * @author yeray
 */
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.esperarYMatar();
    }
    
    private void ejecutaComando() throws Exception {
        ProcessBuilder pb = new ProcessBuilder("CMD","dir","c:\\users");
        Process p = pb.start();
        pb.inheritIO();
        
        p.waitFor(5,TimeUnit.SECONDS);
    }
    private void esperarAQueTermine()throws Exception {
        ProcessBuilder pb = new ProcessBuilder("ping","88.208.35.41");
        Process p = pb.start();
        while(p.isAlive()) {
            System.out.println("esperando");
            Thread.sleep(2000);
        }
    }
    private void esperarYMatar()throws Exception {
        ProcessBuilder pb = new ProcessBuilder("ping","-n","64","88.208.35.41");
        Process p = pb.start();
        Thread.sleep(5000);
        if(p.isAlive()) {
           p.destroyForcibly();
           System.out.print("Process killed, that BD was lackin' (BDK)");
        }
        BufferedReader lector = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader lector2 = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        String linea =null;
        System.out.println("salida del comando");

        while((linea = lector.readLine())!=null) {
            System.out.println(linea);
        }

        String linea1 =null;
        while((linea1 = lector1.readLine())!=null) {
            System.out.println("error lines:"+lineas1);
        }
    }
}

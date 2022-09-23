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
        //main.buscaYGuarda("C:\\Users\\yeray\\Documents\\pythonfriendlytabs\\mubu.txt", "C:\\Users\\yeray\\Documents\\pythonfriendlytabs\\mubu2.txt", "mubu");
        String  [] params = {"ping","-n","64","8.8.8.8"};
        main.esperarYMatar(params);
    }
    
    private void ejecutaComando(String [] c) throws Exception {
        ProcessBuilder pb = new ProcessBuilder(c);
        Process p = pb.start();
        pb.inheritIO();
        
        p.waitFor(5,TimeUnit.SECONDS);
    }
    private void esperarAQueTermine(String [] c)throws Exception {
        ProcessBuilder pb = new ProcessBuilder(c);
        Process p = pb.start();
        while(p.isAlive()) {
            System.out.println("esperando");
            Thread.sleep(2000);
        }
    }
    private void esperarYMatar(String [] c)throws Exception {
        ProcessBuilder pb = new ProcessBuilder(c);
        Process p = pb.start();
        pb.inheritIO();
        
        boolean vivo = p.waitFor(5,TimeUnit.SECONDS);
        if(vivo) {
           p.destroyForcibly();
           System.out.print("Process killed, that BD was lackin' (BDK)");
        }
        BufferedReader lector = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader lector1 = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        String linea =null;
        System.out.println("salida del comando");

        while((linea = lector.readLine())!=null) {
            System.out.println(linea);
        }

        String linea1 =null;
        while((linea1 = lector1.readLine())!=null) {
            System.out.println("error lines:"+linea1);
        }
    }
    private void ejecutarEnDirectorio(String [] args) throws Exception{
        ProcessBuilder pb = new ProcessBuilder(args);
        Process p = pb.start();
        BufferedReader lector = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader lector1 = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        String linea =null;
        System.out.println("salida del comando");

        while((linea = lector.readLine())!=null) {
            System.out.println(linea);
        }

        String linea1 =null;
        while((linea1 = lector1.readLine())!=null) {
            System.out.println("error lines:"+linea1);
        }
    }
    private void buscaYGuarda(String fichero,String fichero2,String texto) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("CMD","find",texto,fichero,">","fichero2");
        Process p = pb.start();
    }
}

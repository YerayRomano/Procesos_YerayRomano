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
import java.util.concurrent.TimeUnit;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.ejecutaComando();
    }
    
    private void ejecutaComando() throws Exception {
        ProcessBuilder pb = new ProcessBuilder("CMD","dir","c:\\users");
        Process p = pb.start();
        pb.inheritIO();
        
        p.waitFor(5,TimeUnit.SECONDS);
    }
}

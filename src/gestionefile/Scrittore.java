package gestionefile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Meddiki Yassine
 * @version 18/01/24
 * Questa classe implementa l'interfaccia "Runnable"
 * e si occupa di scrivere i dati dell'utente
 */

public class Scrittore implements Runnable{

    String nomeFile;
    String Username;
    String Password;
    String fileCopia;
        
    public Scrittore(String nomeFile, String Username, String Password){
        this.nomeFile = nomeFile;
        this.Username = Username;
        this.Password = Password;
    }

    @Override
    public void run() {
        scrivi();
    }
    /**
     * Scrive un file di testo usando la classe BufferedWriter
     */
    public void scrivi() {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(nomeFile))) {
        br.write("<" + Username + ">");
        br.write("\n\r");
        br.write("<" + Password + ">");
        br.write("\n\r");
        br.flush();
        } catch (IOException ex) {
        Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


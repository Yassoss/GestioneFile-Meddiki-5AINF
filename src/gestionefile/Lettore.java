package gestionefile;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

/**
 * @author Meddiki Yassine
 * @version 18/01/24
 * Questa classe estedela classe "Thread" ed ha
 * il compito di leggere il contenuto di un file.
 */

public class Lettore extends Thread{
    String nomeFile;
    
    public Lettore(String nomeFile){
        this.nomeFile = nomeFile;
    }
    
    /**
     * Legge il file senza tener conto del tipo di file
     * e lo mostra in output
     */
    public void leggi(){
        int i; //Per leggere i singoli caratteri dal file
        //Blocco "try-with-resources" che gestisce le risorse
        //Viene creato un oggetto "BufferedReader" che avvolge un "FileReader"
        try(BufferedReader fr = new BufferedReader(new FileReader(nomeFile))){ 

            //2) leggo carattere per carattere e lo stampo 
            while ((i=fr.read()) != -1) //EOF
                //Stampa il carattere letto in input convertendolo in tipo "char"
                System.out.print((char) i); //Lettura e visualizzazione carattere per carattere

            System.out.print("\n\r"); //Stampa una nuova riga
            //3) chiudo il file
        } catch (IOException ex) {
            System.err.println("Errore in lettura!");
        }
    }
    

    public void run(){
        leggi();
    }
}

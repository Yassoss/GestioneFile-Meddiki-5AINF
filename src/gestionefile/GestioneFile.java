package gestionefile;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Meddiki Yassine
 * @version 18/01/24
 * Questa classe gestisce il flusso del programma,
 * nel quale avviene l'interazione con l'utente attraverso
 * la classe "Scanner", la lettura e la scrittura 
 * dei file utilizzando gli oggetti delle 
 * classi "Lettore" e "Scrittore".
 */
public class GestioneFile {
    public static void main(String[] args) throws IOException {
        
        //1)LETTURA
        Lettore lettore = new Lettore("user.json");
        lettore.start();

        //2)ELABORAZIONE
        Scanner scan = new Scanner(System.in); //Creazione oggetto "scan"
       
        System.out.println("Inserisci username: "); //Input dell'username
        String Username = scan.nextLine();

        System.out.println("Inserisci password: ");//Input della password
        String Password = scan.nextLine();

        //3) SCRITTURA
        //Creazione di tre oggetti "Scrittore", ogni oggetto è istanziato con un nome di file diverso e le informazionidell'utente
        Scrittore scrittore = new Scrittore("output.csv", Username, Password);
        Scrittore copia = new Scrittore("copia.csv", Username, Password);
        Scrittore StreamCopia = new Scrittore("user.csv", Username, Password);
        //Creazione di un oggetto "Thread" a cui viene passato l'oggetto "StreamCopia", avvio del Thread
        Thread threadStream = new Thread(StreamCopia);
        threadStream.start();
        /*Scrittura nel file "user.csv", creazione di un oggetto "DataOutputStream"
        che utilizza un "BufferedOutputStream" e un "FileOutputStream" per scrivere i dati*/
        String dataFile = "user.csv";
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)));
        out.writeUTF(dataFile);
        //Creazione e avvio di due oggetti "Thread" che scriveranno nei file "output.csv" e "copia.csv"
        Thread threadScrittore = new Thread(scrittore);
        Thread threadCopia = new Thread(copia);
        threadCopia.start();
        threadScrittore.start();
    }
    
}

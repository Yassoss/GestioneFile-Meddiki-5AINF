package gestionefile;
import java.util.Scanner; //Importazione della classe "Scanner"
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Meddiki Yassine
 * @version 18/01/24
 */
public class GestioneFile {

    /**
     * @param args the command line arguments
     */
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
        Scrittore scrittore = new Scrittore("output.csv", Username, Password);
        Scrittore copia = new Scrittore("copia.csv", Username, Password);
        Scrittore StreamCopia = new Scrittore("user.csv", Username, Password);
        Thread threadStream = new Thread(StreamCopia);
        threadStream.start();
        String dataFile = "user.csv";
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)));
        out.writeUTF(dataFile);
        Thread threadScrittore = new Thread(scrittore);
        Thread threadCopia = new Thread(copia);
        threadCopia.start();
        threadScrittore.start();
    }
    
}

package gestionefile;
import java.util.Scanner; //Importazione della classe "Scanner"
/**
 *
 * @author Meddiki Yassine
 * @version 18/01/24
 */
public class GestioneFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
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
        Scrittore scrittore = new Scrittore("output.csv");
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
        write(username, password);
    }
    
}

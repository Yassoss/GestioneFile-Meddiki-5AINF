package gestionefile;

public class Utente {
    private String Username;
    private String Password;
  
    public Utente(String Username, String Password){
      this.Username = Username;
      this.Password = Password;
    }
    public String getUsername(String Username){
      return Username;
    }

    public String getPassword(String Password){
      return Password; 
    }
}

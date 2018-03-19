package listeners.mappers;

public class UserInfo {

    private String pseudo;
    private String email;
    private String nom;
    private String prenom;
    private String password;
    private int age;

    /*
    Constructeur, utilisé automatiquement par le système de mapping des attributs JSon
     */
    public UserInfo(String pseudo, String email, String nom, String prenom, String password, int age) {
        this.pseudo = pseudo;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.age = age;
    }


    /* Setter probablement inutiles,
        le mapping se fait automatiquement et on
        a pas à modifier le message par la suite
     */

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getNom() {
        return nom;
    }


}
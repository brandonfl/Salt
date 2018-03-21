package database.mysql;
import serveur.Session;

import java.sql.* ;

/**
 * La classe Database implemente l'interface database avec toutes les commandes mysql necessaires
 */
public class MySQLDatabase implements database.Database {
  
  //TODO Implementer cette classe qui permet de faire l'interface entre la  database et le serveur



    /**
     * AddUser permet d'ajouter un nouvel utilisateur avec notamment :
     * <ul>
     *     <li>son identifiant(id) <strong>unique</strong></li>
     *     <li>son pseudo <strong>unique</strong></li>
     *     <li>son nom</li>
     *     <li>son prenom</li>
     *     <li>son email <strong>unique</strong></li>
     *     <li>son age</li>
     * </ul>
     *
     * @param pseudo le pseudo du compte
     * @param nom le nom de la personne ayant créé le compte
     * @param prenom le prenom de la personne ayant créé le compte
     * @param email l'email du compte
     * @param age l'age de la personne ayant créé le compte
     * @return un Boolean qui permet de savoir si l'ajout a bien été fait
     */
    @Override
    public Boolean addUser(String pseudo, String nom, String prenom, String email, String password, int age) {
        Connection con = Connect.connection();
        Boolean bool = false;

        try{
            // create our java preparedstatement using a sql update query
            PreparedStatement ps = con.prepareStatement("INSERT INTO membre(pseudo,prenom,nom,email,password,age) VALUES(?,?,?,?,?,?)");

            // set the preparedstatement parameters
            ps.setString(1,pseudo);
            ps.setString(2,nom);
            ps.setString(3,prenom);
            ps.setString(4,email);
            ps.setString(5,password);
            ps.setInt(6,age);

            // call executeUpdate to execute our sql update statement
            int exec = ps.executeUpdate();
            ps.close();

            bool = (exec == 1);
        }
        catch (SQLException se){
            se.printStackTrace();
            System.exit(1);
        }
        return bool;
    }

    /**
     * connection permet à un utilisateur de se connecter
     *
     * @param email son email
     * @param password son mot de passe en sha1
     * @return un objet du type Session
     */
    @Override
    public Session connection(String email, String password) {
        Connection con = Connect.connection();

        int id= 0;
        String pseudo = null;
        String prenom = null;
        String nom = null;
        int age = 0;

        try {
            // Envoi d’un requête générique
            String sql =  "select * from membre WHERE email='"+email+"'";
            Statement smt = con.createStatement() ;
            ResultSet rs = smt.executeQuery(sql) ;

            while (rs.next()) {
                id = rs.getInt("id");
                pseudo = rs.getString("pseudo");
                prenom = rs.getString("prenom");
                nom = rs.getString("nom");
                age = rs.getInt("age");
            }
        }  catch (Exception e) {
            System.exit(1);
        }
        return new Session(id,pseudo,prenom,nom,email,age);
    }


    /**
     * editPassword permet à un utilisateur de changer son password.
     * Rappel : C'est le client qui doit l'envoyé en sha1
     *
     * @param id l'id de l'utilisateur
     * @param old son ancien mot de passe
     * @param password le nouveau mot de passe
     * @param passwordVerification la verification du nouveau mot de passe
     * @return un boolean qui permet de dire si le mot de passe a bien été modifié
     */
    @Override
    public Boolean editPassword(int id, String old, String password,String passwordVerification) {
        Connection con = Connect.connection();
        String oldpassword = null;
        Boolean bool = false;

        try {
            // Envoi d’un requête générique
            String sql =  "select * from membre WHERE id=" + id;
            Statement smt = con.createStatement() ;
            ResultSet rs = smt.executeQuery(sql) ;

            while (rs.next()) {
                oldpassword = rs.getString("password");
            }

            System.out.println(oldpassword);
        }  catch (Exception e) {
            System.exit(1);
        }

        if(oldpassword.compareTo(old)==0 && password.compareTo(passwordVerification)==0){

            try{
                // create our java preparedstatement using a sql update query
                PreparedStatement ps = con.prepareStatement("UPDATE membre SET password ='"+passwordVerification+"' WHERE id ="+id);

                // set the preparedstatement parameters
                //ps.setString(1,passwordVerification);
                //ps.setInt(2,id);

                // call executeUpdate to execute our sql update statement
                int exec = ps.executeUpdate();
                ps.close();

                bool = (exec == 1);
            }
            catch (SQLException se){
                System.exit(1);
            }

        }else {
            return false;
        }

        return bool;
    }


    /**
     * ExistUser permet de savoir si un utilisateur existe
     *
     * @param pseudo son pseudo
     * @return un boolean permettant de savoir si oui ou non l'utilisateur existe
     */
    @Override
    public Boolean existUser(String pseudo) {
        Connection con = Connect.connection();
        Boolean bool = false;
        int nb = 0;


    try{
        Statement stmt = con.createStatement();

        String sql = "SELECT COUNT(*) AS nb FROM membre WHERE pseudo='"+pseudo+"'";
        ResultSet rs = stmt.executeQuery(sql);
        //STEP 5: Extract data from result set
        while(rs.next()){
            //Retrieve by column name
            nb  = rs.getInt("nb");
        }
        rs.close();

        bool = (nb > 0); // Si il y a plus de 0 membres

    }catch(SQLException se){
        //Handle errors for JDBC
        bool = false;
    }
    return bool;

    }

    /**
     * deleteUser permet de supprimer des utilisateurs
     * @param pseudo le pseudo de l'utilisateur
     * @return un boolean permettant de savoir si oui ou non l'utilisateur a bien été supprimé
     */
    @Override
    public Boolean deleteUser(String pseudo) {
        Connection con = Connect.connection();
        Boolean bool = false;

        try{
            // create our java preparedstatement using a sql update query
            PreparedStatement ps = con.prepareStatement("DELETE FROM membre WHERE pseudo = ?");

            // set the preparedstatement parameters
            ps.setString(1,pseudo);

            // call executeUpdate to execute our sql update statement
            int exec = ps.executeUpdate();
            ps.close();

            bool = (exec == 1);
        }
        catch (SQLException se){
            se.printStackTrace();
            System.exit(1);
        }
        return bool;

    }


}
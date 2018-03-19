package database.mysql;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import serveur.Session;

import static org.junit.Assert.assertEquals;

public class TestUnitConnexion {

    private static final String pseudo = "test";
    private static final String nom = "test";
    private static final String prenom = "test";
    private static final String email = "test@test.fr";
    private static final String password = "test";
    private static final int age = 11;


    @BeforeClass public static void begin(){
        database.mysql.Database database = new Database();

        if(database.existUser(pseudo)==false){
            database.addUser(pseudo,nom,prenom,email,password,age);
        }
    }

    @Test public void testConnection(){
        Database database = new Database();

        Session session;

        session = database.connection(email,password);


        assertEquals(pseudo,session.getPseudo());
        assertEquals(nom,session.getNom());
        assertEquals(prenom,session.getPrenom());
        assertEquals(email,session.getEmail());
        assertEquals(age,session.getAge());
    }


    @AfterClass public static void end(){
        database.mysql.Database database = new Database();

        if(database.existUser(pseudo)){
            database.deleteUser(pseudo);
        }
    }






}

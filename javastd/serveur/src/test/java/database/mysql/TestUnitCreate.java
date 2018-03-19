package database.mysql;


import database.mysql.Database;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestUnitCreate {

    @Before public void begin(){
        database.mysql.Database database = new Database();
        String pseudo = "test";

        if(database.existUser(pseudo)){
            database.deleteUser(pseudo);
        }
    }

    @Test public void creationUtilisateur(){
        database.mysql.Database database = new Database();

        String pseudo = "test";
        String nom = "test";
        String prenom = "test";
        String email = "test@test.fr";
        String password = "test";
        int age = 11;

        boolean bool1;
        boolean bool2;

        bool1 = database.addUser(pseudo,nom,prenom,email,password,age);

        bool2 = database.existUser(pseudo);

        System.out.println(bool1);
        System.out.println(bool2);

        assertEquals(bool1,bool2);
    }


    @AfterClass public static void end(){
        database.mysql.Database database = new Database();
        String pseudo = "test";

        if(database.existUser(pseudo)){
            database.deleteUser(pseudo);
        }
    }


}
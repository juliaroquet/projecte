package edu.upc.dsa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBJDBC2 extends DBJDBC{


    public static void insert() throws SQLException{
        Connection connection = DBUtils.getConnection();

        // SQL INJECTION
        String theQuery = "INSERT INTO User (id, name) VALUES (0, ?)";
        // log.debug

        PreparedStatement statement1  =  connection.prepareStatement(theQuery);
        statement1.setString(1, "Lidia");


        // a = b / 0  - null.method();

        /// NULLPOINTER ??
        statement1.execute();
        /// NULLPOINTER ??


        connection.close();

    }



    public static void main(String[] args) throws Exception {
        insert();
        findAll();

        // ORM (Object Relation Mapping) --> DAO (Data Access Object)

/*
        User u = new User("Toni");
        s.save(u); =====================> "INSERT INTO USER ...."
        u.setName("Juan");
        s.update(u); ====> "UPDATE xxx"

        s.save(new Object("Escudo")):; //"INSERT NTO Object
        s.save(new Mapa("Escudo")):;   // INSERT INTO Mapa
*/


    }

}

package edu.upc.dsa;

import java.sql.*;

public class DBJDBC {

    public static void insert() throws SQLException{

        Connection connection = DBUtils.getConnection();
        Statement statement1  = connection.createStatement();
        statement1.execute("INSERT INTO User (id, name) VALUES (0,'anna')");
        // i = x / 0
        connection.close();

/*
        Connection connection=null;
        try {
            connection = DBUtils.getConnection();


            Statement statement1  = connection.createStatement();
            statement1.execute("INSERT INTO User (ID, lastName, firstName, address, city) VALUES (0,'88888', 'thMceF\'irstName', 'theAddress', 'theCity')");
            //connection.close();

        }
        catch (Exception e) {
           // ...
        }
        finally {
            connection.close();
        }
*/
    }


    private static String getType (int type) {
        String ret = null;
        switch (type) {
            case Types.VARCHAR:
                ret ="VARCHAR";
                break;
            case Types.INTEGER:
                ret = "INTEGER";
                break;
            case Types.DATE:
                ret = "DATE";
                break;

        }

        return ret;
    }


    public static void findAll()  throws Exception {
        Connection connection = null;
        try {
            connection = DBUtils.getConnection();
            Statement statement2 = connection.createStatement();
            ResultSet rs = statement2.executeQuery("SELECT *  FROM User WHERE 1=1");
            // INTROSPECCIÓ BBDD
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println("cols "+rsmd.getColumnCount());
            int i = 1;
            while (i<=rsmd.getColumnCount()) {
                System.out.println("col  "+i+" "+rsmd.getColumnName(i)+" "+
                           rsmd.getColumnType(i)+ " "+DBJDBC.getType(rsmd.getColumnType(i)));
                i++;
            }

            int id;
            String name;

            while (rs.next()) {
                id = (Integer) rs.getObject(1); // 0
                name = (String) rs.getObject(2);

                System.out.println(id+" "+name);

                // Per cada propietat dins de la fila:
                // while (j<=rsmd.getNumColumn()) {
                     // theValue = rs.getObject(j);
                     // theProperty = rsmd.getColumnName(j);
                     // ObjectHelper.setter(theObject, theProperty, theValue);
                // }
            }
        } catch (Exception e) {
            //log.d ("", e)
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        insert();
        findAll();
    }

}

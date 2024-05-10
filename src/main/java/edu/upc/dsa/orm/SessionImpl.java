package edu.upc.dsa.orm;

import edu.upc.dsa.orm.util.ObjectHelper;
import edu.upc.dsa.orm.util.QueryHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;


public class SessionImpl implements Session {
    private final Connection conn;

    public SessionImpl(Connection conn) {
        this.conn = conn;
    }

    public void save(Object entity) {


        // INSERT INTO Partida () ()
        String insertQuery = QueryHelper.createQueryINSERT(entity);
        // INSERT INTO User (ID, lastName, firstName, address, city) VALUES (0, ?, ?, ?,?)


        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(insertQuery);
            pstm.setObject(1, 0);
            int i = 2;

            for (String field: ObjectHelper.getFields(entity)) {
                pstm.setObject(i++, ObjectHelper.getter(entity, field));
            }

            pstm.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object get(Class theClass, Object ID) {
        return null;
    }

    @Override
    public Object get(Object entity , Hashtable table) {
        String selectQuery = QueryHelper.createQuerySELECT(entity,table);
        PreparedStatement pstm = null;
        List<Object> ListObject = new ArrayList<Object>();
        try {
            pstm = conn.prepareStatement(selectQuery);
            pstm.setObject(1, 1);
            pstm.executeQuery();
            ResultSet rs = pstm.getResultSet();
            while (rs.next()) {
                Class clase = entity.getClass();
                Object o = clase.newInstance();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++)
                    ObjectHelper.setter(o, rs.getMetaData().getColumnName(i), rs.getObject(i));
                ListObject.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return ListObject;
    }

    public Object get(Class theClass, int ID) {
/*
        String sql = QueryHelper.createQuerySELECT(theClass);

        Object o = theClass.newInstance();


        ResultSet res = null;

        ResultSetMetaData rsmd = res.getMetaData();

        int numColumns = rsmd.getColumnCount();
        int i=0;

        while (i<numColumns) {
            String key = rsmd.getColumnName(i);
            String value = res.getObject(i);

            ObjectHelper.setter(o, key, value);

        }

*/
        return null;
    }

    public void update(Object object) {

    }

    public void delete(Object object) {

    }

    public List<Object> findAll(Class theClass) {
        return null;
    }


    @Override
    public Object getbyTwoParameters(Class theClass, String byFirstParameter, Object byFirstParameterValue, String bySecondParameter, Object bySecondParameterValue) {
        String selectQuery = QueryHelper.createQuerySELECTbyTwoParameters(theClass, (String) byFirstParameterValue, (String) bySecondParameterValue);


        PreparedStatement pstm = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;

        try {
            Object object = theClass.getDeclaredConstructor().newInstance();

            pstm = conn.prepareStatement(selectQuery);

            pstm.setObject(1, byFirstParameter);
            pstm.setObject(2, bySecondParameter);
            pstm.executeQuery();
            rs = pstm.getResultSet();

            if (rs.next()) {

                rsmd = rs.getMetaData();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    String field = rsmd.getColumnName(i);
                    ObjectHelper.setter(object, field, rs.getObject(i));
                }
                return object;

            } else {
                return null;
            }

        } catch (SQLException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Object> findAll(Class theClass, HashMap params) {
     /*   String theQuery = QueryHelper.createSelectFindAll(theClass, params);
        PreparedStatement pstm = null;
        pstm = conn.prepareStatement(theQuery);

        int i=1;
        for (Object value : params.values()) {
            pstm.setObject(i++, value );
        }
        //ResultSet rs = pstm.executeQuery();




        return result;
*/
        return null;
    }

    public List<Object> query(String query, Class theClass, HashMap params) {
        return null;
    }
}

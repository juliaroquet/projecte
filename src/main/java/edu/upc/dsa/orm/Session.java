package edu.upc.dsa.orm;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public interface Session<E> {
    void save(Object entity);                                           // Crud
    void close();
    Object get(Class theClass, Object ID);                                 // cRud

    Object get(Object entity, Hashtable table);

    void update(Object object);                                         // crUd
    void delete(Object object);                                         // cruD
    List<Object> findAll(Class theClass);
    Object getbyTwoParameters(Class theClass, String byFirstParameter, Object byFirstParameterValue, String bySecondParameter, Object bySecondParameterValue);// cR
    List<Object> findAll(Class theClass, HashMap params) throws SQLException;
    List<Object> query(String query, Class theClass, HashMap params);
}

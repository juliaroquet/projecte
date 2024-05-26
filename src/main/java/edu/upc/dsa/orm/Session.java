package edu.upc.dsa.orm;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface Session<E> {
    void save(Object entity);                                           // Crud
    void close();
    // cRud

    Object get(Class theClass, String column, Object entity) throws SQLException, InstantiationException, IllegalAccessException;

    void update(Object object);                                         // crUd
    void delete(Object object);                                         // cruD
    List<Object> findAll(Class theClass);
    Object getbyTwoParameters(Class theClass, String byFirstParameter, Object byFirstParameterValue, String bySecondParameter, Object bySecondParameterValue);// cR
    Object update(Object entity, String row);
    List<Object> query(String query, Class theClass, HashMap params);
}

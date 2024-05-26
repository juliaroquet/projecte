package edu.upc.dsa.orm.util;

import org.apache.log4j.Logger;

public class QueryHelper {
    final static Logger logger = Logger.getLogger(QueryHelper.class);
    public static String createQueryINSERT(Object entity) {
        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("(");

        String [] fields = edu.upc.dsa.orm.util.ObjectHelper.getFields(entity);

        //idUser primary key, I think we should change it to username, but then when we need to do
        //an instert for the inventori the primary key should also be the idUser
        sb.append("idUser");
        for (String field: fields) {
            if (!field.equals("idUser")) sb.append(", ").append(field);
        }
        sb.append(") VALUES (?");

        for (String field: fields) {
            if (!field.equals("idUser"))  sb.append(", ?");
        }
        sb.append(")");
        // INSERT INTO User (ID, lastName, firstName, address, city) VALUES (0, ?, ?, ?,?)
        return sb.toString();


    }

    public static String createQuerySELECT(Class theClass, String row) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(theClass.getSimpleName());
        sb.append(" WHERE " + row + " = ?");

        return sb.toString();
    }


    public static String createSelectFindAll(Class theClass) {

        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(theClass.getSimpleName());

        return sb.toString();
    }
    public static String createQuerySELECTbyTwoParameters(Class theClass, String byFirstParameter, String bySecondParameter) {

        StringBuffer sb = new StringBuffer("SELECT * FROM ");
        sb.append(theClass.getSimpleName());
        sb.append(" WHERE " + byFirstParameter + " = ?");
        sb.append(" AND " + bySecondParameter + " = ?");

        return sb.toString();
    }
    public static String createQueryUPDATE(Object entity, String row) {
        StringBuffer sb = new StringBuffer("UPDATE ");
        sb.append(entity.getClass().getSimpleName()).append(" SET ");

        String[] fields = edu.upc.dsa.orm.util.ObjectHelper.getFields(entity);

        boolean firstField = true;
        for (String field: fields) {
            if (!field.equals(row)) {
                if (!firstField) {
                    sb.append(", ");
                }
                sb.append(field).append(" = ?");
                firstField = false;
            }
        }
        sb.append(" WHERE ").append(row).append(" = ?");

        return sb.toString();
    }
}


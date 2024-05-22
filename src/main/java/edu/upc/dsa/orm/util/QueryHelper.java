package edu.upc.dsa.orm.util;

import org.apache.log4j.Logger;

public class QueryHelper {
    final static Logger logger = Logger.getLogger(QueryHelper.class);
    public static String createQueryINSERT(Object entity) {
        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("(");

        String [] fields = edu.upc.dsa.orm.util.ObjectHelper.getFields(entity);

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


        /*
        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("(");

        //Obté els camps de la classe
        String [] fields = edu.upc.dsa.orm.util.ObjectHelper.getFields(entity);

        for(String s:fields){
            sb.append(s).append(", ");
        }
        //Elimina la última coma i el espai afegits en el bucle per tenir la sintaxi correcte
        sb=sb.replace(sb.length()-2,sb.length(),"");

        //sb.append(") VALUES (?");
        sb.append(") VALUES (");

        for (String s:fields) {
            sb.append("?, ");
        }
        sb=sb.replace(sb.length()-2,sb.length(),"");

        sb.append(")");

        return sb.toString();

         */


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
}


package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class User {

        String idUser;
        String name;
        String surname;
        String username;
        String password;

        public User(){ this.idUser = RandomUtils.getIdUser(); }
        public User(String name, String surname, String username, String password){
            this.idUser = idUser;
            this.name = name;
            this.surname = surname;
            this.username = username;
            this.password = password;
        }

    public String getIdUser() {
        return this.idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

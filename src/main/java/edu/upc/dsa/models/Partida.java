package edu.upc.dsa.models;

public class Partida {
    private int idPartida;
    int idMapa = getIdMapa();
    private String idUser;

    public Partida(){

    }

    public Partida(int idPartida, int idMapa, String idUser) {
        this.idPartida = idPartida;
        this.idMapa = idMapa;
        this.idUser = idUser;
    }
    public int getIdPartida() {
        return idPartida;
    }
    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }
    public int getIdMapa() {
        return idMapa;
    }
    public void setIdMapa(int idMapa) {
        this.idMapa = idMapa;
    }
    public String getIdUser() {
        return idUser;
    }
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

}

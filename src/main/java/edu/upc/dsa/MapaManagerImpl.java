package edu.upc.dsa;

import edu.upc.dsa.exceptions.MapaNoExiste;
import edu.upc.dsa.exceptions.MapaNomYaExisteix;
import edu.upc.dsa.models.Mapa;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class MapaManagerImpl implements MapaManager{
    private static MapaManager instance;
    public List<Mapa> listmapas;

    final static Logger logger = Logger.getLogger(MapaManagerImpl.class);
    public MapaManagerImpl(){
        this.listmapas = new ArrayList<>();
    }
    public static MapaManager getInstance(){
        if (instance==null) instance = new MapaManagerImpl();
        return instance;
    }
    public int size(){
        int ret = this.listmapas.size();
        logger.info("size " + ret);
        return ret;
    }
    @Override
    public List<Mapa> getmapalist() {
        return listmapas;
    }

    @Override
    public Mapa getmapa(int id) throws MapaNoExiste {
        boolean found = listmapas.contains(id);
        if(found) {
            logger.info("found " + id);
            return listmapas.get(id);
        }
        else{
            logger.warn("not found " + id);
            throw new MapaNoExiste();
        }
    }

    @Override
    public Mapa addmapa(int foodElements, int fuelElements, int fuelRequirement, int enemies, String name) throws MapaNomYaExisteix {
        if(listmapas.contains(name)){
            logger.warn("El nom del mapa ja existeix");
            throw new MapaNomYaExisteix();
        }
        else {
            Mapa mapa = new Mapa(foodElements, fuelElements, fuelRequirement, enemies, name);
            listmapas.add(mapa.getIdMapa(), mapa);
            logger.info("added mapa: " + mapa.getIdMapa());
            return mapa;
        }
    }

    @Override
    public Mapa deletemapa(int id) throws MapaNoExiste {
        Mapa mapa = listmapas.remove(id);
        if(mapa!=null){
            logger.info("Mapa eliminado: " + mapa.getIdMapa());
            return mapa;
        }
        else{
            logger.warn("Mapa no existeix");
            throw new MapaNoExiste();
        }
    }
}

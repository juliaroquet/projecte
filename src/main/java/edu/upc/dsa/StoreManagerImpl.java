package edu.upc.dsa;

import edu.upc.dsa.exceptions.ProductNoExiste;
import edu.upc.dsa.exceptions.ProductYaExiste;
import edu.upc.dsa.models.Product;
import edu.upc.dsa.models.User;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StoreManagerImpl implements StoreManager{
    private static StoreManager instance;

    List<Product> listproducts;
    final static Logger logger = Logger.getLogger(StoreManagerImpl.class);
    private StoreManagerImpl(){
        this.listproducts = new ArrayList<>();

    }
    public static StoreManager getInstance(){
        if (instance==null) instance = new StoreManagerImpl();
        return instance;
    }
    public int size(){
        int ret = this.listproducts.size();
        logger.info("size " + ret);
        return ret;
    }
    @Override
    public List<Product> getProducts() {
        return listproducts;
    }

    @Override
    public void addProduct(String name, String description, double price) throws ProductYaExiste {
        Product p = new Product(name, description, price);
        String id = p.getIdProduct();
        logger.info("Comprovem que aquest producte no esta a la nostre llista");
        if(listproducts.contains(id)){
            logger.error("Aquest producte ja esta a la llista");
            throw new ProductYaExiste();
        }
        logger.info("producte afegit");
        listproducts.add(p);
    }

    @Override
    public void deleteProduct(Product product) throws ProductNoExiste {
        logger.info("Comprovem que el producte existeix");
        String idP = product.getIdProduct();
        if(listproducts.contains(idP)){
            logger.info("Borrem Producte");
            listproducts.remove(product);
        }
        logger.error("Aquest producte no existeix");
        throw new ProductNoExiste();
    }


}

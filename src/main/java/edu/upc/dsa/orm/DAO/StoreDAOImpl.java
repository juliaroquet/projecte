package edu.upc.dsa.orm.DAO;

import edu.upc.dsa.models.Inventario;
import edu.upc.dsa.models.Product;
import edu.upc.dsa.orm.FactorySession;
import edu.upc.dsa.orm.Session;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class StoreDAOImpl implements StoreDAO {
    private static StoreDAO instance;
    private List<Product> listproducts;

    final static Logger logger =Logger.getLogger(StoreDAOImpl.class);

    private StoreDAOImpl() {
        this.listproducts = new ArrayList<Product>();

    }
    public static StoreDAO getInstance() {
        if(instance == null) instance = new StoreDAOImpl();
        return instance;
    }

    @Override
    public Product getProduct(int id) {
        Session session = null;
        try{
            session = FactorySession.openSession();
            Product product = (Product) session.get(Product.class, "idProduct", id);
            logger.info("getPoduct("+id+"): "+product);
            return product;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        logger.info("Product not found");
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        Session session = null;
        List<Product> listproducts = null;
        try{
            session = FactorySession.openSession();
            listproducts = session.findAll(Product.class);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return listproducts;
    }

    @Override
    public Inventario buyProduct(Inventario inventario) {
        Inventario i = new Inventario(inventario.getIdUser(), inventario.getIdProduct(), inventario.getQuantity());
        Session session = null;
        try {
            session = FactorySession.openSession();
            session.save(i);
            logger.info("usuari afegit");
            return i;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }
}

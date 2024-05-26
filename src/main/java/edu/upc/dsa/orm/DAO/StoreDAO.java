package edu.upc.dsa.orm.DAO;

import edu.upc.dsa.models.Inventario;
import edu.upc.dsa.models.Product;

import java.util.List;

public interface StoreDAO {
    public Product getProduct(int id);
    public List<Product> getAllProducts();
    public Inventario buyProduct(Inventario inventario);

}

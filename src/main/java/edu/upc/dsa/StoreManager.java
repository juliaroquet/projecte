package edu.upc.dsa;

import edu.upc.dsa.exceptions.ProductNoExiste;
import edu.upc.dsa.exceptions.ProductYaExiste;
import edu.upc.dsa.exceptions.UserNoExiste;
import edu.upc.dsa.models.Product;
import edu.upc.dsa.models.User;

import java.util.HashMap;
import java.util.List;

public interface StoreManager {
    public List<Product> getProducts();
    //public List<User> getUsers();
    public Product getProduct(String id);
    public void deleteP(String id);
    public void addProduct(String id,String name, String description, double price) throws ProductYaExiste;
    public void deleteProduct(Product product) throws ProductNoExiste;
    public HashMap<String, Product> comprar(User user, Product product) throws ProductNoExiste, UserNoExiste;
}

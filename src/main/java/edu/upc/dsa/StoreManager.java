package edu.upc.dsa;

import edu.upc.dsa.exceptions.ProductNoExiste;
import edu.upc.dsa.exceptions.ProductYaExiste;
import edu.upc.dsa.models.Product;
import edu.upc.dsa.models.User;

import java.util.List;

public interface StoreManager {
    public List<Product> getProducts();
    public void addProduct(String name, String description, double price) throws ProductYaExiste;
    public void deleteProduct(Product product) throws ProductNoExiste;
}

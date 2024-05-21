package edu.upc.dsa.orm.DAO;

import edu.upc.dsa.exceptions.PasswordIncorrecteException;
import edu.upc.dsa.exceptions.UserNotRegisteredException;
import edu.upc.dsa.models.Product;
import edu.upc.dsa.models.User;

import java.util.List;

public interface IUserDAO {
    public User registerUser(User user);
    public User loginUser(String username, String password) throws PasswordIncorrecteException, UserNotRegisteredException;
    public List<User> getUsers();
    public List<Product> getuserInventario(String username) throws UserNotRegisteredException;
    //public void comprar(User user, Product product) throws ProductNoExiste, UserNoExiste;

}

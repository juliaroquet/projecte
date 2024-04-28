package edu.upc.dsa;

import edu.upc.dsa.exceptions.*;
import edu.upc.dsa.models.Product;
import edu.upc.dsa.models.User;

import javax.ws.rs.Produces;
import java.util.List;

public interface UserManager {
    public User registerUser(User user) throws UserNameYaExiste;
    public User loginUser(String username, String password) throws PasswordIncorrecteException, UserNotRegisteredException;
    public List<User> getUsers();
    //public void comprar(User user, Product product) throws ProductNoExiste, UserNoExiste;


}

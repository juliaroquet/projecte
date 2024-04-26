package edu.upc.dsa;

import edu.upc.dsa.exceptions.PasswordIncorrecteException;
import edu.upc.dsa.exceptions.UserNameYaExiste;
import edu.upc.dsa.exceptions.UserNotRegisteredException;
import edu.upc.dsa.models.User;

import java.util.List;

public interface UserManager {
    public User registerUser(User user) throws UserNameYaExiste;
    public User loginUser(String username, String password) throws PasswordIncorrecteException, UserNotRegisteredException;
    public List<User> getUsers();


}

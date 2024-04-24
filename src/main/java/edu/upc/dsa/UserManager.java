package edu.upc.dsa;

import edu.upc.dsa.exceptions.PasswordIncorrecteException;
import edu.upc.dsa.exceptions.UserNameYaExiste;
import edu.upc.dsa.exceptions.UserNotRegisteredException;
import edu.upc.dsa.models.User;

public interface UserManager {
    public User registerUser(String name, String surname, String username, String password) throws UserNameYaExiste;
    public User loginUser(String username, String password) throws PasswordIncorrecteException, UserNotRegisteredException;


}

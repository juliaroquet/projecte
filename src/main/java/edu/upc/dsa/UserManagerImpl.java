package edu.upc.dsa;

import edu.upc.dsa.exceptions.PasswordIncorrecteException;
import edu.upc.dsa.exceptions.UserNameYaExiste;
import edu.upc.dsa.exceptions.UserNotRegisteredException;
import edu.upc.dsa.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;

public class UserManagerImpl implements UserManager{
    private static UserManager instance;
    private HashMap<String, User> MapUsers;
    List<User> listusers;
    final static Logger logger = Logger.getLogger(UserManagerImpl.class);
    private UserManagerImpl(){
        this.listusers = new ArrayList<>();
        this.MapUsers = new HashMap<>();
    }
    public static UserManager getInstance(){
        if (instance==null) instance = new UserManagerImpl();
        return instance;
    }
    public int size(){
        int ret = this.MapUsers.size();
        logger.info("size " + ret);
        return ret;
    }


    @Override
    public User registerUser(String name, String surname, String username, String password) throws UserNameYaExiste {
        logger.info("Comprovem que no hi ha un nom d'usuari ja existent igual");
        if(MapUsers.containsKey(username)){
            logger.error("Aquest username ya s'esta utilitzant");
            throw new UserNameYaExiste();
        }
        logger.info("User registrat");
        User user = new User(name, surname, username, password);
        MapUsers.put(username, user);
        listusers.add(user);
        return user;

    }

    @Override
    public User loginUser(String username, String password) throws PasswordIncorrecteException, UserNotRegisteredException {
        User user = MapUsers.get(username);
        if(user != null){
            logger.info("L'usuari existeix");
            if(!password.equals(user.getPassword())){
                logger.warn("Password incorrecte");
                throw new PasswordIncorrecteException();
            }
            logger.warn("User logged in");
            return user;
        }
        else{
            logger.warn("User no registrat");
            throw new UserNotRegisteredException();
        }

    }
}

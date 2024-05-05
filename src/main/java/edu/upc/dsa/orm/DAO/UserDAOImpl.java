package edu.upc.dsa.orm.DAO;

import edu.upc.dsa.UserManagerImpl;
import edu.upc.dsa.exceptions.PasswordIncorrecteException;
import edu.upc.dsa.exceptions.UserNameYaExiste;
import edu.upc.dsa.exceptions.UserNotRegisteredException;
import edu.upc.dsa.models.Product;
import edu.upc.dsa.models.User;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDAOImpl implements IUserDAO {
    private static IUserDAO instance;
    private HashMap<String, User> MapUsers;
    public List<User> listusers;
    private HashMap<String, Product> inventario;
    final static Logger logger = Logger.getLogger(UserManagerImpl.class);
    private UserDAOImpl(){
        this.listusers = new ArrayList<>();
        this.MapUsers = new HashMap<>();
    }
    public static IUserDAO getInstance(){
        if (instance==null) instance = new UserDAOImpl();
        return instance;
    }
    public int size(){
        int ret = this.MapUsers.size();
        logger.info("size " + ret);
        return ret;
    }


    @Override
    public User registerUser(User user) throws UserNameYaExiste {
        logger.info("Comprovem que no hi ha un nom d'usuari ja existent igual");
        User user1 = MapUsers.get(user.getUsername());
        if(user1 != null){
            logger.error("Aquest username ya s'esta utilitzant");
            throw new UserNameYaExiste();
        }
        logger.info("User registrat");
        listusers.add(user);
        MapUsers.put(user.getUsername(), user);
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

    @Override
    public List<User> getUsers() {
        return listusers;
    }

    /*@Override
    public void comprar(User user, Product product) throws ProductNoExiste, UserNoExiste {
        if(user == null ) {
            logger.info("Comprovem que l'usuari existeix");
            throw new UserNoExiste();
        } else if (product == null) {
            logger.info("Comprovem que el producte existeix");
            throw new ProductNoExiste();
        }
        else{
            String idUser = user.getIdUser();
            inventario.put(idUser, product);
        }

    }*/
}

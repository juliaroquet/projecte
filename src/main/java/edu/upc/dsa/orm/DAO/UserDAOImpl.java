package edu.upc.dsa.orm.DAO;

import edu.upc.dsa.UserManagerImpl;
import edu.upc.dsa.exceptions.UserNotRegisteredException;
import edu.upc.dsa.models.Product;
import edu.upc.dsa.models.User;
import edu.upc.dsa.orm.FactorySession;
import edu.upc.dsa.orm.Session;
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
    public int registerUser(User user)  {
        Session session = null;
        int idUser = 1;
        try{
            session = FactorySession.openSession();
            User user1 = new User(user.getIdUser(), user.getName(), user.getSurname(), user.getPassword(), user.getUsername());
            session.save(user1);
        }
        catch(Exception e){

        }
        finally{
            session.close();
        }
        return idUser;

    }

    @Override
    public User loginUser(String username, String password)  {
      Session session = null;
      User user = null;
      try{
          session = FactorySession.openSession();
          user = (User) session.getbyTwoParameters(User.class, username, "nombre", password, "password");
          if (user!=null) {
              logger.info(user + " rebut!");
              return user;
          }
      }
      catch (Exception e) {
          logger.warn("not found "+ user);
          e.printStackTrace();
      }
      finally {
          session.close();
      }
        return null;
    }

    @Override
    public List<User> getUsers() {
       Session session = null;
       List<User> listusers = null;
       try{
           session = FactorySession.openSession();
           listusers = session.findAll(User.class);
       }
       catch(Exception e){
           e.printStackTrace();
       }
       finally{
           session.close();
       }
       return listusers;
    }

    @Override
    public List<Product> getuserInventario(String username) throws UserNotRegisteredException {
        return null;
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

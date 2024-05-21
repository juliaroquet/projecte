package edu.upc.dsa.services;

import edu.upc.dsa.UserManagerImpl;
import edu.upc.dsa.exceptions.PasswordIncorrecteException;
import edu.upc.dsa.exceptions.UserNameYaExiste;
import edu.upc.dsa.exceptions.UserNotRegisteredException;
import edu.upc.dsa.models.Credencials;
import edu.upc.dsa.models.Register;
import edu.upc.dsa.models.User;
import edu.upc.dsa.orm.DAO.IUserDAO;
import edu.upc.dsa.orm.DAO.UserDAOImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "/userBBDD", description = "Endpoint to User Service")
@Path("/userBBDD")
public class UserDAOService {
    private IUserDAO um;

    public UserDAOService() {
        this.um = UserDAOImpl.getInstance();
        /*
        if (um.getUsers().size()==0){
            um.registerUser(new User(1,"Laura","Fernandez","lauraa8","12345"));
        }
        */
    }

    @Path("basic")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it";
    }

    @GET
    @Path("/reg2/{name}/{surname}")
    public Response register2(@PathParam("name") String name, @PathParam("surname") String surname) {
        User u = new User(0,name, surname, "tonipro", "12345");

        if(u.getUsername()==null || u.getPassword()==null) {
            return Response.status(501).entity(u).build();
        }
        User us = this.um.registerUser(u);
        if(us == null)
            return Response.status(404).build();
        else
            return Response.status(201).entity(u).build();

    }

    @POST
    @ApiOperation(value = "User Registration", notes = "Registrem a un usuari")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User register Successfull"),
            @ApiResponse(code = 404, message = "This username is already being used"),
            @ApiResponse(code = 501, message = "Error")

    })
    @Path("/reg")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(Register register) throws UserNameYaExiste {
        User u = new User(register.getIdUser(),register.getName(), register.getSurname(), register.getUsername(), register.getPassword());

        if(u.getUsername()==null || u.getPassword()==null) return Response.status(501).entity(u).build();
        User us = this.um.registerUser(u);
        if(us == null)
            return Response.status(404).build();
        else
            return Response.status(201).entity(u).build();
       /* //if (user.getName() == null || user.getSurname()==null || user.getPassword()== null || user.getUsername() == null)  return Response.status(500).entity(user).build();
        try{
            this.um.registerUser(new User(user.getIdUser(), user.getName(), user.getSurname(), user.getUsername(), user.getPassword()));
            return Response.status(201).entity(user).build();
        }
        catch(Exception e){
            return Response.status(404).entity(user).build();
        }

        */

    }

    @POST
    @ApiOperation(value = "User Log in", notes = "Fem login d'un usuari")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User logg in Successfull"),
            @ApiResponse(code = 404, message = "The password is incorrect"),

    })
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Credencials credencials) throws PasswordIncorrecteException, UserNotRegisteredException {
        User user1 = this.um.loginUser(credencials.getUsername(), credencials.getPassword());
        if(user1 != null){
            return Response.status(201).entity(user1).build();
        }
        return Response.status(404).entity(user1).build();
    }

}

package edu.upc.dsa.services;

import edu.upc.dsa.StoreManager;
import edu.upc.dsa.StoreManagerImpl;
import edu.upc.dsa.UserManager;
import edu.upc.dsa.UserManagerImpl;
import edu.upc.dsa.exceptions.ProductYaExiste;
import edu.upc.dsa.exceptions.UserNameYaExiste;
import edu.upc.dsa.models.Product;
import edu.upc.dsa.models.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/store", description = "Endpoint to Store Service")
@Path("/store")
public class StoreService {
    private StoreManager sm;
    public StoreService() throws ProductYaExiste {
        this.sm = StoreManagerImpl.getInstance();
        if (sm.getProducts().size()==0){
            sm.addProduct("Martillo","Tool to save the alien",15);
            sm.addProduct("Pico","Tool to save the alien",20);

        }

    }
    @GET
    @ApiOperation(value = "get Store Products", notes = "Show a list of Products that are in the store")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Product.class, responseContainer="List"),
    })
    @Path("/getStoreProducts")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListofProducts() {
        List<Product> products = this.sm.getProducts();

        GenericEntity<List<Product>> entity = new GenericEntity<List<Product>>(products) {};
        return Response.status(201).entity(entity).build();



    }

}

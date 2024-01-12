package Controller;

import DAO.*;
import Entity.*;
import Metier.*;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import Metier.MetierCategories;

@Path("/api/categories")
public class categorieController {

    private MetierCategories metierCategories=new MetierCategories();

    
    
    /*------------- CRUD for categories ------------*/
    /*-----------------------------------------------------*/
      
    
      @Path("/listAll")
      @GET
      @Produces(MediaType.APPLICATION_JSON)
      public List<Categorie> getAllCategories() {
          return metierCategories.getAllCategories();
      }//URL to test : http://localhost:8080/BackendStockL/api/categories/listAll
      

      @Path("/update/{id}")
      @PUT
      @Consumes(MediaType.APPLICATION_JSON)
      @Produces(MediaType.APPLICATION_JSON)   
      public String updateCategory(@PathParam("id") int id, Categorie category) {
      	return metierCategories.updateCategory(id, category);
      }//URL to test : http://localhost:8080/BackendStockL/api/categories/update/
      
      
      
      @Path("/add")
      @POST
      @Consumes(MediaType.APPLICATION_JSON)
      @Produces(MediaType.APPLICATION_JSON)
      public String addCategory(Categorie cat) {
          return metierCategories.addCategory(cat);
      }//URL to test : http://localhost:8080/BackendStockL/api/categories/add

      
      @Path("/getCategory/{id}") 
      @GET
      @Produces(MediaType.APPLICATION_JSON)
      public Categorie getCategoryById(@PathParam("id") int id) {
          return metierCategories.getCategoryById(id);
      }//URL to test : http://localhost:8080/BackendStockL/api/categories/getCategory/
    
      
      @Path("/delete/{id}")
      @DELETE
      @Produces(MediaType.APPLICATION_JSON)
      public void deleteCategory(@PathParam("id") int id) {
          metierCategories.deleteCategory(id);
      }
      //URL to test : http://localhost:8080/BackendStockL/api/categories/delete/
      
    
}

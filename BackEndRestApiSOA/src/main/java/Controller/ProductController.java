package Controller;


import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import Entity.*;
import Metier.MetierProducts;


@Path("/api/products")
public class ProductController{

	
    private MetierProducts metierProducts=new MetierProducts();
    
    
   
       /*------------- CRUD for products ------------*/
    /*-----------------------------------------------------*/
    
    
    
    @Path("/listAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProducts() {
        return metierProducts.getAllProducts();
  } //URL to test : http://localhost:8080/BackendStockL/api/products/listAll
    
    
    
    @Path("/productsByCategory/{idCat}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product>getProductsByCategory(@PathParam("idCat") int idCat){
    	return metierProducts.getProductsByCategory(idCat);
    } //URL TO TEST: http://localhost:8080/BackendStockL/api/products/productsByCategory/2
    
    
    @Path("/getProduct/{id}") 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProductById(@PathParam("id") int id) {
        return metierProducts.getProductById(id);
    }//URL to test : http://localhost:8080/BackendStockL/api/products/getProduct/7 
    
    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addProduct(Product product) {
        return metierProducts.addProduct(product);
    }//URL to test : http://localhost:8080/BackendStockL/api/products/add
    /* 
    { Exemple code json : 
	    "nameProduct":"pc gaming",
	    "priceProduct":5490,
	    "idCat":1
	}
    */

    @Path("/update/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateProduct(@PathParam("id") int id, Product product) {
        return metierProducts.updateProduct(id, product);
    }
    //URL to test : http://localhost:8080/BackendStockL/api/products/update/
    

    @Path("/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteProduct(@PathParam("id") int id) {
        metierProducts.deleteProduct(id);
    }
    //URL to test : http://localhost:8080/BackendStockL/api/products/delete/
    
    
    
}


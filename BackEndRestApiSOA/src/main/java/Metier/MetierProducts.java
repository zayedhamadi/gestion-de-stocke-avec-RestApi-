package Metier;

import java.util.List;


import javax.ws.rs.PathParam;

import DAO.DAOproduct;
import Entity.*;


public class MetierProducts {

    private DAOproduct daoProduct=new DAOproduct();

    public List<Product>getAllProducts(){
    	return daoProduct.getAllProducts();
    }
    public List<Product>getProductsByCategory(int idCat){
    	return daoProduct.getProductsByCategory(idCat);
    }
    
    public Product getProductById( int id) {
        return daoProduct.getProductById(id);
    }
    
    public String addProduct(Product product) {
        return daoProduct.addProduct(product);
    }
    
    public String updateProduct(int id, Product product) {
        return daoProduct.updateProduct(id, product);
    }
    public void deleteProduct(@PathParam("id") int id) {
        daoProduct.deleteProduct(id);
    }
}

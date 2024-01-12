package Metier;

import java.util.List;

import DAO.*;
import Entity.Categorie;
import javax.ws.rs.PathParam;
public class MetierCategories {

	private DAOcat daoCat=new DAOcat();
	
	public List<Categorie> getAllCategories() {
        return daoCat.getAllCategories();
    }
	
	
	 public String updateCategory(@PathParam("id") int id, Categorie category) {
	        return daoCat.updateCategory(id, category);
	    }
	 
	 public String addCategory(Categorie cat) {
	        return daoCat.addCategory(cat);
	    }
	 
	 public Categorie getCategoryById( int id) {
	        return daoCat.getCategoryById(id);
	    }
	    
	 
	 public void deleteCategory(@PathParam("id") int id) {
	        daoCat.deleteCategory(id);
	    }

}

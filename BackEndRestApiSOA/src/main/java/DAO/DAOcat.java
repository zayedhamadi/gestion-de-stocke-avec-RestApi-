package DAO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Database.DataBase;
import Entity.Categorie;

public class DAOcat {

	 private Connection connection;

	public DAOcat( ) {
        this.connection = DataBase.getConnexion();

	}

	 
	//Listing categories
	 public List<Categorie> getAllCategories() {
	        List<Categorie> categories = new ArrayList<>();

	        try {
	            String sql = "SELECT * FROM categorie";
	            
	            PreparedStatement preparedStatement= connection.prepareStatement(sql);

	            ResultSet resultSet = preparedStatement.executeQuery();

	            while (resultSet.next()) {
	                Categorie categorie = new Categorie();
	                categorie.setIdCat(resultSet.getInt("idCat"));
	                categorie.setNameCat(resultSet.getString("nameCat"));

	                
	                categories.add(categorie);
	            }

	            resultSet.close();
	            preparedStatement.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return categories;
	    }
	
	 
	 
	 //Update an existing category
	    public String updateCategory(int idCat, Categorie category) {
	        try {
	            String sql = "UPDATE categorie SET nameCat = ? WHERE idCat = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, category.getNameCat());
	            preparedStatement.setInt(2, idCat);
	            
	            int rowsAffected = preparedStatement.executeUpdate();
	            preparedStatement.close();

	            return "Updated successfully !" +rowsAffected;

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return "Error updating";
	        }
	    }

	    //Adding a new category
	    public String addCategory(Categorie cat) {
	        try {
	            String sql = "INSERT INTO categorie (nameCat) VALUES (?)";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, cat.getNameCat());
	            
	            int rowsAffected = preparedStatement.executeUpdate(); // Exécution de la requête SQL

	            preparedStatement.close();

	            if (rowsAffected > 0) {
	                return "Category added successfully!";
	            } else {
	                return "Failed to add the category";
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return "Error adding the category";
	        }
	    }
	    
	    
	    //Searching an existing category 
	    public Categorie getCategoryById(int catId) {
	        Categorie cat = null;

	        try {
	            String sql = "SELECT * FROM categorie WHERE idCat = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setInt(1, catId);
	            ResultSet resultSet = preparedStatement.executeQuery();

	            if (resultSet.next()) {
	            	cat = new Categorie();
	            	cat.setIdCat(resultSet.getInt("idCat"));
	            	cat.setNameCat(resultSet.getString("nameCat"));
	            }

	            resultSet.close();
	            preparedStatement.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return cat;
	    }
	    
	    //Delete a category
	    public String deleteCategory(int idCat) {
	        try {
	            String sql = "DELETE FROM categorie WHERE idCat = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setInt(1, idCat);
	            
	            int rowsAffected = preparedStatement.executeUpdate();
	            preparedStatement.close();
	            
	            return "Deleted successfully &nbsp &nbsp "+	rowsAffected;

	        } catch (SQLException e) {
	            e.printStackTrace();
	            return "Error in deleting";
	        }
	    }
	    
}
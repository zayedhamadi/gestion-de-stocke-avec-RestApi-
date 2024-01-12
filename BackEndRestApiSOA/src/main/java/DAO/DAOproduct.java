package DAO;

import java.sql.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Database.DataBase;
import Entity.Product;

public class DAOproduct {

    private Connection connection;

    public DAOproduct() {
        this.connection = DataBase.getConnexion();
    }
    
    //Lister tous les produits
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        try {
            String sql = "SELECT * FROM product";
            
            PreparedStatement preparedStatement= connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("idProduct"));
                product.setNameProduct(resultSet.getString("nameProduct"));
                product.setPriceProduct(resultSet.getInt("priceProduct"));
                product.setIdCat(resultSet.getInt("idCat"));
                
                products.add(product);
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
    
    //Lister les produits par catégorie
    public List<Product> getProductsByCategory(int idCat) {
        List<Product> products = new ArrayList<>();

        try {
            String sql = "SELECT * FROM product WHERE idCat=?";
            
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setInt(1, idCat);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("idProduct"));
                product.setNameProduct(resultSet.getString("nameProduct"));
                product.setPriceProduct(resultSet.getInt("priceProduct"));
                product.setIdCat(resultSet.getInt("idCat"));
                
                products.add(product);
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
    //Get one product using its ID
    public Product getProductById(int productId) {
        Product product = null;

        try {
            String sql = "SELECT * FROM product WHERE idProduct = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                product = new Product();
                product.setId(resultSet.getInt("idProduct"));
                product.setNameProduct(resultSet.getString("nameProduct"));
                product.setPriceProduct(resultSet.getInt("priceProduct"));
            }

            resultSet.close();
            preparedStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }
    
    public String addProduct(Product product) {
        try {
            String sql = "INSERT INTO product (nameProduct, priceProduct, idCat) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setDouble(2, product.getPriceProduct());
            preparedStatement.setInt(3, product.getIdCat());
            
            int rowsAffected = preparedStatement.executeUpdate(); // Ajout de cette ligne

            preparedStatement.close();

            if (rowsAffected > 0) {
                return "Added successfully!";
            } else {
                return "Failed to add the product";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error adding the product";
        }
    }

    //Update an existing product
    public String updateProduct(int id, Product product) {
        try {
            String sql = "UPDATE product SET nameProduct = ?, priceProduct = ? WHERE idProduct = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setDouble(2, product.getPriceProduct());
            preparedStatement.setInt(3, id); // Use the passed 'id' for updating
            
            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();

            return "Updated successfully !" +rowsAffected;

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error updating";
        }
    }


    //Delete a product
    public String deleteProduct(int productId) {
        try {
            String sql = "DELETE FROM product WHERE idProduct = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productId);
            
            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            
            return "Deleted successfully &nbsp"+	rowsAffected;

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error in deleting";
        }
    }
}


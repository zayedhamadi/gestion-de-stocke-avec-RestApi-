package Testing;




import java.net.URI;

import com.sun.jersey.api.client.*;
import javax.ws.rs.core.UriBuilder;
import javax.xml.crypto.Data;

import com.sun.jersey.api.client.config.DefaultClientConfig;

import Database.DataBase;
import Entity.*;


import java.sql.*;



public class Test {

	public static void main(String[] args) {
	
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DataBase.getConnexion();

            String sqlQuery = "SELECT * FROM product"; 
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
            	int idProduct = resultSet.getInt("idProduct");
                String nameProduct = resultSet.getString("nameProduct");
                int price=resultSet.getInt("priceProduct");
                
                System.out.print("---------------------------\n");
                System.out.println("Id produit :"+idProduct);
                System.out.println("Nom du produit  :"+nameProduct);
                System.out.println("Prix du produit  :"+price);
                System.out.print("---------------------------\n");	            }

            System.out.println("Test d'accès à la base de données réussi.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erreur d'accès à la base de données : " + e.getMessage());

        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();

            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Erreur lors de la fermeture des ressources : " + e.getMessage());
            }
        }
    
}

}

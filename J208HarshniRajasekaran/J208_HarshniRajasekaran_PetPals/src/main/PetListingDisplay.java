package main;
import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class PetListingDisplay {
	
    public static void displayPetListings() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
           
            connection = DatabaseUtil.getConnection();

            
            statement = connection.createStatement();

            
            String query = "SELECT * FROM pet";
            resultSet = statement.executeQuery(query);

           
            System.out.println("Available Pets:");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String breed = resultSet.getString("breed");
                System.out.println("Name: " + name + ", Age: " + age + ", Breed: " + breed);
            }
        } catch (SQLException e) {
            System.out.println("Database Error: Unable to retrieve pet listings. " + e.getMessage());
        } finally {
            
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    System.out.println("Error closing ResultSet: " + e.getMessage());
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("Error closing Statement: " + e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error closing Connection: " + e.getMessage());
                }
            }
        }
    }
	public static void main(String[] args) {
		displayPetListings();
	}

}

package main;
import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class DonationRecording {
	// Method to record cash donations into the database
    public static void recordCashDonation() {
        Scanner scanner = new Scanner(System.in);

        try (Connection connection = DatabaseUtil.getConnection()) {
            // Prompt the user to enter donor information and donation amount
            System.out.print("Enter donor name: ");
            String donorName = scanner.nextLine();

            System.out.print("Enter donation amount: ");
            double donationAmount = scanner.nextDouble();

            // Prepare SQL statement for inserting donation record
            String insertQuery = "INSERT INTO donations (donor_name, amount) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                // Set parameters in the prepared statement
                preparedStatement.setString(1, donorName);
                preparedStatement.setDouble(2, donationAmount);

                // Execute the query to insert donation record
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Donation recorded successfully.");
                } else {
                    System.out.println("Failed to record donation.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Database Error: Unable to record donation. " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        recordCashDonation();
    }    
}

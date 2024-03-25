package main;
import util.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class AdoptionEventManager {
	// Method to display information about upcoming adoption events
    public static void displayUpcomingEvents() {
        try (Connection connection = DatabaseUtil.getConnection()) {
            // Query to retrieve information about upcoming adoption events
            String query = "SELECT * FROM adoption_events WHERE event_date > CURRENT_DATE()";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                // Display information about upcoming adoption events
                System.out.println("Upcoming Adoption Events:");
                while (resultSet.next()) {
                    String eventName = resultSet.getString("event_name");
                    String eventDate = resultSet.getString("event_date");
                    System.out.println("Event Name: " + eventName + ", Event Date: " + eventDate);
                }
            }
        } catch (SQLException e) {
            System.out.println("Database Error: Unable to retrieve upcoming events. " + e.getMessage());
        }
    }

    // Method to allow a user to register for an adoption event
    public static void registerForEvent() {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter their details
        System.out.print("Enter your name: ");
        String participantName = scanner.nextLine();

        System.out.print("Enter the event name you want to register for: ");
        String eventName = scanner.nextLine();

        try (Connection connection = DatabaseUtil.getConnection()) {
            // Prepare SQL statement for inserting participant details into the "participants" table
            String insertQuery = "INSERT INTO participants (participant_name, event_name) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                // Set parameters in the prepared statement
                preparedStatement.setString(1, participantName);
                preparedStatement.setString(2, eventName);

                // Execute the query to insert participant details
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Registration successful.");
                } else {
                    System.out.println("Failed to register for the event.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Database Error: Unable to register for the event. " + e.getMessage());
        }
    }

	public static void main(String[] args) {
		displayUpcomingEvents();
        registerForEvent();

	}

}

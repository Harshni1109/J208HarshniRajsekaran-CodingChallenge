package model;
import exception.InsufficientFundsException;
public class DonationProcessing {
	public void processCashDonation(double amount) {
        final double MIN_DONATION_AMOUNT = 10.0;

        try {
            if (amount < MIN_DONATION_AMOUNT) {
                throw new InsufficientFundsException("Donation amount is insufficient. Minimum donation amount is $" + MIN_DONATION_AMOUNT);
            }
            // Process the donation
            System.out.println("Thank you for your donation of $" + amount);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

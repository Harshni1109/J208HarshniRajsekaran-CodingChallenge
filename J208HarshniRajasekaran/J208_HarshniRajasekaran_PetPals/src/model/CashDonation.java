package model;
import java.time.LocalDate;
public class CashDonation extends Donation {

    private LocalDate donationDate;
    
    public CashDonation(String donorName, double amount, LocalDate donationDate) {
        super(donorName, amount);
        this.donationDate = donationDate;
    }

    @Override
    public void recordDonation() {
        
        System.out.println("Cash donation recorded on " + donationDate);
        System.out.println("Donor: " + getDonorName());
        System.out.println("Amount: $" + getAmount());
    }

    
    public LocalDate getDonationDate() {
        return donationDate;
    }

    public void setDonationDate(LocalDate donationDate) {
        this.donationDate = donationDate;
    }
}

package model;

public class ItemDonation extends Donation {

    private String itemType;

    public ItemDonation(String donorName, double amount, String itemType) {
        super(donorName, amount);
        this.itemType = itemType;
    }

    @Override
    public void recordDonation() {
        
        System.out.println("Item donation recorded:");
        System.out.println("Donor: " + getDonorName());
        System.out.println("Item Type: " + itemType);
        System.out.println("Estimated Value: $" + getAmount());
    }

   
    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
}

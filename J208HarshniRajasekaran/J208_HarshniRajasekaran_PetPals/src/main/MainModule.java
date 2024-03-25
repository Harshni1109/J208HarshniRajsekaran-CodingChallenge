package main;
import model.Pet;
import model.PetShelter;
import model.DonationProcessing;
import model.FileHandling;
import exception.AdoptionException;
import java.util.Scanner;
public class MainModule {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        PetShelter shelter = new PetShelter();

        System.out.print("Enter pet name: ");
        String name = sc.nextLine();

        System.out.print("Enter pet age: ");
        int age = sc.nextInt();

        System.out.print("Enter pet breed: ");
        sc.nextLine(); 
        String breed = sc.nextLine();

        Pet Pet = new Pet(name, age, breed);

        shelter.addPetWithExceptionHandling(Pet);
        DonationProcessing donationProcessing = new DonationProcessing();

        System.out.print("Enter donation amount: $");
        double amount = sc.nextDouble();

        donationProcessing.processCashDonation(amount);
        String filePath = "C:\\Users\\HP\\Desktop\\hexaware_workspace/petpals.txt"; 
        FileHandling fileHandler = new FileHandling();
        fileHandler.readFromFile(filePath);
       Pet pet = new Pet(name, age, breed);

        try {
            shelter.adoptPet(pet);
        } catch (AdoptionException e) {
            System.out.println("Adoption Error: " + e.getMessage());
        }
	}

}

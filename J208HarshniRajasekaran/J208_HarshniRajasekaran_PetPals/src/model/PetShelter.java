package model;
import java.util.ArrayList;
import java.util.List;
import exception.InvalidPetAgeException;
import exception.AdoptionException;
public class PetShelter {
	
    private List<Pet> availablePets;

    public PetShelter() {
        this.availablePets = new ArrayList<>();
    }

    public void addPet(Pet pet) {
        availablePets.add(pet);
    }
    public void addPetWithExceptionHandling(Pet pet) {
        try {
            if (pet.getAge() <= 0) {
                throw new InvalidPetAgeException("Invalid pet age. Age should be a positive integer.");
            }
            availablePets.add(pet);
            System.out.println("Pet added successfully.");
        } catch (InvalidPetAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
        public void displayAvailablePets() {
            System.out.println("Available Pets:");
            for (Pet pet : availablePets) {
                try {
                    System.out.println("Name: " + pet.getName());
                    System.out.println("Age: " + pet.getAge());
                    System.out.println("Breed: " + pet.getBreed());
                } catch (NullPointerException e) {
                    System.out.println("Pet information is missing.");
                }
            
               
    
   }
}
        public void adoptPet(Pet pet) throws AdoptionException {
            
            if (!isPetAvailableForAdoption(pet)) {
                throw new AdoptionException("Pet " + pet.getName() + " is not available for adoption.");
            }

            
            if (pet.getName() == null || pet.getAge() == 0 || pet.getBreed() == null) {
                throw new AdoptionException("Pet information is incomplete.");
            }

           
            System.out.println("Pet " + pet.getName() + " adopted successfully.");
        }
        

        
        private boolean isPetAvailableForAdoption(Pet pet) {
            
            return true; 
        }
}

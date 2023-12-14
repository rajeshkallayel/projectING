package test;

import model.Sandwich;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.SandwichService;

import static org.junit.jupiter.api.Assertions.*;

public class SandwichServiceTest {
    private SandwichService sandwichService;

    @BeforeEach
    public void setUp() {
        sandwichService = new SandwichService();
    }

    @Test
    public void testAddSandwich() {
        // Create a sandwich to add
        Sandwich sandwich = new Sandwich("Turkey Sandwich", 6.99);

        // Add the sandwich
        sandwichService.addSandwich(sandwich);

        // Check if the sandwich was added successfully
        assertTrue(sandwichService.getAllSandwiches().contains(sandwich));
    }

    @Test
    public void testRemoveSandwich() {
        // Create a sandwich and add it
        Sandwich sandwich = new Sandwich("Veggie Wrap", 5.99);
        sandwichService.addSandwich(sandwich);

        // Remove the sandwich
        sandwichService.removeSandwich("Veggie Wrap");

        // Check if the sandwich was removed successfully
        assertFalse(sandwichService.getAllSandwiches().contains(sandwich));
    }

    @Test
    public void testSetSandwichNameInLanguage() {
        // Create a sandwich and add it
        Sandwich sandwich = new Sandwich("BLT Sandwich", 7.49);
        sandwichService.addSandwich(sandwich);

        // Set the sandwich name in a different language
        sandwichService.setSandwichNameInLanguage("BLT Sandwich", Sandwich.Language.FRENCH, "Sandwich BLT");

        // Get the sandwich and check if the name is set in the specified language
        Sandwich updatedSandwich = sandwichService.getAvailableSandwich("BLT Sandwich");
        assertNotNull(updatedSandwich);
        assertEquals("Sandwich BLT", updatedSandwich.getNameInLanguage(Sandwich.Language.FRENCH));
    }


}

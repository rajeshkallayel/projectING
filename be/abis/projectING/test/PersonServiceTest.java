package test;

import model.Admin;
import model.Order;
import model.Person;
import model.Sandwich;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.PersonRepository;
import services.PersonService;
import services.SandwichService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;

    @Mock
    private SandwichService sandwichService;

    private PersonService personService;

    @BeforeEach
    public void setUp() {
        personService = new PersonService(personRepository, sandwichService);
    }

    @Test
    public void testOrderSandwichSuccess() {
        Person student = new Person("Alice", "Student");
        when(sandwichService.placeOrder("Alice", "Turkey Sandwich")).thenReturn(true);

        personService.orderSandwich(student, "Turkey Sandwich");

        verify(sandwichService).placeOrder("Alice", "Turkey Sandwich");
    }

    @Test
    public void testOrderSandwichAdminFailure() {
        Admin admin = new Admin("Emily", "Admin");

        // Mocking behavior to disallow admin from placing an order
        when(sandwichService.placeOrder("Emily", "Turkey Sandwich")).thenReturn(false);

        personService.orderSandwich(admin, "Turkey Sandwich");

        verify(sandwichService, never()).placeOrder(anyString(), anyString());
    }

    @Test
    public void testOrderSandwichMaxLimitExceeded() {
        Person student = new Person("Bob", "Student");
        List<Order> orders = Arrays.asList(
                new Order("Alice", new Sandwich("Turkey Sandwich", 6.99)),
                new Order("Eva", new Sandwich("Club Sandwich", 8.99))
        );
        when(sandwichService.getOrdersByUser("Bob")).thenReturn(orders);

        personService.orderSandwich(student, "Turkey Sandwich");

        verify(sandwichService, never()).placeOrder(anyString(), anyString());
    }

    @Test
    public void testOrderSandwichSandwichNotAvailable() {
        Person student = new Person("Charlie", "Student");
        when(sandwichService.getAvailableSandwich("Veggie Wrap")).thenReturn(null);

        personService.orderSandwich(student, "Veggie Wrap");

        verify(sandwichService, never()).placeOrder(anyString(), anyString());
    }

    @Test
    public void testAddSandwichSuccess() {
        Admin admin = new Admin("John", "Admin");

        personService.addSandwich(admin, "Club Sandwich");

        verify(sandwichService).addSandwich(new Sandwich("Club Sandwich", 0.0));
    }

    @Test
    public void testAddSandwichNonAdmin() {
        Person student = new Person("Eva", "Student");

        personService.addSandwich(student, "Ham and Cheese");

        verify(sandwichService, never()).addSandwich(any(Sandwich.class));
    }

    @Test
    public void testRemoveSandwichSuccess() {
        Admin admin = new Admin("Emily", "Admin");

        personService.removeSandwich(admin, "Veggie Wrap");

        verify(sandwichService).removeSandwich("Veggie Wrap");
    }

    @Test
    public void testRemoveSandwichNonAdmin() {
        Person student = new Person("Frank", "Student");

        personService.removeSandwich(student, "Turkey Sandwich");

        verify(sandwichService, never()).removeSandwich(anyString());
    }
}

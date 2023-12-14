package services;
import model.Order;
import model.Admin;
import model.Person;
import repository.PersonRepository;
import model.Sandwich;

import java.util.List;

public class PersonService {
    private PersonRepository personRepository;
    private SandwichService sandwichService; 

    public PersonService(PersonRepository personRepository, SandwichService sandwichService) {
        this.personRepository = personRepository;
        this.sandwichService = sandwichService;
    }

    public void orderSandwich(Person person, String sandwichName) {
        // Check if the person is an admin
        if (person instanceof Admin) {
            System.out.println("Only students and instructors can order sandwiches.");
            return;
        }

        // Check if the maximum order limit (2 sandwiches) is reached
        List<Order> personOrders = sandwichService.getOrdersByUser(person.getName());
        if (personOrders.size() >= 2) {
            System.out.println(person.getName() + " has reached the maximum order limit.");
            return;
        }

        // Check if the sandwich exists
        Sandwich sandwich = sandwichService.getAvailableSandwich(sandwichName);
        if (sandwich == null) {
            System.out.println("Sandwich '" + sandwichName + "' is not available.");
            return;
        }

        // Place the order
        boolean orderPlaced = sandwichService.placeOrder(person.getName(), sandwichName);
        if (orderPlaced) {
            System.out.println("Order placed successfully: " + sandwichName);
        } else {
            System.out.println("Order placement failed.");
        }
    }

    public void addSandwich(Person person, String sandwichName) {
        if (person instanceof Admin) {
            // Only admins can add sandwiches
            sandwichService.addSandwich(new Sandwich(sandwichName, 0.0));
        } else {
            System.err.println("Only admins can add sandwiches.");
        }
    }

    public void removeSandwich(Person person, String sandwichName) {
        if (person instanceof Admin) {
            sandwichService.removeSandwich(sandwichName);
            System.out.println(person.getName() + " removed the sandwich: " + sandwichName);
        } else {
            System.err.println("Only admins can remove sandwiches.");
        }
    }

    public List<Person> getAllPersons() {
        return personRepository.getAllPersons();
    }
}

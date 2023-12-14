package services;

import model.Sandwich;
import model.Order;

import java.util.ArrayList;
import java.util.List;

public class SandwichService {
    private List<Sandwich> availableSandwiches;

    public SandwichService() {
        this.availableSandwiches = new ArrayList<>();
    }

    public void addSandwich(Sandwich sandwich) {
        availableSandwiches.add(sandwich);
    }

    public void removeSandwich(String sandwichName) {
        availableSandwiches.removeIf(sandwich -> sandwich.getName().equalsIgnoreCase(sandwichName));
    }

    public void setSandwichNameInLanguage(String sandwichName, Sandwich.Language language, String translatedName) {
        for (Sandwich sandwich : availableSandwiches) {
            if (sandwich.getName().equalsIgnoreCase(sandwichName)) {
                sandwich.setNameInLanguage(language, translatedName);
            }
        }
    }

    public boolean placeOrder(String userName, String sandwichName) {
        if (getOrdersByUser(userName).size() >= 2) {
            return false;
        }

        Sandwich sandwich = getAvailableSandwich(sandwichName);
        if (sandwich != null) {
            Order order = new Order(userName, sandwich);
            return true;
        }
        return false;
    }


    public List<Sandwich> getAllSandwiches() {
        return availableSandwiches;
    }

    public Sandwich getAvailableSandwich(String sandwichName) {
        for (Sandwich sandwich : availableSandwiches) {
            if (sandwich.getName().equalsIgnoreCase(sandwichName)) {
                return sandwich;
            }
        }
        return null;
    }

    public List<Order> getOrdersByUser(String userName) {
        List<Order> userOrders = new ArrayList<>();
        for (Order order : getDummyOrders()) {
            if (order.getUserName().equalsIgnoreCase(userName)) {
                userOrders.add(order);
            }
        }
        return userOrders;
    }

    private List<Order> getDummyOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("John", getAvailableSandwich("Turkey Sandwich")));
        orders.add(new Order("Alice", getAvailableSandwich("Veggie Wrap")));
        return orders;
    }
}

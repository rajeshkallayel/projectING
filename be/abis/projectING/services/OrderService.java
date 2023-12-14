package services;

import model.Order;
import model.Sandwich;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {
    private Map<String, List<Order>> userOrders;
    private SandwichService sandwichService; 

    public OrderService(SandwichService sandwichService) {
        this.sandwichService = sandwichService;
        userOrders = new HashMap<>();
    }

    public boolean placeOrder(String userName, Sandwich sandwich) {
        // Check if the user has already placed 2 orders
        if (getOrdersByUser(userName).size() >= 2) {
            return false; // Exceeded order limit
        }

        Order order = new Order(userName, sandwich);
        userOrders.computeIfAbsent(userName, k -> new ArrayList<>()).add(order);
        return true; // Order placed successfully
    }

    public List<Order> getOrdersByUser(String userName) {
        return userOrders.getOrDefault(userName, new ArrayList<>());
    }
}

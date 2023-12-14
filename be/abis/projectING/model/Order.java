package model;

public class Order {
    private String userName;
    private Sandwich orderedSandwich;

    public Order(String userName, Sandwich orderedSandwich) {
        this.userName = userName;
        this.orderedSandwich = orderedSandwich;
    }

    public String getUserName() {
        return userName;
    }

    public Sandwich getOrderedSandwich() {
        return orderedSandwich;
    }
}

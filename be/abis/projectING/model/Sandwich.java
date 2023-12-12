package be.abis.projectING.model;


/**
 * Represents a sandwich class with sandwichId, name, and price.
 */
public class Sandwich {
    private int sandwichId;
    private String name;
    private double price;

    /**
     * Constructs a Sandwich with the given attributes.
     *
     * @param sandwichId The unique identifier for the sandwich.
     * @param name       The name of the sandwich.
     * @param price      The price of the sandwich.
     */
    public Sandwich(int sandwichId, String name, double price) {
        this.sandwichId = sandwichId;
        this.name = name;
        this.price = price;
    }

    public int getSandwichId() {
        return sandwichId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "sandwichId=" + sandwichId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


}

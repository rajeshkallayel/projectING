package repository;

import model.Sandwich;

import java.util.ArrayList;
import java.util.List;

public class SandwichRepository {
    private List<Sandwich> sandwiches;


    public SandwichRepository() {
        this.sandwiches = new ArrayList<>();
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void removeSandwich(Sandwich sandwich) {
        sandwiches.remove(sandwich);
    }

    public List<Sandwich> getAllSandwiches() {
        return sandwiches;
    }
}

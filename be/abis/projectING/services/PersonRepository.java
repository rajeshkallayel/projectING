package repository;

import model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    private List<Person> persons = new ArrayList<>();

    public void addPerson(Person person) {
        persons.add(person);
    }

    public List<Person> getAllPersons() {
        return persons;
    }
}

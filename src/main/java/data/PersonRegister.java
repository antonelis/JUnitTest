package data;

import java.util.ArrayList;
import java.util.List;

public class PersonRegister {

    private final List<Person> persons = new ArrayList<>();

    public void addPerson(Person p) {
        persons.add(p);
    }

    public Person searchPerson(String name) {
        return persons.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst().orElse(new Person("Name", 0));
    }
}

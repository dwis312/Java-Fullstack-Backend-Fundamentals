package collection;

import java.util.UUID;

public class Developer extends Employee {
    private final String id;

    public Developer(String name, int age, double salary) {
        super(name, age, salary);
        this.id = UUID.randomUUID().toString().substring(0, 8);
    }

    public String getId() {
        return id;
    }

    @Override
    public void work() {
        System.out.println("Writing code and fixing bugs.");
    }

    @Override
    public String toString() {
        return "Developer|" + id + "|" + getName() + "|" + getAge() + "|" + getSalary();
    }

}

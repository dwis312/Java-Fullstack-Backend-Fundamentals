package collection;

import java.util.UUID;

public class Manager extends Employee {
    private final String id;

    public Manager(String name, int age, double salary) {
        super(name, age, salary);
        this.id = UUID.randomUUID().toString().substring(0, 8);
    }

    public String getId() {
        return id;
    }

    @Override
    public void work() {
        System.out.println("Managing team and overseeing projects.");
    }

    @Override
    public String toString() {
        return "Manager|" + id + "|" + getName() + "|" + getAge() + "|" + getSalary();
    }

}

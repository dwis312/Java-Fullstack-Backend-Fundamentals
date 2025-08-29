package collection;

import java.util.UUID;

public class Student extends Person implements Printable{
    private final String id;

    public Student(String name, int age) {
        super(name, age);
        this.id = UUID.randomUUID().toString().substring(0, 8);
    }

    public String getId() {
        return id;
    }

    public void print() {
        toString();
    }

    @Override
    public String toString() {
        return  super.toString() + " | " +
                id;
    }
}

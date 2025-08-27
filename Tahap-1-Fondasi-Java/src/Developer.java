import java.util.UUID;

public class Developer extends Employee {
    private final String id;

    public Developer(String name, double salary) {
        super(name, salary);
        this.id = UUID.randomUUID().toString();
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
        return  super.toString()+ " | " +
                id;
    }

}

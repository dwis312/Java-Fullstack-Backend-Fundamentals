import java.util.UUID;

public class Manager extends Employee {
    private final String id;

    public Manager(String name, double salary) {
        super(name, salary);
        this.id = UUID.randomUUID().toString();
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
        return  super.toString()+ " | " +
                id;
    }

}

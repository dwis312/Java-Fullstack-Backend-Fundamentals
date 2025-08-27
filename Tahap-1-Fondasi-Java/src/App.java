
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        addPerson();
        
    }

    private static void addPerson() {
        List<Person> list = new ArrayList<>();

        list.add(new Person("Udin", 34));
        list.add(new Person("Nana", 24));
        list.add(new Person("Budi", 20));
        list.add(new Person("Ani", 24));
        list.add(new Person("Lisa", 28));
        list.add(new Person("Joko", 24));

        System.out.println("---------------------------------");
        System.out.printf("| %-5s | %-10s | %-8s |\n",
        "No","Nama","Usia");
        System.out.println("---------------------------------");

        for (int i = 0; i < list.size(); i++) {
            System.out.printf("| %-5s | %-10s | %-8s |\n",
            i+1,list.get(i).getName(),list.get(i).getAge());
        }
        System.out.println("---------------------------------");

    }
}

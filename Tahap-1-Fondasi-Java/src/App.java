
import exceptionhandling.Arithmetic;
import exceptionhandling.BacaData;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class App {
    public static void main(String[] args) throws Exception {
        List<Person> person = new ArrayList<>();
        List<Student> murid = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        List<Manager> manager = new ArrayList<>();
        List<Developer> developer = new ArrayList<>();
        List<Counter> counter = new ArrayList<>();

        person.add(new Person("Nana", 24));
        person.add(new Person("Budi", 20));
        person.add(new Person("Ani", 24));
        person.add(new Person("Joko", 24));
        person.add(new Person("Udin", 34));
        person.add(new Person("Lisa", 28));

        System.out.println("----------------------------------------------");
        System.out.printf("| %-5s | %-10s | %-8s | %-10s |\n",
        "No","Nama","Usia", "Status");
        System.out.println("----------------------------------------------");
        

        for (int i = 0; i < person.size(); i++) {
            int usia = person.get(i).getAge();
            String nama = person.get(i).getName();
            
            counter.add(new Counter());
            
            if (usia <= 24) {
                murid.add(new Student(nama, usia));

                System.out.printf("| %-5s | %-10s | %-8s | %-10s |\n",Counter.getCount(),nama,usia, "Murid");
            } else if (usia > 25) {
                if (usia <= 30) {
                    manager.add(new Manager(nama, 18000000));   
                    System.out.printf("| %-5s | %-10s | %-8s | %-10s |\n",Counter.getCount(),nama,usia, "Manger");
                } else {
                    developer.add(new Developer(nama, 7000000));   
                    System.out.printf("| %-5s | %-10s | %-8s | %-10s |\n",Counter.getCount(),nama,usia, "Developer");

                }
            }
        }
        System.out.println("----------------------------------------------");
        
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
        if (manager.isEmpty()) {
            System.out.println("kosong");
        } else {
            for (int j = 0; j < manager.size(); j++) {
                System.out.println("ID   : " + manager.get(j).getId());
                System.out.println("Nama : " + manager.get(j).getName());
                System.out.println("Gaji : " + formatRupiah.format(manager.get(j).getSalary()));
            }
        }
        System.out.println("----------------------------------------------");

        System.out.println();
        System.out.print("object Counter : ");
        System.out.println(Counter.getCount());

        System.out.println("----------------------------------------------");
        
        Arithmetic.pembagian();
        System.out.println();
        System.out.println("----------------------------------------------");
        try {
            BacaData.fileTxt("data/person.txt");
        } catch (IOException e) {
            System.out.println("Kesalahan: Terjadi masalah saat membaca file.");
            System.err.println(e.getMessage());
        }
        System.out.println("----------------------------------------------");
    }
    
}

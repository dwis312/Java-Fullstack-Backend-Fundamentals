package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Collection {
    private HashMap<String, Person> orang = new HashMap<>();
    private List<Student> murid = new ArrayList<>();
    private List<Employee> pekerja = new ArrayList<>();

    public HashMap<String, Person> getAllPerson() {
        return orang;
    }

    public List<Student> getAllMurid() {
        return murid;
    }

    public List<Employee> getAllPekerja() {
        return pekerja;
    }

    public void generateDataMurid() {
        murid.clear();

        for (Person p : orang.values()) {
            if (p.getAge() <= 25) {
                murid.add(new Student(p.getName(), p.getAge()));
            }
        }
    }

    public void generateDataPekerja() {
        pekerja.clear();

        for (Person p : orang.values()) {
            int usia = p.getAge();
            String nama = p.getName();
            int gaji = 0;

            if (usia >= 25) {
                if (usia > 30) {
                    gaji = 12000000;
                    pekerja.add(new Manager(nama, usia, gaji));
                } else {
                    gaji = 8000000;
                    pekerja.add(new Developer(nama, usia, gaji));
                }
            }
        }
    }

    public void loadDumy(String name, int age) {
        orang.put(name, new Person(name, age));
        System.out.println(name + " berhasil ditambah.");
    }

}

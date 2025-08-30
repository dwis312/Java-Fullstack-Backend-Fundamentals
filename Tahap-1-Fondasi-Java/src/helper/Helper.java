package helper;

import collection.Developer;
import collection.Manager;
import collection.Person;
import collection.Student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    private List<Person> orang = new ArrayList<>();
    private BufferedReader reader;
    private BufferedWriter writer;
    private final String FILE_TXT = "data/people.txt";
    
    public List<Person> readTxt() {
        orang.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_TXT))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                String type = parts[0];

                switch (type) {
                    case "Person":
                        // Person|nama|usia
                        String personName = parts[1];
                        int personAge = Integer.parseInt(parts[2]);
                        orang.add(new Person(personName, personAge));
                        break;
                    case "Manager":
                        // Manager|id|nama|usia|gaji
                        String managerId = parts[1];
                        String managerName = parts[2];
                        int managerAge = Integer.parseInt(parts[3]);
                        double managerSalary = Double.parseDouble(parts[4]);
                        // Tambahkan ke koleksi Manager atau gabungkan ke koleksi utama jika Anda mau
                        // (Contoh ini hanya menambahkan ke list 'orang')
                        orang.add(new Manager(managerName, managerAge, managerSalary));
                        break;
                    case "Developer":
                        // Developer|id|nama|usia|gaji
                        String devId = parts[1];
                        String devName = parts[2];
                        int devAge = Integer.parseInt(parts[3]);
                        double devSalary = Double.parseDouble(parts[4]);
                        // Tambahkan ke koleksi Developer
                        orang.add(new Developer(devName, devAge, devSalary));
                        break;
                    case "Student":
                        // Student|id|nama|usia
                        String studentId = parts[1];
                        String studentName = parts[2];
                        int studentAge = Integer.parseInt(parts[3]);
                        // Tambahkan ke koleksi Student
                        orang.add(new Student(studentName, studentAge));
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Gagal memuat data: " + e.getMessage());
        }
        return orang;

    }

    public void saveTxt(List data) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_TXT))) {
            for (Object obj : data) {
                writer.write(obj.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data user: " + e.getMessage());
        }
        
    }

}

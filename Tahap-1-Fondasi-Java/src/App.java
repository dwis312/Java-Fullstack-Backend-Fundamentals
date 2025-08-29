
import collection.Collection;
import collection.Counter;
import collection.Developer;
import collection.Employee;
import collection.Manager;
import collection.Person;
import collection.Student;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class App {
    private static Collection collection = new Collection();
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int pilihan = -1;
        boolean exit = false;

        while (!exit) {
            menu();
            try {
                pilihan = input.nextInt();
                input.nextLine();
                exit = menuPilihan(pilihan);
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Masukkan angka.");
                input.nextLine();
            }
        }
        input.close();
        System.out.println("Program berhenti.");
    }
    
    private static void menu() {
        clearScreen();
        System.out.println("\n---------------------------");
        System.out.println("        MENU PILIHAN       ");
        System.out.println("---------------------------");
        System.out.println("\n1. Input Data");
        System.out.println("2. Tampilkan daftar Orang");
        System.out.println("3. Tampilkan daftar Murid");
        System.out.println("4. Tampilkan daftar Pekerja");
        System.out.println("5. Hapus Data");
        System.out.println("6. Input Data Dumy");
        System.out.println("0. Keluar");

        System.out.println("\n---------------------------");
        System.out.print("Pilihan anda: ");
    }

    private static boolean menuPilihan(int pilihan) {

        switch (pilihan) {
            case 1:
                clearScreen();
                addData();
                enterToContinu();
                break;
            case 2:
                clearScreen();
                getData();
                enterToContinu();
                break;
            case 3:
                clearScreen();
                getDataMurid();
                enterToContinu();
                break;
            case 4:
                clearScreen();
                getDataPekerja();
                enterToContinu();
                break;
            case 5:
                clearScreen();
                removeData();
                enterToContinu();
                break;
            case 6:
                clearScreen();
                addDumy();
                enterToContinu();
                break;
            case 0:
                return true;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }
        return false;
    }

    private static void addData() {
        System.out.println("    TAMBAH DATA    ");

        String kategori = null;
        String nama;
        int usia;
        int num = -1;
        boolean valid = true;

        
        
        System.out.println("\n1. Manager");
        System.out.println("2. Developer");
        System.out.println("3. Murid sekolah");
        System.out.println("0. Batal");
        System.out.print("\nPilih kategori: ");
        num = inputInt(input);

        if (num == 0) {
            System.out.println("Kembali ke menu");
            return;
        }

        System.out.print("\nMasukan Nama: ");
        nama = inputStr(input);
        System.out.print("Masukan Usia: ");
        usia = inputInt(input);

        if (num == 1) { 
            collection.getAllPerson().put(nama, new Person(nama, usia)); 
            collection.getAllPekerja().add(new Manager(nama, usia, 12000000));
            System.out.println(nama + " (Manager) berhasil ditambah.");
        } else if (num == 2) {
            collection.getAllPerson().put(nama, new Person(nama, usia));
            collection.getAllPekerja().add(new Developer(nama, usia, 8000000));
            System.out.println(nama + " (Developer) berhasil ditambah.");
        } else if (num == 3) { 
            collection.getAllPerson().put(nama, new Person(nama, usia));
            collection.getAllMurid().add(new Student(nama, usia));
            System.out.println(nama + " (Murid) berhasil ditambah.");
        } else {
            System.out.println("Pilihan tidak valid.");
        }
        
    }

    private static void removeData() {
        
    }

    private static void addDumy() {
        collection.loadDumy("Nana", 24);
        collection.loadDumy("Budi", 20);
        collection.loadDumy("Ani", 24);
        collection.loadDumy("Joko", 24);
        collection.loadDumy("Udin", 34);
        collection.loadDumy("Lisa", 28); 

        collection.generateDataMurid();
        collection.generateDataPekerja();
    }

    private static void getData() {
        Counter.reset();
        HashMap<String, Person> orang = collection.getAllPerson();
        
        if (orang.isEmpty()) {
            System.out.println("Data masih kosong.");
            return;
        }

        System.out.println("---------------------------------");
        System.out.printf("| %-5s | %-10s | %-8s |\n",
        "No","Nama","Usia");
        System.out.println("---------------------------------");
        

        for (Map.Entry<String, Person> entry : orang.entrySet()) {
            Counter.increment();
            String nama = entry.getKey();
            int usia = entry.getValue().getAge();
            
            System.out.printf("| %-5s | %-10s | %-8s |\n",Counter.getCount(),nama,usia);
        }
        System.out.println("---------------------------------");
        
    }

    private static void getDataMurid() {
        Counter.reset();
        List<Student> murid = collection.getAllMurid();
        if (murid.isEmpty()) {
            System.out.println("Data masih kosong.");
            return;
        }

        System.out.println("-----------------------------------------");
        System.out.printf("| %-5s | %-10s | %-8s | %-5s |\n",
        "No","id","Nama","Usia");
        System.out.println("-----------------------------------------");

        for (int i = 0; i < murid.size(); i++) {
            Counter.increment();

            System.out.printf("| %-5s | %-10s | %-8s | %-5s |\n",Counter.getCount(), murid.get(i).getId(), murid.get(i).getName(), murid.get(i).getAge());
            
        }
        System.out.println("-----------------------------------------");

    }
    
    private static void getDataPekerja() {
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));
        List<Employee> pekerja = collection.getAllPekerja();
        
        if (pekerja.isEmpty()) {
            System.out.println("Data masih kosong.");
            return;
        }

        Counter.reset();
        System.out.println("------------------------------------------------------------------");
        System.out.printf("| %-5s | %-10s | %-10s | %-10s | %-15s |\n",
        "No","ID","Nama","Jabatan","gaji");
        System.out.println("------------------------------------------------------------------");

        for (Employee e : pekerja) {
            Counter.increment();
            String id = "";
            String tipe = "";
            double gaji = 0;
            
            if (e instanceof Manager) {
                Manager manager = (Manager) e;
                id = manager.getId();
                tipe = "Manger";
                gaji = manager.getSalary();
                
            } else if (e instanceof Developer) {
                Developer developer = (Developer) e;
                id = developer.getId();
                tipe = "Developer";
                gaji = developer.getSalary();
                
            }

            System.out.printf("| %-5s | %-10s | %-10s | %-10s | %-15s |\n",
                                    Counter.getCount(),
                                    id,
                                    e.getName(),
                                    tipe,
                                    formatRupiah.format(gaji));
        }
        System.out.println("------------------------------------------------------------------");

    }

    private static void enterToContinu() {
        System.out.println("\nEnter untuk melanjutkan...");
        input.nextLine();
    }

    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.err.println("Gagal membersihkan layar.");
        }
    }

    private static int inputInt(Scanner input) {
        boolean valid = false;
        int angka = -1;

        while (!valid) {
            try {
                String bukanNomor = input.nextLine();

                if (bukanNomor.trim().isEmpty()) {
                    System.out.println("Input tidak boleh kosong");
                } else {
                    angka = Integer.parseInt(bukanNomor);
                    valid = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid! harus angka");
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }

        }

        return angka;
    }

    private static String inputStr(Scanner input) {
        boolean valid = false;
        String stringInput = "";

        while (!valid) {
            stringInput = input.nextLine();
            if (stringInput.trim().isEmpty()) {
                System.out.println("Input tidak boleh kosong");
            } else {
                valid = true;
            }
        }

        return stringInput;
    }
}

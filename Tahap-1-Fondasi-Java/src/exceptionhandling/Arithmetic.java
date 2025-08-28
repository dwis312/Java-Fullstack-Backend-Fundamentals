package exceptionhandling;

import java.util.Scanner;

public class Arithmetic {
    
    public static void pembagian() {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Masukkan angka pertama: ");
            int angka1 = scanner.nextInt();

            System.out.print("Masukkan angka kedua: ");
            int angka2 = scanner.nextInt();

            int hasil = angka1 / angka2; // Baris ini berpotensi menyebabkan ArithmeticException
            System.out.println("Hasil pembagian: " + angka1+ " : " + angka2 + " = " + hasil);
            
        } catch (ArithmeticException e) {
            System.out.println("Kesalahan: Tidak dapat melakukan pembagian dengan nol.");
        } finally {
            scanner.close();
        }
    }

}

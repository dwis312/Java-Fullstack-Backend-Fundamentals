# Exception Handling

Exception handling adalah mekanisme dalam bahasa pemrograman untuk mengelola kesalahan saat runtime (runtime errors) atau kejadian tak terduga yang dapat mengganggu alur normal program. Kesalahan ini, yang disebut exception (pengecualian), bisa terjadi karena berbagai alasan, seperti mencoba membuka berkas yang tidak ada, membagi angka dengan nol, atau mengakses elemen di luar batas array. Tanpa exception handling, program bisa tiba-tiba berhenti (crash) dan menampilkan pesan kesalahan yang tidak jelas.

Tujuan utama dari exception handling adalah untuk menangani kesalahan dengan anggun, mencegah program berhenti secara tiba-tiba, dan memberikan respons yang terencana kepada pengguna.

---

## Cara Kerja Exception Handling
Exception Handling bekerja dengan prinsip dasar "coba, tangkap, dan selesaikan".
- `try`: Anda menempatkan kode yang berpotensi menimbulkan kesalahan di dalam blok `try`.
- `throw`: Jika kesalahan terjadi (misalnya, pembagian dengan nol), program akan membuat (instantiate) sebuah objek `exception` dan melemparkannya (throw) dari blok `try`.
- `catch`: Program akan mencari blok `catch` yang sesuai untuk "menangkap" `exception` yang dilemparkan. Di sinilah Anda menulis kode untuk mengelola atau memperbaiki kesalahan tersebut.
- `finally`: Blok ini selalu dieksekusi, baik jika `exception` terjadi atau tidak. Ini ideal untuk kode "pembersihan", seperti menutup berkas atau koneksi basis data.

---

## Hubungan Antar Konsep
Semua konsep yang Anda sebutkan saling terkait dalam ekosistem exception handling.
- `Try`-`catch`-`finally` : Ini adalah struktur dasar dari exception handling.
    - `try` berfungsi sebagai "pengawas" yang mendeteksi kesalahan.
    - `catch` adalah "penyelamat" yang menangani kesalahan tersebut.
    - `finally` adalah "pembersih" yang menyelesaikan tugas terlepas dari hasilnya.

- `Multiple Catch` : 
ini adalah perluasan dari blok `catch`. Karena sebuah blok `try` bisa menghasilkan berbagai jenis `exception`, `multiple catch` digunakan untuk menangani setiap jenis kesalahan secara spesifik. Ini membuat penanganan kesalahan menjadi lebih terperinci dan efektif. Misalnya, dapat menampilkan pesan yang berbeda untuk `FileNotFoundException` (berkas tidak ditemukan) dibandingkan dengan `IOException` (kesalahan saat membaca berkas).

- `Throw & Throws`
    - `throw` adalah **aksi** yang dilakukan untuk melempar sebuah `exception` secara manual. Misalnya, `throw new IllegalArgumentException` jika sebuah nilai tidak memenuhi kriteria yang ditetapkan.
    - `throws` adalah **deklarasi** di tanda tangan sebuah `method` untuk memberitahukan bahwa `method` tersebut mungkin akan **melempar** sebuah `exception`. Ini berfungsi sebagai "peringatan" kepada pemanggil `method` agar siap untuk menangani potensi kesalahan.

- `Checked` vs `Unchecked Exception` : Ini adalah klasifikasi `exception` berdasarkan cara Java memaksanya.
    - `Checked Exception` adalah `exception` yang **harus ditangani**. Jika tidak, program tidak akan berhasil dikompilasi. Ini biasanya merupakan kesalahan eksternal yang tidak dapat dihindari oleh program, seperti `IOException` (kesalahan input/output).

    - `Unchecked Exception` adalah `exception` yang **tidak harus ditangani**. Ini biasanya menandakan kesalahan logika dalam program (bug), seperti `NullPointerException` (mencoba mengakses objek yang kosong), yang seharusnya bisa dicegah dengan perbaikan kode.

---

## Contoh sederhana
- `Try`-`catch`-`finally` :
```java
try {
    // Kode yang mungkin menyebabkan error
    int hasil = 10 / 0; 
} catch (ArithmeticException e) {
    // Penanganan error
    System.out.println("Terjadi kesalahan: Pembagian dengan nol tidak diizinkan.");
} finally {
    // Kode ini akan selalu dieksekusi
    System.out.println("Selesai mencoba.");
}
```

---

- `Multiple Catch` :
```java
try {
    // Kode yang bisa menghasilkan ArithmeticException atau ArrayIndexOutOfBoundsException
    int[] angka = new int[5];
    int hasil = 100 / angka[5];
} catch (ArithmeticException e) {
    System.out.println("Terjadi kesalahan aritmatika.");
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Terjadi kesalahan indeks di luar batas array.");
} catch (Exception e) { // Catch all exceptions
    System.out.println("Terjadi kesalahan umum.");
}
```

---

- `Throw & Throws` :
```java
public void cekUsia(int usia) throws IllegalArgumentException {
    if (usia < 0) {
        throw new IllegalArgumentException("Usia tidak boleh negatif.");
    }
}
```

---

- `Checked` vs `Unchecked Exception` :
    - `Checked Exception` memaksa untuk menangani kesalahan, seperti saat mencoba membuka berkas yang tidak ada.
    ```java
    import java.io.File;
    import java.io.FileNotFoundException;
    import java.io.FileReader;

    public class CheckedExample {
        public static void main(String[] args) {
            // Coba membuka berkas yang tidak ada.
            // FileReader bisa melempar FileNotFoundException, yang merupakan Checked Exception.
            try {
                File file = new File("non_existent_file.txt");
                FileReader reader = new FileReader(file);
            } catch (FileNotFoundException e) {
                // Kompiler memaksa kita untuk menangani exception ini.
                System.err.println("Maaf, berkas tidak ditemukan.");
                // e.printStackTrace(); // Baris ini berguna untuk debugging
            }
        }
    }

    ```
    **Penjelasan**: Tanpa `blok try-catch`, kode ini akan gagal saat dikompilasi karena `FileNotFoundExceptio`n adalah `Checked Exception` yang harus ditangani.

    ---

    - `Unchecked Exception` tidak memaksa Anda untuk menanganinya, karena mereka sering kali menunjukkan bug pada logika program.
    ```java
    public class UncheckedExample {
        public static void main(String[] args) {
            // Coba mengakses indeks yang tidak ada dalam array.
            int[] numbers = {1, 2, 3};

            // Ini adalah Unchecked Exception, ArrayIndexOutOfBoundsException.
            // Kompiler tidak akan memaksanya untuk ditangani.
            try {
                System.out.println(numbers[10]); // Akses indeks ke-10 (di luar batas array)
            } catch (ArrayIndexOutOfBoundsException e) {
                // Menangani exception untuk mencegah program berhenti.
                System.err.println("Maaf, Anda mencoba mengakses indeks yang tidak ada.");
            }
        }
    }
    ```
    **Penjelasan**: Kode ini akan berhasil dikompilasi tanpa blok `try-catch`, tetapi akan menyebabkan program `crash` saat dijalankan. Menambahkan `try-catch` membantu mengelola kesalahan dengan lebih baik, tetapi secara teknis tidak wajib.

---

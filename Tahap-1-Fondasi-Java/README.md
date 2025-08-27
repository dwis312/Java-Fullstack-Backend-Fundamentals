# Tahap 1: Fondasi Java
Tujuan: Menguasai dasar bahasa Java dan prinsip Object-Oriented Programming (OOP).

## 1. Class, Object, Constructor
- Materi:
    - Pengertian class dan object
    - Menulis class dengan atribut dan method
    - Constructor default vs parameterized
- Kegiatan Praktik:
    - Buat class Person dengan atribut name dan age
    - Tambahkan constructor untuk inisialisasi object
    - Buat beberapa instance Person dan cetak atributnya

---

## 2. Encapsulation & Access Modifier
- Materi:
    - private, protected, public
    - Getter dan setter untuk atribut private
    - Keuntungan enkapsulasi (data safety)
- Kegiatan Praktik:
    - Ubah atribut Person menjadi private
    - Buat getter/setter untuk name dan age
    - Coba akses atribut langsung → error, akses lewat getter/setter → berhasil

---

## 3. Inheritance, Polymorphism, Interface, Abstract Class
- Materi:
    - Inheritance: class Student extends Person
    - Polymorphism: method overriding, method overloading
    - Interface: kontrak method tanpa implementasi
    - Abstract Class: class abstrak dengan method abstract dan concrete
- Kegiatan Praktik:
    - Buat class Student turunan Person dengan atribut studentId
    - Override method toString()
    - Buat interface Printable dengan method print(), implementasikan di Student
    - Buat abstract class Employee dan turunkan menjadi Manager/Developer

---

## 4. Static vs Instance Members
- Materi:
    - Perbedaan member static dan instance
    - Akses member static tanpa object
- Kegiatan Praktik:
    - Buat class Counter dengan static count dan method increment()
    - Buat beberapa object Counter → lihat count yang sama untuk semua object

---

## 5. Exception Handling
- Materi:
    - Try-catch-finally
    - Multiple catch
    - Throw & throws
    - Checked vs Unchecked Exception
- Kegiatan Praktik:
    - Buat program pembagian 2 angka → tangani ArithmeticException
    - Buat method baca file → tangani IOException

---

## 6. Collection Framework
- Materi:
    - List (ArrayList, LinkedList)
    - Map (HashMap, TreeMap)
    - Set (HashSet)
    - Iterasi collection
- Kegiatan Praktik:
    - Buat ArrayList<Person> → tambah, hapus, tampilkan data
    - Buat HashMap<String, Integer> → simpan nama → usia
    - Iterasi menggunakan for, for-each, Iterator

---

## 7. I/O: FileReader/FileWriter, BufferedReader/BufferedWriter
- Materi:
    - Membaca dan menulis file teks
    - Perbedaan Reader/Writer vs BufferedReader/BufferedWriter
- Kegiatan Praktik:
    - Buat program simpan daftar Person ke file people.txt
    - Baca data dari people.txt → tampilkan di console

---

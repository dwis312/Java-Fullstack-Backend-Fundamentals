# Java Fullstack Backend Fundamentals

### Deskripsi
Proyek ini adalah pembelajaran **Java server-side programming** dari nol dengan pendekatan **Object-Oriented Programming (OOP)** dan **Model-View-Controller (MVC)**.  
Tujuan utama proyek ini adalah memahami cara membuat server, menangani request/response HTTP, serta mengelola data dengan struktur modular tanpa framework eksternal (Spring Boot, Maven, dsb).

---

## Roadmap Konseptual
- **Tahap 1: Fondasi Java**
    - Tujuan: Kuasai dasar bahasa Java dan OOP.
    - Materi & Kegiatan:
        - Class, Object, Constructor
        - Encapsulation, Access Modifier, Getter/Setter
        - Inheritance, Polymorphism, Interface, Abstract Class
        - Static vs Instance Members
        - Exception Handling
        - Collection Framework (ArrayList, LinkedList, Map)
        - I/O: FileReader/FileWriter, BufferedReader/BufferedWriter

- **Tahap 2: Dasar Networking & HTTP**
    - Tujuan: Paham konsep server-client dan protokol HTTP.
    - Materi & Kegiatan:
        - TCP/IP dan port
        - Socket programming (ServerSocket, Socket)
        - Request & Response HTTP
        - Menjalankan server di localhost (port 8080)

- **Tahap 3: Konsep MVC & Struktur Proyek**
    - Tujuan: Memahami arsitektur MVC untuk backend modular.
    - Materi & Kegiatan:
        - Model → representasi data
        - View → format output (JSON/HTML)
        - Controller → routing & request handling

- **Tahap 4: Routing & HTTP Request Handling**
    - Tujuan: Mengelola endpoint dan request dengan rapi.
    - Materi & Kegiatan:
        - Mapping URL → Controller → Method
        - HTTP Methods: GET, POST, PUT, DELETE
        - Parsing URL, query parameters, request body
        - Membuat response: status code, headers, body (JSON/HTML)

- **Tahap 5: Database & Persistence**
    - Tujuan: Menyimpan data secara permanen dan terstruktur.
    - Materi & Kegiatan:
        - Pilihan database: MySQL, PostgreSQL, SQLite
        - JDBC: koneksi ke database
        - DAO Pattern: abstraksi akses database
        - CRUD operations (Create, Read, Update, Delete)
        - Mapping data database → Model
        - Konfigurasi koneksi: db.properties / config file

- **Tahap 6: Service & Business Logic**
    - Tujuan: Memisahkan logika bisnis dari controller.
    - Materi & Kegiatan:
        - Service layer untuk operasi kompleks
        - Validasi data
        - Integrasi service dengan DAO dan controller

- **Tahap 7: Middleware & Utilities**
    - Tujuan: Tambahan lapisan yang mempermudah pengelolaan server.
    - Materi & Kegiatan:
        - Logging request & response
        - Error handling dan exception management
        - JSON serialization/deserialization
        - Input validation

- **Tahap 8: Modularisasi & OOP Lanjutan**
    - Tujuan: Membuat server scalable dan reusable.
    - Materi & Kegiatan:
        - Reusable components (ResponseBuilder, Router, RequestParser)
        - Polymorphism untuk service/controller
        - Abstraction untuk DAO & service
        - Encapsulation dan separation of concerns

- **Tahap 9: Testing & Debugging**
    - Tujuan: Memastikan server bekerja dengan baik.
    - Materi & Kegiatan:
        - Unit testing untuk model, DAO, service
        - Integration testing untuk alur request → response
        - Debugging: logging, breakpoint, console output

- **Tahap 10: Optimasi & Skalabilitas**
    - Tujuan: Server siap untuk banyak client dan performa tinggi.
    - Materi & Kegiatan:
        - Multi-threaded server untuk handle banyak request
        - Caching data yang sering diakses
        - Global exception handler
        - Refactoring untuk micro-controller modular


---

### Fitur Utama
1. **Server HTTP**
   - Menjalankan server di `localhost` dengan port yang dapat dikonfigurasi (misal 8080)
   - Menangani request HTTP: GET, POST, PUT, DELETE
2. **Routing & Controller**
   - Mapping URL endpoint ke controller
   - Menggunakan MVC pattern: Model → Controller → View
3. **Model & Service**
   - Representasi data (User, Product, dll.)
   - Logika bisnis di service terpisah dari controller
4. **Database & DAO Pattern**
   - CRUD operations menggunakan database relasional (MySQL, PostgreSQL, SQLite)
   - Abstraksi akses database menggunakan DAO
   - Koneksi database configurable melalui file `db.properties`
5. **Middleware & Utilities**
   - Logging request & response
   - Error handling dan validasi input
   - JSON serialization/deserialization
6. **Modular & OOP**
   - Kelas dan paket terstruktur (`model`, `view`, `controller`, `service`, `dao`, `core`)
   - Reusable components, encapsulation, abstraction


---

### Cara Menjalankan
1. Compile semua file `.java` di `src/`
```bash
javac -d out src/**/*.java
```

2. Jalankan server
```bash
java -cp out core.Main
```

3. Akses server di browser atau tools seperti curl
```bash
http://localhost:8080/

```

---

### Catatan
- Tidak menggunakan framework eksternal, murni Java standard library.
- Fokus pembelajaran: struktur server, OOP, modular MVC, dan dasar backend.
- Cocok sebagai dasar sebelum belajar framework seperti Spring Boot.

---

### Lisensi
MIT License

---
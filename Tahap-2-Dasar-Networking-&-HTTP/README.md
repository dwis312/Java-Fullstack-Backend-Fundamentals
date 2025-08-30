# Tahap 2: Dasar Networking & HTTP
Dasar dari komunikasi dalam jaringan komputer, Dwi, adalah model server-client (peladen-klien).
Dalam model ini, ada dua peran utama:
- **Server**: Sebuah perangkat atau program yang **menunggu permintaan** (**request**) dan menyediakan layanan atau sumber daya, seperti data, file, atau aplikasi.
- **Client**: Sebuah perangkat atau program yang **mengirimkan permintaan** ke server untuk mendapatkan layanan atau sumber daya.

---

- Tujuan:
    - Memahami konsep **client-server** dan **protokol HTTP**.
    - Memahami dasar **TCP/IP** dan penggunaan **port**.
    - Memahami cara kerja **Socket** dan **ServerSocket**.
    - Membuat server sederhana di `localhost:8080` yang bisa merespon permintaan HTTP.

---

## 1. Konsep TCP/IP dan Port
Untuk memastikan server dan client dapat "berbicara" satu sama lain, mereka menggunakan seperangkat aturan yang disebut protokol. Protokol yang paling umum di internet adalah **TCP/IP** (Transmission Control Protocol/Internet Protocol).
- **IP** (Internet Protocol): Ini adalah protokol yang bertanggung jawab untuk **mengirimkan paket data** dari satu komputer ke komputer lain di internet. Setiap perangkat memiliki **alamat IP unik**, seperti alamat rumah, yang memungkinkan paket data menemukan tujuannya.

- **TCP** (Transmission Control Protocol): Protokol ini bekerja di atas IP dan bertugas **memastikan pengiriman data yang andal dan terurut**. TCP memecah data menjadi paket-paket kecil di sisi pengirim dan menyatukannya kembali di sisi penerima, memastikan tidak ada data yang hilang.

- **Port** Jika alamat IP adalah alamat rumah, maka **port** adalah nomor kamar di dalam rumah tersebut. Port adalah nomor unik yang digunakan untuk mengidentifikasi aplikasi atau layanan tertentu yang berjalan di server.Misalnya:
    - **Port 80**: Standar untuk lalu lintas HTTP (web).
    - **Port 443**: Standar untuk HTTPS (web aman).
    - **Port 8080**: Sering digunakan untuk server web lokal saat pengembangan.

### Ilustrasi sederhana:
    ```bash
    Client ----(Request)---> Server
    Client <---(Response)--- Server

    ```

---

## 2. Socket Programming di Java
**Socket** adalah titik akhir dari sebuah koneksi dua arah. Menggunakan socket programming, kita bisa membuat aplikasi yang bisa berkomunikasi melalui jaringan.

- `ServerSocket`: Ini adalah class(cetak biru) di sisi server yang berfungsi untuk **mendengarkan koneksi masuk** dari client pada port tertentu. ServerSocket akan menunggu sampai ada client yang mencoba terhubung.

- `Socket`: Ini adalah class(cetak biru) yang merepresentasikan **titik akhir komunikasi** baik di sisi client maupun server. Ketika `ServerSocket` menerima koneksi, ia akan membuat objek `Socket` baru untuk menangani komunikasi dengan client tersebut.

**Kode Server TCP sederhana:**
```java
import java.io.*;
import java.net.*;

public class SimpleTCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server listening on port 8080...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String message = in.readLine();
            System.out.println("Received: " + message);
            out.println("Hello from server!");

            clientSocket.close();
        }
    }
}


```

```java
import java.io.*;
import java.net.*;

public class SimpleTCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        out.println("Hello Server!");
        System.out.println("Server says: " + in.readLine());

        socket.close();
    }
}


```

---

## 3. Memahami HTTP Request & Response
**HTTP** (Hypertext Transfer Protocol) adalah protokol yang digunakan untuk komunikasi antara browser (client) dan server web. Setiap interaksi dalam HTTP terdiri dari **request** (permintaan) dan **response** (tanggapan).

- **Request** (Permintaan): Dikirim oleh client ke server. Sebuah permintaan HTTP biasanya terdiri dari:
    - **Metode HTTP**: Seperti **GET** (untuk mengambil data) atau **POST** (untuk mengirim data).
    - **Path**: Lokasi sumber daya yang diminta, misalnya `/index.html`.
    - **Header**: Informasi tambahan tentang permintaan, seperti tipe browser.
    - **Body**: Data tambahan, seringkali digunakan pada metode `POST`.

- **Response** (Tanggapan): Dikirim oleh server kembali ke client setelah menerima permintaan. Sebuah tanggapan HTTP biasanya terdiri dari:
    - **Status Code**: Angka 3 digit yang menunjukkan hasil permintaan. Contohnya:
        - **200 OK**: Permintaan berhasil.
        - **404 Not Found**: Sumber daya tidak ditemukan.
        - **500 Internal Server Error**: Ada kesalahan di sisi server.
    - **Header**: Informasi tambahan tentang tanggapan, seperti tipe konten.
    - **Body**: Konten yang diminta, seperti halaman HTML, gambar, atau data JSON.

**HTTP adalah protokol berbasis teks:**
```java
GET / HTTP/1.1
Host: localhost:8080

HTTP/1.1 200 OK
Content-Type: text/plain

Hello World!


```

**Request Line**: `GET / HTTP/1.1`
**Header**: `Host: localhost:8080`
**Body**: Konten yang dikirim (opsional).
**Response**: Status code, header, body.

---

## 4. Menjalankan HTTP Server Sederhana di Java
`localhost` adalah nama khusus yang merujuk pada komputer, dengan alamat IP 127.0.0.1. Saat menjalankan server di `localhost`, server tersebut hanya dapat diakses dari komputer sendiri, tidak bisa dari perangkat lain di jaringan.

`port 8080` sering digunakan untuk pengembangan karena port standar (80 atau 443) mungkin sudah digunakan oleh program lain. Saat mengakses `http://localhost:8080` di browser, Akan mengarah ke browser untuk terhubung ke server yang berjalan di komputer local, pada port 8080.


**Server ini akan berjalan di `http://localhost:8080`**.
```java
import java.io.*;
import java.net.*;

public class SimpleHTTPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("HTTP Server running on http://localhost:8080");

        while (true) {
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            // Baca request (hanya header pertama untuk contoh sederhana)
            String requestLine = in.readLine();
            System.out.println("Request: " + requestLine);

            // Kirim response
            String responseBody = "<h1>Hello, World!</h1>";
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html");
            out.println("Content-Length: " + responseBody.length());
            out.println();
            out.println(responseBody);
            out.flush();

            socket.close();
        }
    }
}

```

**Uji dengan browser atau curl:**
```bash
curl -v http://localhost:8080

```


---

## Ringkasan

| Materi            | Ringkasan                                                 |
| ----------------- | --------------------------------------------------------- |
| **Client-Server** | Model komunikasi di jaringan: client minta, server balas. |
| **TCP/IP**        | TCP = reliabilitas data, IP = alamat pengiriman.          |
| **Port**          | Identifikasi layanan di komputer.                         |
| **Socket**        | Titik komunikasi dua arah.                                |
| **HTTP**          | Protokol berbasis teks untuk web.                         |

**Diagram Layer OSI vs TCP/IP**
| **Layer OSI (7)** | **Layer TCP/IP (4)** | **Contoh Protokol**  |
| ----------------- | -------------------- | -------------------- |
| 7. Application    | Application          | HTTP, FTP, SMTP, DNS |
| 6. Presentation   | Application          | TLS/SSL, JPEG, GIF   |
| 5. Session        | Application          | RPC, NetBIOS         |
| 4. Transport      | Transport            | TCP, UDP             |
| 3. Network        | Internet             | IP, ICMP, ARP        |
| 2. Data Link      | Link                 | Ethernet, Wi-Fi      |
| 1. Physical       | Link                 | Kabel, Fiber, Radio  |


**Diagram Alur Request-Response (Client ↔ Server)**
```bash
┌───────────┐       Request: GET /index.html HTTP/1.1
│  Client   │  -----------------------------------▶
│ (Browser) │                                     │
└───────────┘                                     │
                                                  │
                                                  ▼
                                            ┌──────────┐
                                            │  Server  │
                                            │ (Web)    │
                                            └──────────┘
                                                  │
                                                  │ Response:
                                                  │ HTTP/1.1 200 OK
                                                  │ Content-Type: text/html
                                                  │ <html>...</html>
                                                  │
                                                  ▼
┌───────────┐       ◀------------------------------
│  Client   │
│ (Browser) │
└───────────┘

```

**Struktur HTTP Request & Response**
- **HTTP Request**

- **HTTP Response**

- **Debugging Networking**

    - curl (HTTP Debug)
    ```bash
        # Kirim request GET
        curl -v http://localhost:8080

        # Kirim POST dengan data JSON
        curl -X POST -H "Content-Type: application/json" \
        -d '{"name":"Dwi"}' http://localhost:8080/api

    ```
    Opsi `-v` menampilkan detail header & response.

    - telnet (Tes Koneksi TCP)
    ```bash
        telnet localhost 8080
        # Setelah terhubung, bisa ketik:
        GET / HTTP/1.1
        Host: localhost

    ```

    - nc (Netcat)
    ```bash
        # Tes port terbuka
        nc -vz localhost 8080

    ```

**Apa itu Socket?**

- **Socket** = ujung komunikasi dua arah (client ↔ server).
- **ServerSocket** = untuk listen koneksi di port tertentu.

Flow:

Server menjalankan `new ServerSocket(port)` → menunggu koneksi.
Client menjalankan `new Socket(host, port)` → mencoba koneksi.
Keduanya bertukar data lewat `InputStream` & `OutputStream`.

---

## Praktikum
- **Jalankan TCP Server & Client** → pastikan komunikasi berhasil.
- **Modifikasi HTTP Server** untuk:
    - Menampilkan halaman berbeda jika path `/about`.
    - Mengirim file HTML dari disk.
- **Tambah Logging**: tampilkan IP & path request di console.

---

## Challenge Lanjutan
- Buat Mini Web Server:
    - Bisa melayani GET /, GET /about, GET /contact.
    - Tampilkan halaman HTML sederhana.
- Implementasikan status code 404 Not Found jika path tidak ada.
- Tambahkan JSON response untuk endpoint /api.

---
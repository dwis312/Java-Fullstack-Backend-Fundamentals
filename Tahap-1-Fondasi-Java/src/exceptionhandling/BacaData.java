package exceptionhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BacaData {
    public static void fileTxt(String namaFile) throws IOException {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(namaFile));
            String baris;
            while ((baris = reader.readLine()) != null) {
                System.out.println(baris);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        
    }

}

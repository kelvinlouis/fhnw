package ch.fhnw.oop2.testPrep;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Kelvin on 04-Jul-16.
 */
public class FileExample {
    public static void main(String[] args) {
        readFile();
        writeFile();
    }

    public static void readFile() {
        // Read File: BufferedReader mit FileReader
        try {
            BufferedReader br = new BufferedReader(new FileReader("starwars.txt"));
            List<String> lines = br.lines().collect(Collectors.toList());

            for (String str: lines) {
                //System.out.println(str);
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Read File: BufferedReader mit InputStreamReader
        try {
            InputStream stream = FileExample.class.getResourceAsStream("starwars.txt");
            InputStreamReader isr = new InputStreamReader(stream, Charset.forName("UTF-8"));
            BufferedReader br2 = new BufferedReader(isr);

            //br2.lines().forEach(s -> System.out.println(s));
            br2.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Read File: FileInputStream
        try {
            File file = new File(FileExample.class.getResource("starwars.txt").getFile());
            FileInputStream fileInputStream = new FileInputStream(file);
            //DataInputStream data = new DataInputStream(fileInputStream);

            for (int i=1; i<file.length(); ++i) {
                // Reads integers
                //System.out.print((char) fileInputStream.read());
//                System.out.println(data.readChar());
            }
            fileInputStream.close();
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }


        // Read File with Files
        try {
            Files.lines(
                    new File(FileExample.class.getResource("starwars.txt").getFile()).toPath(),
                    Charset.forName("UTF-8"))
                    .forEach(s -> System.out.println());
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static void writeFile() {
        // Write File: Files
        List<String> lines = new ArrayList<>();
        lines.add("KelvinTest");
        lines.add("Test2");

        File file = new File("C:\\Users\\Kelvin\\Desktop\\testWrite0.txt");

        try {
            Files.write(file.toPath(), lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            // Write File: BufferedWriter
            File file1 = new File("C:\\Users\\Kelvin\\Desktop\\testWrite1.txt");
            FileWriter writer = new FileWriter(file1);
            BufferedWriter bw = new BufferedWriter(writer);

            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }

            bw.close();
        } catch (IOException ex) {
        }

        // Write File: FileOutputStream
        try {
            File file2 = new File("C:\\Users\\Kelvin\\Desktop\\testWrite2.txt");
            FileOutputStream fos2 = new FileOutputStream(file2);
            DataOutputStream dos = new DataOutputStream(fos2);

            if (!file2.exists()) {
                file2.createNewFile();
            }

            for (String line : lines) {
                System.out.println(line);
                dos.writeChars(line + "\n");
            }

            dos.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {

        }
    }
}

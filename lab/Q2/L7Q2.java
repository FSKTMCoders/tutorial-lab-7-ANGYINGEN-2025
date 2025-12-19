package Q2;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class L7Q2 {
    public static void main(String [] args){
        try {
            URL u = new URL("https://fsktm.um.edu.my");
            URLConnection cnn = u.openConnection();
            InputStream stream = cnn.getInputStream();

            try (Scanner in = new Scanner(stream, "UTF-8");BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("index.htm"), "UTF-8"))) {
                while (in.hasNextLine()) {
                    w.write(in.nextLine());
                    w.newLine();
                }
            }

            System.out.println("Web page saved to index.htm");

        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}

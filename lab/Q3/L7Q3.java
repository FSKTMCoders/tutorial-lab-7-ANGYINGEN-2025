package Q3;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class L7Q3 {
    public static void main(String[] args) {
        writeOri();
        writeRev();
    }

    public static void writeRev () {
        try(Scanner in = new Scanner(new FileInputStream("original.txt"))) {
            try (PrintWriter out2 = new PrintWriter(new FileOutputStream("reverse.txt"))) {
            while(in.hasNextLine()) {
                String line = in.nextLine();
                for(int i = line.length()-1; i>=0;i--) {
                    char result = line.charAt(i);
                    out2.write(result);

                }
                out2.println();

            }
            System.out.println("File Updated");
        
        }    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeOri () {
        try(PrintWriter out = new PrintWriter(new FileOutputStream("original.txt"))) {
            out.write("Hello Good Morning");
            out.println();
            out.write("Hello Good Afternoon");
            System.out.println("File Updated");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

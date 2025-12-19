package Q1;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class L7Q1 {
    public static void main(String[] args) {
         try(Scanner sc = new Scanner(System.in)) {
            writeFile();
         
            System.out.print("Enter the code you want to check: ");
            String code = sc.nextLine();
            checkCourse(code);
            
         }
        
    }

    public static void checkCourse(String code) {
        boolean result = false;

        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("coursename.dat"))) {   
            while (true) {
                String temp = in.readUTF();
                String [] a = temp.split(",");

                if (code.equals(a[0])) {
                    System.out.println("The course is "+ a[1]);
                    result = true;
                    break;
            }
        } 

    } catch (EOFException e) {
            if (!result) {
                System.out.println("Course not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("coursename.dat"))) {
            out.writeUTF("WXES1116,Programming I");
            out.writeUTF("WXES1115,Data Structure");
            out.writeUTF("WXES1110,Operating System");
            out.writeUTF("WXES1112,Computing Mathematics I");
   
         } catch (IOException e) {
            System.out.println("File error");
            e.printStackTrace();
         }

    }
}

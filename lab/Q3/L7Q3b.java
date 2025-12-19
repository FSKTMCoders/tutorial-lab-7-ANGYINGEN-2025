package Q3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class L7Q3b {
    public static void main(String[] args) {
        readOri();
    }

    public static void readOri() {
        String filePath = "C:\\Users\\User\\Documents\\Y1\\y1s1.lab\\lab7\\Q3\\q3b.txt";
    
        try(BufferedReader rd = new BufferedReader(new FileReader(filePath));BufferedWriter wd = new BufferedWriter(new FileWriter("reverse2.txt"))) {
            String line;
            while((line = rd.readLine())!= null) {
                for(int i = line.length()-1; i>=0;i--) {
                    char result = line.charAt(i);
                    wd.write(result);

                }
                wd.newLine();
            }
            System.out.println("File Updated");
        } catch (FileNotFoundException e) {
            System.out.println("Could not locate file ");
        }
        catch (IOException e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }
}

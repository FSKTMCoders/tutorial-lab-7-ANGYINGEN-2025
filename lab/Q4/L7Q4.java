import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class L7Q4 {
    public static void main(String[] args) {
        int wordCount = 0;
        int totalChar = 0;
        int lineCount = 0;

        String filePath = "C:\\Users\\User\\Documents\\Y1\\y1s1.lab\\lab7\\Q4\\text.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = br.readLine())!=null) {
                System.out.println(line);
                lineCount ++;

                String [] word = line.split(" ");
                wordCount += word.length;

                int count = 0;
                for (int i = 0; i<line.length();i++) {
                    char ch = line.charAt(i);
                    if (ch == ' ') {
                        count++;
                    }
                }
                int charCount = line.length()-count;
                totalChar += charCount;
            }
            System.out.println("The total number of word : " + wordCount);
            System.out.println("The total number of character : " + totalChar);
            System.out.println("The total number of line : " + lineCount);


        } catch (IOException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();

        }
    }
    
}

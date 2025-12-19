import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class L7Q4b {
    public static void main(String[] args) {
     
        String filePath = "C:\\Users\\User\\Documents\\Y1\\y1s1.lab\\lab7\\Q4\\text.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int [] result = check(br);

            printResults(result[0],result[1],result[2]);

        } catch (IOException e) {
            System.out.println("Error reading the file.");
            e.printStackTrace();

        }
    }

    public static int[] check(BufferedReader br) throws IOException {
        String line;
        int wordCount = 0;
        int totalChar = 0;
        int lineCount = 0;

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
            return new int[]{wordCount, totalChar, lineCount};
    }

    public static void printResults (int word,int ch,int line) {
        System.out.println("The total number of word : " + word);
        System.out.println("The total number of character : " + ch);
        System.out.println("The total number of line : " + line);
    }
    
}


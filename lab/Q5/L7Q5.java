import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class L7Q5 {
    public static void main(String[] args) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.dat"))) {
            int n = in.readInt();
            String [] nameArray = new String[n];
            int [] ageArray = new int [n];
            char [] genderArray = new char [n];
            
            for (int i = 0;i<n;i++) {
                String name = in.readUTF();
                int age = in.readInt();
                char gender = in.readChar();
                nameArray[i] = name;
                ageArray [i] = age;
                genderArray [i] = gender;
            } 
            
            for (int i = 0;i<n-1;i++) { //Bubble sort (ascending order)
                for (int j =0;j<n-i-1;j++) {
                    if(nameArray[j].compareTo(nameArray[j+1]) > 0) { //j+1 comes first
                        String temp1 = nameArray[j];
                        nameArray[j] = nameArray[j+1];
                        nameArray[j+1] = temp1;

                        int temp2 = ageArray[j];
                        ageArray[j] = ageArray[j+1];
                        ageArray[j+1] = temp2;

                        char temp3 = genderArray[j];
                        genderArray[j] = genderArray[j+1];
                        genderArray[j+1] = temp3;
                    }
                }
            }

            for (int i = 0; i<n;i++) {
                System.out.println(nameArray[i]);
                System.out.println(ageArray[i]);
                System.out.println(genderArray[i]);
            }

        } catch (EOFException e) {
            System.out.println("End of File");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

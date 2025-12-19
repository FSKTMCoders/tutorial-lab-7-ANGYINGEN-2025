# Tutorial 
## 1. Write statements for each of the following

### a.
Store ten random integers within 0 to 1000 to a text file named `integer.txt`.
##### Answer:
``` java
try(PrintWriter out = new PrintWriter(new FileOutputStream("integer.txt"))) {
Random rand = new Random();
int [] num = new int [10];
for (int i = 0;i<10;i++) {
num [i] = rand.nextInt(1001);
out.println(num[i]);
} 
}  catch(IOException e) {
e.printStackTrace();
}
```
### b.
Read from the text file generated in a. Display all the integers and the largest integer.
##### Answer:
``` java
try (Scanner in = new Scanner(new FileInputStream("integer.txt"))){
int max = Integer.MIN_VALUE;
while(in.hasNextLine) {
int num = in.nextInt();
System.out.println(num);
if (num>max) {
max = num;
}
}
System.out.println(max);
}catch (IOException e) {
 e.printStackTrace();
}
```
### c.
Store ten random integers within 0 to 1000 to a binary file named `integer.dat`.
##### Answer:
``` java
try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("integer.txt"))) {
Random rand = new Random();
int [] num = new int [10];
for (int i = 0;i<10;i++) {
num [i] = rand.nextInt(1001);
out.writeInt(num[i]);
} 
}  catch(IOException e) {
e.printStackTrace();
}
```
### d.
Read from the binary file generated in c. Display all the integers and the average.
##### Answer:
``` java
try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("integer.dat"))) {
int sum = 0;
int count = 0;
while (true) {
int num = in.readInt();
System.out.println(num);
sum += num;
count++;
}
} catch (EOFException e) {
}
System.out.println("Average: " + (sum / (double)count));
```
---

## 2. Correct the error for the following statements
### a.
```java
PrintWriter out = new PrintWriter(new FileOutputStream("d:\data\matrix.txt"));
```
##### Answer:
``` java
PrintWriter out = new PrintWriter(new FileOutputStream("d:\\data\\matrix.txt"));
```
### b.
```java
try {
    PrintWriter out = new PrintWriter(new FileOutputStream("data.txt"));
    out.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
}
```
##### Answer:
``` java
try (PrintWriter out = new PrintWriter(new FileOutputStream("data.txt"))) {

} catch (IOException e e) {
    System.out.println("Problem with file output");
}
```
### c.
```java
int num;
Scanner a = new Scanner(new FileInputStream("data.dat"));
num = a.readInt();
a.close();
```
##### Answer:
``` java
try {
int num;
ObjectInputStream a = new ObjectInputStream(new FileInputStream("data.dat"));
num = a.nextInt();
a.close();
}catch (Exception ex) {}
}
```
### d.
```java
ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("data.dat"));
o.print('A');
o.close();
```
##### Answer:
``` java
try {
ObjectOutputStream o = new ObjectOutputStream (new FileOutputStream("data.dat"));
o.writeChar('A');
o.close();
}catch (Exception ex) {}
```

---

## 3.

Write a program that:

1. Converts a sentence into binary numbers (ASCII code 8-bit) and stores it in a text file named `data.txt`.
2. Reads from the text file and displays the sentence.
##### Answer:
``` java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;

public class T7Q3 {

    public static void main(String[] args) {

        String sentence = "Hello World!";

        try (PrintWriter out = new PrintWriter(new FileOutputStream("data.txt"))) {
            for (char c : sentence.toCharArray()) {
                String bin = String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0');
                out.println(bin);
            }
            System.out.println("Sentence written as binary to data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (Scanner in = new Scanner(new FileInputStream("data.txt"))) {
            StringBuilder sb = new StringBuilder();
            while (in.hasNextLine()) {
                String bin = in.nextLine();
                int ascii = Integer.parseInt(bin, 2);
                sb.append((char) ascii);
            }
            System.out.println("Reconstructed sentence: " + sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

```

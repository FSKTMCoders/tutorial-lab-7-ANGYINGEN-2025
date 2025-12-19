# Tutorial 
## 1. Write statements for each of the following

### a.

Store ten random integers within 0 to 1000 to a text file named `integer.txt`.

### b.

Read from the text file generated in a. Display all the integers and the largest integer.

### c.

Store ten random integers within 0 to 1000 to a binary file named `integer.dat`.

### d.

Read from the binary file generated in c. Display all the integers and the average.

---

## 2. Correct the error for the following statements

### a.

```java
PrintWriter out = new PrintWriter(new FileOutputStream("d:\data\matrix.txt"));
```

### b.

```java
try {
    PrintWriter out = new PrintWriter(new FileOutputStream("data.txt"));
    out.close();
} catch (FileNotFoundException e) {
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

### d.

```java
ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("data.dat"));
o.print('A');
o.close();
```

---

## 3.

Write a program that:

1. Converts a sentence into binary numbers (ASCII code 8-bit) and stores it in a text file named `data.txt`.
2. Reads from the text file and displays the sentence.


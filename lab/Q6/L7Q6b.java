import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class L7Q6b {
    public static void main(String [] args){
        String [][] productArr = new String[7][4];
        String [][] orderArr = new String [5][3];

        try{
            Scanner sc = new Scanner(new FileInputStream("product.txt"));

            String rawStr;
            for(int i = 0; sc.hasNextLine(); i++){
                rawStr = sc.nextLine();
                productArr[i] = rawStr.split(",");
            }

            sc = new Scanner(new FileInputStream("order.txt"));

            rawStr = "";
            for(int i = 0; sc.hasNextLine(); i++){
                rawStr = sc.nextLine();
                orderArr[i] = rawStr.split(",");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(int i = 0 ; i<orderArr.length; i++){
            int linkIndex = getLinkIndex(orderArr[i][1], productArr);
            if(linkIndex > 0) {
                double total = Integer.parseInt(orderArr[i][2]) * Double.parseDouble(productArr[linkIndex][2]);
                System.out.printf("%-10s %-20s %-8s %-8s %8.2f %n", productArr[linkIndex][0], productArr[linkIndex][1], orderArr[i][2], productArr[linkIndex][2], total);
            }
        }
    }

    public static int getLinkIndex(String orderId, String [][] productArr){
        for(int i = 0; i<productArr.length; i++){
            if(productArr[i][0].equals(orderId))
                return i;
        }
        return -1;
    }
}

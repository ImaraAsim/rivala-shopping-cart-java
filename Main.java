import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
public static void main(String []args){

electronic();
}
public static void cart(){

}
public static  void electronic() {
    Scanner sc = new Scanner(System.in);
    System.out.println("  <<<    Laptops     >>>");
    String del = "DEL ";
    String hp = " hp";
    String lenovo = " Lenovo";
    String torceba = " Torceba";
    String lg = " LG";
    int delprice = 50000;
    int hpprice = 70000;
    int lenprice = 80000;
    int torc = 900000;
    int lgprice = 1500000;

    System.out.println("  <!!! PRODUCT LIST   !!!> ");
    System.out.printf("%-3s %-10s %-5s  \n ", "Num", "! Name ! ", " ! Price !");
    System.out.printf("%-3s %-10s %-5d %-3s \n", "1.", del, delprice, "RS");
    System.out.printf("%-3s%-10s %-5d %-3s \n", "2.", hp, hpprice, "RS");
    System.out.printf("%-3s%-10s %-5d %-3s \n", "3.", lenovo, lenprice, "RS");
    System.out.printf("%-3s%-10s %-5d %-3s \n", "4.", torceba, torc, "RS");
    System.out.printf("%-3s%-10s %-5d %-3s \n", "5.", lg, lgprice, "RS");


    try {
        int finalBill=0;
        int amount=0;
        String again="y";
        FileWriter file = new FileWriter("product.txt");
        PrintWriter pw = new PrintWriter(file);
        pw.printf("%-3s %-10s %-10s %-10s %-3s  \n ", "Num", "! Name ! ", "   ! Price !" ,"   !Amount !", "   ! Bill !");

        while(again.equalsIgnoreCase("y")) {
            System.out.println(" Select the product ");
            int  selectProduct = sc.nextInt();
            if (selectProduct==1){
                System.out.println( " AMOUNT  :  ");
                  amount = sc.nextInt();
                 int Bill =bill(amount,delprice,finalBill);
                    pw.printf("%-3s %-10s %-5d %-10s %-10d%-5d %-3s \n", "1.", del, delprice, "RS" ,amount,Bill,"Rs");}
            else if (selectProduct==2){
                System.out.println( " AMOUNT  :  ");
                amount = sc.nextInt();
                int Bill =bill(amount,hpprice,finalBill);

                pw.printf("%-3s%-10s %-5d %-10s %-10d %-5d %-3s \n", "2.", hp, hpprice, "RS",amount,Bill, "Rs");}
            else if (selectProduct==3){
                System.out.println( " AMOUNT  :  ");
                amount = sc.nextInt();
                int Bill =bill(amount,lenprice,finalBill);
                    pw.printf("%-3s%-10s %-5d %-10s %-10d %-5d %-3s \n", "3.", lenovo, lenprice, "RS" , amount , Bill , "Rs");}
            else if (selectProduct==4){
                System.out.println( " AMOUNT  :  ");
                amount = sc.nextInt();
                int Bill =bill(amount,torc,finalBill);
                    pw.printf("%-3s%-10s %-5d %-10s %-10d %5d %-3s \n", "4.", torceba, torc, "RS",amount,Bill,"Rs");}
            else if (selectProduct==5){
                System.out.println( " AMOUNT  :  ");
                amount = sc.nextInt();
                int Bill =bill(amount,lgprice,finalBill);
                    pw.printf("%-3s%-10s %-5d %-10s %-10d %-5d %-3s \n", "5.", lg, lgprice, "RS",amount ,Bill,"Rs");
            }
            else {
                System.out.println( " invalid input.... select avalaible products ");
            }
            System.out.println( " DO YOU WANT TO BUY SOMETHING MORE ?  Y/N ");
            again=sc.next();
        }
        pw.close();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

}
public static int  bill(int amount,int price , int finalBill){
    int bill=0;
    int count=0;
    if (amount %3==0 ){
    count++;
     bill=( (amount-1) *price );
     finalBill =bill;
    }else {
        bill = amount*price;
        finalBill = bill;
    }

    return bill;


}

}

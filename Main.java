import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        electronic();
        cart();
    }


    public static void electronic() {
        Scanner sc = new Scanner(System.in);
        System.out.println("  <<<    Laptops     >>>");
        String del = "DEL ";
        String hp = " hp";
        String lenovo = " Lenovo";
        String mac = " Mac book";
        String lg = " LG";
        int delprice = 50000;
        int hpprice = 70000;
        int lenprice = 80000;
        int macp = 200000;
        int lgprice = 1500000;


        System.out.println("\n --> NAME ||  |  ||PRICES <--\n");
        System.out.println("1. DEL       -   Rs. 50000");
        System.out.println("2. HP        -   Rs. 70000");
        System.out.println("3. LENOVO    -   Rs. 80000");
        System.out.println("4. MAC BOOK  -   Rs. 200000");
        System.out.println("5. LG        -   Rs. 1500000");
        int  selectProduct=0;

        try {
            int total = 0;
            int amount = 0;
            String again = "y";
            FileWriter file = new FileWriter("product.txt");
            PrintWriter pw = new PrintWriter(file);
            pw.println("------>   CART   <------");

            pw.printf("%-4s %-20s %-10s %-8s %-15s %-10s\n", "No.", "Item", "Price (Rs)", "Qty", "Discount", "Total (Rs)");
            boolean againb = true;


            while(againb==true) {
                if (again.equalsIgnoreCase("y") ){
                    System.out.println(" Select the product ");
                     selectProduct= sc.nextInt();

                    if (selectProduct == 1) {
                        System.out.println(" AMOUNT  :  ");
                        amount = sc.nextInt();
                        int Bill = ebill(amount, delprice);
                        String more = "y";
                        while (more.equalsIgnoreCase("y")) {
                            try {
                                System.out.println(" Do you want to buy more ? choose y or n ");
                                more = sc.next();
                                if (more.equalsIgnoreCase("y")) {
                                    System.out.println("AMOUNT:");
                                    total = sc.nextInt();
                                    amount += total;
                                } else if (more.equalsIgnoreCase("n")) {
                                    break;
                                } else {
                                    throw new InputMismatchException("Invalid  input ... enter y/n ");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println(e.getMessage());
                                more = sc.next();
                            }
                        }

                        pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d \n", "1.", del, delprice, amount, "70% OFF", Bill);
                    } else if (selectProduct == 2) {
                        System.out.println(" AMOUNT  :  ");
                        amount = sc.nextInt();
                        int Bill = ebill(amount, hpprice);
                        String more = "y";
                        while (more.equalsIgnoreCase("y")) {
                            try {
                                System.out.println(" Do you want to buy more ? choose y or n ");
                                more = sc.next();
                                if (more.equalsIgnoreCase("y")) {
                                    System.out.println("AMOUNT:");
                                    total = sc.nextInt();
                                    amount += total;
                                } else if (more.equalsIgnoreCase("n")) {
                                    break;
                                } else {
                                    throw new InputMismatchException("Invalid  input ... enter y/n ");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println(e.getMessage());
                                more = sc.next();
                            }
                        }


                        pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", "2.", hp, hpprice, amount, "70% OFF", Bill);
                    } else if (selectProduct == 3) {
                        System.out.println(" AMOUNT  :  ");
                        amount = sc.nextInt();
                        int Bill = ebill(amount, lenprice);
                        String more = "y";
                        while (more.equalsIgnoreCase("y")) {
                            try {
                                System.out.println(" Do you want to buy more ? choose y or n ");
                                more = sc.next();
                                if (more.equalsIgnoreCase("y")) {
                                    System.out.println("AMOUNT:");
                                    total = sc.nextInt();
                                    amount += total;
                                } else if (more.equalsIgnoreCase("n")) {
                                    break;
                                } else {
                                    throw new InputMismatchException("Invalid  input ... enter y/n ");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println(e.getMessage());
                                more = sc.next();
                            }

                        }


                        pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", "3.", lenovo, lenprice, amount, "70% OFF", Bill);
                    } else if (selectProduct == 4) {
                        System.out.println(" AMOUNT  :  ");
                        amount = sc.nextInt();
                        int Bill = ebill(amount, macp);
                        String more = "y";
                        while (more.equalsIgnoreCase("y")) {
                            try {
                                System.out.println(" Do you want to buy more ? choose y or n ");
                                more = sc.next();
                                if (more.equalsIgnoreCase("y")) {
                                    System.out.println("AMOUNT:");
                                    total = sc.nextInt();
                                    amount += total;
                                } else if (more.equalsIgnoreCase("n")) {
                                    break;
                                } else {
                                    throw new InputMismatchException("Invalid  input ... enter y/n ");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println(e.getMessage());
                                more = sc.next();
                            }
                        }

                        pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", "4.", mac, macp, amount, "70% OFF", Bill);
                    } else if (selectProduct == 5) {
                        System.out.println(" AMOUNT  :  ");
                        amount = sc.nextInt();
                        int Bill = ebill(amount, lgprice);
                        String more = "y";
                        while (more.equalsIgnoreCase("y")) {
                            try {
                                System.out.println(" Do you want to buy more ? choose y or n ");
                                more = sc.next();
                                if (more.equalsIgnoreCase("y")) {
                                    System.out.println("AMOUNT:");
                                    total = sc.nextInt();
                                    amount += total;
                                } else if (more.equalsIgnoreCase("n")) {
                                    break;
                                } else {
                                    throw new InputMismatchException("Invalid  input ... enter y/n ");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println(e.getMessage());
                                more = sc.next();
                            }
                        }

                        pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", "5.", lg, lgprice, amount, "70% OFF", Bill);

                    } else {

                        throw new InputMismatchException(" invalid input.... select avalaible products ");

                    }

                    System.out.println(" Do you want to buy some other product ?  Y/N ");
                    again = sc.next();
                    if ( again.equalsIgnoreCase("y")) {

                    againb = true ;
                }else if (again.equalsIgnoreCase("n")) {

                        againb = false ;
                        break;
                }else {
                    System.out.println(" INVALID INPUT ...");
                    again = sc.next();
                    againb = false;
                }
                }



                pw.close();
                break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
            selectProduct = sc.nextInt();

        }

        }



    public static int ebill(int amount, int price) {
        int bill = 0;
        int count = 0;
        if (amount > 2) {
            double discount = price * 0.7;
            int priceF = (int) (price - discount);
            bill = amount * priceF;
        } else {
            bill = amount * price;
        }

        return bill;
    }





    public static void cart() {
        try {
            Scanner sc = new Scanner(System.in);
            File file = new File("product.txt");
            BufferedReader br = new BufferedReader(new FileReader("product.txt"));
            String line;
            System.out.println("\n --> choose the options <--\n");
            System.out.println("1. - ADD");
            System.out.println("2. - Remove");
            System.out.println("3. - Checkout");
            int choose = sc.nextInt();
            String product = "";
            int amount = 0;
            String prpd = "";
            if (choose == 2) {
                while ((line = br.readLine()) != null) {
                    System.out.println(line);

                }
                System.out.println("what do you want to remove");
                product = sc.next();
                System.out.println("amount :");
                amount = sc.nextInt();
                prpd = String.valueOf(product);

                br.close();

                BufferedReader brr = new BufferedReader(new FileReader("product.txt"));
                File temp =new File("temp.txt");
                FileWriter temp1 = new FileWriter("temp.txt");

                PrintWriter pw = new PrintWriter("temp.txt");
                boolean present = false;

                String lineT;
                while ((lineT = brr.readLine()) != null) {
                    if (lineT.startsWith(product)) {
                        present = true;
                        String[] parts = lineT.trim().split("\s+");
                        if (parts.length >= 6) {
                            int price = Integer.parseInt(parts[2]);
                            int amountc = Integer.parseInt(parts[3]);
                            int bill = Integer.parseInt(parts[6]);
                            int amountf = amountc - amount;
                            // String newamountstr = String.valueOf(amountf);

                            int Bill = ebill((amountf), price);
                            String newbill = String.format("%-5d", Bill);
                            String newamount = String.format("%-5d", amountf);
                            lineT = lineT.replaceFirst(parts[6], newbill.trim());
                            lineT = lineT.replace(parts[3], newamount);


                        }
                        pw.println(lineT);

                    } else {
                        pw.println(lineT);
                    }
                }
                if (present = false ){
                    System.out.println("INVALID INPUT .... THAT PRODUCT IS NOT PRESENT ");
                }

                pw.close();
                brr.close();





            }

             else{
                System.out.println( "INVALID INPUT ....");
                choose = sc.nextInt();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }catch (InputMismatchException e){
            System.out.println("INVALID INPUT...");
        }


    }
}




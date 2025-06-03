import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.nio.Buffer;
import java.text.Normalizer;
import java.util.InputMismatchException;
import java.util.Scanner;

public class shoppingcartUpdated {
    static String username = "1";
    static int index = 1;

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("WELCOME TO HOME PAGE");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("0. Exit");
                System.out.println("Choose a Number:");
                int choice = 0;
                try {
                    choice = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Enter Valid Number!");
                    sc.nextLine();
                }
                if (choice == 1) {
                    registration();
                } else if (choice == 2) {
                    isLogin();
                } else if (choice == 0) {
                    System.out.println("Happy Shopping!\nHope You Have Enjoyed Your Experience Here!\nPlease! Visit Us Again.");
                    break;
                } else {
                    System.out.println("Invalid Number!");
                }
            }
        }
    }

    public static void registration() {
        Scanner input = new Scanner(System.in);
        try {
            FileWriter fw = new FileWriter("registration.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            System.out.println("----> REGISTER TO OUR WEBSITE FIRST <-----");
            System.out.println("Enter the User Name:");
            pw.println("User Name: ");
            String name = input.nextLine();
            pw.println(name);
            System.out.println("Enter the Password:");
            pw.println("Password: ");
            String password = input.nextLine();
            pw.println(password);
            File file = new File("registration.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                sc.nextLine();
                String name1 = sc.nextLine();
                sc.nextLine();
                String password1 = sc.nextLine();
                if (name.equals(name1) && password.equals(password1)) {
                    System.out.println("You are Already Registered, Please Login!");
                    return;
                } else {
                    System.out.println("You have been successfully Registered");
                    break;
                }
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("An Error has been Occurred!");
        } catch (Exception e) {
            System.out.println("An Unexpected Error has been Occurred");
        }
    }

    public static void isLogin() {
        File file = new File("registration.txt");
        System.out.println("----> LOGIN <----");
        Scanner input = new Scanner(System.in);
        int attempt = 0;
        boolean loggin = false;
        while (attempt < 3 && !loggin) {
            int found = 0;
            try {
                if (!file.exists() || file.length() == 0) {
                    System.out.println("No Users Registered Yet. Please Register First!");
                    return;
                }
                System.out.println("Enter name: ");
                username = input.nextLine();
                System.out.println("Enter the password:");
                String password = input.nextLine();
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    sc.nextLine();
                    String name1 = sc.nextLine();
                    sc.nextLine();
                    String password1 = sc.nextLine();
                    if (name1.equals(username) && password1.equals(password)) {
                        System.out.println("Login Successfully!");
                        loggin = true;
                        categories();

                        break;
                    } else {
                        if (!name1.equals(username) && password1.equals(password)) {
                            found = 1;

                        } else if (!password1.equals(password) && name1.equals(username)) {
                            found = 2;
                        }
                    }
                }
                if (!loggin) {
                    attempt++;
                    if (found == 0) {
                        System.out.println("User not Registered Yet! Press 1 to Register");
                        break;
                    } else if (found == 1) {
                        System.out.println("Invalid User Name");
                    } else if (found == 2) {
                        System.out.println("Invalid Login Password");
                    }

                }
                if (attempt >= 3) {
                    System.out.println("Too Many Invalid Tries, Please try again later");
                    System.exit(1);
                }
                sc.close();
            } catch (IOException e) {
                System.out.println("Error!");
            } catch (Exception e) {
                System.out.println("An Unexpected Error has been Occurred");

            }
        }
    }

    public static void categories() {
        Scanner sc = new Scanner(System.in);
        try {
            FileWriter file = new FileWriter(username + ".txt", true);
            PrintWriter pw = new PrintWriter(file);
            File f = new File(username + ".txt");
            if (f.length() == 0) {
                pw.printf("%-4s %-20s %-10s %-8s %-15s %-10s\n", "No.", "Item", "Price (Rs)", "Qty", "Discount", "Total (Rs)");
                pw.flush();
            } 
            while (true) {
                System.out.println("\n |---- CATEGORIES ----|");
                System.out.println("1. Clothing");
                System.out.println("2. Groceries");
                System.out.println("3. Personal Care");
                System.out.println("4. Electronics");
                System.out.println("0. Exit");
                System.out.println("Choose a Number:");
                int choose = sc.nextInt();
                if (choose == 1) {
                    clothing(pw);
                } else if (choose == 2) {
                    groceries(pw);
                } else if (choose == 3) {
                    personalCare(pw);
                } else if (choose == 4) {
                    electronics(pw);
                } else if (choose == 0) {
                    pw.close();
                    cart();
                    break;
                } else {
                    System.out.println("Invalid Number!");
                }
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error!");
        }
    }

    public static void clothing(PrintWriter pw) {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        int choose = 0;
        String ch = "";
        int item = 0;
        int item1 = 0;
        int item2 = 0;
        int item3 = 0;
        int item4 = 0;
        int item5 = 0;
        while (true) {
            System.out.println("\n |---- CLOTHING ----|");
            System.out.println(" 1. T-Shirt ");
            System.out.println(" 2. Jeans   ");
            System.out.println(" 3. Hoodies  ");
            System.out.println(" 4. Shoes ");
            System.out.println(" 0. Exit");
            System.out.println(" ");
            while (true) {
                try {
                    System.out.println("Choose a Section: ");
                    choose = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input!");
                    sc.nextLine();
                }
            }
            if (choose == 1) {
                System.out.println("\n  |----CLOTHING   -->   T-SHIRTS----|");
                while (true) {
                    System.out.println("  --> SHIRTS          |   PRICES <--");
                    System.out.println("1. Formal Shirt       -  Rs. 1800");
                    System.out.println("2. Casual Shirt       -  Rs. 1500");
                    System.out.println("3. Checked Shirt      -  Rs. 1600");
                    System.out.println("4. Printed Shirt      -  Rs. 1700");
                    System.out.println("5. Denim Shirt        -  Rs. 1900");
                    System.out.println("0. Exit");
                    while (true) {
                        try {
                            System.out.println("\nChoose Items: ");
                            item = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                            sc.nextLine();
                        }
                    }
                    if (item == 0) {
                        break;
                    } else {
                        if (item == 1) {
                            System.out.println("\n|--- Formal Shirt  -  Rs. 1800 ---| ");
                            while (true) {
                                int price1 = 1800;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Formal Shirt", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 2) {
                            System.out.println("\n|--- Casual Shirt  -  Rs. 1500 ---|");
                            while (true) {
                                int price2 = 1500;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item2 = sc.nextInt();
                                        if (item2 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item2;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n': ");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price2);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Casual Shirt", price2, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character");
                                }
                            }

                        } else if (item == 3) {
                            System.out.println("\n|--- Checked Shirt  -  Rs. 1600 ---|");
                            while (true) {
                                int price3 = 1600;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item3 = sc.nextInt();
                                        if (item3 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item3;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n': ");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price3);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Checked Shirt", price3, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character");
                                }
                            }
                        } else if (item == 4) {
                            System.out.println("\n|--- Printed Shirt  -  Rs. 1700 ---|");
                            while (true) {
                                int price4 = 1700;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item4 = sc.nextInt();
                                        if (item4 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item4;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n': ");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price4);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Printed Shirt", price4, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character");
                                }
                            }
                        } else if (item == 5) {
                            System.out.println("\n|--- Denim Shirt  -  Rs. 1900 ---|");
                            while (true) {
                                int price5 = 1900;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item5 = sc.nextInt();
                                        if (item5 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item5;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n': ");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price5);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Denim Shirt", price5, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character");
                                }
                            }
                        } else {
                            System.out.println("Invalid Number!");
                        }
                    }
                }
            } else if (choose == 2) {
                System.out.println("\n  |----CLOTHING   -->  JEANS----|");
                while (true) {
                    System.out.println(" --> JEANS          |   PRICES <--");
                    System.out.println("1. Wide Leg Jeans   -  Rs. 2200");
                    System.out.println("2. Ripped Jeans     -  Rs. 2400");
                    System.out.println("3. Baggy Jeans      -  Rs. 2100");
                    System.out.println("4. Straight Fit     -  Rs. 2300");
                    System.out.println("5. Slim Fit Jeans   -  Rs. 2500");
                    System.out.println("0. Exit");
                    while (true) {
                        try {
                            System.out.println("\nChoose Items: ");
                            item = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                            sc.nextLine();
                        }
                    }
                    if (item == 0) {
                        break;
                    } else {
                        if (item == 1) {
                            System.out.println("\n|--- Wide Leg Jeans  -  Rs. 2200 ---| ");
                            while (true) {
                                int price1 = 2200;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Wide Leg Jeans", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 2) {
                            System.out.println("\n|--- Ripped Jeans  -  Rs. 2400 ---|");
                            while (true) {
                                int price2 = 2400;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item2 = sc.nextInt();
                                        if (item2 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item2;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n': ");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price2);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Ripped Jeans", price2, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character");
                                }
                            }

                        } else if (item == 3) {
                            System.out.println("\n|--- Baggy Jeans  -  Rs. 2100 ---|");
                            while (true) {
                                int price3 = 2100;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item3 = sc.nextInt();
                                        if (item3 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item3;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n': ");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price3);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Baggy Jeans", price3, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character");
                                }
                            }
                        } else if (item == 4) {
                            System.out.println("\n|--- Straight Fit  -  Rs. 2300 ---|");
                            while (true) {
                                int price4 = 2300;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item4 = sc.nextInt();
                                        if (item4 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item4;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n': ");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price4);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Straight Fit", price4, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character");
                                }
                            }
                        } else if (item == 5) {
                            System.out.println("\n|--- Slim Fit Jeans  -  Rs. 2500 ---|");
                            while (true) {
                                int price5 = 2500;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item5 = sc.nextInt();
                                        if (item5 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item5;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n': ");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price5);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Slim Fit Jeans", price5, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character");
                                }
                            }
                        } else {
                            System.out.println("Invalid Number!");
                        }
                    }
                }
            } else if (choose == 3) {
                System.out.println("\n|----CLOTHING   -->  HOODIES----|");
                while (true) {
                    System.out.println(" --> HOODIES         |   PRICES <--");
                    System.out.println("1. Zipper Hoodie     -  Rs. 1800");
                    System.out.println("2. Pullover Hoodie   -  Rs. 1700");
                    System.out.println("3. Oversized Hoodie  -  Rs. 2000");
                    System.out.println("4. Graphic Hoodie    -  Rs. 1900");
                    System.out.println("5. Cropped Hoodie    -  Rs. 1600");
                    System.out.println("0. Exit");

                    while (true) {
                        try {
                            System.out.println("\nChoose Items: ");
                            item = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                            sc.nextLine();
                        }
                    }
                    if (item == 0) {
                        break;
                    } else {
                        if (item == 1) {
                            System.out.println("\n|--- Zipper Hoodie  -  Rs. 1800 ---| ");
                            while (true) {
                                int price1 = 1800;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Zipper Hoodie", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 2) {
                            System.out.println("\n|--- Pullover Hoodie  -  Rs. 1700 ---|");
                            while (true) {
                                int price2 = 1700;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item2 = sc.nextInt();
                                        if (item2 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item2;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n': ");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price2);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Pullover Hoodie", price2, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character");
                                }
                            }

                        } else if (item == 3) {
                            System.out.println("\n|--- Oversized Hoodie  -  Rs. 2000 ---|");
                            while (true) {
                                int price3 = 2000;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item3 = sc.nextInt();
                                        if (item3 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item3;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n': ");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price3);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Oversized Hoodie", price3, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character");
                                }
                            }
                        } else if (item == 4) {
                            System.out.println("\n|--- Graphic Hoodie  -  Rs. 1900 ---|");
                            while (true) {
                                int price4 = 1900;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item4 = sc.nextInt();
                                        if (item4 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item4;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n': ");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price4);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Graphic Hoodie", price4, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character");
                                }
                            }
                        } else if (item == 5) {
                            System.out.println("\n|--- Cropped Hoodie  -  Rs. 1600 ---|");
                            while (true) {
                                int price5 = 1600;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item5 = sc.nextInt();
                                        if (item5 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item5;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n': ");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price5);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Cropped Hoodie", price5, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character");
                                }
                            }
                        } else {
                            System.out.println("Invalid Number!");
                        }
                    }
                }
            } else if (choose == 4) {
                System.out.println("\n  |----CLOTHING  -->   SHOES----|");
                while (true) {
                    System.out.println(" --> SHOES           |   PRICES <--");
                    System.out.println("1. Running Shoes     -  Rs. 3000");
                    System.out.println("2. Sneakers          -  Rs. 2800");
                    System.out.println("3. Loafers           -  Rs. 2600");
                    System.out.println("4. Formal Shoes      -  Rs. 3200");
                    System.out.println("5. Long Shoes        -  Rs. 2900");
                    System.out.println("0. Exit");

                    while (true) {
                        try {
                            System.out.println("\nChoose Items: ");
                            item = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                            sc.nextLine();
                        }
                    }
                    if (item == 0) {
                        break;
                    } else {
                        if (item == 1) {
                            System.out.println("\n|--- Running Shoes  -  Rs. 3000 ---| ");
                            while (true) {
                                int price1 = 3000;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Running Shoes", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 2) {
                            System.out.println("\n|--- Sneakers  -  Rs. 2800 ---|");
                            while (true) {
                                int price2 = 2800;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item2 = sc.nextInt();
                                        if (item2 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item2;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n': ");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price2);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Sneakers", price2, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character");
                                }
                            }

                        } else if (item == 3) {
                            System.out.println("\n|--- Loafers   -  Rs. 2600 ---|");
                            while (true) {
                                int price3 = 2600;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item3 = sc.nextInt();
                                        if (item3 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item3;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n': ");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price3);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Loafers ", price3, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character");
                                }
                            }
                        } else if (item == 4) {
                            System.out.println("\n|--- Formal Shoes  -  Rs.3200 ---|");
                            while (true) {
                                int price4 = 3200;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item4 = sc.nextInt();
                                        if (item4 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item4;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n': ");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price4);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Formal Shoes ", price4, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character");
                                }
                            }
                        } else if (item == 5) {
                            System.out.println("\n|---  Long Shoes  -  Rs. 2900 ---|");
                            while (true) {
                                int price5 = 2900;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item5 = sc.nextInt();
                                        if (item5 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item5;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n': ");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price5);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Long Shoes", price5, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character");
                                }
                            }
                        } else {
                            System.out.println("Invalid Number!");
                        }
                    }
                }
            } else if (choose == 0) {
                System.out.println("Thank You For Shopping!");
                break;
            } else {
                System.out.println("Invalid Input!");
            }
        }
    }

    public static void groceries(PrintWriter pw) {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        int choose = 0;
        String ch = "";
        int item = 0;
        int item1 = 0;
        while (true) {
            System.out.println("\n |---- GROCERIES ----|");
            System.out.println(" 1. Snacks");
            System.out.println(" 2. Beverages");
            System.out.println(" 3. Chocolates & Candies");
            System.out.println(" 4. Frozen Foods");
            System.out.println(" 0. Exit");
            System.out.println(" ");
            while (true) {
                try {
                    System.out.println("Choose a Section: ");
                    choose = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input!");
                    sc.nextLine();
                }
            }
            if (choose == 1) {
                System.out.println("\n  |----GROCERIES  -->   SNACKS----|");
                while (true) {
                    System.out.println(" --> SNACKS              |   PRICES <--");
                    System.out.println("1. Lays Chips            -  Rs. 100");
                    System.out.println("2. Kurkure               -  Rs. 50");
                    System.out.println("3. Salted Peanuts        -  Rs. 80");
                    System.out.println("4. Nimko Mix             -  Rs. 70");
                    System.out.println("5. Popcorn Pack          -  Rs. 120");
                    System.out.println("0. Exit");
                    while (true) {
                        try {
                            System.out.println("\nChoose Items: ");
                            item = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                            sc.nextLine();
                        }
                    }
                    if (item == 0) {
                        break;
                    } else {
                        if (item == 1) {
                            System.out.println("\n|--- Lays Chips  -  Rs. 100 ---| ");
                            while (true) {
                                int price1 = 100;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Lays Chips", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 2) {
                            System.out.println("\n|--- Kurkure  -  Rs. 50 ---| ");
                            while (true) {
                                int price1 = 50;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Kurkure", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 3) {
                            System.out.println("\n|--- Salted Peanuts  -  Rs. 80 ---| ");
                            while (true) {
                                int price1 = 80;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Salted Peanuts", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 4) {
                            System.out.println("\n|--- Nimko Mix  -  Rs. 70 ---| ");
                            while (true) {
                                int price1 = 70;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Nimko Mix", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 5) {
                            System.out.println("\n|--- Popcorn Pack  -  Rs. 120 ---| ");
                            while (true) {
                                int price1 = 120;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Popcorn Pack", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else {
                            System.out.println("Invalid Number!");
                        }
                    }
                }
            } else if (choose == 2) {
                System.out.println("\n  |----GROCERIES  -->   BEVERAGES----|");
                while (true) {
                    System.out.println(" --> DRINKS              |   PRICES <--");
                    System.out.println("1. Pepsi                 -  Rs. 180");
                    System.out.println("2. Sprite                -  Rs. 180");
                    System.out.println("3. Red Bull              -  Rs. 250");
                    System.out.println("4. Coffee Cup            -  Rs. 100");
                    System.out.println("5. Nestle Juice          -  Rs. 60");
                    System.out.println("0. Exit");
                    while (true) {
                        try {
                            System.out.println("\nChoose Items: ");
                            item = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                            sc.nextLine();
                        }
                    }
                    if (item == 0) {
                        break;
                    } else {
                        if (item == 1) {
                            System.out.println("\n|--- Pepsi  -  Rs. 180 ---| ");
                            while (true) {
                                int price1 = 180;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Pepsi", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 2) {
                            System.out.println("\n|--- Sprite  -  Rs. 180 ---| ");
                            while (true) {
                                int price1 = 180;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Sprite", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 3) {
                            System.out.println("\n|--- Red Bull  -  Rs. 250 ---| ");
                            while (true) {
                                int price1 = 250;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Red Bull", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 4) {
                            System.out.println("\n|--- Coffee Cup  -  Rs. 100 ---| ");
                            while (true) {
                                int price1 = 100;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Coffee Cup", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 5) {
                            System.out.println("\n|--- Nestle Juice  -  Rs. 60 ---| ");
                            while (true) {
                                int price1 = 60;
                                while (true) {
                                    try {
                                        System.out.println("Amount: ");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Nestle Juice", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else {
                            System.out.println("Invalid Number!");
                        }
                    }
                }
            } else if (choose == 3) {
                System.out.println("\n|----GROCERIES  -->   CHOCOLATES & CANDIES----|");
                while (true) {
                    System.out.println(" --> ITEMS               |   PRICES <--");
                    System.out.println("1. Dairy Milk            -  Rs. 100");
                    System.out.println("2. KitKat                -  Rs. 120");
                    System.out.println("3. Snickers Bar          -  Rs. 150");
                    System.out.println("4. Mentos Pack           -  Rs. 30");
                    System.out.println("5. Chilli Mili           -  Rs. 20");
                    System.out.println("0. Exit");
                    while (true) {
                        try {
                            System.out.println("\nChoose Items: ");
                            item = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                            sc.nextLine();
                        }
                    }
                    if (item == 0) {
                        break;
                    } else {
                        if (item == 1) {
                            System.out.println("\n|--- Dairy Milk  -  Rs. 100 ---| ");
                            while (true) {
                                int price1 = 100;
                                while (true) {
                                    try {
                                        System.out.println("Amount: ");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Dairy Milk", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 2) {
                            System.out.println("\n|--- KitKat  -  Rs. 120 ---| ");
                            while (true) {
                                int price1 = 120;
                                while (true) {
                                    try {
                                        System.out.println("Amount: ");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "KitKat", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 3) {
                            System.out.println("\n|--- Snickers Bar  -  Rs. 150 ---| ");
                            while (true) {
                                int price1 = 150;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Snickers Bar", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 4) {
                            System.out.println("\n|--- Mentos Pack  -  Rs. 30 ---| ");
                            while (true) {
                                int price1 = 30;
                                while (true) {
                                    try {
                                        System.out.println("Amount: ");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Mentos Pack", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 5) {
                            System.out.println("\n|--- Chilli Mili  -  Rs. 30 ---| ");
                            while (true) {
                                int price1 = 30;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Chilli Mili", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else {
                            System.out.println("Invalid Number!");
                        }
                    }
                }
            } else if (choose == 4) {
                System.out.println("\n  |----GROCERIES  -->   FROZEN FOODS----|");
                while (true) {
                    System.out.println(" --> ITEMS               |   PRICES <--");
                    System.out.println("1. Chicken Nuggets       -  Rs. 600");
                    System.out.println("2. French Fries          -  Rs. 480");
                    System.out.println("3. Frozen Paratha        -  Rs. 350");
                    System.out.println("4. Samosa Box            -  Rs. 400");
                    System.out.println("5. Chicken Patties       -  Rs. 300");
                    System.out.println("0. Exit");
                    while (true) {
                        try {
                            System.out.println("\nChoose Items: ");
                            item = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                            sc.nextLine();
                        }
                    }
                    if (item == 0) {
                        break;
                    } else {
                        if (item == 1) {
                            System.out.println("\n|--- Chicken Nuggets  -  Rs. 600 ---| ");
                            while (true) {
                                int price1 = 600;
                                while (true) {
                                    try {
                                        System.out.println("Amount: ");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Chicken Nuggets", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 2) {
                            System.out.println("\n|--- French Fries  -  Rs. 480 ---| ");
                            while (true) {
                                int price1 = 480;
                                while (true) {
                                    try {
                                        System.out.println("Amount: ");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "French Fries", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 3) {
                            System.out.println("\n|--- Frozen Paratha  -  Rs. 350 ---| ");
                            while (true) {
                                int price1 = 350;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Frozen Paratha", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 4) {
                            System.out.println("\n|---  Samosa Box  -  Rs. 400 ---| ");
                            while (true) {
                                int price1 = 400;
                                while (true) {
                                    try {
                                        System.out.println("Amount: ");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Samosa Box", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 5) {
                            System.out.println("\n|--- Chicken Patties  -  Rs. 300 ---| ");
                            while (true) {
                                int price1 = 300;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Chicken Patties", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else {
                            System.out.println("Invalid Number!");
                        }
                    }
                }
            } else if (choose == 0) {
                System.out.println("Thank You For Shopping!");
                break;
            } else {
                System.out.println("Invalid Number!");
            }
        }
    }

    public static void personalCare(PrintWriter pw) {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        int choose = 0;
        String ch = "";
        int item = 0;
        int item1 = 0;
        while (true) {
            System.out.println("\n |---- PERSONAL CARE ----|");
            System.out.println(" 1. Hair Care");
            System.out.println(" 2. Skin Care");
            System.out.println(" 3. Cosmetics");
            System.out.println(" 4. Accessories");
            System.out.println(" 0. Exit");
            System.out.println(" ");
            while (true) {
                try {
                    System.out.println("Choose a Section: ");
                    choose = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input!");
                    sc.nextLine();
                }
            }
            if (choose == 1) {
                System.out.println("\n |---- DAILY ESSENTIALS  -->   HAIR CARE ----|");
                while (true) {
                    System.out.println(" --> HAIR CARE           |   PRICES <--");
                    System.out.println("1. Shampoo               -   Rs. 500");
                    System.out.println("2. Conditioner           -   Rs. 600");
                    System.out.println("3. Hair Oil              -   Rs. 700");
                    System.out.println("5. Hair Gel              -   Rs. 650");
                    System.out.println("4. Hair Spray            -   Rs. 400");
                    System.out.println("0. Exit");
                    while (true) {
                        try {
                            System.out.println("\nChoose Items: ");
                            item = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                            sc.nextLine();
                        }
                    }
                    if (item == 0) {
                        break;
                    } else {
                        if (item == 1) {
                            System.out.println("\n|--- Shampoo  -  Rs. 500 ---| ");
                            while (true) {
                                int price1 = 500;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Shampoo", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 2) {
                            System.out.println("\n|--- Conditioner  -  Rs. 600 ---| ");
                            while (true) {
                                int price1 = 600;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Conditioner", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 3) {
                            System.out.println("\n|--- Hair Oil  -  Rs. 700 ---| ");
                            while (true) {
                                int price1 = 700;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Hair Oil", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 4) {
                            System.out.println("\n|--- Hair Gel  -  Rs. 650 ---| ");
                            while (true) {
                                int price1 = 650;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Hair Gel", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 5) {
                            System.out.println("\n|--- Hair Spray  -  Rs. 400 ---| ");
                            while (true) {
                                int price1 = 400;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Hair Spray", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else {
                            System.out.println("Invalid Number!");
                        }
                    }
                }
            } else if (choose == 2) {
                System.out.println("\n |---- PERSONAL CARE --> SKIN CARE ----|");
                while (true) {
                    System.out.println(" --> SKIN CARE           |  PRICES <--");
                    System.out.println("1. Face Wash             -  Rs. 250");
                    System.out.println("2. Moisturizer           -  Rs. 400");
                    System.out.println("3. Sunscreen             -  Rs. 350");
                    System.out.println("4. Face Serum            -  Rs. 500");
                    System.out.println("5. Face Scrub            -  Rs. 300");
                    System.out.println("0. Exit");
                    while (true) {
                        try {
                            System.out.println("\nChoose Items: ");
                            item = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                            sc.nextLine();
                        }
                    }
                    if (item == 0) {
                        break;
                    } else {
                        if (item == 1) {
                            System.out.println("\n|--- Face Wash  -  Rs. 250 ---| ");
                            while (true) {
                                int price1 = 250;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Face Wash", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 2) {
                            System.out.println("\n|--- Moisturizer  -  Rs. 400 ---| ");
                            while (true) {
                                int price1 = 400;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Moisturizer", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 3) {
                            System.out.println("\n|--- Sunscreen  -  Rs. 350 ---| ");
                            while (true) {
                                int price1 = 350;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Sunscreen", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 4) {
                            System.out.println("\n|--- Face Serum  -  Rs. 500 ---| ");
                            while (true) {
                                int price1 = 500;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Face Serum", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 5) {
                            System.out.println("\n|--- Face Scrub  -  Rs. 300 ---| ");
                            while (true) {
                                int price1 = 300;
                                while (true) {
                                    try {
                                        System.out.println("Amount: ");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Face Scrub", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else {
                            System.out.println("Invalid Number!");
                        }
                    }
                }
            } else if (choose == 3) {
                System.out.println("\n |---- PERSONAL CARE --> COSMETICS ----|");
                while (true) {
                    System.out.println(" --> COSMETICS           |   PRICES <--");
                    System.out.println("1. Lipstick              -  Rs. 600");
                    System.out.println("2. Foundation            -  Rs. 1200");
                    System.out.println("3. Mascara               -  Rs. 800");
                    System.out.println("4. Eyeliner              -  Rs. 500");
                    System.out.println("5. Perfume               -  Rs. 1500");
                    System.out.println("0. Exit");
                    while (true) {
                        try {
                            System.out.println("\nChoose Items: ");
                            item = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                            sc.nextLine();
                        }
                    }
                    if (item == 0) {
                        break;
                    } else {
                        if (item == 1) {
                            System.out.println("\n|--- Lipstick  -  Rs. 600 ---| ");
                            while (true) {
                                int price1 = 600;
                                while (true) {
                                    try {
                                        System.out.println("Amount: ");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Lipstick", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 2) {
                            System.out.println("\n|--- Foundation  -  Rs. 1200 ---| ");
                            while (true) {
                                int price1 = 1200;
                                while (true) {
                                    try {
                                        System.out.println("Amount: ");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Foundation", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 3) {
                            System.out.println("\n|--- Mascara  -  Rs. 800 ---| ");
                            while (true) {
                                int price1 = 800;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Mascara", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 4) {
                            System.out.println("\n|--- Eyeliner  -  Rs. 500 ---| ");
                            while (true) {
                                int price1 = 500;
                                while (true) {
                                    try {
                                        System.out.println("Amount: ");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Eyeliner", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 5) {
                            System.out.println("\n|--- Perfume  -  Rs. 1500 ---| ");
                            while (true) {
                                int price1 = 1500;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Perfume", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else {
                            System.out.println("Invalid Number!");
                        }
                    }
                }
            } else if (choose == 4) {
                System.out.println("\n |---- PERSONAL CARE --> ACCESSORIES ----|");
                while (true) {
                    System.out.println(" --> ACCESSORIES         |   PRICES <--");
                    System.out.println("1. Comb                  -   Rs. 150");
                    System.out.println("2. Bobby Pins            -   Rs. 80");
                    System.out.println("3. Headbands             -   Rs. 200");
                    System.out.println("4. Hair Clips            -   Rs. 180");
                    System.out.println("5. Mirrors               -   Rs. 350");
                    System.out.println("0. Exit");
                    while (true) {
                        try {
                            System.out.println("\nChoose Items: ");
                            item = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                            sc.nextLine();
                        }
                    }
                    if (item == 0) {
                        break;
                    } else {
                        if (item == 1) {
                            System.out.println("\n|--- Comb  -  Rs. 150 ---| ");
                            while (true) {
                                int price1 = 150;
                                while (true) {
                                    try {
                                        System.out.println("Amount: ");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Comb", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 2) {
                            System.out.println("\n|--- Bobby Pins  -  Rs. 80 ---| ");
                            while (true) {
                                int price1 = 80;
                                while (true) {
                                    try {
                                        System.out.println("Amount: ");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Bobby Pins", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 3) {
                            System.out.println("\n|--- Headbands  -  Rs. 200 ---| ");
                            while (true) {
                                int price1 = 200;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Headbands", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 4) {
                            System.out.println("\n|---  Hair Clips  -  Rs. 180 ---| ");
                            while (true) {
                                int price1 = 180;
                                while (true) {
                                    try {
                                        System.out.println("Amount: ");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Hair Clips", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 5) {
                            System.out.println("\n|--- Mirrors  -  Rs. 350 ---| ");
                            while (true) {
                                int price1 = 350;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = bill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Mirrors", price1, total, "BUY2GET1", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else {
                            System.out.println("Invalid Number!");
                        }
                    }
                }
            } else if (choose == 0) {
                System.out.println("Thank You For Shopping!");
                break;
            } else {
                System.out.println("Invalid Number!");
            }
        }
    }

    public static void electronics(PrintWriter pw) {
        Scanner sc = new Scanner(System.in);
        int total = 0;
        int choose = 0;
        String ch = "";
        int item = 0;
        int item1 = 0;
        while (true) {
            System.out.println("\n |---- ELECTRONICS ----|");
            System.out.println(" 1. Laptops");
            System.out.println(" 2. Mobiles");
            System.out.println(" 3. Headphones");
            System.out.println(" 4. Mobile Accessories");
            System.out.println(" 0. Exit");
            System.out.println(" ");
            while (true) {
                try {
                    System.out.println("Choose a Section: ");
                    choose = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input!");
                    sc.nextLine();
                }
            }
            if (choose == 1) {
                System.out.println("\n |---- ELECTRONICS    -->   LAPTOPS ----|");
                while (true) {
                    System.out.println(" --> LAPTOPS         |   PRICES <--");
                    System.out.println("1. DEL               -   Rs. 50,000");
                    System.out.println("2. HP                -   Rs. 70,000");
                    System.out.println("3. LENOVO            -   Rs. 80,000");
                    System.out.println("4. MAC BOOK          -   Rs. 2,00,000");
                    System.out.println("5. LG                -   Rs. 1,50,000");
                    System.out.println("0. Exit");
                    while (true) {
                        try {
                            System.out.println("\nChoose Items: ");
                            item = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                            sc.nextLine();
                        }
                    }
                    if (item == 0) {
                        break;
                    } else {
                        if (item == 1) {
                            System.out.println("\n|--- DEL  -  Rs. 50,000 ---| ");
                            while (true) {
                                int price1 = 50000;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = ebill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "DEL", price1, total, "70% OFF", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 2) {
                            System.out.println("\n|--- HP  -  Rs. 70,000 ---| ");
                            while (true) {
                                int price1 = 70000;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = ebill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "HP", price1, total, "70% OFF", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 3) {
                            System.out.println("\n|---  LENOVO  -  Rs. 80,000 ---| ");
                            while (true) {
                                int price1 = 80000;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = ebill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, " LENOVO", price1, total, "70% OFF", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 4) {
                            System.out.println("\n|--- MAC BOOK  -  Rs. 2,00,000 ---| ");
                            while (true) {
                                int price1 = 200000;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = ebill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "MAC BOOK", price1, total, "70% OFF", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 5) {
                            System.out.println("\n|--- LG  -  Rs. 1,50,000 ---| ");
                            while (true) {
                                int price1 = 150000;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = ebill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "LG", price1, total, "70% OFF", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else {
                            System.out.println("Invalid Number!");
                        }
                    }
                }
            } else if (choose == 2) {
                System.out.println("\n |---- ELECTRONICS --> MOBILE PHONES ----|");
                while (true) {
                    System.out.println(" --> MOBILE PHONES       |  PRICES <--");
                    System.out.println("1. Samsung Galaxy        -  Rs. 170,000");
                    System.out.println("2. iPhone Pro            -  Rs. 220,000");
                    System.out.println("3. Redmi Note            -  Rs. 55,000");
                    System.out.println("4. Vivo V29              -  Rs. 80,000");
                    System.out.println("5. Infinix Zero          -  Rs. 50,000");
                    System.out.println("0. Exit");
                    while (true) {
                        try {
                            System.out.println("\nChoose Items: ");
                            item = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                            sc.nextLine();
                        }
                    }
                    if (item == 0) {
                        break;
                    } else {
                        if (item == 1) {
                            System.out.println("\n|--- Samsung Galaxy  -  Rs. 170,000 ---| ");
                            while (true) {
                                int price1 = 170000;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = ebill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Samsung Galaxy", price1, total, "70% OFF", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 2) {
                            System.out.println("\n|--- iPhone Pro  -  220,000 ---| ");
                            while (true) {
                                int price1 = 220000;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = ebill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "iPhone Pro", price1, total, "70% OFF", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 3) {
                            System.out.println("\n|--- Redmi Note  -  Rs. 55,000 ---| ");
                            while (true) {
                                int price1 = 55000;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = ebill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Redmi Note", price1, total, "70% OFF", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 4) {
                            System.out.println("\n|--- Vivo V29  -  Rs. 80,000 ---| ");
                            while (true) {
                                int price1 = 80000;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = ebill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Vivo V29", price1, total, "70% OFF", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 5) {
                            System.out.println("\n|--- Infinix Zero  -  Rs.  50,000 ---| ");
                            while (true) {
                                int price1 = 50000;
                                while (true) {
                                    try {
                                        System.out.println("Amount: ");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = ebill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Infinix Zero", price1, total, "70% OFF", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else {
                            System.out.println("Invalid Number!");
                        }
                    }
                }
            } else if (choose == 3) {
                System.out.println("\n |---- ELECTRONICS --> HEADPHONES ----|");
                while (true) {
                    System.out.println(" --> HEADPHONES           |  PRICES <--");
                    System.out.println("1. Audionic Classic       -  Rs. 2,000");
                    System.out.println("2. Dany Pro               -  Rs. 1,800");
                    System.out.println("3. Sony Basic             -  Rs. 3,500");
                    System.out.println("4. Philips Wired          -  Rs. 2,500");
                    System.out.println("5. A4Tech Stereo          -  Rs. 2,200");
                    System.out.println("0. Exit");
                    while (true) {
                        try {
                            System.out.println("\nChoose Items: ");
                            item = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                            sc.nextLine();
                        }
                    }
                    if (item == 0) {
                        break;
                    } else {
                        if (item == 1) {
                            System.out.println("\n|--- Audionic Classic  -  Rs. 2,000 ---| ");
                            while (true) {
                                int price1 = 2000;
                                while (true) {
                                    try {
                                        System.out.println("Amount: ");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = ebill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Audionic Classic", price1, total, "70% OFF", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 2) {
                            System.out.println("\n|--- Dany Pro  -  Rs. 1,800 ---| ");
                            while (true) {
                                int price1 = 1800;
                                while (true) {
                                    try {
                                        System.out.println("Amount: ");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = ebill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Dany Pro", price1, total, "70% OFF", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 3) {
                            System.out.println("\n|--- Sony Basic  -  Rs. 3,500 ---| ");
                            while (true) {
                                int price1 = 3500;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = ebill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Sony Basic", price1, total, "70% OFF", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 4) {
                            System.out.println("\n|--- Philips Wired  -  Rs. 2,500 ---| ");
                            while (true) {
                                int price1 = 2500;
                                while (true) {
                                    try {
                                        System.out.println("Amount: ");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = ebill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Philips Wired", price1, total, "70% OFF", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 5) {
                            System.out.println("\n|--- A4Tech Stereo  -  Rs. 2,200 ---| ");
                            while (true) {
                                int price1 = 2200;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = ebill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "A4Tech Stereo", price1, total, "70% OFF", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else {
                            System.out.println("Invalid Number!");
                        }
                    }
                }
            } else if (choose == 4) {
                System.out.println("\n |---- ELECTRONICS  -->  MOBILE ACCESSORIES ----|");
                while (true) {
                    System.out.println(" --> MOBILE ACCESSORIES   |  PRICES <--");
                    System.out.println("1. Fast Charger           -  Rs. 1,000");
                    System.out.println("2. USB Cable              -  Rs. 500");
                    System.out.println("3. Screen Protector       -  Rs. 300");
                    System.out.println("4. Back Cover             -  Rs. 700");
                    System.out.println("5. Power Bank             -  Rs. 2,000");
                    System.out.println("0. Exit");
                    while (true) {
                        try {
                            System.out.println("\nChoose Items: ");
                            item = sc.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Input!");
                            sc.nextLine();
                        }
                    }
                    if (item == 0) {
                        break;
                    } else {
                        if (item == 1) {
                            System.out.println("\n|--- Fast Charger  -  Rs. 1,000 ---| ");
                            while (true) {
                                int price1 = 1000;
                                while (true) {
                                    try {
                                        System.out.println("Amount: ");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = ebill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Fast Charger", price1, total, "70% OFF", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 2) {
                            System.out.println("\n|--- USB Cable  -  Rs. 500 ---| ");
                            while (true) {
                                int price1 = 500;
                                while (true) {
                                    try {
                                        System.out.println("Amount: ");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = ebill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "USB Cable", price1, total, "70% OFF", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 3) {
                            System.out.println("\n|--- Screen Protector  -  Rs. 300 ---| ");
                            while (true) {
                                int price1 = 300;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = ebill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Screen Protector", price1, total, "70% OFF", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 4) {
                            System.out.println("\n|---  Back Cover  -  Rs. 700 ---| ");
                            while (true) {
                                int price1 = 700;
                                while (true) {
                                    try {
                                        System.out.println("Amount: ");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = ebill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Back Cover", price1, total, "70% OFF", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else if (item == 5) {
                            System.out.println("\n|--- Power Bank  -  Rs. 2,000 ---| ");
                            while (true) {
                                int price1 = 2000;
                                while (true) {
                                    try {
                                        System.out.println("Amount:");
                                        item1 = sc.nextInt();
                                        if (item1 <= 0) {
                                            System.out.println("Please enter a number greater than zero.");
                                            continue;
                                        }
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid Input!");
                                        sc.nextLine();
                                    }
                                }
                                total += item1;
                                System.out.println("Do You Want to Buy More of This Item? Choose 'y' or 'n':");
                                while (true) {
                                    try {
                                        ch = sc.next().toLowerCase();
                                        if (!ch.equals("y") && !ch.equals("n")) {
                                            System.out.println("Choose 'y' or 'n':");
                                            continue;
                                        }
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid Character");
                                        sc.nextLine();
                                    }
                                }
                                if (ch.equals("y")) {
                                    continue;
                                } else if (ch.equals("n")) {
                                    System.out.println("Item SuccessFully Added to a Cart!\n");
                                    int Bill = ebill(total, price1);
                                    pw.printf("%-4s %-20s %-10d %-8d %-15s %-10d\n", index, "Power Bank", price1, total, "70% OFF", Bill);
                                    index++;
                                    total = 0;
                                    break;
                                } else {
                                    System.out.println("Invalid Character!");
                                }
                            }
                        } else {
                            System.out.println("Invalid Number!");
                        }
                    }
                }
            } else if (choose == 0) {
                System.out.println("Thank You For Shopping!");
                break;
            } else {
                System.out.println("Invalid Number!");
            }
        }
    }

    public static int ebill(int amount, int price) {
    int bill = 0;
    if (amount > 2) {
        double discount = price * 0.7;
        int priceF = (int) (price - discount);
        bill = amount * priceF;
    } else {
        bill = amount * price;
    }
    return bill;
    }

    public static int bill(int amount, int price) {
        int divide = amount / 3;
        int bill = (amount - divide) * price;
        return bill;
    }

    public static void remove() {
        try {
            Scanner sc = new Scanner(System.in);
            File file = new File(username + ".txt");
            BufferedReader br = new BufferedReader(new FileReader(username + ".txt"));
            String line;

            String product = "";
            int amount = 0;
            String prpd = "";

            while ((line = br.readLine()) != null) {
                System.out.println(line);

            }
            System.out.println("what do you want to remove");
            product = sc.next();
            System.out.println("amount :");
            amount = sc.nextInt();
            prpd = String.valueOf(product);

            br.close();

            BufferedReader brr = new BufferedReader(new FileReader(username + ".txt"));
            File temp = new File("temp.txt");
            FileWriter temp1 = new FileWriter("temp.txt");

            PrintWriter pw = new PrintWriter("temp.txt");
            boolean present = false;

            String lineT;
            while ((lineT = brr.readLine()) != null) {
                if (lineT.startsWith(product)) {
                    present = true;
                    String[] parts = lineT.trim().split("\s+");

                    if (parts.length >= 6) {
                        boolean words = true;
                        try {
                            Integer.parseInt(parts[2]);
                            words = true;
                        } catch (NumberFormatException ex) {
                            words = false;
                        }
                        if (words == true) {
                            int price = Integer.parseInt(parts[2]);
                            int amountc = Integer.parseInt(parts[3]);
                            int bill = Integer.parseInt(parts[5]);
                            int amountf = amountc - amount;
                            // String newamountstr = String.valueOf(amountf);

                            int Bill = bill((amountf), price);
                            String newbill = String.format("%-1d", Bill);
                            String newamount = String.format("%-1d", amountf);
                            lineT = lineT.replaceFirst(parts[5], newbill.trim());
                            lineT = lineT.replace(parts[3], newamount);

                        } else {
                            int price = Integer.parseInt(parts[3]);
                            int amountc = Integer.parseInt(parts[4]);
                            int bill = Integer.parseInt(parts[6]);
                            int amountf = amountc - amount;
                            // String newamountstr = String.valueOf(amountf);

                            int Bill = bill((amountf), price);
                            String newbill = String.format("%-1d", Bill);
                            String newamount = String.format("%-1d", amountf);
                            lineT = lineT.replaceFirst(parts[6], newbill.trim());
                            lineT = lineT.replace(parts[4], newamount);
                        }


                    }
                    pw.println(lineT);

                } else {
                    pw.println(lineT);
                }
            }

            if (present == false) {
                System.out.println("INVALID INPUT .... THAT PRODUCT IS NOT PRESENT ");
            }

            pw.close();
            brr.close();
            temp1.close();
            RenameFile();


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InputMismatchException e) {
            System.out.println("INVALID INPUT...");
        }


    }


    public static void add() {
        Scanner sc = new Scanner(System.in);
        int choose = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(username + ".txt"));
            String line;

            String product = "";
            int amount = 0;
            String prpd = "";

            while ((line = br.readLine()) != null) {
                System.out.println(line);

            }


            prpd = String.valueOf(product);

            br.close();

            BufferedReader brr = new BufferedReader(new FileReader(username + ".txt"));
            FileWriter temp1 = new FileWriter("temp.txt");

            PrintWriter pw = new PrintWriter(temp1);
            System.out.println(" WHAT DO YOU  WANT TO ADD?\n 1. AMOUNT  OF PRESENT PRODUCT\n 2. ADD NEW PRODUCT  ");
            choose = sc.nextInt();
            if (choose == 1) {
                try {
                    System.out.println("what do you want to add");
                    product = sc.next();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input .. enter the integer ");
                    product = sc.next();
                }
                try {
                    System.out.println("amount :");
                    amount = sc.nextInt();
                } catch (InputMismatchException ee) {
                    System.out.println("Invalid input .... Enter the integer ");
                    amount = sc.nextInt();

                }
                boolean present = false;

                String lineT;
                while ((lineT = brr.readLine()) != null) {

                    if (lineT.startsWith(product)) {
                        present = true;

                        String[] parts = lineT.trim().split("\s+");
                        if (parts.length >= 6) {
                            boolean words = true;
                            try {
                                Integer.parseInt(parts[2]);
                            } catch (NumberFormatException ex) {
                                words = false;

                            }

                            if (words == true) {
                                int price = Integer.parseInt(parts[2]);
                                int amountc = Integer.parseInt(parts[3]);
                                int bill = Integer.parseInt(parts[5]);
                                int amountf = (amountc + amount);
                                // String newamountstr = String.valueOf(amountf);

                                int Bill = bill((amountf), price);
                                String newbill = String.format("%-1d", Bill);
                                String newamount = String.format("%-1d", amountf);
                                lineT = lineT.replaceFirst(parts[5], newbill.trim());
                                lineT = lineT.replace(parts[3], newamount);
                            } else {
                                int price = Integer.parseInt(parts[3]);
                                int amountc = Integer.parseInt(parts[4]);
                                int bill = Integer.parseInt(parts[6]);
                                int amountf = (amountc + amount);
                                // String newamountstr = String.valueOf(amountf);

                                int Bill = bill((amountf), price);
                                String newbill = String.format("%-1d", Bill);
                                String newamount = String.format("%-1d", amountf);
                                lineT = lineT.replaceFirst(parts[6], newbill.trim());
                                lineT = lineT.replace(parts[4], newamount);


                            }
                        }
                        pw.println(lineT);

                    } else {
                        pw.println(lineT);
                    }
                }
                if (present == false) {
                    System.out.println("INVALID INPUT .... THAT PRODUCT IS NOT PRESENT ");
                }

            } else if (choose == 2) {
                categories();
                System.out.println(" added successfully");
            } else {
                System.out.println(" Invalid input ... select 1 or 2");
                choose = sc.nextInt();
            }


            pw.close();
            brr.close();
            RenameFile();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InputMismatchException e) {
            System.out.println("INVALID INPUT...");
            choose = sc.nextInt();
        }


    }

        public static void RenameFile() {

            try (BufferedReader br = new BufferedReader(new FileReader(username+".txt"))) {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Path source = Paths.get("temp.txt");
            Path target = Paths.get(username + ".txt");

            try {
                Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("File renamed successfully!");
            } catch (Exception e) {
                System.err.println("Error renaming file: " + e.getMessage());
            }
        }


    public static void cart() {
        Scanner sc = new Scanner(System.in);
        boolean again = true;
        while (again == true) {
            System.out.println("\n --> choose the options <--\n");
            System.out.println("1. - ADD");
            System.out.println("2. - Remove");
            System.out.println("3. - Checkout");
            System.out.println("0. - Exit");
            int choose = sc.nextInt();
            if (choose == 1) {
                add();
            } else if (choose == 2) {
                remove();
            }
            else if (choose == 3) {
                checkout();
                break;
            }else if (choose == 0) {
                again = false;
                break;
            } else {
                System.out.println("invalid input ");
                again = true;
                choose = sc.nextInt();
            }

        }
    }


    public static void checkout() {
    int total = 0;

    try {
        BufferedReader br = new BufferedReader(new FileReader(username + ".txt"));
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.trim().split("\\s+");

            if (parts.length > 6) {  // ensure parts[5] and parts[6] exist
                // Try to parse parts[5] and parts[6]
                int billPart5 = parseIntSafe(parts[5]);
                int billPart6 = parseIntSafe(parts[6]);

                if (billPart5 != -1) {
                    total += billPart5;
                } else if (billPart6 != -1) {
                    total += billPart6;
                }
            } else {
                System.out.println("Skipping short/invalid line: " + line);
            }
        }
        br.close();

        System.out.println("Your Total Bill is: " + total);

        // Append total bill to file
        try (PrintWriter pw = new PrintWriter(new FileWriter(username + ".txt", true))) {
            pw.println("TOTAL BILL   :    " + total);
        }

        System.out.println("------->   YOUR ORDER HISTORY IS   <-------");
        try (BufferedReader brr = new BufferedReader(new FileReader(username + ".txt"))) {
            String lineTer;
            while ((lineTer = brr.readLine()) != null) {
                System.out.println(lineTer);
            }
        }

        payment(total);

    } catch (IOException e) {
        System.out.println("Error!");
        e.printStackTrace();
    }
}

// Helper method to safely parse integer, returns -1 if invalid
private static int parseIntSafe(String s) {
    try {
        return Integer.parseInt(s);
    } catch (NumberFormatException e) {
        return -1;
    }
}

    // public static  void  checkout() {
    //     int total =0;
    //     try {
    //         BufferedReader br = new BufferedReader(new FileReader(username + ".txt"));

    //         String line;
    //         while((line=br.readLine())!=null) {
    //             String[] parts = line.trim().split("\\s+");
    //             if (integer(parts[5]) || integer(parts[6])) {
    //                 if (parts.length >= 6) {
    //                     boolean words = true;
    //                     try {
    //                         Integer.parseInt(parts[2]);
    //                         words = true;
    //                     } catch (NumberFormatException e) {
    //                         words = false;
    //                     }
    //                     if (words == true) {
    //                         int bill = Integer.parseInt(parts[5]);
    //                         total += bill;
    //                     } else {
    //                         int bill = Integer.parseInt(parts[6]);
    //                         total += bill;
    //                     }
    //                 } else {
    //                     System.out.println("Skipping short/invalid line: " + line);
    //                 }
    //             }

    //         }
    //         System.out.println(" Your  Total Bill is " + total);
    //         FileWriter file = new FileWriter(username + ".txt", true);
    //         PrintWriter pw = new PrintWriter(file);
    //         pw.println("TOTAL BILL   :    " + total);
    //         pw.close();
    //         file.close();
    //         System.out.println(   "------->   YOUR ORDER HISTORY IS   <------");
    //         BufferedReader brr = new BufferedReader(new FileReader(username + ".txt"));
    //         String lineTer;
    //         while ((lineTer = br.readLine()) != null) {
    //             System.out.println(lineTer);

    //         }

    //        brr.close();
    //         payment(total);


    //     } catch (IOException e) {
    //         System.out.println("error");
    //         throw new RuntimeException(e);

    //     }
    // }
    public static void payment(int a){
        String ch = "";
        int choose;
        int remaining=0;
        int num;
        String len;
        int price =0;
        String adress ="";
        int phone=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("  -----> PAYMENT METHOD  <----");
        System.out.println("1 . CARD   ");
        System.out.println("2 . CASH ON DILVERY  ");
        try {
            choose = sc.nextInt();
            if (choose ==1){
                ch = " CARD ";
                System.out.println(".....CARD .....");
                System.out.println(" ENTER THE CARD NUMBER ");
                try {
                    num = sc.nextInt();
                    len = (String.valueOf(num));
                    while (len.length()<8){
                        System.out.println("CARD NUMBER MUST BE  MORE THAN OR EQUAL TO  8 DIGIT NUMBER   ");
                        num = sc.nextInt();
                       len = (String.valueOf(num));
                    }
                    System.out.println(" CARD  DATA  ENTRY IS SUCCESSFULL..... ");
                    try{
                        System.out.println(" Your Bill is     =    ");
                        System.out.println(" Enter the BILL Payment  ");
                        price = sc.nextInt();
                        if (a>price ){
                            System.out.println("Insufficient  Balance .. TRY AGAIN.");
                            price= sc.nextInt();
                        }else if (a<price ){
                            remaining = a-price;
                            System.out.println(" Your Remaining Balance  is    =    "+remaining);
                            System.out.println( " Payment Completed ..... !! THANK YOU !!");
                        }else{
                            System.out.println( " Payment Completed ..... !! THANK YOU !!");
                        }

                    }catch (InputMismatchException e){
                        System.out.println("INVALID INPUT... PRICE SHOULD BE IN NUMBERS ");
                        price = sc.nextInt();
                    }

                }catch (InputMismatchException n ){
                    System.out.println(" INVALID INPUT .... ENTER THE DIGITS ");
                    num=sc.nextInt();
                }
            }else if(choose==2){
                ch= " CASH ON DILVERY ";
                System.out.println(" ...CASH ON DILVERY ....");
                System.out.println( " ENTER THE ADDRESS");
                while (adress.equals("")){
                    adress= sc.next();
                    if (adress.equals("")){
                        System.out.println( " MUST ENTER THE ADDRESS...");
                    }
                }
                System.out.println( " ENTER THE PHONE NUMBER ");
                try {
                    phone = sc.nextInt();
                    System.out.println(" PAYMENT DATA COMPLETED...");
                    System.out.println(" YOU WILL  RECEIVE THE PARCEL WITHIN A WEAK  ....");

                }catch (InputMismatchException p){
                    System.out.println( " Invalid Input.... PHONE NUMBER MUST IN DIGITS ");
                    phone = sc.nextInt();
                }




            }else{
                throw new InputMismatchException();
            }
        }catch(InputMismatchException e){
            System.out.println( "Invalid Input ... enter the integer 1 or 2 ");
            choose=sc.nextInt();
        }
        try {
            FileWriter file = new FileWriter(username + ".txt", true);
            PrintWriter pw = new PrintWriter(file);

            if (ch.equals(" CARD ")) {
                pw.println( "PAYMENT METHOD      =    " +ch);
                pw.println(" YOUR BILL WAS   = "+a);
                pw.println(" YOU HAVE PAID   = " + price);
                if (remaining!=0){
                    pw.println(" YOR REMAINING BALANCE IS   =  "+remaining);
                }
                pw.println(" Payment Completed ..... !! THANK YOU !!");
            }else if (ch.equals( " CASH ON DILVERY ")){
                pw.println( "PAYMENT METHOD      =    " +ch);
                pw.println( " ...... USER DATA  OR DILEVERY.....");
                pw.println("NAME           =  "+username);
                pw.println("ADDRESS        =  " +adress);
                pw.println("PHONE NUMBER   =  "+phone);
                pw.println(" PAYMENT DATA COMPLETED...");
                pw.println("YOU WILL  RECEIVE THE PARCEL WITHIN A WEAK  ....2 ");

            }
            pw.close();
            file.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public  static boolean integer(String x){
     try {
         Integer.parseInt(x);
      return true;
     }catch (NumberFormatException E){
         return false ;
     }
    }

}
package bankmanagmentsystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class BankManagmentSystem {

    static Scanner input = new Scanner(System.in);
    //used for generating random IDs
    static Random rd = new Random();
    
    static String outputpath = "C:\\\\Users\\Boni\\Desktop\\bankmangment.bm";
    
    static boolean isRunning = false;
    
    public static void main(String[] args) {
        System.out.println("******************Welcome to BANKING MANAGMENT SYSTEM**********************");
        System.out.println("******************MICROLINK INFORMATION TECHNOLOGY   **********************");
        System.out.println("***************** DEPARETEMENT OF COMPUTER SCIENCE   **********************");
        System.out.println("***************** TITle:BANK MANAGEMENT SYSTEM       **********************");
        System.out.println("*********Group Members            Id                 **********************");
        System.out.println("*********1.Boni Yehya           15,369/21            **********************");
        System.out.println("*********2.Daniel Jemmo          15,344/21            **********************");
        System.out.println("*********3.Daniel Sahle         15,551/21            **********************");
        System.out.println("*********4.Eden Erge            15,363/21            **********************");
        System.out.println("*********5.Elshaday Fekede      15,565/21            **********************");
        System.out.println("*********6.Samuel Getachew      15,345/21            **********************");
        System.out.println("*********                            SubmitionDate:8/15/2******************");
        System.out.println("*********                            Submittedto: Ins.Eyasu****************");
        System.out.println("***************************************************************************");
        
        System.out.println("Choose To login :");
        System.out.println("1.For registeration ");
        System.out.println("2.Signin as an Admin");
        System.out.println("3.My Account");
        System.out.println("4.Backup State");
        System.out.println("5.Exit ");
        
        if(!isRunning) {
            //read_object_file();
        }
        
        isRunning = true;
        
        int main_choice = input.nextInt();
        
        switch(main_choice) {
            case 1:
                register_customer();
                break;
            case 2:
                sign_in_admin();
                break;
            case 3:
                my_account();
                break;
            case 4:
                write_object_file(Bank.getbank());
                break;
            case 5:
                exit();
                break;
            default:
                System.out.println("Unknown input ,please enter the correct input");
                break;
        }
    
    }
    public static void register_customer() {
        System.out.println("Enter your name?");
        String name = input.next();
        System.out.println("Enter your email?");
        String email = input.next();
        System.out.println("Enter your password?");
        String password = input.next();
        //we are putting it in absolute value 
        Customer cu = new Customer(Math.abs(rd.nextInt()), name, email, password, 0.0, 0.0);
        Bank.getbank().addcustomer(cu);
                
        System.out.println("Enter:");
        System.out.println("1.To go back to main menu");
        System.out.println("2.Exit the system");
        
        int b = input.nextInt();
        
        if (b == 1) {
            main(null);
        } else if (b == 2) {
            exit();
        }
    }
    
    public static void my_account() {
        System.out.println("Please Enter your email: ");
        String email = input.next();
        System.out.println("Please Enter your password: ");
        String password = input.next();
        Customer currentCustomer = Bank.getbank().getCustomerByEmail(email);
        
        if (currentCustomer != null && currentCustomer.getPassword().equals(password)) {
            System.out.println("Welcome " + currentCustomer.getName());
            System.out.println("***********************************************************");
            System.out.println("Balance: " + currentCustomer.getBalance() + " Loan: " + currentCustomer.getLoan() + " ID: " + currentCustomer.getId());
            System.out.println("*********************************************************** ");
            System.out.println("Press Enter: ");
            System.out.println("1.To deposit");
            System.out.println("2.WithDraw");
            System.out.println("3.Ask a Loan");
            System.out.println("4.Send Money");
            System.out.println("5.Go back to main menu");
            System.out.println("6.Exit");
            
            int c = input.nextInt();
            
            switch(c) {
                case 1:
                    customer_deposit(currentCustomer);
                    break;
                case 2:
                    customer_withdraw(currentCustomer);
                    break;
                case 3:
                    ask_loan(currentCustomer);
                    break;
                case 4:
                    send_money(currentCustomer);
                    break;
                case 5:
                    main(null);
                    break;
                case 6:
                    exit();
                    break;
            }
        } else {
            System.out.println("Credentials are not correct!");
            System.out.println("Enter: ");
            System.out.println("1.To retry");
            System.out.println("2.To Go to Main menu");
            System.out.println("3.Exit The system");
            
            int d = input.nextInt();
            
            switch (d) {
                case 1:
                    my_account();
                    break;
                case 2:
                    main(null);
                    break;
                case 3:
                    exit();
                    break;
                default:
                    System.out.println("Unknown Input");
                    break;
            }
        }
    }

    public static void sign_in_admin() {
        System.out.println("Enter email: ");
        String email = input.next();
        System.out.println("Enter password: ");
        String password = input.next();
        
        if (email.equals("epicdream@gmail.com") && password.equals("0000")) {
                      
            System.out.println("Welcome Admin Enter: ");
            System.out.println("1.To View Customers");
            System.out.println("2.To View Transaction");
            System.out.println("3.To View Loans");
            System.out.println("4.To go back to main menu");
            System.out.println("5.Exit the System");
            
            int a = input.nextInt();
            
            switch(a) {
                case 1:
                    view_customers();
                    break;
                case 2:
                    view_transaction();
                    break;
                case 3:
                    view_loans();
                    break;
                case 4:
                    main(null);
                    break;
                default:
                    System.out.println("Unknown Input");
                    break;
            }
        
        } else {
            System.out.println("Password or username is not correct!");
            System.out.println("Enter:");
            System.out.println("1.To go back to main menu");
            System.out.println("2.Retry");
            System.out.println("3.Exit the system");

            int b = input.nextInt();
            
            switch (b) {
                case 1:
                    main(null);
                    break;
                case 2:
                    sign_in_admin();
                    break;
                case 3:
                    exit();
                    break;
            }
        }
    }
    
    public static void create_backup() {
        System.out.println("Not implemented!");
    }

    public static void exit() {
        write_object_file(Bank.getbank());
        System.out.println("****************** THANKS FOR USING OUT SYSTEM****************** ");
        System.exit(0);
    }

    public static void view_transaction() {
        System.out.println("****************** Transactions ****************** ");
        System.out.println("Id\t\tFrom\t\tTo\t\tDate\t\tAmount");
        
        for (Transaction t: Bank.getbank().gettransaction()) {
            System.out.println(t.getId() + "\t\t" + t.getFrom() + "\t\t" + t.getTo() + "\t\t" + t.getDate() + "\t\t" + t.getAmount());
        }
        
        System.out.println("Please Enter: ");
        System.out.println("1.Go Back To Main Menu");
        System.out.println("2.Exit System");
        
        int c = input.nextInt();
        
        switch (c) {
            case 1:
                main(null);
                break;
            case 2:
                exit();
                break;
        }
    }

    public static void view_customers() {
        System.out.println("****************** Customers ******************");
        System.out.println("ID\tName\tEmail\tBalance\tLoan");
        for (Customer c: Bank.getbank().getCustomers()) {
            System.out.println(c.getId() + "\t" + c.getName() + "\t" + c.getEmail() + "\t" + c.getBalance() + "\t" + c.getLoan());
        }
        System.out.println("Please Enter: ");
        System.out.println("1.Delete Customer");
        System.out.println("2.Edit Customer");
        System.out.println("3.Back to Main menu");
        System.out.println("4.Exit System");
        
        int c = input.nextInt();
        
        switch (c) {
            case 1:
                delete_customer();
                break;
            case 2:
                edit_customer();
                break;
            case 3:
                main(null);
                break;
            case 4:
                exit();
                break;
            default:
                System.out.println("Unknown Input");
                break;
        }
    }

    public static void view_loans() {
        System.out.println("****************** Loans ***********************");
        System.out.println("Id\t\tBy\t\tUserId\t\tAmount\t\tInterestRate");
        for (Loan l : Bank.getbank().getloan()) {
            System.out.println(l.getId() +"\t" + l.getBy() +"\t" +l.getUserid() + "\t" + l.getAmount() +"\t" +l.getInterest());
        }
    }

    private static void customer_deposit(Customer c) {
        System.out.println("Please Enter the Amount you want to deposit: ");
        double amount = input.nextDouble();
        
        if (amount < 0) {
            System.out.println("Invalid Amount");
            customer_deposit(c);
        }
        
        double new_balance = c.getBalance() + amount;
        c.setBalance(new_balance);
        
        System.out.println("Deposited Successfully! your new balance is " + new_balance);
        System.out.println("Enter: ");
            System.out.println("1.Go Back to Main menu");
            System.out.println("2.Exit the system");
            
            int i = input.nextInt();
            
            switch (i) {
                case 1:
                    main(null);
                    break;
                case 2:
                    exit();
                    break;
                default:
                    System.out.println("Unknown Input");
                    break;
            }
    }

    private static void customer_withdraw(Customer c) {
        double balance = c.getBalance();
        System.out.println("Please Enter the Amount you want to withdraw: ");
        double wb = input.nextDouble();
        
        if (wb < 0 || wb > balance) {
            System.out.println("Invalid Amount, please Try again!");
            customer_withdraw(c);
        }
        
        double new_balance = c.getBalance() - wb;
        c.setBalance(new_balance);
        System.out.println("Withdraw Successfull! your new balance " + new_balance);
        
        System.out.println("1.Go Back to Main menu");
            System.out.println("2.Exit the system");
            
            int i = input.nextInt();
            
            switch (i) {
                case 1:
                    main(null);
                    break;
                case 2:
                    exit();
                    break;
                default:
                    System.out.println("Unknown Input");
                    break;
            }
    }

    private static void ask_loan(Customer c) {
        double balance = c.getBalance();
        System.out.println("Please Enter the Amount: ");
        double loanamount = input.nextDouble();
        double l = c.getLoan();
        double crieteria = loanamount * 0.3;
        
        if (balance >= crieteria && l == 0) {
            Loan ln = new Loan(Math.abs(rd.nextInt()), c.getName(), c.getId(), loanamount, LocalDateTime.now().toString(), 10);
            Bank.getbank().addloan(ln);
            l += ln.getAmount();
            c.setLoan(l);
            System.out.println("Loaned successfully!");
        } else {
            System.out.println("Sorry! you are not eliglible for the amount of money you asked!");
        }
        
        System.out.println("1.Go Back to Main menu");
            System.out.println("2.Exit the system");
            
            int i = input.nextInt();
            
            switch (i) {
                case 1:
                    main(null);
                    break;
                case 2:
                    exit();
                    break;
                default:
                    System.out.println("Unknown Input");
                    break;
            }
    }

    private static void delete_customer() {
        System.out.println("Enter the id of the customer: ");
        int id = input.nextInt();
        
        Customer c = Bank.getbank().getCustomer(id);
        
        if (c != null) {
            Bank.getbank().getCustomers().remove(c);
            System.out.println("Delete Successfull!");
            System.out.println("Enter: ");
            System.out.println("1.Go Back to Main menu");
            System.out.println("2.Exit the system");
            
            int i = input.nextInt();
            
            switch (i) {
                case 1:
                    main(null);
                    break;
                case 2:
                    exit();
                    break;
                default:
                    System.out.println("Unknown Input");
                    break;
            }
        }
    }

    private static void edit_customer() {
        System.out.println("Enter the id of customer: ");
        int id  = input.nextInt();
        
        Customer c = Bank.getbank().getCustomer(id);
        
        if (c != null) {
            System.out.println("Editing " + c.getName());
            System.out.println("Enter New Name: ");
            String name = input.next();
            System.out.println("Enter Email: ");
            String email = input.next();
            System.out.println("Enter password: ");
            String password = input.next();
            
            Customer newC = new Customer(id, name, email, password, 0.0, 0.0);
            Bank.getbank().update(newC, id);
        }
    }

    private static void send_money(Customer c) {
        double balance = c.getBalance();
        System.out.println("Enter the ID of the receiver: ");
        int id = input.nextInt();
        Customer an = Bank.getbank().getCustomer(id);
        if (an != null) {
            System.out.println("Enter the amount of Money you want to send: ");
            double amount = input.nextInt();

            if (amount > balance) {
                System.out.println("You can't send more than you have!");
                
                System.out.println("Please Enter: ");
                System.out.println("1.To send Again");
                System.out.println("2.To go back Main menu");
                System.out.println("3.To exit");
                
                int a = input.nextInt();
                
                switch (a) {
                    case 1:
                        send_money(c);
                        break;
                    case 2:
                        main(null);
                        break;
                    case 3:
                        exit();
                        break;
                    default:
                        System.out.println("Unknown Input!");
                        break;
                }
            } else {
                Transaction tr = new Transaction(Math.abs(rd.nextInt()), c.getName(), an.getName(), LocalDateTime.now().toString(), amount);
                c.setBalance(balance - amount);
                an.setBalance(an.getBalance() + amount);
                
                Bank.getbank().addtransaction(tr);
                System.out.println("Successfully sent!");
                System.out.println("Enter: ");
                System.out.println("1.To send Again");
                System.out.println("2.To go back Main menu");
                System.out.println("3.To exit");
                
                int a = input.nextInt();
                
                switch (a) {
                    case 1:
                        send_money(c);
                        break;
                    case 2:
                        main(null);
                        break;
                    case 3:
                        exit();
                        break;
                    default:
                        System.out.println("Unknown Input!");
                        break;
                }
            }
        }
    }
    
    /**
     * this method reads a file and then restores the object to its 
     * initial state.
     */
        public static void read_object_file() {
            //try if you can read the file from the given path if there is an error
            // catch it!
        try {
            System.out.println("Recovering backup...");
            FileInputStream fileInputStream = new FileInputStream(outputpath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            
            Bank bankrestore = (Bank) objectInputStream.readObject();
            if (bankrestore != null) {
                Bank.setbank(bankrestore);
            }
            
            fileInputStream.close();
            objectInputStream.close();
            
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void write_object_file(Object o) {
        try {
            FileOutputStream fileOut = new FileOutputStream(outputpath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(o);
            objectOut.close();
            fileOut.close();
            System.out.println("The Object  was succesfully written to a file");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
    }

}

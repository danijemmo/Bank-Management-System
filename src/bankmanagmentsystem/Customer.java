package bankmanagmentsystem;

import java.io.Serializable;

public class Customer implements Serializable{
    
    private static final long serialVersionUID = 456745098266657680L;
    
    private int customid;
    
    private String customname;
    
    private String customemail;
    
    private String custompassword;
    
    private double balance;
    
    private double loan;

    public Customer() {
    }

    public Customer(int id, String name, String email, String password, double balance, double loan) {
        this.customid = id;
        this.customname = name;
        this.customemail = email;
        this.custompassword = password;
        this.balance = balance;
        this.loan = loan;
    }

    public int getId() {
        return customid;
    }

    public void setId(int id) {
        this.customid = id;
    }

    public String getName() {
        return customname;
    }

    public void setName(String name) {
        this.customname = name;
    }

    public String getEmail() {
        return customemail;
    }

    public void setEmail(String email) {
        this.customemail = email;
    }

    public String getPassword() {
        return custompassword;
    }

    public void setPassword(String password) {
        this.custompassword = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }
    
}

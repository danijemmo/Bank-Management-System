package bankmanagmentsystem;

import java.io.Serializable;


public class Loan implements Serializable {
    
    private static final long serialVersionUID = 673962509867747780L;
    
    private int id;
    
    private String by; 
    
    private int userid; 
    
    private double loanamount; 
    
    private String loandate; 
    
    private double loaninterest;

    public Loan() {
    }

    public Loan(int id, String by, int userid, double amount, String date, double interest) {
        this.id = id;
        this.by = by;
        this.userid = userid;
        this.loanamount = amount;
        this.loandate = date;
        this.loaninterest = interest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public double getAmount() {
        return loanamount;
    }

    public void setAmount(double amount) {
        this.loanamount = amount;
    }

    public String getDate() {
        return loandate;
    }

    public void setDate(String date) {
        this.loandate = date;
    }

    public double getInterest() {
        return loaninterest;
    }

    public void setInterest(double interest) {
        this.loaninterest = interest;
    }
    
    
}

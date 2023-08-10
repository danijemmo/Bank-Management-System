package bankmanagmentsystem;

import java.io.Serializable;

public class Transaction implements Serializable {
    
    private static final long serialVersionUID = 6529625098265557690L;
    
    private int id;
    
    private String from; 
    
    private String to; 
      
    private String date;
    
    private double amount;

    public Transaction() {
    }
    
    public Transaction(int id, String from, String to, String date, double amount) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.date = date;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
}

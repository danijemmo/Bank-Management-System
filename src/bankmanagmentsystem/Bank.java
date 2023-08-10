package bankmanagmentsystem;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Bank implements Serializable {
    
    private static final long serialVersionUID = 7543609091238757540L;
    
    private int id;
    
    private String name;
    
    private String location;
    
    private final Map<Integer, Customer> customers = new HashMap<>(); // all of the customers
    
    private final Map<String, Admin> admins = new HashMap<>(); // all of the admins 
    
    private final Map<Integer, Loan> loans = new HashMap<>(); // all the loans
    
    private final Map<Integer, Transaction> transaction = new HashMap<>(); // all of the transactions
    
    
    /**
     * This helps us so that there couldn't exist multiple instances of the same class 
     * across different methods and invocations.
     */    
    private static Bank bank = new Bank(); // the bank singleton.
        
    public Bank() {}

    public Bank(int id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }
    
    public static Bank getbank() {
        return bank;
    }
    /**
     * This sets the previous Bank object to null and assigns the Bank object the 
     * passed value.
     * @param bk 
     */
    public static void setbank(Bank bk) {
        bank = null;
        bank = bk;
    }
    
    /**
     * Adds the passed in object to the admins HashMap
     * @param ad 
     */
    public void addadmin(Admin ad) {
        admins.put(ad.adminemail, ad);
    }
    
    /**
     * Does the same thing but uses the ID as a key
     * @param c 
     */
    public void addcustomer(Customer c) {
        customers.put(c.getId(), c);
    }
    
    public void addloan(Loan ln) {
        loans.put(ln.getId(), ln);
    }
    
    public void addtransaction(Transaction tr) {
        transaction.put(tr.getId(), tr);
    }  
    
    /**
     * Updates the customers HashMap with the ID given
     * @param c new Object
     * @param id the customer to be updated
     */
    public void update(Customer c, int id) {
        customers.put(id, c);
    }
    
    /**
     * returns all customers
     * @return 
     */
    public Collection<Customer> getCustomers() {
        return customers.values();
    }
    
    public Collection<Loan> getloan() {
        return loans.values();
    }
    
    /**
     * returns the customer required by the given ID
     * @param id
     * @return 
     */
    public Customer getCustomer(int id) {
        return customers.get(id);
    }
    
    public Collection<Transaction> gettransaction() {
        return transaction.values();
    }
    
    /**
     * gets all customers then returns the matching object
     * @param email - the email to be searched
     * @return 
     */
    public Customer getCustomerByEmail(String email) {
        Customer c = null;      
        for (Customer ci : getCustomers()) {
            if (ci.getEmail().equals(email)) {
                c = ci;
            }
        }
        
        return c;
    }
    
    public void removeadmin(String e) {
        admins.remove(e);
    }
    
    public void removecustomer(int i) {
        customers.remove(i);
    }
    
    public void removetransaction(int t) {
        transaction.remove(t);
    }
    
}

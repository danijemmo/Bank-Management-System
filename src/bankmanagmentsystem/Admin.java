package bankmanagmentsystem;

import java.io.Serializable;


public class Admin implements Serializable {

    private static final long serialVersionUID = 3633693453445551690L;
    
    int adminid;
    
    String adminname;
    
    String adminpassword;
    
    String adminemail;

    public Admin() {
    }

    public Admin(int id, String name, String password, String email) {
        this.adminid = id;
        this.adminname = name;
        this.adminpassword = password;
        this.adminemail = email;
    }

    public int getId() {
        return adminid;
    }

    public void setId(int id) {
        this.adminid = id;
    }

    public String getName() {
        return adminname;
    }

    public void setName(String name) {
        this.adminname = name;
    }

    public String getPassword() {
        return adminpassword;
    }

    public void setPassword(String password) {
        this.adminpassword = password;
    }

    public String getEmail() {
        return adminemail;
    }

    public void setEmail(String email) {
        this.adminemail = email;
    }
    
    
}

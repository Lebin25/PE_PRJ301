package dto;


public class Account {
    private String username;
    private String password;
    private String fullname;
    private int role;
    private int status;

    public Account() {
    }

    public Account(String username, String password, String fullname, int role, int status) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", password=" + password + ", fullname=" + fullname + ", role=" + role + ", status=" + status + '}';
    }
    
    
}

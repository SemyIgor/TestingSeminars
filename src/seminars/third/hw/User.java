package seminars.third.hw;

public class User {

    private int userId;
    private String name;
    private String password;

    private boolean isAdmin;

    private boolean isAuthenticated;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.userId = (int) (Math.random()*1000);
        this.isAuthenticated = false;
        this.isAdmin = isAdmin;

    }



    //3.6.
    public boolean authenticate(String name, String password) {
        if(name == this.name && password == this.password) {
            this.isAuthenticated = true;
            return true;
        }
        return false;
    }


    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(boolean authenticate) {
        isAuthenticated = authenticate;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return password;
    }
}
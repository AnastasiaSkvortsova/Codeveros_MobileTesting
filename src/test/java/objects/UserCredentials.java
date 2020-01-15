package objects;

public class UserCredentials {

    String userName;
    String password;

    public UserCredentials(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public String getUserName(){
        return userName;
    }

    public String getPassword(){
        return password;
    }
}

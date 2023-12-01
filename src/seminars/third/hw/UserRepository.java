package seminars.third.hw;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public boolean addUser(User user) {
       //..
        if(user.isAuthenticated()) {
            this.getData().add(user);
            return true;
        }
        return false;
    }

    public List<User> getData() {
        return data;
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.getName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void disAuthenticateAllButAdmins(UserRepository userRepository){
        for (User user: userRepository.getData()) {
            if(!user.isAdmin()){
                user.setAuthenticated(false);
            }
        }
    }
}
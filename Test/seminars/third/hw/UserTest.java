package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seminars.third.hw.User;
import seminars.third.hw.UserRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    User user;
    User userAdmin;
    UserRepository userRepository = new UserRepository();


    @BeforeEach
    void setUp(){
        user = new User("Ivan", "321", false);
        userAdmin = new User("Peter", "321", true);
    }

    @Test
    void testUserIdentified(){assertThat(user.authenticate("Ivan", "321")).isTrue();}

    @Test
    void testUserNotIdentifiedByName(){assertThat(user.authenticate("John", "321")).isFalse();}

    @Test
    void testUserNotIdentifiedByPassword(){assertThat(user.authenticate("Ivan", "523")).isFalse();}

    @Test
    void testUserIsAdmin(){assertThat(userAdmin.isAdmin()).isTrue();}

    @Test
    void testUserIsNotAdmin(){assertThat(user.isAdmin()).isFalse();}

    @Test
    void testUserSetIsAdmin(){
        user.setIsAdmin(true);
        assertThat(user.isAdmin()).isTrue();
    }

    @Test
    void testUserIsAuthenticate(){
        user.setAuthenticated(true);
        assertThat(user.isAuthenticated()).isTrue();
    }

    @Test
    void testUserIsNotAuthenticate(){
        assertThat(user.isAuthenticated()).isFalse();
    }

    @Test
    void testUserIsDisAuthenticate(){
        user.setAuthenticated(true);
        user.setAuthenticated(false);
        assertThat(user.isAuthenticated()).isFalse();
    }

    @Test
    void testUserGetTrueName(){
        assertThat(userAdmin.getName()).isEqualTo("Peter");
    }

    @Test
    void testUserGetFalseName(){assertThat(user.getName()).isNotEqualTo("Gleb");}

    @Test
    void testUserGetTruePassword(){
        assertThat(userAdmin.getPassword()).isEqualTo("321");
    }

    @Test
    void testUserGetFalsePassword(){assertThat(user.getPassword()).isNotEqualTo("123");}
}
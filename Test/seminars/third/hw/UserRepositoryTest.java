package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserRepositoryTest {
    private UserRepository userRepository;
    private User userToAdd;
    private User userAdmin;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        userToAdd = new User("Gleb", "321", false);
    }

    @Test
    void testByListSizeAddedUser() {
        userToAdd.authenticate("Gleb", "321");
        userRepository.addUser(userToAdd);
        assertThat(userRepository.getData().size()).isEqualTo(1);
    }

    @Test
    void testByNameAddedUser() {
        userToAdd.authenticate("Gleb", "321");
        userRepository.addUser(userToAdd);
        assertThat(userRepository.getData().get(0).getName()).isEqualTo("Gleb");
    }

    @Test
    void testByMethodInfoAddedUser() {
        userToAdd.authenticate("Gleb", "321");
        assertThat(userRepository.addUser(userToAdd)).isTrue();
    }

    /**
     * Попытка добавить в базу пользователя Gleb,
     * не прошедшего аутентификацию из-за неверного имени (Peter)
     */
    @Test
    void testByNameNotAddedUser() {
        userToAdd.authenticate("Peter", "321");
        userRepository.addUser(userToAdd);
        assertThat(userRepository.getData().size()).isEqualTo(0);
    }

    /**
     * Попытка добавить в базу пользователя Gleb,
     * не прошедшего аутентификацию из-за неверного пароля (123)
     */
    @Test
    void testByPasswordNotAddedUser() {
        userToAdd.authenticate("Gleb", "123");
        userRepository.addUser(userToAdd);
        assertThat(userRepository.getData().size()).isEqualTo(0);
    }

    @Test
    void testByMethodInfoUserAdded() {
        userToAdd.authenticate("Gleb", "321");
        assertThat(userRepository.addUser(userToAdd)).isTrue();
    }

    @Test
    void testByMethodInfoUserNotAddedByName() {
        userToAdd.authenticate("gleb", "321");
        assertThat(userRepository.addUser(userToAdd)).isFalse();
    }

    @Test
    void testByMethodInfoUserNotAddedByPassword() {
        userToAdd.authenticate("Gleb", "123");
        assertThat(userRepository.addUser(userToAdd)).isFalse();
    }

    @Test
    void testFindByName() {
        userToAdd.authenticate("Gleb", "321");
        userRepository.addUser(userToAdd);
        assertThat(userRepository.findByName("Gleb")).isTrue();
    }

    @Test
    void testNotFindByName() {
        userToAdd.authenticate("Gleb", "321");
        userRepository.addUser(userToAdd);
        assertThat(userRepository.findByName("Peter")).isFalse();
    }

    @Test
    void testDisAuthenticateForNotAdmins() {
//        Добавим пользователя с правами администратора
        userAdmin = new User("Peter", "asd", true);
//        Аутентификация
        userToAdd.authenticate("Gleb", "321");
        userAdmin.authenticate("Peter", "asd");
//        Добавление в репозиторий
        userRepository.addUser(userToAdd);
        userRepository.addUser(userAdmin);
//        Отключаем аутентификацию у пользователей, не имеющих прав администратора
        userRepository.disAuthenticateAllButAdmins(userRepository);
//        Тестируем наличие аутентификации у пользователя без права администратора
        assertThat(userRepository.getData().get(0).isAuthenticated()).isFalse();
    }

    @Test
    void testDisAuthenticateForAdmins() {
//        Добавим пользователя с правами администратора
        userAdmin = new User("Peter", "asd", true);
//        Аутентификация
        userToAdd.authenticate("Gleb", "321");
        userAdmin.authenticate("Peter", "asd");
//        Добавление в репозиторий
        userRepository.addUser(userToAdd);
        userRepository.addUser(userAdmin);
//        Отключаем аутентификацию у пользователей, не имеющих прав администратора
        userRepository.disAuthenticateAllButAdmins(userRepository);
//        Тестируем наличие аутентификации у пользователя без права администратора
        assertThat(userRepository.getData().get(1).isAuthenticated()).isTrue();
    }
}
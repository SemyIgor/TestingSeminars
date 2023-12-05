package seminars.five.user;

public class UserRepository {
    public String getUserById(int id) {
        // В реальной жизни здесь был бы код, работающий с базой данных
/*        return "User id= " + id; // Для более глубокой проверки эта строка
//        помещалась бы в какой-нибудь JdbcTemplate.query select username from users where id= ....*/
        return "select username from users where id= " + id;
    }
}

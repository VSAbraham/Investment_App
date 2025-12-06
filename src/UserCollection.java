import java.util.List;

public interface UserCollection {
    void displayUsers();
    void addUser(User user);
    User createUser(String name, long contact, String address);
    Book searchUserById(Integer id);
//    void updateUser(Integer id);
    void deleteUser(Integer id);
    boolean existById(Integer id);
}

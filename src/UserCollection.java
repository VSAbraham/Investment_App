import java.util.List;

public interface UserCollection {
    void displayUsers();
    void addUser(User user);
    User createUser(String name, Integer contact, String address);
    Book searchUserById(Integer id);
}

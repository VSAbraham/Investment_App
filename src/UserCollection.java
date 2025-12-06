import java.util.Scanner;

public interface UserCollection {
    void displayUsers();
    void addUser(User user);
    User createUser(String name, long contact, String address);
    Book searchUserById(Integer id);
    void UpdateUserDetails(long contact, Scanner sc);
}

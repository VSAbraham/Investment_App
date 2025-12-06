public interface UserCollection {
    void displayUsers();
    void addUser(User user);
    User createUser(String name, long contact, String address);
    Book searchUserById(Integer id);
    void updateUserDetails(long contact, String name, String address, long ph_no);
    void deleteUser(Integer id);
}

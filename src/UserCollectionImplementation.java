import java.util.List;

public class UserCollectionImplementation implements UserCollection{
    private List<User> allUsers;
    @Override
    public void displayUsers(){
        for(User user : allUsers) {
            System.out.println();
            System.out.println("ID\t\tName\t\tContact\t\tAddress");
            System.out.println(user.getId()+"\t\t"+user.getName()+"\t"+user.getContact()+"\t"+user.getAddress());
        }
    }

    @Override
    public User createUser(String name, Integer contact, String address){
        return new User(allUsers.size(), name, contact, address);
    }

    @Override
    public void addUser(User user){
        allUsers.add(user);
    }
}

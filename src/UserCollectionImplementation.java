import java.util.List;

public class UserCollectionImplementation implements UserCollection{
    private List<User> allUsers;
    @Override
    public void displayUsers(){
        if(allUsers.size() == 0)
            System.out.println("No users available!!!");
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

    @Override
    public Book searchUserById(Integer Id){
        return allUsers.get(Id).getBook();
    }
}

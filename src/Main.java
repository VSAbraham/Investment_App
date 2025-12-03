import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UserCollection userCollection = new UserCollectionImplementation();
        while(true){
            System.out.println("Options:\n\n1. Display All Users\n2. Add a New User\n3. Search User Transaction details\n\nEnter 0 to exit");
            Scanner sc = new Scanner(System.in);

            int ch = sc.nextInt();

            if(ch == 1)
                userCollection.displayUsers();

            else if (ch == 2) {
                System.out.println("Enter Name: ");
                String name = sc.next();
                System.out.println("Enter Phone No. : ");
                Integer ph = sc.nextInt();
                //to validate phone number
                if(String.valueOf(ph).length() != 10) {
                    System.out.println("Invalid Phone Number...");
                    continue;
                }
                System.out.println("Enter Address details: ");
                String address = sc.next();

                User user = userCollection.createUser(name, ph, address);
                userCollection.addUser(user);
            }

            else if (ch == 3) {
                System.out.println("Enter ID: ");
                Integer id = sc.nextInt();
                userCollection.searchUserById(id).displayTransactions();
            }

            else if (ch == 0) {
                break;
            }else
                System.out.println("Invalid Option!!!\nAvailable options are 1,2,3 & 0");

        }

    }
}
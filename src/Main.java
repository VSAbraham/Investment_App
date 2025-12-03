import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UserCollection userCollection = new UserCollectionImplementation();
        while(true){
            System.out.print("Options:\n\n1. Display All Users\n2. Add a New User\n3. Search User Transaction details\n\nEnter 0 to exit\n");
            System.out.print("Enter Option: ");
            Scanner sc = new Scanner(System.in);

            int ch = sc.nextInt();

            if(ch == 1)
                userCollection.displayUsers();

            else if (ch == 2) {
                System.out.print("Enter Name: ");
                sc.nextLine();
                String name = sc.nextLine().trim();
                System.out.print("Enter Phone No. : ");
                long ph = sc.nextLong();
                //to validate phone number
                if(String.valueOf(ph).length() != 10) {
                    System.out.println("Invalid Phone Number...");
                    continue;
                }
                System.out.print("Enter Address details: ");
                sc.nextLine();
                String address = sc.nextLine().trim();

                System.out.print("Enter Amount to deposit: ");
                long depositAmount = sc.nextLong();

                User user = userCollection.createUser(name, ph, address);
                userCollection.addUser(user);
                LocalDate date = LocalDate.now();
                //Adding initial deposit amount from User...
                user.getBook().addTransaction(new Transaction(user.getId(), depositAmount, date));
                System.out.println("\nUser Added successfully!!!\n\n");
            }

            else if (ch == 3) {
                System.out.print("Enter ID: ");
                Integer id = sc.nextInt();
                try {
                    userCollection.searchUserById(id).displayTransactions();
                }
                catch (NullPointerException e){
                    System.out.println("\n\nNo transactions found for the given ID. Please check the ID and try again.\n\n");

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("\n\nNo Users Found, Kindly add a user, using option 2\n\n");
                }
            }

            else if (ch == 0) {
                break;
            }else
                System.out.println("Invalid Option!!!\nAvailable options are 1,2,3 & 0");

        }

    }
}
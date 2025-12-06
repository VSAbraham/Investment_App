import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UserCollection userCollection = new UserCollectionImplementation();
        try (Scanner sc = new Scanner(System.in)) {
        while (true) {
            System.out.print("Options:\n\n1. Display All Users" +
                    "\n2. Add a New User" +
                    "\n3. Search User Transaction details" +
                    "\n4. Update the User Details" +
                    "\n5. Delete User"+
                    "\n\nEnter 0 to exit\n");
            System.out.print("Enter Option: ");
           
            int ch = sc.nextInt();
            boolean flag = false;
            switch (ch) {
                //Display all users
                case 1 -> userCollection.displayUsers();
                //Create User
                case 2 -> {
                    System.out.print("Enter Name: ");
                    sc.nextLine();
                    String name = sc.nextLine().trim();
                    System.out.print("Enter Phone No. : ");
                    long ph = sc.nextLong();
                    //to validate phone number
                    if(String.valueOf(ph).length() != 10) {
                        System.out.println("Invalid Phone Number...");
                        continue;
                    }   System.out.print("Enter Address details: ");
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
                //Display Transactions of a User
                case 3 -> {
                    System.out.print("Enter ID: ");
                    Integer id = sc.nextInt();
                    try {
                        userCollection.searchUserById(id).displayTransactions();
                    } catch (NullPointerException e){
                        System.out.println("\n\nNo transactions found for the given ID. Please check the ID and try again.\n\n");

                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("\n\nNo Users Found, Kindly add a user, using option 2\n\n");
                    }
                }
                //Update a User
                case 4 ->{
                    System.out.println("Enter your Phone Number:");
                    long contact = sc.nextLong();
                     System.out.println("Please enter the details:\n If the detail need not be changed please press enter");
                    String name;
                    String address;
                    long ph_no;
                    try {
                        System.out.println("Enter the Name: ");
                        sc.nextLine();
                        name = sc.nextLine();
                        System.out.println("Enter the Address: ");
                        address = sc.nextLine();
                        System.out.println("Enter the Phone Number: ");
                        String ph = sc.nextLine();
                        ph_no = (ph.isEmpty())?0:Long.parseLong(ph);
                         userCollection.updateUserDetails(contact, name,address,ph_no);
                    } catch (RuntimeException e) {
                         throw new RuntimeException(e);
                    }

                }
                //Delete User
                case 5 -> {
                    System.out.print("Enter ID: ");
                    Integer id = sc.nextInt();
                    userCollection.deleteUser(id);
                }
                //Exit
                case 0 -> {
                    flag = true;
                }
                default -> System.out.println("Invalid Option!!!\nAvailable options are 1,2,3 & 0");
            }
            if(flag){
            break;
            }
            }
        }
    

    }
}
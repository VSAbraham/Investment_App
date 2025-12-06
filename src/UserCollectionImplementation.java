import java.util.*;

public class UserCollectionImplementation implements UserCollection{
    private final Map<Integer,User> allUsers = new HashMap<>();

    @Override
    public void displayUsers() {
        if (allUsers.isEmpty()) {
            System.out.println("No users available!!!");
            return;
        }

        // Headers
        String hId = "ID";
        String hName = "Name";
        String hContact = "Contact";
        String hAddress = "Address";

        // Compute max width for each column (based on header and data)
        int idWidth = hId.length();
        int nameWidth = hName.length();
        int contactWidth = hContact.length();
        int addressWidth = hAddress.length();

        for (User u : allUsers.values()) {
            String idStr = String.valueOf(u.getId() == null ? "" : u.getId());
            String nameStr = safe(u.getName());
            String contactStr = safe(String.valueOf(u.getContact()));
            String addressStr = safe(u.getAddress());

            idWidth = Math.max(idWidth, idStr.length());
            nameWidth = Math.max(nameWidth, nameStr.length());
            contactWidth = Math.max(contactWidth, contactStr.length());
            addressWidth = Math.max(addressWidth, addressStr.length());
        }

        // Optional: limit the maximum width of a column to keep the table readable
        // Adjust these as you like or set to Integer.MAX_VALUE to disable truncation
        final int MAX_ADDRESS = 60;
        final int MAX_NAME = 30;
        final int MAX_CONTACT = 20;

        addressWidth = Math.min(addressWidth, MAX_ADDRESS);
        nameWidth = Math.min(nameWidth, MAX_NAME);
        contactWidth = Math.min(contactWidth, MAX_CONTACT);

        // Box drawing characters
        String TOP_LEFT = "┌", TOP_RIGHT = "┐", BOTTOM_LEFT = "└", BOTTOM_RIGHT = "┘";
        String H = "─", V = "│";
        String TOP_T = "┬", MID_T = "┼", LEFT_T = "├", RIGHT_T = "┤", BOTTOM_T = "┴";

        // Build border pieces
        String top = TOP_LEFT
                + repeat(H, idWidth + 2) + TOP_T
                + repeat(H, nameWidth + 2) + TOP_T
                + repeat(H, contactWidth + 2) + TOP_T
                + repeat(H, addressWidth + 2) + TOP_RIGHT;

        String headerSep = LEFT_T
                + repeat(H, idWidth + 2) + MID_T
                + repeat(H, nameWidth + 2) + MID_T
                + repeat(H, contactWidth + 2) + MID_T
                + repeat(H, addressWidth + 2) + RIGHT_T;

        String bottom = BOTTOM_LEFT
                + repeat(H, idWidth + 2) + BOTTOM_T
                + repeat(H, nameWidth + 2) + BOTTOM_T
                + repeat(H, contactWidth + 2) + BOTTOM_T
                + repeat(H, addressWidth + 2) + BOTTOM_RIGHT;

        // Print top
        System.out.println(top);

        // Print header
        System.out.printf("%s %-" + idWidth + "s %s %-" + nameWidth + "s %s %-" + contactWidth + "s %s %-" + addressWidth + "s %s%n",
                V, hId, V, hName, V, hContact, V, hAddress, V);

        // Header separator
        System.out.println(headerSep);

        // Print rows
        for (User u : allUsers.values()) {
            String idStr = String.valueOf(u.getId() == null ? "" : u.getId());
            String nameStr = safe(u.getName());
            String contactStr = safe(String.valueOf(u.getContact()));
            String addressStr = safe(u.getAddress());

            // Truncate columns that exceed max widths
            nameStr = truncate(nameStr, nameWidth);
            contactStr = truncate(contactStr, contactWidth);
            addressStr = truncate(addressStr, addressWidth);

            System.out.printf("%s %-" + idWidth + "s %s %-" + nameWidth + "s %s %-" + contactWidth + "s %s %-" + addressWidth + "s %s%n",
                    V, idStr, V, nameStr, V, contactStr, V, addressStr, V);
        }

        // Print bottom
        System.out.println(bottom);
    }

    private Integer id = 1;

    @Override
    public User createUser(String name, long contact, String address){
        User user = new User(id, name, contact, address);
        user.setBook(new Book(user.getId(), user.getName()));
        id++;
        return user;
    }
    @Override
    public void UpdateUserDetails(long contact,String name,String address,long ph_no){
        boolean isContactAvailable = false;
        for (User user : allUsers.values()) {
            if(user.getContact()==contact){
                isContactAvailable = true;
               
                if(!name.isEmpty()){
                    user.setName(name);
                }
                if(!address.isEmpty()){
                    user.setAddress(address);
                }
                if(ph_no!=0){
                    user.setContact(ph_no);
                }
                break;
            }
        }
        if(isContactAvailable)
        {
            System.out.println("Updated Successfully");
        }
        else
        {
             System.out.println("Please Provide a valid Number");
        }
    }
    @Override
    public void addUser(User user){
        allUsers.put(user.getId(),user);
    }

    @Override
    public Book searchUserById(Integer id) {
        User u = allUsers.get(id);
        return (u == null) ? null : u.getBook();
    }

    // ---------- Helper methods ----------
    private static String repeat(String s, int times) {
        StringBuilder sb = new StringBuilder(Math.max(0, times));
        for (int i = 0; i < times; i++) sb.append(s);
        return sb.toString();
    }

    private static String safe(String s) {
        return s == null ? "" : s;
    }

    private static String truncate(String s, int max) {
        if (s.length() <= max) return s;
        if (max <= 3) return s.substring(0, max);
        return s.substring(0, max - 3) + "...";
    }
}

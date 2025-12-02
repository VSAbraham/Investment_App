import java.util.ArrayList;
import java.util.List;

public class Book {
    private Integer id;
    private String name;
    private List<Transaction> transactions = new ArrayList<>();

    public Book(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void displayTransactions() {
        System.out.println("Transaction Book: " + name);
        System.out.println("ID\tType\tAmount\tDate");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}
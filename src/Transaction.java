import java.time.LocalDate;

public class Transaction {
    private Integer id;
    private String type; // e.g. "BUY", "SELL", "DEPOSIT"
    private long amount;
    private LocalDate date; // or use LocalDateTime for better handling

    public Transaction(Integer id, long amount, LocalDate date) {
        this.id = id;
        this.amount = amount;
        this.date = date;
    }

    public Integer getId() { return id; }
//    public String getType() { return type; }
    public long getAmount() { return amount; }
    public LocalDate getDate() { return date; }

    @Override
    public String toString() {
        return id + "\t" + amount + "\t" + date;
    }
}
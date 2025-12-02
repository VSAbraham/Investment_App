public class Transaction {
    private Integer id;
    private String type; // e.g. "BUY", "SELL", "DEPOSIT"
    private Double amount;
    private String date; // or use LocalDateTime for better handling

    public Transaction(Integer id, String type, Double amount, String date) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public Integer getId() { return id; }
    public String getType() { return type; }
    public Double getAmount() { return amount; }
    public String getDate() { return date; }

    @Override
    public String toString() {
        return id + "\t" + type + "\t" + amount + "\t" + date;
    }
}
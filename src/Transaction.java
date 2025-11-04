import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private final String type;
    private final double amount;
    private final LocalDateTime dateTime;

    public Transaction(String type,double amount){
        this.type = type;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    public String getType(){
        return type;
    }

    public double getAmount(){
        return amount;
    }

    public String getFormattedDataTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return dateTime.format(formatter);
    }

    @Override
    public String toString(){
        return String.format("[%s] %s: Rs. %.2f", getFormattedDataTime(),type,amount);
    }
}

import java.util.ArrayList;
import java.util.List;

public class Receiver implements Person{
    String name;
    List<Transaction> transactionsReceived;

    public Receiver(String name) {
        this.name = name;
        this.transactionsReceived = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Transaction> getTransactions() {
        return transactionsReceived;
    }
}

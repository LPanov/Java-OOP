import java.util.ArrayList;
import java.util.List;

public class Sender implements Person{
    String name;
    List<Transaction> transactionsSent;

    public Sender(String name) {
        this.name = name;
        this.transactionsSent = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Transaction> getTransactions() {
        return transactionsSent;
    }
}

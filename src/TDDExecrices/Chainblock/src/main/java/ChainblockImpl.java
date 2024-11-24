import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class ChainblockImpl implements Chainblock{
    private List<Transaction> transactions;
    private List<Person> senders;
    private List<Person> receivers;

    public ChainblockImpl() {
        this.transactions = new ArrayList<>();
        this.senders = new ArrayList<>();
        this.receivers = new ArrayList<>();
    }

    public int getCount() {
        return transactions.size();
    }

    public void add(Transaction transaction) {
        if (!transactions.contains(transaction)) {
            transactions.add(transaction);
        }
    }

    @Override
    public List<Person> getSenders() {
        return senders;
    }

    @Override
    public List<Person> getReceivers() {
        return receivers;
    }

    public boolean contains(Transaction transaction) {
        return transactions.contains(transaction);
    }

    public boolean contains(int id) {
        return transactions.stream().anyMatch(tr -> tr.getId() == id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        Transaction transaction = transactions.stream()
                .filter(tr -> tr.getId() == id).findFirst().
                orElseThrow(IllegalArgumentException::new);

        transaction.setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        Transaction transaction = transactions.stream()
                .filter(tr -> tr.getId() == id)
                .findFirst().orElseThrow(IllegalArgumentException::new);

        transactions.remove(transaction);
    }

    public Transaction getById(int id) {
        return transactions.stream()
                .filter(tr -> tr.getId() == id)
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        transactions.sort(Comparator.comparing(Transaction::getAmount).reversed());
        List<Transaction> statusTransactions = transactions.stream()
                .filter(tr -> tr.getTransactionStatus() == status).collect(toList());

        if (statusTransactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return statusTransactions;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<Pair> pairs = new ArrayList<>();
        for (Person sender : senders) {
            for (Transaction transaction : sender.getTransactions()) {
                if (transaction.getTransactionStatus() == status) {
                    pairs.add(new Pair(sender.getName(), transaction.getAmount()));
                }
            }
        }

        if (pairs.isEmpty()) {
            throw new IllegalArgumentException();
        }

        pairs.sort(Comparator.comparing(Pair::getAmount).reversed());
        List<String> sendersNames = new ArrayList<>();
        pairs.forEach(p -> sendersNames.add(p.getName()));

        return sendersNames;

    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<Pair> pairs = new ArrayList<>();
        receivers.forEach(receiver -> {
            receiver.getTransactions().stream()
                    .filter(transaction -> transaction.getTransactionStatus() == status)
                    .forEach(transaction ->
                            pairs.add(new Pair(receiver.getName(), transaction.getAmount())));
        });

        if (pairs.isEmpty()) {
            throw new IllegalArgumentException();
        }

        pairs.sort(Comparator.comparing(Pair::getAmount).reversed());
        List<String> receiversNames = new ArrayList<>();
        pairs.forEach(p -> receiversNames.add(p.getName()));

        return receiversNames;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return null;
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        return null;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        return null;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    public Iterator<Transaction> iterator() {
        return transactions.iterator();
    }
}

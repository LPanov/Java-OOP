public interface Transaction {
    public int getId();

    public TransactionStatus getTransactionStatus();

    public String getFrom();
    public String getTo();
    public double getAmount();

    public void setStatus(TransactionStatus transactionStatus);
}

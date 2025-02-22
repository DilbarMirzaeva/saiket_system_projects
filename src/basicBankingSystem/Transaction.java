package basicBankingSystem;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction {
    private static int Id=0;
    private int transactionId;
    private String transactionType;
    private Double amount;
    private final LocalDateTime transactionDateTime;
    BankAccount bankAccount;

    public Transaction(String transactionType, Double amount, BankAccount bankAccount) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDateTime = LocalDateTime.now();
        this.bankAccount = bankAccount;
        transactionId=Id++;
    }

    public Transaction(String transactionType, BankAccount bankAccount) {
        this.transactionType = transactionType;
        this.bankAccount = bankAccount;
        transactionDateTime=LocalDateTime.now();
    }

    public void type(){
        if(transactionType.equalsIgnoreCase("deposit")){

        }
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", transactionType='" + transactionType + '\'' +
                ", transaction time=" + transactionDateTime +
                ", bankAccount=" + bankAccount +
                '}';
    }
}

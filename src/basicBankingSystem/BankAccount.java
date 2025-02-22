package basicBankingSystem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static calculator.util.getInput;

public class BankAccount {
    private static int Id=1;
    private  int accountId;
    private User user;
    private Double balance;
    private List<Transaction> transactions=new ArrayList<>();

    public BankAccount( User user) {
        this.balance = (double) 0;
        this.user = user;
        this.accountId=Id++;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit() {
        Double depoAmount = getInput("Please enter the deposit amount : ", Double.class);
        while (true) {
            try {
                if (depoAmount <= 0) {
                    throw new RuntimeException("Deposit amount must be positive and greater than zero");
                } else {
                    setBalance(getBalance() + depoAmount);
                    transactions.add(new Transaction("deposit",depoAmount,this));
                    System.out.println("The deposit transaction completed successfully.");
                    return;
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                depoAmount = getInput("Try again: ", Double.class);
            }
        }
    }

        public void withdrawal(){
            Double withdrawAmount=getInput("How much money do you want to withdraw? Enter :", Double.class);
            while (true){
                try{if (withdrawAmount<=0){
                    throw new RuntimeException("Withdraw amount must be positive and greater than zero");
                } else if (getBalance()<withdrawAmount) {
                    throw new RuntimeException("You don't have enough money..");
                } else {
                    setBalance(getBalance()-withdrawAmount);
                    transactions.add(new Transaction("withdrawal",withdrawAmount,this));
                    System.out.println("Withdrawal transaction completed successfully");
                    return;
                }
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                    withdrawAmount = getInput("Try again: ", Double.class);
                }
            }
        }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountId=" + accountId +
                ", user=" + user +
                ", balance=" + balance +
                '}';
    }
}

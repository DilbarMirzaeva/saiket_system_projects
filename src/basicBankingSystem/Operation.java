package basicBankingSystem;

import java.util.ArrayList;
import java.util.List;

import static calculator.util.getInput;

public class Operation {
    static List<BankAccount> bankAccounts = new ArrayList<>();
    static List<User> users = new ArrayList<>();

    public static void bankSystem() {
        System.out.println("\t\t\t------Bank------");
        System.out.println("\n\nWelcome our Bank Account System");
        while (true) {
            Integer input = getInput("""
                    1.Create Bank Account
                    2.View Account balance
                    3.Deposit Money
                    4.Withdraw Money
                    5.View Transaction History
                    6.Exit""", Integer.class);
            while (input < 1 || input > 6) {
                input = getInput("Please try again(between 1-6): ", Integer.class);
            }
            System.out.println("--------------");
            switch (input) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    viewBalance(getUser());
                    break;
                case 3:
                    depo();
                    break;
                case 4:
                    withdraw();
                    break;
                case 5:
                    trans();
                    break;
                case 6:
                    return;

            }
        }
    }

    public static User getUser() {
        String name = getInput("Enter your name : ", String.class);
        String mail = getInput("Enter your mail : ", String.class);
        for (User user : users) {
            if (user.getName().equals(name) && user.getMail().equals(mail)) {
                return user;
            }
        }
        User newUser = new User(name, mail);
        users.add(newUser);
        return newUser;
    }

    public static void createAccount() {
        System.out.println("--------------");
        User user = getUser();
        BankAccount newBankAccount = new BankAccount(user);
        bankAccounts.add(newBankAccount);
        user.addBankAccount(newBankAccount);
        System.out.println("Your account created successfully");
        System.out.println("--------------");
    }

    public static void viewBalance(User user) {
        if (user.getAccounts().isEmpty()) {
            System.out.println("You don't have bank account.If you want,please create the account.");
            System.out.println("--------------");
            return;
        }
        System.out.println("Your accounts:");
        for (BankAccount bankAccount : user.getAccounts()) {
            System.out.println("Account Id:" + bankAccount.getAccountId() + " => Account balance:" + bankAccount.getBalance());

        }
        System.out.println("--------------");
    }

    public static void depo() {
        System.out.println("--------------");
        User user = getUser();
        if (user.getAccounts().isEmpty()) {
            System.out.println("You don't have bank account.If you want,please create the account.");
            System.out.println("--------------");
            return;
        }
        viewBalance(user);
        int accountID = getInput("Enter the Account ID you want to deposit into: ", Integer.class);
        for (BankAccount bankAccount : user.getAccounts()) {
            if (bankAccount.getAccountId() == accountID) {
                bankAccount.deposit();
                System.out.println("--------------");
                return;
            }
        }
        System.out.println("Invalid account Id,try again");
        System.out.println("--------------");
    }

    public static void withdraw() {
        System.out.println("--------------");
        User user = getUser();
        if (user.getAccounts().isEmpty()) {
            System.out.println("You don't have bank account.If you want,please create the account.");
            System.out.println("--------------");
            return;
        }
        viewBalance(user);
        int accountID = getInput("Enter the Account ID which you want to withdraw: ", Integer.class);
        for (BankAccount bankAccount : user.getAccounts()) {
            if (bankAccount.getAccountId() == accountID) {
                bankAccount.withdrawal();
                return;
            }
        }
        System.out.println("Invalid account Id,try again");
        System.out.println("--------------");
    }

    public static void trans(){
        System.out.println("-----------");
        User user=getUser();
        if (user.getAccounts().isEmpty()) {
            System.out.println("You don't have bank account.If you want,please create the account.");
            System.out.println("--------------");
            return;
        }
        for (BankAccount bankAccount:user.getAccounts()){
            System.out.println(bankAccount.getTransactions());
        }
    }

}

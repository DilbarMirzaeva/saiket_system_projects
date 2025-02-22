package basicBankingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private static int id=1;
    private int ID;
    private String name;
    private String mail;
    private List<BankAccount> accounts=new ArrayList<>();


    public User(String name, String mail) {
        this.name = name;
        this.mail = mail;
        this.ID=id++;
    }


    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void addBankAccount(BankAccount account) {
        accounts.add(account);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return  Objects.equals(name, user.name) && Objects.equals(mail, user.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash( name, mail);
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        User.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                "accounts="+accounts.size()+'}';
    }
}

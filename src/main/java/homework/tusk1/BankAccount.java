package homework.tusk1;

public class BankAccount {
    private String ownerName;
    private double balance;

    public BankAccount(String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }

    // Геттеры и сеттеры
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            System.out.println("Баланс не может быть отрицательным");
            this.balance = balance;
        } else {
            this.balance = balance;
        }
    }


    public static void main(String[] args) {
        BankAccount account = new BankAccount("Сергей Серегин", 0);
        account.setOwnerName("Владимир Владыкин");
        account.setBalance(1000);
        System.out.println("Баланс после установки 1000: " + account.getBalance());
        account.setBalance(-500);
        System.out.println("Баланс после установки -500: " + account.getBalance());
    }
}
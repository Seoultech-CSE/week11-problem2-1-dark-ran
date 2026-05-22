import java.util.Scanner;
import java.util.InputMismatchException;

class InsufficientBalanceException extends Exception {
    private double balance;
    private double amount;

    public InsufficientBalanceException(double balance, double amount) {
        super("Insufficient balance. Current balance: $" + balance + ", Requested amount: $" + amount);
        this.balance = balance;
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public double getAmount() {
        return amount;
    }
}

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than 0.");
        }

        balance += amount;
        System.out.println("$" + amount + " successfully deposited.");
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException(balance, amount);
        }

        balance -= amount;
        System.out.println("$" + amount + " successfully withdrawn.");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BankAccount account = new BankAccount(500.0);

        try {
            double depositAmount = input.nextDouble();
            account.deposit(depositAmount);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a numeric value.");
            input.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("Deposit failed: " + e.getMessage());
        } finally {
            System.out.println("[Current Balance Status] $" + account.getBalance());
        }

        try {
            double withdrawAmount = input.nextDouble();
            account.withdraw(withdrawAmount);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a numeric value.");
            input.nextLine();
        } catch (InsufficientBalanceException e) {
            System.out.println("Withdrawal failed: " + e.getMessage());
        } finally {
            System.out.println("[Current Balance Status] $" + account.getBalance());
        }

        input.close();
    }
}
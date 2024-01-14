import java.util.Scanner;
public class ATM {
    private String accountNumber;
    private double balance;
    public ATM(String accountNumber, double initialBalance){
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    public void displayMenu(){
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }
    public void processOption(int option){
        switch (option){
            case 1:
                withdraw();
                break;
            case 2:
                deposit();
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                System.out.println("Thank you for using the ATM.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please choose a valid option.");
        }
    }
    private void withdraw(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: ");
        double amount = validateAmountInput(scanner.nextDouble());

        if (amount > balance){
            System.out.println("Insufficient funds. Withdrawal canceled.");
        } else {
            balance -= amount;
            System.out.printf("Successfully withdrew %.2f. Updated balance: %.2f%n", amount, balance);
        }
    }
    private void deposit(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: ");
        double amount = validateAmountInput(scanner.nextDouble());

        balance += amount;
        System.out.printf("Successfully deposited %.2f. Updated balance: %.2f%n", amount, balance);
    }
    private void checkBalance(){
        System.out.printf("Current balance for account %s: %.2f%n", accountNumber, balance);
    }
    private double validateAmountInput(double amount) {
        while (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive amount.");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the amount again: ");
            amount = scanner.nextDouble();
        }
        return amount;
    }
    public static void main(String[] args){
        // Example usage
        ATM atm = new ATM("123456789", 1000.0);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.displayMenu();
            System.out.print("Choose an option (1-4): ");
            int option = scanner.nextInt();

            atm.processOption(option);
        }
    }
}


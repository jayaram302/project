class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public Account(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}

class Transaction {
    private String transactionId;
    private String accountNumber;
    private double amount;
    private String type; // Deposit or Withdraw

    public Transaction(String transactionId, String accountNumber, double amount, String type) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.type = type;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }
}

class BankingSystem {
    private Map<String, Account> accounts = new HashMap<>();
    private List<Transaction> transactionHistory = new ArrayList<>();

    public void createAccount(String accountNumber, String accountHolder, double initialBalance) {
        Account account = new Account(accountNumber, accountHolder, initialBalance);
        accounts.put(accountNumber, account);
        System.out.println("Account created for: " + accountHolder);
    }

    public void deposit(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
            transactionHistory.add(new Transaction(UUID.randomUUID().toString(), accountNumber, amount, "Deposit"));
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.withdraw(amount);
            transactionHistory.add(new Transaction(UUID.randomUUID().toString(), accountNumber, amount, "Withdraw"));
        } else {
            System.out.println("Account not found.");
        }
    }

    public void printTransactionHistory() {
        for (Transaction transaction : transactionHistory) {
            System.out.println("Transaction ID: " + transaction.getTransactionId() + ", Account: " + transaction.getAccountNumber() + ", Amount: " + transaction.getAmount() + ", Type: " + transaction.getType());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();
        bankingSystem.createAccount("123456", "John Doe", 1000.00);
        bankingSystem.deposit("123456", 500.00);
        bankingSystem.withdraw("123456", 200.00);
        bankingSystem.printTransactionHistory();
    }
}

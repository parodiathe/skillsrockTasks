class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Deposit <= 0");
        balance += amount;
    }

    public synchronized void withdraw(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        if (balance < amount)
            throw new IllegalArgumentException("Insufficient funds");
        balance -= amount;
    }

    public synchronized double getBalance() {
        return balance;
    }
}

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ConcurrentBank {
    private final Set<BankAccount> accounts = Collections.synchronizedSet(new HashSet<>());

    public BankAccount createAccount(double balance) {
        BankAccount account = new BankAccount(balance);
        accounts.add(account);
        return account;
    }

    public double getBalance() {

        BankAccount[] accountsCopy = accounts.toArray(new BankAccount[0]);
        double total = 0;
        for (BankAccount account : accountsCopy) {
            total += account.getBalance();
        }
        return total;
    }

    public void transfer(BankAccount from, BankAccount to, double amount) {
        BankAccount first;
        BankAccount second;

        if (System.identityHashCode(from) < System.identityHashCode(to)) {
            first = from;
            second = to;
        } else {
            first = to;
            second = from;
        }

        synchronized (first) {
            synchronized (second) {
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }

}

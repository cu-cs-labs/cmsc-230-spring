package bank;

import java.util.*;
import org.springframework.stereotype.Service;

// the bank's accounts, in memory: a name and its balance in
// cents. Spring makes one, and hands it to every controller
// that asks for it.
@Service
public class Accounts {
    private final Map<String, Long> balances =
            new TreeMap<>();

    public Accounts() {
        balances.put("alice", 1250L);
        balances.put("bob", 250L);
    }

    // the balance, or null when there is no such account
    public Long balance(String name) {
        return balances.get(name);
    }

    // adds cents to name's balance; false when there is no
    // such account
    public boolean deposit(String name, long cents) {
        Long now = balances.get(name);
        if (now == null) {
            return false;
        }
        balances.put(name, now + cents);
        return true;
    }
}

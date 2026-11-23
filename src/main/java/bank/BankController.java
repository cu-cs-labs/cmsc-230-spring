package bank;

import org.springframework.web.bind.annotation.*;

// the bank's URLs: each method answers one kind of request
@RestController
public class BankController {
    private final Accounts accounts;

    // Spring calls this, with the one Accounts it made
    public BankController(Accounts accounts) {
        this.accounts = accounts;
    }

    // GET /balance/alice: alice's balance
    @GetMapping("/balance/{name}")
    public Balance balance(@PathVariable String name) {
        return new Balance(name, accounts.balance(name));
    }
}

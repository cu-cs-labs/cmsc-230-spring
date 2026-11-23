package bank;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

// the controller is a plain class: these tests make one
// with new, and no Spring, no server and no browser
public class BankControllerTest {
    BankController bank =
            new BankController(new Accounts());

    @Test
    void aliceStartsWith1250() {
        assertEquals(1250, bank.balance("alice").cents());
    }
}

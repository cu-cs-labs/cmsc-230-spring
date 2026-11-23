package bank;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

// the bank on the web: run this, then open
// http://localhost:8080/ in a browser
@SpringBootApplication
public class BankWeb {
    public static void main(String[] args) {
        SpringApplication.run(BankWeb.class, args);
    }
}

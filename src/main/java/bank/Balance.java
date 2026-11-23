package bank;

// what a request about an account gets back, as JSON:
// {"name":"alice","cents":1250}
public record Balance(String name, long cents) {
}

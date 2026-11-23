package bank;

import java.net.*;
import java.net.http.*;

// eight clients at once, each depositing 1 cent into
// alice's account 500 times, while BankWeb runs; then
// her balance
public class Crowd {
    static final HttpClient web =
            HttpClient.newHttpClient();

    // sends the request, and gives back the answer's body
    static String send(HttpRequest request)
            throws Exception {
        HttpResponse<String> answer = web.send(request,
                HttpResponse.BodyHandlers.ofString());
        return answer.body();
    }

    public static void main(String[] args)
            throws Exception {
        HttpRequest oneCent = HttpRequest.newBuilder(
                URI.create("http://localhost:8080/deposit"))
                .header("Content-Type",
                        "application/x-www-form-urlencoded")
                .POST(HttpRequest.BodyPublishers.ofString(
                        "name=alice&cents=1"))
                .build();
        HttpRequest balance = HttpRequest.newBuilder(
                URI.create("http://localhost:8080"
                        + "/balance/alice"))
                .build();
        System.out.println("before: " + send(balance));
        Thread[] clients = new Thread[8];
        for (int i = 0; i < clients.length; i++) {
            clients[i] = new Thread(() -> {
                try {
                    for (int k = 0; k < 500; k++) {
                        send(oneCent);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            });
            clients[i].start();
        }
        for (Thread c : clients) {
            c.join();
        }
        System.out.println("after 4000 deposits of 1 cent: "
                + send(balance));
    }
}

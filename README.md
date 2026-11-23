# CMSC 230: the bank on the web

A bank in Spring Boot, for Class 26. What to do with it is on the class's
page on the course site, under Monday, November 30.

- `src/main/java/bank/BankWeb.java` starts the bank: run it from the arrow
  beside `main`, then open <http://localhost:8080/> in a browser.
- `Accounts.java` keeps the accounts, `BankController.java` answers the
  requests, and `Balance.java` is what an answer carries. Those three are
  yours to change.
- `Crowd.java` is a client that sends 4,000 deposits at once; run it while
  `BankWeb` runs.
- `src/main/resources/static/index.html` is the page the browser shows at
  `http://localhost:8080/`, with a form that sends a deposit.
- `src/test/java/bank/BankControllerTest.java` holds the tests; yours go there
  too.

The first run fetches Spring Boot, about 60 MB, so give IntelliJ a minute.
Commit and push before you leave, as with `cmsc-230-jdbc`.

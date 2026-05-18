[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/eRvaT0Xk)
# Interactive Bank Account System
## 부제: 사용자 입력을 받는 통합형 은행 계좌 시스템 구현

---

## 📄 Problem Description (한국어)

본 문제에서는 별도의 실행 클래스를 만들지 않고, `BankAccount` 클래스 내부에 `main` 메서드를 직접 구현하여 프로그램의 진입점으로 사용합니다. 또한, `java.util.Scanner`를 사용하여 유저로부터 직접 예치금 및 출금액을 입력받아 동작하는 대화형 프로그램으로 구성합니다.

### 1. 사용자 정의 Checked 예외 클래스 구현
* 잔액보다 많은 금액을 출금하려고 할 때 발생시킬 `InsufficientBalanceException` 클래스를 정의하세요.
* 이 클래스는 자바 내장 `Exception` 클래스를 상속받아야 하며, 이는 컴파일러가 예외 처리를 강제하는 **Checked Exception**이 됩니다.
* 예외 발생 시점의 현재 잔액(`balance`)과 요청 금액(`amount`)을 저장할 수 있는 필드와 이를 초기화하는 생성자를 구현하세요.

### 2. `BankAccount` 클래스 기능 통합
* `deposit(double amount)`: 입금 기능입니다. 만약 입금액이 `0` 이하일 경우, 잘못된 인자가 넘어왔음을 알리는 자바 내장 Unchecked 예외인 `IllegalArgumentException`을 발생시키세요.
* `withdraw(double amount)`: 출금 기능입니다. 출금 요청 금액이 잔액보다 크면 `InsufficientBalanceException`을 던지도록(`throws`) 메서드 시그니처에 선언하고, 조건에 맞지 않을 때 예외 객체를 생성하여 던지세요(`throw`).

### 3. `main` 메서드 내 예외 처리 및 `finally` 활용
* `Scanner`를 통해 입출금 금액을 입력받습니다. 숫자가 아닌 잘못된 형식이 입력될 경우 발생하는 `InputMismatchException`을 처리하고 무효한 입력 버퍼를 폐기하세요.
* `try-catch-finally` 문을 활용하여 예외가 발생하더라도 프로그램이 비정상 종료되지 않고 정상 흐름으로 제어되도록Separation을 명확히 하세요.
* **핵심 조건:** 입출금 성공 여부나 예외 발생 여부와 관계없이, 현재 계좌의 잔액 상태가 항상 콘솔에 출력되도록 `finally` 블록을 구성해야 합니다.

---

## 📄 Problem Description (English)

In this assignment, you will integrate the `main` method directly inside the `BankAccount` class as the program's entry point instead of creating a separate execution class. You will also use `java.util.Scanner` to create an interactive program that dynamically reads user input for deposits and withdrawals.

### 1. Implement a Custom Checked Exception
* Define an `InsufficientBalanceException` class that will be thrown when a withdrawal amount exceeds the current balance.
* This class must extend the built-in `Exception` class, making it a **Checked Exception** where the compiler forces the programmer to handle it.
* Include fields and a constructor to store the current `balance` and the requested `amount` at the time of the exception.

### 2. Implement `BankAccount` Methods
* `deposit(double amount)`: If the deposit amount is `0` or negative, throw a built-in unchecked `IllegalArgumentException` to flag the programming logic error.
* `withdraw(double amount)`: If the withdrawal amount exceeds the balance, declare that this method `throws` `InsufficientBalanceException` and explicitly throw the exception using the `throw` keyword.

### 3. Handle Exceptions in the `main` Method with `finally`
* Utilize a `Scanner` to read values from the user. Handle `InputMismatchException` if a non-numeric value is entered, and discard the invalid input.
* Use `try-catch-finally` structures to cleanly separate normal logic from error processing.
* **Core Constraint:** Ensure that the current account balance is always displayed inside the `finally` block, as it executes regardless of whether an exception occurred or not.
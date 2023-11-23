// Step 1: Define Operation interface
interface Operation {
    void setNext(Operation next);
    void performOperation(double num1, double num2, String operation);
}

// Step 2: Implement Handlers
class AdditionOperation implements Operation {
    private Operation next;

    @Override
    public void setNext(Operation next) {
        this.next = next;
    }

    @Override
    public void performOperation(double num1, double num2, String operation) {
        if (operation.equals("+")) {
            System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
        } else if (next != null) {
            next.performOperation(num1, num2, operation);
        }
    }
}

// Similar implementations for Subtraction, Multiplication, and Division handlers

// Step 3: Chain Handlers
class Calculator {
    private Operation chain;

    public Calculator() {
        buildChain();
    }

    private void buildChain() {
        chain = new AdditionOperation();
        Operation subtraction = new SubtractionOperation();
        Operation multiplication = new MultiplicationOperation();
        Operation division = new DivisionOperation();

        chain.setNext(subtraction);
        subtraction.setNext(multiplication);
        multiplication.setNext(division);
    }

    public void performOperation(double num1, double num2, String operation) {
        chain.performOperation(num1, num2, operation);
    }
}


// Continuing from the previous Calculator example

// Subtraction Handler
class SubtractionOperation implements Operation {
    private Operation next;

    @Override
    public void setNext(Operation next) {
        this.next = next;
    }

    @Override
    public void performOperation(double num1, double num2, String operation) {
        if (operation.equals("-")) {
            System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
        } else if (next != null) {
            next.performOperation(num1, num2, operation);
        }
    }
}

// Multiplication Handler
class MultiplicationOperation implements Operation {
    private Operation next;

    @Override
    public void setNext(Operation next) {
        this.next = next;
    }

    @Override
    public void performOperation(double num1, double num2, String operation) {
        if (operation.equals("*")) {
            System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
        } else if (next != null) {
            next.performOperation(num1, num2, operation);
        }
    }
}

// Division Handler
class DivisionOperation implements Operation {
    private Operation next;

    @Override
    public void setNext(Operation next) {
        this.next = next;
    }

    @Override
    public void performOperation(double num1, double num2, String operation) {
        if (operation.equals("/")) {
            if (num2 != 0) {
                System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
            } else {
                System.out.println("Cannot divide by zero");
            }
        } else if (next != null) {
            next.performOperation(num1, num2, operation);
        }
    }
}

// Client Code
public class ChainOfResponsibilityExample {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // Example usage
        calculator.performOperation(5, 3, "+");
        calculator.performOperation(5, 3, "-");
        calculator.performOperation(5, 3, "*");
        calculator.performOperation(5, 0, "/"); // Division by zero example
    }
}

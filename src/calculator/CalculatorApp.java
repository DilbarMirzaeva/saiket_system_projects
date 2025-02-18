package calculator;


import static calculator.util.getInput;


public class CalculatorApp {
    public static void main(String[] args) {
        System.out.println("\t\t\t--Calculator---");
        while (true) {
            Integer choosen = getInput("""
                    You have 2 choice:
                    1.Use the calculator
                    2.Exit
                    """, Integer.class);
            while (choosen < 1 || choosen > 2) {
                choosen = getInput("Invalid number(choose 1 or 2):", Integer.class);
            }
            switch (choosen) {
                case 1:
                    System.out.println("---------");
                    System.out.println("\t" + calculate());
                    System.out.println("---------");
                    break;
                case 2:
                    return;
            }
        }
    }

    public static double calculate() {
        while (true) {
            char c = choose();
            System.out.println("---------------");
            double a = getInput("First value:", Double.class);
            System.out.println("Operation:" + c);
            double b = getInput("Second value:", Double.class);

            switch (c) {
                case '+':
                    return sum(a, b);
                case '-':
                    return subtract(a, b);
                case '*':
                    return multiply(a, b);
                case '/':
                    try {
                        return divide(a, b);
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                        break;
                    }
            }
        }
    }

    public static char choose() {
        String ch = getInput("""
                Please choose the operation : '+ , '-', '*' , '/');
                """, String.class);
        while (!"+-/*".contains(ch) || ch.length() != 1) {
            ch = getInput("Invalid entered(choose '+' , '-' , '*' or '/':", String.class);
        }
        return ch.charAt(0);
    }


    public static Double sum(Double a, Double b) {
        return a + b;
    }

    public static Double subtract(Double a, Double b) {
        return a - b;
    }

    public static Double multiply(Double a, Double b) {
        return a * b;
    }

    public static Double divide(Double a, Double b) {
        if (b == 0) {
            throw new ArithmeticException("/0 is not possible..");
        }
        return a / b;
    }
}

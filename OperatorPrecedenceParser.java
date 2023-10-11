import java.util.Stack;

public class OperatorPrecedenceParser {
    // Define operator precedence and associativity
    private static final String operators = "+-*/";
    private static final int[] precedence = {1, 1, 2, 2};  // + and - have lower precedence than * and /

    public static int evaluate(String expression) {
        String[] tokens = expression.split(" ");
        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (String token : tokens) {
            if (isNumber(token)) {
                values.push(Integer.parseInt(token));
            } else if (isOperator(token)) {
                char operator = token.charAt(0);

                while (!ops.isEmpty() && hasHigherPrecedence(ops.peek(), operator)) {
                    int b = values.pop();
                    int a = values.pop();
                    char op = ops.pop();
                    values.push(applyOperator(a, b, op));
                }

                ops.push(operator);
            }
        }

        while (!ops.isEmpty()) {
            int b = values.pop();
            int a = values.pop();
            char op = ops.pop();
            values.push(applyOperator(a, b, op));
        }

        return values.pop();
    }

    private static boolean isNumber(String token) {
        return token.matches("\\d+");
    }

    private static boolean isOperator(String token) {
        return operators.contains(token);
    }

    private static boolean hasHigherPrecedence(char op1, char op2) {
        int index1 = operators.indexOf(op1);
        int index2 = operators.indexOf(op2);
        return precedence[index1] >= precedence[index2];
    }

    private static int applyOperator(int a, int b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        String expression = "3 + 5 * 2 - 6 / 3";
        int result = evaluate(expression);
        System.out.println("Result: " + result);
    }
}

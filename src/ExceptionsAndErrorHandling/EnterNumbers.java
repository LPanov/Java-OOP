package ExceptionsAndErrorHandling;

import org.w3c.dom.ranges.RangeException;

import java.util.*;

public class EnterNumbers {
    public static boolean readNumber(String num) throws  NumberFormatException, ArithmeticException {
        int n = Integer.parseInt(num);
        if (n <= 1 || n >= 100) {
            throw new ArithmeticException();
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = new LinkedList<>();

        while (numbers.size() < 10) {
            String num = scanner.nextLine();
            try {
                if (readNumber(num)) {
                    int last = (numbers.isEmpty()) ? 0 : Integer.parseInt(numbers.getLast());
                    if (Integer.parseInt(num) == 99) {
                        numbers.addLast(num);
                        break;
                    }
                    if (Integer.parseInt(num) > last) {
                        numbers.addLast(num);
                    }
                }
            } catch (NumberFormatException nfe) {
               System.out.println("Invalid Number!");
            } catch (ArithmeticException ae) {
                if (numbers.isEmpty()) System.out.println("Your number is not in range 1 - 100!");
                else System.out.println("Your number is not in range "+numbers.getLast()+" - 100!");
            }

        }

        StringJoiner stringJoiner = new StringJoiner(", ");
        numbers.forEach(stringJoiner::add);
        System.out.println(stringJoiner);
    }
}

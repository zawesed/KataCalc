import java.util.Scanner;

public class KataCalc {
    public void start() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String[] example = scanner.nextLine().split(" ");

        if (example.length != 3) {
            throw new Exception("wrong number of elements");
        }

        String o1 = example[0];
        String o2 = example[2];
        String sign = example[1];
        boolean isRomanNotation = false;

        int n1;
        int n2;

        try {
            n1 = Integer.parseInt(o1);
            n2 = Integer.parseInt(o2);
        } catch (NumberFormatException e) {
            try {
                n1 = RomanCalc.convertFrom(o1);
                n2 = RomanCalc.convertFrom(o2);
                isRomanNotation = true;
            } catch (NoRomanNumberException ex) {
                throw new DifferentNotationException();
            }
        }

        int result = switch (sign) {
            case "+" -> n1 + n2;
            case "-" -> n1 - n2;
            case "*" -> n1 * n2;
            case "/" -> n1 / n2;
            default -> throw new WrongSingException();
        };

        if (isRomanNotation) {
            System.out.println(RomanCalc.convertTo(result));
        } else {
            System.out.println(result);
        }
    }
}

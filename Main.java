import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите числа и оператор");
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception {
        String[] oper = input.split(" ");
        if (oper.length != 3) {
            throw new Exception();
        }
        String rt = oper[0];
        boolean isRomanA = RomanNumbers.roman.containsValue(rt);
        int a;
        if (isRomanA) {
            a = getArabian(rt);
        } else {
            a = Integer.parseInt(oper[0]);
        }
        if (a > 10 || a < 1) {
            throw new Exception();
        }
        String znak = oper[1];
        String chislo = oper[2];
        boolean isRomanB = RomanNumbers.roman.containsValue(chislo);
        if ((isRomanA && !isRomanB) || (!isRomanA && isRomanB)) {
            throw new Exception();
        }
        int b;
        if (isRomanB) {
            b = getArabian(chislo);
        } else {
            b = Integer.parseInt(oper[2]);
        }
        if (b > 10 || b < 1) {
            throw new Exception();
        }
        int result;
        switch (znak) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new Exception();
        }

        if (isRomanA) {
            if (result < 0) {
                throw new Exception();
            }
            return RomanNumbers.roman.get(result);
        } else {
            return String.valueOf(result);
        }
    }

    static Integer getArabian(String roman) throws Exception {
        for (Map.Entry<Integer, String> set : RomanNumbers.roman.entrySet()) {
            if (roman.equals(set.getValue())) {
                return set.getKey();
            }
        }

        throw new Exception();
    }

}

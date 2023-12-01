import java.util.Scanner;
import java.io.*;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(part1());
        System.out.println(part2());
    }

    public static int part1() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Input.txt"));
        int total = 0;

        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String num = "";
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    num += c;
                    break;
                }
            }
            for (int i = s.length()-1; i >= 0; i--) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    num += c;
                    break;
                }
            }

            total += Integer.parseInt(num);
        }

        sc.close();
        return total;
    }

    public static int part2() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Input.txt"));
        int total = 0;
        String[] digits = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String num = "";
            boolean digit1Found = false;
            boolean digit2Found = false;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    num += c;
                    break;
                } else {
                    for (int j = 0; j < 9; j++) {
                        if (s.substring(i).startsWith(digits[j])) {
                            num += j+1;
                            digit1Found = true;
                            break;
                        }
                    }
                    if (digit1Found) {
                        break;
                    }
                }
            }
            for (int i = s.length()-1; i >= 0; i--) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    num += c;
                    break;
                } else {
                    for (int j = 0; j < 9; j++) {
                        if (s.substring(i).startsWith(digits[j])) {
                            num += j+1;
                            digit2Found = true;
                            break;
                        }
                    }
                    if (digit2Found) {
                        break;
                    }
                }
            }
            System.out.println(num);

            total += Integer.parseInt(num);
        }

        sc.close();
        return total;
    }
}

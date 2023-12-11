import java.util.*;
import java.util.stream.IntStream;
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
            String winString = s.substring(10, 40);
            String haveString = s.substring(42);
            int[] winNums = new int[10];
            int[] haveNums = new int[25];
            int power = -1;

            for (int i = 0; i < winString.length(); i+=3) {
                if (Character.isDigit(winString.charAt(i))) {
                    winNums[i/3] = Integer.parseInt(winString.substring(i, i+2));
                } else {
                    winNums[i/3] = Integer.parseInt(winString.substring(i+1, i+2));
                }
            }

            for (int i = 0; i < haveString.length(); i+=3) {
                if (Character.isDigit(haveString.charAt(i))) {
                    haveNums[i/3] = Integer.parseInt(haveString.substring(i, i+2));
                } else {
                    haveNums[i/3] = Integer.parseInt(haveString.substring(i+1, i+2));
                }
            }

            for (int i = 0; i < haveNums.length; i++) {
                for (int j = 0; j < winNums.length; j++) {
                    if (haveNums[i] == winNums[j]) {
                        power++;
                    }
                }
            }

            if (power > -1) {
                total += (Math.pow(2, power));
            }
        }

        return total;
    }

    public static int part2() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Input.txt"));
        int[] cards = new int[202];
        Arrays.fill(cards, 1);
        int counter = 0;

        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String winString = s.substring(10, 40);
            String haveString = s.substring(42);
            int[] winNums = new int[10];
            int[] haveNums = new int[25];
            int matches = 0;

            for (int i = 0; i < winString.length(); i+=3) {
                if (Character.isDigit(winString.charAt(i))) {
                    winNums[i/3] = Integer.parseInt(winString.substring(i, i+2));
                } else {
                    winNums[i/3] = Integer.parseInt(winString.substring(i+1, i+2));
                }
            }

            for (int i = 0; i < haveString.length(); i+=3) {
                if (Character.isDigit(haveString.charAt(i))) {
                    haveNums[i/3] = Integer.parseInt(haveString.substring(i, i+2));
                } else {
                    haveNums[i/3] = Integer.parseInt(haveString.substring(i+1, i+2));
                }
            }

            for (int i = 0; i < haveNums.length; i++) {
                for (int j = 0; j < winNums.length; j++) {
                    if (haveNums[i] == winNums[j]) {
                        matches++;
                    }
                }
            }

            for (int i = counter+1; i < counter+matches+1; i++) {
                for (int j = 0; j < cards[counter]; j++) {
                    cards[i]++;
                }
            }

            counter++;
        }

        return IntStream.of(cards).sum();
    }
}
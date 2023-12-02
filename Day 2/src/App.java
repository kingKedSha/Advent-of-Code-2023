import java.util.*;
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
            int gameNum = Integer.parseInt(s.substring(5, s.indexOf(':')));
            boolean possible = true;
            s = s.substring(s.indexOf(':')+1);
            String[] sets = s.split(";");

            for (String set : sets) {
                int[] nums = {0, 0, 0};
                String[] things = set.split(",");
                for (String asdf : things) {
                    if (asdf.startsWith(" ")) {
                        asdf = asdf.substring(1);
                    }
                    String fdsa = asdf.substring(asdf.indexOf(' ')+1);
                    if (fdsa.equals("red")) {
                        nums[0] += Integer.parseInt(asdf.substring(0, asdf.indexOf(' ')));
                    } else if (fdsa.equals("green")) {
                        nums[1] += Integer.parseInt(asdf.substring(0, asdf.indexOf(' ')));
                    } else {
                        nums[2] += Integer.parseInt(asdf.substring(0, asdf.indexOf(' ')));
                    }
                }

                if (nums[0] > 12 || nums[1] > 13 || nums[2] > 14) {
                    possible = false;
                }
            }

            if (possible) {
                total += gameNum;
            }
        }

        sc.close();
        return total;
    }

    public static int part2() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Input.txt"));
        int total = 0;
        
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            s = s.substring(s.indexOf(':')+1);
            String[] sets = s.split(";");
            int[] maxes = {0, 0, 0};

            for (String set : sets) {
                int[] nums = {0, 0, 0};
                String[] things = set.split(",");
                for (String asdf : things) {
                    if (asdf.startsWith(" ")) {
                        asdf = asdf.substring(1);
                    }
                    String fdsa = asdf.substring(asdf.indexOf(' ')+1);
                    if (fdsa.equals("red")) {
                        nums[0] += Integer.parseInt(asdf.substring(0, asdf.indexOf(' ')));
                    } else if (fdsa.equals("green")) {
                        nums[1] += Integer.parseInt(asdf.substring(0, asdf.indexOf(' ')));
                    } else {
                        nums[2] += Integer.parseInt(asdf.substring(0, asdf.indexOf(' ')));
                    }
                }

                for (int i = 0; i < 3; i++) {
                    maxes[i] = Math.max(maxes[i], nums[i]);
                }
            }

            int power = maxes[0] * maxes[1] * maxes[2];
            total += power;
        }

        sc.close();
        return total;
    }
}
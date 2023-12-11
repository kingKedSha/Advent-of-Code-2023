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
        int counter = 0;
        String[] lines = new String[140];

        while (sc.hasNextLine()) {
            lines[counter] = sc.nextLine();
            counter++;
        }

        counter = 0;

        for (String s : lines) {
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    boolean foundIt = false;
                    int end = i;
                    for (int j = i; j < s.length(); j++) {
                        if (Character.isDigit(s.charAt(j))) {
                            end++;
                        } else {
                            break;
                        }
                    }
                    int num = Integer.parseInt(s.substring(i, end));

                    if (counter != 0) {
                        for (int j = i; j < end; j++) {
                            if (!Character.isDigit(lines[counter-1].charAt(j)) && lines[counter-1].charAt(j) != '.') {
                                foundIt = true;
                                total += num;
                                break;
                            }
                        }
                    }
                    if (!foundIt && counter != 139) {
                        for (int j = i; j < end; j++) {
                            if (!Character.isDigit(lines[counter+1].charAt(j)) && lines[counter+1].charAt(j) != '.') {
                                foundIt = true;
                                total += num;
                                break;
                            }
                        }
                    }
                    if (!foundIt && i != 0) {
                        if (lines[counter].charAt(i-1) != '.') {
                            foundIt = true;
                            total += num;
                        }
                    }
                    if (!foundIt && end != s.length()) {
                        if (lines[counter].charAt(end) != '.') {
                            foundIt = true;
                            total += num;
                        }
                    }
                    if (!foundIt && i != 0 && counter != 0) {
                        if (!Character.isDigit(lines[counter-1].charAt(i-1)) && lines[counter-1].charAt(i-1) != '.') {
                                foundIt = true;
                                total += num;
                            }
                    }
                    if (!foundIt && i != 0 && counter != 139) {
                        if (!Character.isDigit(lines[counter+1].charAt(i-1)) && lines[counter+1].charAt(i-1) != '.') {
                                foundIt = true;
                                total += num;
                            }
                    }
                    if (!foundIt && end != s.length() && counter != 0) {
                        if (!Character.isDigit(lines[counter-1].charAt(end)) && lines[counter-1].charAt(end) != '.') {
                                foundIt = true;
                                total += num;
                            }
                    }
                    if (!foundIt && end != s.length() && counter != 139) {
                        if (!Character.isDigit(lines[counter+1].charAt(end)) && lines[counter+1].charAt(end) != '.') {
                                foundIt = true;
                                total += num;
                            }
                    }

                    i = end;
                }
            }
            counter++;
        }

        sc.close();
        return total;
    }

    public static int part2() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Input.txt"));
        int total = 0;
        int counter = 0;
        String[] lines = new String[140];
        ArrayList<Integer> gearPos = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> gearNums = new ArrayList<ArrayList<Integer>>();

        while (sc.hasNextLine()) {
            lines[counter] = sc.nextLine();
            counter++;
        }

        counter = 0;

        for (String s : lines) {
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    int end = i;
                    for (int j = i; j < s.length(); j++) {
                        if (Character.isDigit(s.charAt(j))) {
                            end++;
                        } else {
                            break;
                        }
                    }
                    int num = Integer.parseInt(s.substring(i, end));

                    if (counter != 0) {
                        for (int j = i; j < end; j++) {
                            if (lines[counter-1].charAt(j) == '*') {
                                int[] pair = {counter-1, j};
                                int pos = -1;
                                for (int k = 0; k < gearPos.size(); k+=2) {
                                    if (gearPos.get(k) == pair[0] && gearPos.get(k+1) == pair[1]) {
                                        pos = k;
                                        break;
                                    }
                                }
                                if (pos == -1) {
                                    gearPos.add(pair[0]);
                                    gearPos.add(pair[1]);
                                    ArrayList<Integer> blah = new ArrayList<Integer>();
                                    blah.add(num);
                                    gearNums.add(blah);
                                } else {
                                    ArrayList<Integer> blah = gearNums.get(pos/2);
                                    blah.add(num);
                                    gearNums.set(pos/2, blah);
                                }
                            }
                        }
                    }
                    if (counter != 139) {
                        for (int j = i; j < end; j++) {
                            if (lines[counter+1].charAt(j) == '*') {
                                int[] pair = {counter+1, j};
                                int pos = -1;
                                for (int k = 0; k < gearPos.size(); k+=2) {
                                    if (gearPos.get(k) == pair[0] && gearPos.get(k+1) == pair[1]) {
                                        pos = k;
                                        break;
                                    }
                                }
                                if (pos == -1) {
                                    gearPos.add(pair[0]);
                                    gearPos.add(pair[1]);
                                    ArrayList<Integer> blah = new ArrayList<Integer>();
                                    blah.add(num);
                                    gearNums.add(blah);
                                } else {
                                    ArrayList<Integer> blah = gearNums.get(pos/2);
                                    blah.add(num);
                                    gearNums.set(pos/2, blah);
                                }
                            }
                        }
                    }
                    if (i != 0) {
                        if (lines[counter].charAt(i-1) == '*') {
                            int[] pair = {counter, i-1};
                            int pos = -1;
                            for (int k = 0; k < gearPos.size(); k+=2) {
                                if (gearPos.get(k) == pair[0] && gearPos.get(k+1) == pair[1]) {
                                    pos = k;
                                    break;
                                }
                            }
                            if (pos == -1) {
                                gearPos.add(pair[0]);
                                gearPos.add(pair[1]);
                                ArrayList<Integer> blah = new ArrayList<Integer>();
                                blah.add(num);
                                gearNums.add(blah);
                            } else {
                                ArrayList<Integer> blah = gearNums.get(pos/2);
                                blah.add(num);
                                gearNums.set(pos/2, blah);
                            }
                        }
                    }
                    if (end != s.length()) {
                        if (lines[counter].charAt(end) == '*') {
                            int[] pair = {counter, end};
                            int pos = -1;
                            for (int k = 0; k < gearPos.size(); k+=2) {
                                if (gearPos.get(k) == pair[0] && gearPos.get(k+1) == pair[1]) {
                                    pos = k;
                                    break;
                                }
                            }
                            if (pos == -1) {
                                gearPos.add(pair[0]);
                                gearPos.add(pair[1]);
                                ArrayList<Integer> blah = new ArrayList<Integer>();
                                blah.add(num);
                                gearNums.add(blah);
                            } else {
                                ArrayList<Integer> blah = gearNums.get(pos/2);
                                blah.add(num);
                                gearNums.set(pos/2, blah);
                            }
                        }
                    }
                    if (i != 0 && counter != 0) {
                        if (lines[counter-1].charAt(i-1) == '*') {
                            int[] pair = {counter-1, i-1};
                            int pos = -1;
                            for (int k = 0; k < gearPos.size(); k+=2) {
                                if (gearPos.get(k) == pair[0] && gearPos.get(k+1) == pair[1]) {
                                    pos = k;
                                    break;
                                }
                            }
                            if (pos == -1) {
                                gearPos.add(pair[0]);
                                gearPos.add(pair[1]);
                                ArrayList<Integer> blah = new ArrayList<Integer>();
                                blah.add(num);
                                gearNums.add(blah);
                            } else {
                                ArrayList<Integer> blah = gearNums.get(pos/2);
                                blah.add(num);
                                gearNums.set(pos/2, blah);
                            }
                        }
                    }
                    if (i != 0 && counter != 139) {
                        if (lines[counter+1].charAt(i-1) == '*') {
                            int[] pair = {counter+1, i-1};
                            int pos = -1;
                            for (int k = 0; k < gearPos.size(); k+=2) {
                                if (gearPos.get(k) == pair[0] && gearPos.get(k+1) == pair[1]) {
                                    pos = k;
                                    break;
                                }
                            }
                            if (pos == -1) {
                                gearPos.add(pair[0]);
                                gearPos.add(pair[1]);
                                ArrayList<Integer> blah = new ArrayList<Integer>();
                                blah.add(num);
                                gearNums.add(blah);
                            } else {
                                ArrayList<Integer> blah = gearNums.get(pos/2);
                                blah.add(num);
                                gearNums.set(pos/2, blah);
                            }
                        }
                    }
                    if (end != s.length() && counter != 0) {
                        if (lines[counter-1].charAt(end) == '*') {
                            int[] pair = {counter-1, end};
                            int pos = -1;
                            for (int k = 0; k < gearPos.size(); k+=2) {
                                if (gearPos.get(k) == pair[0] && gearPos.get(k+1) == pair[1]) {
                                    pos = k;
                                    break;
                                }
                            }
                            if (pos == -1) {
                                gearPos.add(pair[0]);
                                gearPos.add(pair[1]);
                                ArrayList<Integer> blah = new ArrayList<Integer>();
                                blah.add(num);
                                gearNums.add(blah);
                            } else {
                                ArrayList<Integer> blah = gearNums.get(pos/2);
                                blah.add(num);
                                gearNums.set(pos/2, blah);
                            }
                        }
                    }
                    if (end != s.length() && counter != 139) {
                        if (lines[counter+1].charAt(end) == '*') {
                            int[] pair = {counter+1, end};
                            int pos = -1;
                            for (int k = 0; k < gearPos.size(); k+=2) {
                                if (gearPos.get(k) == pair[0] && gearPos.get(k+1) == pair[1]) {
                                    pos = k;
                                    break;
                                }
                            }
                            if (pos == -1) {
                                gearPos.add(pair[0]);
                                gearPos.add(pair[1]);
                                ArrayList<Integer> blah = new ArrayList<Integer>();
                                blah.add(num);
                                gearNums.add(blah);
                            } else {
                                ArrayList<Integer> blah = gearNums.get(pos/2);
                                blah.add(num);
                                gearNums.set(pos/2, blah);
                            }
                        }
                    }

                    i = end;
                }
            }
            counter++;
        }

        for (int i = 0; i < gearNums.size(); i++) {
            ArrayList<Integer> blah = gearNums.get(i);
            if (blah.size() == 2) {
                int mult = blah.get(0) * blah.get(1);
                total += mult;
            }
        }

        sc.close();
        return total;
    }
}
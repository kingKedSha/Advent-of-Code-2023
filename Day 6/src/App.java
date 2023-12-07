public class App {
    public static void main(String[] args) {
        System.out.println(part1());
        System.out.println(part2());
    }

    public static int part1() {
        int total = 1;
        // int[][] inp = {{7, 9}, {15, 40}, {30, 200}};
        int[][] inp = {{44, 277}, {89, 1136}, {96, 1890}, {91, 1768}};

        for (int i = 0; i < inp.length; i++) {
            int counter = 0;
            for (int j = 0; j <= inp[i][0]; j++) {
                int blah = j*(inp[i][0]-j);
                if (blah > inp[i][1]) {
                    counter++;
                }
            }
            total *= counter;
        }

        return total;
    }

    public static double part2() {
        double total = 0;
        // double[] inp = {71530, 940200};
        double[] inp = {44899691.0, 277113618901768.0};
        for (double i = 0.0; i < inp[0]; i++) {
            if (i*(inp[0]-i) > inp[1]) {
                total++;
            }
        }
        return total;
    }
}

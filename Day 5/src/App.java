import java.util.*;
import java.io.*;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        // System.out.println(part1());
        System.out.println(part2());
    }

    public static double part1() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Input.txt"));

        String[] seedString = sc.nextLine().substring(7).split(" ");
        double[] seeds = new double[seedString.length];
        for (int i = 0; i < seeds.length; i++) {
            seeds[i] = Double.parseDouble(seedString[i]);
        }

        sc.nextLine();
        sc.nextLine();
        
        double[][] soil = new double[14][3];
        for (int i = 0; i < 14; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                soil[i][j] = Double.parseDouble(s[j]);
            }
        }

        sc.nextLine();
        sc.nextLine();

        double[][] fertilizer = new double[11][3];
        for (int i = 0; i < 11; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                fertilizer[i][j] = Double.parseDouble(s[j]);
            }
        }

        sc.nextLine();
        sc.nextLine();
        
        double[][] water = new double[34][3];
        for (int i = 0; i < 34; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                water[i][j] = Double.parseDouble(s[j]);
            }
        }

        sc.nextLine();
        sc.nextLine();
        
        double[][] light = new double[30][3];
        for (int i = 0; i < 30; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                light[i][j] = Double.parseDouble(s[j]);
            }
        }

        sc.nextLine();
        sc.nextLine();
        
        double[][] temperature = new double[43][3];
        for (int i = 0; i < 43; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                temperature[i][j] = Double.parseDouble(s[j]);
            }
        }
        sc.nextLine();
        sc.nextLine();
        
        double[][] humidity = new double[46][3];
        for (int i = 0; i < 46; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                humidity[i][j] = Double.parseDouble(s[j]);
            }
        }

        sc.nextLine();
        sc.nextLine();
        
        double[][] location = new double[20][3];
        for (int i = 0; i < 20; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                location[i][j] = Double.parseDouble(s[j]);
            }
        }

        double min = 100000000000.0;

        for (int i = 0; i < seeds.length; i++) {
            double cur = seeds[i];
            for (int j = 0; j < soil.length; j++) {
                if (cur >= soil[j][1] && cur < soil[j][1] + soil[j][2]) {
                    cur = soil[j][0] + cur - soil[j][1];
                    break;
                }
            }
            for (int j = 0; j < fertilizer.length; j++) {
                if (cur >= fertilizer[j][1] && cur < fertilizer[j][1] + fertilizer[j][2]) {
                    cur = fertilizer[j][0] + cur - fertilizer[j][1];
                    break;
                }
            }
            for (int j = 0; j < water.length; j++) {
                if (cur >= water[j][1] && cur < water[j][1] + water[j][2]) {
                    cur = water[j][0] + cur - water[j][1];
                    break;
                }
            }
            for (int j = 0; j < light.length; j++) {
                if (cur >= light[j][1] && cur < light[j][1] + light[j][2]) {
                    cur = light[j][0] + cur - light[j][1];
                    break;
                }
            }
            for (int j = 0; j < temperature.length; j++) {
                if (cur >= temperature[j][1] && cur < temperature[j][1] + temperature[j][2]) {
                    cur = temperature[j][0] + cur - temperature[j][1];
                    break;
                }
            }
            for (int j = 0; j < humidity.length; j++) {
                if (cur >= humidity[j][1] && cur < humidity[j][1] + humidity[j][2]) {
                    cur = humidity[j][0] + cur - humidity[j][1];
                    break;
                }
            }
            for (int j = 0; j < location.length; j++) {
                if (cur >= location[j][1] && cur < location[j][1] + location[j][2]) {
                    cur = location[j][0] + cur - location[j][1];
                    break;
                }
            }
            min = Math.min(cur, min);
        }

        sc.close();
        return min;
    }

    public static double part2() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Input.txt"));

        String[] seedString = sc.nextLine().substring(7).split(" ");
        double[][] seeds = new double[seedString.length/2][2];
        for (int i = 0; i < seedString.length; i+=2) {
            seeds[i/2][0] = Double.parseDouble(seedString[i]);
            seeds[i/2][1] = Double.parseDouble(seedString[i+1]);
        }

        sc.nextLine();
        sc.nextLine();
        
        double[][] soil = new double[14][3];
        for (int i = 0; i < 14; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                soil[i][j] = Double.parseDouble(s[j]);
            }
        }

        sc.nextLine();
        sc.nextLine();

        double[][] fertilizer = new double[11][3];
        for (int i = 0; i < 11; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                fertilizer[i][j] = Double.parseDouble(s[j]);
            }
        }

        sc.nextLine();
        sc.nextLine();
        
        double[][] water = new double[34][3];
        for (int i = 0; i < 34; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                water[i][j] = Double.parseDouble(s[j]);
            }
        }

        sc.nextLine();
        sc.nextLine();
        
        double[][] light = new double[30][3];
        for (int i = 0; i < 30; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                light[i][j] = Double.parseDouble(s[j]);
            }
        }

        sc.nextLine();
        sc.nextLine();
        
        double[][] temperature = new double[43][3];
        for (int i = 0; i < 43; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                temperature[i][j] = Double.parseDouble(s[j]);
            }
        }
        sc.nextLine();
        sc.nextLine();
        
        double[][] humidity = new double[46][3];
        for (int i = 0; i < 46; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                humidity[i][j] = Double.parseDouble(s[j]);
            }
        }

        sc.nextLine();
        sc.nextLine();
        
        double[][] location = new double[20][3];
        for (int i = 0; i < 20; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                location[i][j] = Double.parseDouble(s[j]);
            }
        }

        double min = 100000000000.0;

        for (int i = 0; i < seeds.length; i++) {
            for (double k = seeds[i][0]; k < seeds[i][0] + seeds[i][1]; k++) {
                double cur = k;
                System.out.println(k);
                for (int j = 0; j < soil.length; j++) {
                    if (cur >= soil[j][1] && cur < soil[j][1] + soil[j][2]) {
                        cur = soil[j][0] + cur - soil[j][1];
                        break;
                    }
                }
                for (int j = 0; j < fertilizer.length; j++) {
                    if (cur >= fertilizer[j][1] && cur < fertilizer[j][1] + fertilizer[j][2]) {
                        cur = fertilizer[j][0] + cur - fertilizer[j][1];
                        break;
                    }
                }
                for (int j = 0; j < water.length; j++) {
                    if (cur >= water[j][1] && cur < water[j][1] + water[j][2]) {
                        cur = water[j][0] + cur - water[j][1];
                        break;
                    }
                }
                for (int j = 0; j < light.length; j++) {
                    if (cur >= light[j][1] && cur < light[j][1] + light[j][2]) {
                        cur = light[j][0] + cur - light[j][1];
                        break;
                    }
                }
                for (int j = 0; j < temperature.length; j++) {
                    if (cur >= temperature[j][1] && cur < temperature[j][1] + temperature[j][2]) {
                        cur = temperature[j][0] + cur - temperature[j][1];
                        break;
                    }
                }
                for (int j = 0; j < humidity.length; j++) {
                    if (cur >= humidity[j][1] && cur < humidity[j][1] + humidity[j][2]) {
                        cur = humidity[j][0] + cur - humidity[j][1];
                        break;
                    }
                }
                for (int j = 0; j < location.length; j++) {
                    if (cur >= location[j][1] && cur < location[j][1] + location[j][2]) {
                        cur = location[j][0] + cur - location[j][1];
                        break;
                    }
                }
                min = Math.min(cur, min);
            }
        }

        sc.close();
        return min;
    }
}
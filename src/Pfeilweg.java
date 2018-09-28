import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.nanoTime;

public class Pfeilweg {
    static int ziel;
    static int schritte;
    static long anzahlWege;
    static Long[][][] memory;    //x| y|  schritte noch machbar| speichert

    public static void main(String[] args) {
        System.out.println("durchgänge eingeben");
        Scanner scanner = new Scanner(System.in);
        int durchläufe = scanner.nextInt();
        scanner.close();
        for (int n = 0; n < durchläufe; n++) {
            ziel = n;
            schritte = 2 * ziel;
            memory = new Long[schritte + 1][schritte + 1][schritte + 1];
            long anfang = nanoTime();

            anzahlWege = laufschritt(0, 0, schritte);
            long ende = nanoTime();

            long dauer = ende - anfang;

            System.out.println("ziel: " + ziel + " wege: " + anzahlWege /*+ " dauer: " + dauer / 1e9 + "sec"*/);
            Arrays.fill(memory, null);

        }
    }

    public static long laufschritt(int x, int y, int n) {
        if (x < 0 || y < 0) {
            return 0;
        } else {
            if (memory[x][y][n] != null) {
                if (memory[x][y][n] > 0) {
                    return memory[x][y][n];
                } else {
                    return 0;
                }
            }


            if (y == ziel && x == 0 && n == 0) {
                memory[x][y][n] = 1l;
                return 1;


            } else if (n == 0) {
                memory[x][y][n] = 0l;
                return 0;

            } else if (n == x && n == ziel - y) {
                memory[x][y][n] = 1l;
                return 1;
            } else if (y >= 0 && x >= 0 && n >= x && n >= ziel - y) {
                long richtigeWege;
                //hoch
                richtigeWege =
                        laufschritt(x, y + 1, n - 1) +
                                //runter
                                laufschritt(x, y - 1, n - 1) +
                                //rechts
                                laufschritt(x + 1, y, n - 1) +
                                //links hoch
                                laufschritt(x - 1, y + 1, n - 1);
                memory[x][y][n] = richtigeWege;
                return richtigeWege;


            }
        }

        return 0;
    }
}




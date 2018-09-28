import java.math.BigInteger;
import java.util.Scanner;

import static java.lang.System.nanoTime;

public class Pfeilweg {
    static int ziel;
    static int schritte;
    static BigInteger anzahlWege;
    static BigInteger[][][] memory;    //x| y|  schritte noch machbar| speichert

    public static void main(String[] args) {
        System.out.println("Ziel eingeben");
            Scanner scanner = new Scanner(System.in);
            ziel = scanner.nextInt();
            scanner.close();
            schritte = 2 * ziel;
            memory=new BigInteger[schritte+1][schritte+1][schritte+1];
            long anfang = nanoTime();

            anzahlWege= laufschritt(0, 0, schritte);
            long ende = nanoTime();

            long dauer = ende - anfang;

            System.out.println("ziel: "+ziel +" wege: " + anzahlWege + " dauer: " + dauer/1e9+ "sec");
        }


    public static BigInteger laufschritt(int x, int y, int n) {
        if(x<0||y<0){
            return BigInteger.ZERO;
        }
        else {
            if (memory[x][y][n] != null) {
                if (memory[x][y][n].compareTo(BigInteger.ZERO)==1) {
                    return memory[x][y][n];
                } else {
                    return BigInteger.ZERO;
                }
            }


            if (y == ziel && x == 0 && n == 0) {
                memory[x][y][n] = BigInteger.ONE;
                return BigInteger.ONE;


            } else if (n == 0) {
                memory[x][y][n] = BigInteger.ZERO;
                return BigInteger.ZERO;

            } else if (n == x && n == ziel - y) {
                memory[x][y][n] = BigInteger.ONE;
                return BigInteger.ONE;
            } else if (y >= 0 && x >= 0 && n >= x && n >= ziel - y) {
                BigInteger richtigeWege;
                //hoch
                richtigeWege =
                        laufschritt(x, y + 1, n - 1) .add(
                                //runter
                                laufschritt(x, y - 1, n - 1)).add(
                                //rechts
                                laufschritt(x + 1, y, n - 1)).add(
                                //links hoch
                                laufschritt(x - 1, y + 1, n - 1));
                memory[x][y][n] = richtigeWege;
                return richtigeWege;


            }
        }

        return BigInteger.ZERO;
    }
}




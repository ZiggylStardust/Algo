import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.nanoTime;

public class BruteForcePfeile {

    static int ziel;
    static long anzahlWege;

    public static void main(String[] args) {



        System.out.println("Ziel eingeben");
        Scanner scanner = new Scanner(System.in);
        ziel = scanner.nextInt();
        scanner.close();
            long anfang = nanoTime();

            laufschritt(0, 0, 2*ziel, "");
            long ende = nanoTime();

            long dauer = ende - anfang;

            System.out.println("ziel: " + ziel + " wege: " + anzahlWege + " dauer: " + dauer / 1e9 + "sec");
            anzahlWege = 0;
            System.out.println();


    }

    /**
     * Methode berechnet die anzahl möglicher werte
     *
     * @param x    x position
     * @param y    y position
     * @param n    anzahl an schritte, die noch möglich sind.
     * @param wege String der bewegungen, die durchgeführt werden. wird zu array hinzugefügt, wenn ziel erreicht wird
     */
    public static void laufschritt(int x, int y, int n, String wege) {

        if (x >= 0 && y >= 0&&n>=0) {                   //Wenn x oder y negativ sind, ist der weg unmöglich.


            if (y == ziel && x == 0 && n == 0) {                        //falls das ziel erreicht wird mit 2n schritten

                anzahlWege++;
                System.out.println(wege);

            } else if (n >= x && n >= ziel - y) {                       //wenn übrige schritte kleiner als weg nach links oder zum ziel nach oben sind, ist es unmöglich das tziel zu erreichen

                //hoch
                laufschritt(x, y + 1, n - 1, wege + "↑");
                //runter
                laufschritt(x, y - 1, n - 1, wege + "↓");
                //rechts
                laufschritt(x + 1, y, n - 1, wege + "→");
                //links hoch
                laufschritt(x - 1, y + 1, n - 1, wege + "↖");
            }

        }


    }
}
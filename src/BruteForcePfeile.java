import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.nanoTime;

public class BruteForcePfeile {

    static int ziel;
    static int schritte;
    static long anzahlWege;
    static ArrayList<String> möglichewge;

    public static void main(String[] args) {


        System.out.println("Ziel eingeben");
        Scanner scanner = new Scanner(System.in);
        int anzahl = scanner.nextInt();
        scanner.close();
        for (int n = 0; n < anzahl; n++) {
            möglichewge = new ArrayList<>();
            ziel = n;
            schritte = 2 * ziel;
            long anfang = nanoTime();

            laufschritt(0, 0, schritte, "");
            long ende = nanoTime();

            long dauer = ende - anfang;

            System.out.println("ziel: " + ziel + " wege: " + anzahlWege + " dauer: " + dauer / 1e9 + "sec");
            anzahlWege = 0;
            System.out.println(möglichewge);
            System.out.println();

        }
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

        if (x >= 0 && y >= 0) {                   //Wenn x oder y negativ sind, ist der weg unmöglich.


            if (y == ziel && x == 0 && n == 0) {                        //falls das ziel erreicht wird mit 2n schritten

                anzahlWege++;
                möglichewge.add(wege);


            } else if (n >= x && n >= ziel - y) {                       //wenn übrige schritte kleiner als weg nach links oder zum ziel nach oben sind, ist es unmöglich das tziel zu erreichen

                //hoch
                laufschritt(x, y + 1, n - 1, wege + "hoch ");
                //runter
                laufschritt(x, y - 1, n - 1, wege + "runter ");
                //rechts
                laufschritt(x + 1, y, n - 1, wege + "rechts ");
                //links hoch
                laufschritt(x - 1, y + 1, n - 1, wege + "linkshoch ");

            }

        }


    }
}
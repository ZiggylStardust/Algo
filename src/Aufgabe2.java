import java.util.Scanner;

import static java.lang.System.nanoTime;

/**
 * Algo aufgabe 1, bis 08.10.2018
 *
 * @author Tobias Fetzer 198318
 * @version 1.0
 * @date 28/09/18
 */
public class Aufgabe2 {
    static int ziel;
    static long anzahlWege;

    public static void main(String[] args) {


        System.out.println("Ziel eingeben");
        Scanner scanner = new Scanner(System.in);
        ziel = scanner.nextInt();
        scanner.close();
        long anfang = nanoTime();

        laufschritt(0, 0, 0);
        long ende = nanoTime();

        long dauer = ende - anfang;

        System.out.println("ziel: " + ziel + " wege: " + anzahlWege + " dauer: " + dauer / 1e9 + "sec");
        anzahlWege = 0;
        System.out.println();


    }

    /**
     * Methode berechnet die anzahl möglicher werte
     *
     * @param x x position
     * @param y y position
     */
    public static void laufschritt(int x, int y, int last) {

        if (x >= 0 && y >= 0) {                   //Wenn x oder y negativ sind, ist der weg unmöglich.


            if (y == ziel && x == 0) {                        //falls das ziel erreicht wird mit 2n schritten

                anzahlWege++;

            } else {                       //wenn übrige schritte kleiner als weg nach links oder zum ziel nach oben sind, ist es unmöglich das tziel zu erreichen

                if (last == 2 || last == 5)
                    laufschritt(x, y + 1,  1);
                //rechts
                if (last == 0)
                    laufschritt(x + 1, y,  2);
                //links hoch
                if (last == 4)
                    laufschritt(x - 1, y + 1,  3);
                //rechts runter
                if (last == 3)
                    laufschritt(x + 1, y - 1,  4);
                //rechts hoch
                if (last == 1)
                    laufschritt(x + 1, y + 1,  5);

            }

        }


    }

}





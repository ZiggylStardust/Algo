import java.math.BigInteger;
import java.util.Scanner;

import static java.lang.System.nanoTime;

/**
 * Algo aufgabe 1, bis 08.10.2018
 *
 * @author Tobias Fetzer 198318
 * @version 1.0
 * @date 28/09/18
 */
public class Pfeilweg {
    static int ziel;
    static int schritte;
    static BigInteger anzahlWege;
    static BigInteger[][][] memory;    //x| y|  schritte noch machbar| speichert die anzahl an wege, die von diesem punkt bei dieser anzahl an übrigen schrittten möglich sind

    public static void main(String[] args) {

        System.out.println("Ziel eingeben");
        Scanner scanner = new Scanner(System.in);
        int anzahl = scanner.nextInt();
        scanner.close();
        for (int n = 0; n < anzahl; n++) {
            ziel = n;
            schritte = 2 * ziel;
            memory = new BigInteger[schritte + 1][schritte + 1][schritte + 1];
            long anfang = nanoTime();

            anzahlWege = laufschritt(0, 0, schritte);
            long ende = nanoTime();

            long dauer = ende - anfang;

            System.out.println("ziel: " + ziel + " wege: " + anzahlWege + " dauer: " + dauer / 1e9 + "sec");

        }
    }

    /**
     * Methode berechnet die anzahl möglicher werte
     *
     * @param x x position
     * @param y y position
     * @param n anzahl an schritte, die noch möglich sind.
     * @return //anzahl an möglichenw wegen von der derzeitigen position mit der derzeitigen anzahl an übrigen schritten
     */
    public static BigInteger laufschritt(int x, int y, int n) {

        if (x < 0 || y < 0) {                   //Wenn x oder y negativ sind, ist der weg unmöglich.
            return BigInteger.ZERO;
        } else {
            if (memory[x][y][n] != null) {                              //Wenn der wert null ist, war noch kein pfad da
                if (memory[x][y][n].compareTo(BigInteger.ZERO) == 1) {      //Wenn es größer als 0 ist, dann hat der pfad so viele wege
                    return memory[x][y][n];                             //gibt die pfade zurück
                } else {
                    return BigInteger.ZERO;                             //gibt 0 zurück, wenn es der pfad zu keinem ziel führt
                }
            }


            if (y == ziel && x == 0 && n == 0) {                        //falls das ziel erreicht wird mit 2n schritten
                memory[x][y][n] = BigInteger.ONE;
                return BigInteger.ONE;                                  //wert in memory auf 1 setzen, 1 returnen da von diser position 1 weg möglich ist (das ziel ist bereits erreicht)


            } else if (n == 0) {                                        //wenn mit 2n bewegungen das ziel nicht erreicht ist, wird 0 zurückgegeben und memory auf 0 gesetzt
                memory[x][y][n] = BigInteger.ZERO;
                return BigInteger.ZERO;

            } else if (n == x && n == ziel - y) {                       //spezifischer fall, wenn übrige schritte=weg zum ziel hoch=weg zum ziel nach links. Nur noch 1 weg möglich (immer links hoch)
                memory[x][y][n] = BigInteger.ONE;
                return BigInteger.ONE;
            } else if (n >= x && n >= ziel - y) {                       //wenn übrige schritte kleiner als weg nach links oder zum ziel nach oben sind, ist es unmöglich das tziel zu erreichen
                BigInteger richtigeWege;
                richtigeWege =
                        /*
                         * geht einen rekursiv einen schritt in jede richtung
                         * und addiert die anzahl an möglichen werten, die zurückgegeben werden
                         * gibt diesen wert zurück
                         * */

                        //hoch
                        laufschritt(x, y + 1, n - 1).add(
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





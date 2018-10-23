package Aufgabe2;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Algo aufgabe 2, bis 22.10.2018
 *
 * @author Tobias Fetzer 198318
 * @version 1.0
 * @date 20/10/18
 */
public class Walks {
  static int ziel;
  static BigInteger[][][] cache;      //Cache, Felder sind x, y und der letzte schritt, gezeigt als integer zwischen 1 und 5

  public static void main(String[] args) {


    System.out.println("Ziel eingeben");
    Scanner scanner = new Scanner(System.in);
    ziel = scanner.nextInt();
    scanner.close();
    cache = new BigInteger[ziel + 1][ziel + 1][6];

    BigInteger anzahlWege = laufschritt(0, 0, 0);

    System.out.println("ziel: " + ziel + ", wege: " + anzahlWege /*+ "\ndauer: " + dauer / 1e9 + "sec"*/);
  }


  /**
   * Methode berechnet die anzahl möglicher werte.
   *
   * @param x x position
   * @param y y position
   */
  public static BigInteger laufschritt(int x, int y, int last) {

    if (x >= 0 && y >= 0 && x + y <= ziel) {                   //Wenn x oder y negativ sind, ist der weg unmöglich.

      if (cache[x][y][last] != null) {
        return cache[x][y][last];
      }


      if (y == 0 && x == ziel) {                        //falls das ziel erreicht wird
        cache[x][y][last] = BigInteger.ONE;
        return BigInteger.ONE;


      } else {

        BigInteger ergbniss =
            BigInteger.ZERO.add(last == 2 || last == 5 ? BigInteger.ZERO :

                laufschritt(x, y + 1, 1)).add(last == 1 ? BigInteger.ZERO :                        //hoch

                laufschritt(x + 1, y, 2)).add(last == 4 ? BigInteger.ZERO :                        //rechts

                laufschritt(x - 1, y + 1, 3)).add(last == 3 ? BigInteger.ZERO :                        //links hoch

                laufschritt(x + 1, y - 1, 4)).add(last == 1 ? BigInteger.ZERO :                        //rechts runter

                laufschritt(x + 1, y + 1, 5));                        //rechts hoch

        cache[x][y][last] = ergbniss;


        return ergbniss;
      }


    }
    return BigInteger.ZERO;


  }

}





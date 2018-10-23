package Aufgabe4;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Algo aufgabe 2, bis 22.10.2018
 *
 * @author Tobias Fetzer 198318
 * @version 1.0
 * @date 20/10/18
 */
public class Walks2 {
  static int ziel;
  static BigInteger[][][][] cache;      //Cache, Felder sind x, y und der letzte schritt, gezeigt als integer zwischen 1 und 5
  // und ob wege oder punkte, 0 ist punkte, 1 ist wege

  public static void main(String[] args) {


    System.out.println("Ziel eingeben");
    Scanner scanner = new Scanner(System.in);
    ziel = scanner.nextInt();
    scanner.close();
    cache = new BigInteger[ziel + 1][ziel + 1][6][2];

    BigInteger anzahlWege[] = laufschritt(0, 0, 0);

    System.out.println("ziel: " + ziel + ", punkte: " + anzahlWege[0] /*+ "\ndauer: " + dauer / 1e9 + "sec"*/);

  }


  /**
   * Methode berechnet die anzahl möglicher werte.
   *
   * @param x x position
   * @param y y position
   * @return erste stelle sind die anzahl punkte, 2. anzahl wege
   */
  public static BigInteger[] laufschritt(int x, int y, int last) {


    if (x >= 0 && y >= 0 && x + y <= ziel) {                   //Wenn x oder y negativ sind, ist der weg unmöglich.

      if (cache[x][y][last][0] != null) {

        return new BigInteger[]{cache[x][y][last][0],cache[x][y][last][1]};
      }


      if (y == 0 && x == ziel) {                        //falls das ziel erreicht wird
        cache[x][y][last][0] = BigInteger.ONE;
        cache[x][y][last][1] = BigInteger.ONE;
        return new BigInteger[]{BigInteger.ONE,BigInteger.ONE};


      } else {

        ArrayList<BigInteger[]> erg = new ArrayList<>();

        BigInteger punkte = BigInteger.ZERO;
        BigInteger wege=BigInteger.ZERO;
        if ((last != 2 && last != 5))
          erg.add(laufschritt(x, y + 1, 1));                      //hoch

        if (last != 1)
          erg.add(laufschritt(x + 1, y, 2));                       //rechts

        if (last != 4)
          erg.add(laufschritt(x - 1, y + 1, 3));                      //links hoch

        if (last != 3)
          erg.add(laufschritt(x + 1, y - 1, 4));                       //rechts runter
        if (last != 1)
          erg.add(laufschritt(x + 1, y + 1, 5));                        //rechts hoch

        //Addiert die Punkte zusammen, und addiert die wege darauf, da so oft durch den derzeitigen punkt gegangen wird
        for (BigInteger[] i : erg) {
          if (!(i.equals(BigInteger.ZERO))) {
            punkte = punkte.add(i[0]).add(i[1]);
            wege=wege.add(i[1]);

          }
        }
        cache[x][y][last][0] = punkte;
        cache[x][y][last][1] = wege;



        return new BigInteger[]{punkte,wege};
      }


    }
    return new BigInteger[]{BigInteger.ZERO,BigInteger.ZERO};


  }

}





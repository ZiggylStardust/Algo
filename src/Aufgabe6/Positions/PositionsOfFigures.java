package Aufgabe6.Positions;

import Aufgabe6.Positions.Figures.DominoFigure;
import Aufgabe6.Positions.Figures.TFigure;
import Aufgabe6.Positions.Figures.XFigure;
import Aufgabe6.Positions.Figures.YFigure;

import java.util.ArrayList;

/**
 * @Author Tobias Fetzer 198318
 * Class creates the array of ints, which represent the positions in the field that are filled by a figure
 */
public class PositionsOfFigures {
  public int[][] feld;
  public ArrayList<int[]> positionen = new ArrayList<>();
  public int n;
  public ArrayList<Figure> figures = new ArrayList<>();

  /**
   * Construktor, adds figures to arrayList and generates field.
   *
   * @param n number of Columns
   */
  public PositionsOfFigures(int n) {
    this.n = n;
    feld = new int[6][n]; //6 nach unten
    int zähler = 1;
    figures.add(new DominoFigure());
    figures.add(new XFigure());
    figures.add(new YFigure());
    figures.add(new TFigure());
    for (int y = 0; y < 6; y++) {
      for (int x = 0; x < n; x++, zähler++) {
        feld[y][x] = zähler;
      }
    }

  }

  /**
   * Creates the ArrayList of the positions for every figure
   *
   * @return the Arraylist of a containing the positions that every figure can take
   */
  public ArrayList<int[]> createPositions() {
    for (int y = 0; y < 6; y++) {
      for (int x = 0; x < n; x++) {
        for (Figure figure : figures) {
          while (figure.position < figure.size) {

            positionen.add(matchfigur(figure.rotate(), x, y));
          }
          figure.position = 0;

        }

      }
    }
    positionen.removeIf(i -> i == null);
    return positionen;


  }

  /**
   * Creates the int[] of a single figure, the position it has in the field
   *
   * @param figur the figure being worked on
   * @param x     the current x position in the field
   * @param y     the current y position in the field
   * @return the int[] of the figure
   */
  public int[] matchfigur(boolean[][] figur, int x, int y) {
    ArrayList<Integer> positionen = new ArrayList<>(5);
    int k = 0;
    if (figur.length + y > 6 || figur[0].length + x > n) {
      return null;
    }

    for (int i = 0; i < figur.length; i++) {
      for (int j = 0; j < figur[0].length; j++) {
        if (figur[i][j]) {
          positionen.add(feld[i + y][j + x]);
        }
      }
    }
    return positionen.stream().mapToInt(i -> i).toArray();


  }
}

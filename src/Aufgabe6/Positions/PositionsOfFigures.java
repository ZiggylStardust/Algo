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
  public int[][] field;    //The field, filled with numbers from 1 to n*6
  public ArrayList<int[]> positions = new ArrayList<>(); /*result ArrayList, represents every possible
                                                          orientation of the figures in the field*/
  public int n;
  public ArrayList<Figure> figures = new ArrayList<>();   //ArrayList of the Figure Classes, the T,Y,X and domino

  /**
   * Constructor, adds figures to arrayList and generates field.
   *
   * @param n number of Columns
   */
  public PositionsOfFigures(int n) {
    this.n = n;
    field = new int[6][n]; //6 down
    int zähler = 1;
    figures.add(new DominoFigure());
    figures.add(new XFigure());
    figures.add(new YFigure());
    figures.add(new TFigure());
    for (int y = 0; y < 6; y++) {
      for (int x = 0; x < n; x++, zähler++) {
        field[y][x] = zähler;
      }
    }

  }

  /**
   * Creates the ArrayList of the positions for every figure and it's orientations
   *
   * @return the ArrayList of a containing the positions/orientations that every figure can take
   */
  public ArrayList<int[]> createPositions() {
    for (int y = 0; y < 6; y++) {
      for (int x = 0; x < n; x++) {
        for (Figure figure : figures) {
          while (figure.orientation < figure.numberOfOrientations) {

            positions.add(matchFigure(figure.rotate(), x, y));
          }
          figure.orientation = 0;
        }

      }
    }
    positions.removeIf(i -> i == null);
    return positions;


  }

  /**
   * Creates the int[] of a single figure, the orientation it has in the field
   *
   * @param figure  the current orientation of the figure being worked on
   * @param x       the current x position in the field
   * @param y       the current y position in the field
   * @return        the position of the figure in the field, represented as an int[] showing which parts of the
   *                field are covered by it. Returns Null if the orientation doesn't fit in the field
   */
  public int[] matchFigure(boolean[][] figure, int x, int y) {
    ArrayList<Integer> position = new ArrayList<>(5);
    int k = 0;
    if (figure.length + y > 6 || figure[0].length + x > n) {
      return null;
    }

    for (int i = 0; i < figure.length; i++) {
      for (int j = 0; j < figure[0].length; j++) {
        if (figure[i][j]) {
          position.add(field[i + y][j + x]);
        }
      }
    }
    return position.stream().mapToInt(i -> i).toArray();


  }
}

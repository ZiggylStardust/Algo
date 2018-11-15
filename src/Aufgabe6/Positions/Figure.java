package Aufgabe6.Positions;

import java.util.ArrayList;

/**
 * @Author Tobias Fetzer 198318
 * Represents a generic figure, all specific figures inherit from it.
 * A figure is represented as an arrayList of boolean[][], each boolean[][] representing one orientation of it
 */
public class Figure {
  public int orientation;
  public int numberOfOrientations;
  public ArrayList<boolean[][]> orientationsOfFigure;


  /**
   * Rotates the orientationsOfFigure by calling the next orientation of the array
   *
   * @return the next orientation
   */
  public boolean[][] rotate() {
    return orientationsOfFigure.get(orientation++);
  }


}
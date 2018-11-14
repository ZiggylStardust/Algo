package Aufgabe6.Positions;

import java.util.ArrayList;

/**
 * @Author Tobias Fetzer 198318
 * Represnts a figure, all specific figures inherit from it.
 */
public class Figure {
  public int position;
  public int size;
  public ArrayList<boolean[][]> figure ;


  /**
   * Rotates the figure by calling the next figure the array
   * @return  the next figure
   */
  public boolean[][] rotate(){
    return figure.get(position++);
 }


}
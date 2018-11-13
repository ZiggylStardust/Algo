package Aufgabe6.Positions;

import java.util.ArrayList;

public class Figure {
  public int position;
  public int size;
  public ArrayList<boolean[][]> figure ;


  public boolean[][] rotate(){
    return figure.get(position++);
 }


}
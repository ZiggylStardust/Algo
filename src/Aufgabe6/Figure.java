package Aufgabe6;

import java.util.ArrayList;

public class Figure {
  public int position;
  public int size;
  public ArrayList<boolean[][]> figure ;


  public boolean[][] rotate(){
    return figure.get(position++);
 }


}
package Aufgabe6;

import java.util.ArrayList;

public class DominoFigure extends Figure {
  public ArrayList<boolean[][]> figure = new ArrayList<>();


  DominoFigure(){
    size=2;
    figure.add(new boolean[][]{{true}, {true}});
    figure.add(new boolean[][]{{true, true}});
  }
  @Override
  public boolean[][] rotate(){
    return figure.get(position++);
  }

  @Override
  public String toString() {
    return "Domino";
  }
}

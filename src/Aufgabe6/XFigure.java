package Aufgabe6;

import java.util.ArrayList;

public class XFigure extends Figure {


  public ArrayList<boolean[][]> figure = new ArrayList<>();



  XFigure() {
    figure.add(new boolean[][]{{false, true, false}, {true, true, true}, {false, true, false}});
    size=1;
  }
  @Override
  public boolean[][] rotate(){
    return figure.get(position++);

  }

}

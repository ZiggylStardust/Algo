package Aufgabe6.Positions.Figures;

import Aufgabe6.Positions.Figure;

import java.util.ArrayList;

public class XFigure extends Figure {


  public ArrayList<boolean[][]> figure = new ArrayList<>();



  public XFigure() {
    figure.add(new boolean[][]{{false, true, false}, {true, true, true}, {false, true, false}});
    size=1;
  }
  @Override
  public boolean[][] rotate(){
    return figure.get(position++);

  }

}

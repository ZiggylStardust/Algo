package Aufgabe6.Positions.Figures;

import Aufgabe6.Positions.Figure;

import java.util.ArrayList;

public class XFigure extends Figure {





  public XFigure() {
    figure = new ArrayList<>();
    figure.add(new boolean[][]{{false, true, false}, {true, true, true}, {false, true, false}});
    size=1;
  }


}

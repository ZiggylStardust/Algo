package Aufgabe6.Positions.Figures;

import Aufgabe6.Positions.Figure;

import java.util.ArrayList;

public class XFigure extends Figure {
  /**
   * @Author Tobias Fetzer 198318
   * Represents an X (or a +)
   */
  public XFigure() {
    orientationsOfFigure = new ArrayList<>();
    orientationsOfFigure.add(new boolean[][]{{false, true, false}, {true, true, true}, {false, true, false}});
    numberOfOrientations = 1;
  }


}

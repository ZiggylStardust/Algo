package Aufgabe6.Positions.Figures;

import Aufgabe6.Positions.Figure;

import java.util.ArrayList;

/**
 * @Author Tobias Fetzer 198318
 * Represents a T
 */
public class TFigure extends Figure {


  public TFigure() {
    orientationsOfFigure = new ArrayList<>();
    numberOfOrientations = 4;
    orientationsOfFigure.add(new boolean[][]{{true, true, true}, {false, true, false}, {false, true, false}});
    orientationsOfFigure.add(new boolean[][]{{false, false, true}, {true, true, true}, {false, false, true}});
    orientationsOfFigure.add(new boolean[][]{{false, true, false}, {false, true, false}, {true, true, true}});
    orientationsOfFigure.add(new boolean[][]{{true, false, false}, {true, true, true}, {true, false, false}});
  }

}

package Aufgabe6.Positions.Figures;

import Aufgabe6.Positions.Figure;

import java.util.ArrayList;

/**
 * @Author Tobias Fetzer 198318
 * Represents a domino
 */
public class DominoFigure extends Figure {

  public DominoFigure() {
    numberOfOrientations = 2;
    orientationsOfFigure = new ArrayList<>();
    orientationsOfFigure.add(new boolean[][]{{true}, {true}});
    orientationsOfFigure.add(new boolean[][]{{true, true}});
  }
}

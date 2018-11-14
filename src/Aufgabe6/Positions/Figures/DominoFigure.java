package Aufgabe6.Positions.Figures;

import Aufgabe6.Positions.Figure;

import java.util.ArrayList;

/**
 * @Author Tobias Fetzer 198318
 * Represents a domino
 */
public class DominoFigure extends Figure {

  public DominoFigure() {
    size = 2;
    figure = new ArrayList<>();
    figure.add(new boolean[][]{{true}, {true}});
    figure.add(new boolean[][]{{true, true}});
  }
}

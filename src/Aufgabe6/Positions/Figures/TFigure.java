package Aufgabe6.Positions.Figures;

import Aufgabe6.Positions.Figure;

import java.util.ArrayList;

/**
 * @Author Tobias Fetzer 198318
 * Represents a T
 */
public class TFigure extends Figure {


  public TFigure() {
    figure=new ArrayList<>();
    size=4;
    figure.add(new boolean[][]{{true, true, true}, {false, true, false}, {false, true, false}});
    figure.add(new boolean[][]{{false, false, true}, {true, true, true}, {false, false, true}});
    figure.add(new boolean[][]{{false, true, false}, {false, true, false}, {true, true, true}});
    figure.add(new boolean[][]{{true, false, false}, {true, true, true}, {true, false, false}});
  }

}

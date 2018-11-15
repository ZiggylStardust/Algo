package Aufgabe6.Positions.Figures;

import Aufgabe6.Positions.Figure;

import java.util.ArrayList;

public class YFigure extends Figure {

  /**
   * @Author Tobias Fetzer 198318
   * Represents a Y
   */
  public YFigure() {
    orientationsOfFigure = new ArrayList<>();

    numberOfOrientations = 8;
    orientationsOfFigure.add(new boolean[][]{{true, false}, {true, true}, {true, false}, {true, false}});
    orientationsOfFigure.add(new boolean[][]{{true, true, true, true}, {false, false, true, false}});
    orientationsOfFigure.add(new boolean[][]{{false, true}, {false, true}, {true, true}, {false, true}});
    orientationsOfFigure.add(new boolean[][]{{false, true, false, false}, {true, true, true, true}});

    orientationsOfFigure.add(new boolean[][]{{false, true}, {true, true}, {false, true}, {false, true}});
    orientationsOfFigure.add(new boolean[][]{{false, false, true, false}, {true, true, true, true}});
    orientationsOfFigure.add(new boolean[][]{{true, false}, {true, false}, {true, true}, {true, false}});
    orientationsOfFigure.add(new boolean[][]{{true, true, true, true}, {false, true, false, false}});
  }
}

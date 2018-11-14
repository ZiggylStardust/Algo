package Aufgabe6.Positions.Figures;

import Aufgabe6.Positions.Figure;

import java.util.ArrayList;

public class YFigure extends Figure {

  public YFigure(){
    figure = new ArrayList<>();

    size=8;
    figure.add(new boolean[][]{{true, false}, {true, true}, {true, false}, {true, false}});
    figure.add(new boolean[][]{{true, true, true, true}, {false, false, true, false}});
    figure.add(new boolean[][]{{false, true}, {false, true}, {true, true}, {false, true}});
    figure.add(new boolean[][]{{false, true, false, false}, {true, true, true, true}});

    figure.add(new boolean[][]{{false, true}, {true, true}, {false, true}, {false, true}});
    figure.add(new boolean[][]{{false, false, true, false}, {true, true, true, true}});
    figure.add(new boolean[][]{{true, false}, {true, false}, {true, true}, {true, false}});
    figure.add(new boolean[][]{{true, true, true, true}, {false, true, false, false}});
  }
}

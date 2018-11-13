package Aufgabe6.Positions;

import Aufgabe6.Positions.Figures.DominoFigure;
import Aufgabe6.Positions.Figures.TFigure;
import Aufgabe6.Positions.Figures.XFigure;
import Aufgabe6.Positions.Figures.YFigure;

import java.util.ArrayList;
import java.util.Arrays;

public class PositionsOfFigures {
  public int[][] feld;
  public ArrayList<int[]> positionen = new ArrayList<>();
  public int n;
  public ArrayList<Figure> figures=new ArrayList<>();



  public PositionsOfFigures(int n) {
    this.n = n;
    feld = new int[6][n]; //6 nach unten
    int zähler = 1;
    figures.add(new DominoFigure());
    figures.add(new XFigure());
    figures.add(new YFigure());
    figures.add(new TFigure());
    for (int y = 0; y < 6; y++) {
      for (int x = 0; x < n; x++, zähler++) {
        feld[y][x] = zähler;
      }
    }

  }

  public ArrayList<int[]> createPositions() {
    for (int y = 0; y < 6; y++) {
      for (int x = 0; x < n; x++) {
        for (Figure figure:figures){
          while(figure.position<figure.size){

            positionen.add(matchfigur(figure.rotate(),x,y));
          }
          figure.position=0;

        }

      }
    }
    positionen.removeIf(i->i==null);
    return positionen;


  }

  public int[] matchfigur(boolean[][] figur, int x, int y) {
    ArrayList<Integer> positionen = new ArrayList<>(5);
    int k = 0;
    if(figur.length+y>6||figur[0].length+x>n){
      return null;
    }

    for (int i = 0; i < figur.length; i++) {
      for (int j = 0; j < figur[0].length; j++) {
        if (figur[i][j]) {
          positionen.add(feld[i + y][j + x]);
        }
      }
    }
    return positionen.stream().mapToInt(i->i).toArray();


  }
}

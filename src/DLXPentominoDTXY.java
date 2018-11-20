package Aufgabe6;

import Aufgabe6.Positions.PositionsOfFigures;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author Tobias Fetzer 198318
 * Main class, creates Strukture and calculates result using DLX class
 */
public class DLXPentominoDTXY {
  static DLXNode[] header;
  static int n;
  static ArrayList<int[]> positions;  //Array of figures (
  static int fieldSize; //number of header=largest possible element in a figure


  public static void main(String[] args) {
    System.out.println("Enter size");
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();

    scan.close();

    fieldSize = n * 6;
    PositionsOfFigures t = new PositionsOfFigures(n);
    positions = t.createPositions();
      /*for (int[] i : t.positions) { //Output of position arrays
        System.out.println(Arrays.toString(i));
      }*/
    if (n > 0) {
      createList();


      DLX.h = new DLXNode();//creates the header elemnt left to the header column
      DLX.h.R = header[0];
      header[0].L = DLX.h;
      header[fieldSize - 1].R = DLX.h;
      DLX.h.L = header[fieldSize - 1];
      DLX.search(0);
    }
    System.out.println("a(" + n + ")= " + DLX.cnt);
    DLX.cnt = 0;

  }

  /**
   * Creates the List structure used for the algorithm
   */
  public static void createList() {
    createHeaders();
    for (int[] figure : positions) { //Creates the rows for each figure, and connects them to the last one
      DLXNode start = new DLXNode();
      DLXNode current = start;
      createRows(figure, current, start);
      connectRows(figure, current);
    }
  }

  /**
   * Create Headers of list, and saves the in array
   */
  public static void createHeaders() {
    int länge = 6 * n;
    header = new DLXNode[länge];
    header[0] = new DLXNode();
    for (int i = 1; i < länge; i++) {
      header[i] = new DLXNode();
      header[i - 1].R = header[i];
      header[i].L = header[i - 1];
    }
    header[länge - 1].R = header[0];
    header[0].L = header[länge - 1];

  }

  /**
   * Creates one row by connecting the Nodes with it'S neighbours left and right
   *
   * @param figure  the current figure, and int[] with the orientation of the orientationsOfFigure in the field
   * @param current the current Node that is being connected
   * @param start   the start node of a row
   */
  public static void createRows(int[] figure, DLXNode current, DLXNode start) {
    for (int i = 0; i < figure.length - 1; i++, current = current.R) {
      current.R = new DLXNode();
      current.R.L = current;

    }
    current.R = start;
    start.L = current;
    current = start;

  }

  /**
   * Connects the nodes of a row with the next node above or below it
   *
   * @param figure  the figure oreintation being worked on
   * @param current the starting node of the figure
   */
  public static void connectRows(int[] figure, DLXNode current) {
    for (int i = 0; i < figure.length; i++, current = current.R) {
      int pos = figure[i] - 1;
      DLXNode up = header[pos].U;
      header[pos].U = current;
      current.U = up;
      up.D = current;
      current.D = header[pos];
      current.C = header[pos];
    }
  }
}


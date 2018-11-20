package Aufgabe6;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author Tobias Fetzer 198318
 * Main class, creates Strukture and calculates result
 */
public class DLXPentominoDTXY {
  static DLXNode[] header;
  static int n;
  static ArrayList<int[]> positions;  //Array of figures (
  static int fieldSize; //number of header=largest possible element in a figure
  static DLXNode h;
  public static int cnt = 0;


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


      h = new DLXNode();//creates the header elemnt left to the header column
      h.R = header[0];
      header[0].L = h;
      header[fieldSize - 1].R = h;
      h.L = header[fieldSize - 1];
      search(0);
    }
    System.out.println("a(" + n + ")= " + cnt);
    cnt = 0;

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

  /**
   * search tries to find and count all complete coverings of the DLX matrix.
   * Is a recursive, depth-first, backtracking algorithm that finds
   * all solutions to the exact cover problem encoded in the DLX matrix.
   * each time all columns are covered, static long cnt is increased
   *
   * @param k: number of level
   */
  public static void search(int k) { // finds & counts solutions
    if (h.R == h) {
      cnt++;
      return;
    }     // if empty: count & done
    DLXNode c = h.R;                   // choose next column c
    cover(c);                          // remove c from columns
    for (DLXNode r = c.D; r != c; r = r.D) {  // forall rows with 1 in c
      for (DLXNode j = r.R; j != r; j = j.R) // forall 1-elements in row
        cover(j.C);                    // remove column
      search(k + 1);                    // recursion
      for (DLXNode j = r.L; j != r; j = j.L) // forall 1-elements in row
        uncover(j.C);                  // backtrack: un-remove
    }
    uncover(c);                        // un-remove c to columns
  }

  /**
   * cover "covers" a column c of the DLX matrix
   * column c will no longer be found in the column list
   * rows i with 1 element in column c will no longer be found
   * in other column lists than c
   * so column c and rows i are invisible after execution of cover
   *
   * @param c: header element of column that has to be covered
   */
  public static void cover(DLXNode c) { // remove column c
    c.R.L = c.L;                         // remove header
    c.L.R = c.R;                         // .. from row list
    for (DLXNode i = c.D; i != c; i = i.D)      // forall rows with 1
      for (DLXNode j = i.R; i != j; j = j.R) {   // forall elem in row
        j.D.U = j.U;                     // remove row element
        j.U.D = j.D;                     // .. from column list
      }
  }

  /**
   * uncover "uncovers" a column c of the DLX matrix
   * all operations of cover are undone
   * so column c and rows i are visible again after execution of uncover
   *
   * @param c: header element of column that has to be uncovered
   */
  public static void uncover(DLXNode c) {//undo remove col c
    for (DLXNode i = c.U; i != c; i = i.U)      // forall rows with 1
      for (DLXNode j = i.L; i != j; j = j.L) {   // forall elem in row
        j.D.U = j;                       // un-remove row elem
        j.U.D = j;                       // .. to column list
      }
    c.R.L = c;                           // un-remove header
    c.L.R = c;                           // .. to row list
  }
}

/**
 * Class Aufgabe6.DLXNode
 * represents a matrix element of the cover matrix with value 1
 * links go to up down left right neigbors, and column header
 * can also be used as colm header or root of column headers
 * matrix is sparsely coded
 * try to do all operations very efficiently
 * see:
 * http://en.wikipedia.org/wiki/Dancing_Links
 * http://arxiv.org/abs/cs/0011047
 */
class DLXNode { // represents 1 element or header
  DLXNode C; // reference to column-header
  DLXNode L, R, U, D; // left, right, up, down references

  DLXNode() {
    C = L = R = U = D = this;
  } // supports circular lists

}

/**
 * @Author Tobias Fetzer 198318
 * Class creates the array of ints, which represent the positions in the field that are filled by a figure
 */
class PositionsOfFigures {
  public int[][] field;    //The field, filled with numbers from 1 to n*6
  public ArrayList<int[]> positions = new ArrayList<>(); /*result ArrayList, represents every possible
                                                          orientation of the figures in the field*/
  public int n;
  public ArrayList<Figure> figures = new ArrayList<>();   //ArrayList of the Aufgabe6.Figure Classes, the T,Y,X and domino

  /**
   * Constructor, adds figures to arrayList and generates field.
   *
   * @param n number of Columns
   */
  public PositionsOfFigures(int n) {
    this.n = n;
    field = new int[6][n]; //6 down
    int zähler = 1;
    figures.add(new Figure.DominoFigure());
    figures.add(new Figure.XFigure());
    figures.add(new Figure.YFigure());
    figures.add(new Figure.TFigure());
    for (int y = 0; y < 6; y++) {
      for (int x = 0; x < n; x++, zähler++) {
        field[y][x] = zähler;
      }
    }

  }

  /**
   * Creates the ArrayList of the positions for every figure and it's orientations
   *
   * @return the ArrayList of a containing the positions/orientations that every figure can take
   */
  public ArrayList<int[]> createPositions() {
    for (int y = 0; y < 6; y++) {
      for (int x = 0; x < n; x++) {
        for (Figure figure : figures) {
          while (figure.orientation < figure.numberOfOrientations) {

            positions.add(matchFigure(figure.rotate(), x, y));
          }
          figure.orientation = 0;
        }

      }
    }
    positions.removeIf(i -> i == null);
    return positions;


  }

  /**
   * Creates the int[] of a single figure, the orientation it has in the field
   *
   * @param figure the current orientation of the figure being worked on
   * @param x      the current x position in the field
   * @param y      the current y position in the field
   * @return the position of the figure in the field, represented as an int[] showing which parts of the
   * field are covered by it. Returns Null if the orientation doesn't fit in the field
   */
  public int[] matchFigure(boolean[][] figure, int x, int y) {
    ArrayList<Integer> position = new ArrayList<>(5);
    int k = 0;
    if (figure.length + y > 6 || figure[0].length + x > n) {
      return null;
    }

    for (int i = 0; i < figure.length; i++) {
      for (int j = 0; j < figure[0].length; j++) {
        if (figure[i][j]) {
          position.add(field[i + y][j + x]);
        }
      }
    }
    return position.stream().mapToInt(i -> i).toArray();


  }
}


/**
 * @Author Tobias Fetzer 198318
 * Represents a generic figure, all specific figures inherit from it.
 * A figure is represented as an arrayList of boolean[][], each boolean[][] representing one orientation of it
 */
class Figure {
  public int orientation;
  public int numberOfOrientations;
  public ArrayList<boolean[][]> orientationsOfFigure;


  /**
   * Rotates the orientationsOfFigure by calling the next orientation of the array
   *
   * @return the next orientation
   */
  public boolean[][] rotate() {
    return orientationsOfFigure.get(orientation++);
  }


  /**
   * @Author Tobias Fetzer 198318
   * Represents a domino
   */
  public static class DominoFigure extends Figure {

    public DominoFigure() {
      numberOfOrientations = 2;
      orientationsOfFigure = new ArrayList<>();
      orientationsOfFigure.add(new boolean[][]{{true}, {true}});
      orientationsOfFigure.add(new boolean[][]{{true, true}});
    }
  }

  public static class XFigure extends Figure {
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

  public static class YFigure extends Figure {

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

  /**
   * @Author Tobias Fetzer 198318
   * Represents a T
   */
  public static class TFigure extends Figure {


    public TFigure() {
      orientationsOfFigure = new ArrayList<>();
      numberOfOrientations = 4;
      orientationsOfFigure.add(new boolean[][]{{true, true, true}, {false, true, false}, {false, true, false}});
      orientationsOfFigure.add(new boolean[][]{{false, false, true}, {true, true, true}, {false, false, true}});
      orientationsOfFigure.add(new boolean[][]{{false, true, false}, {false, true, false}, {true, true, true}});
      orientationsOfFigure.add(new boolean[][]{{true, false, false}, {true, true, true}, {true, false, false}});
    }

  }
}

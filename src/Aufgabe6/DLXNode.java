package Aufgabe6;

public class DLXNode { // represents 1 element or header
  DLXNode C; // reference to column-header
  DLXNode L, R, U, D; // left, right, up, down references
  int col;
  int row;

  DLXNode(int col,int row) {
    this.col=col;
    this.row=row;
    C = L = R = U = D = this;
  } // supports circular lists

  @Override
  public String toString() {
    return "col: "+col+" row:"+row;
  }
}

package Aufgabe6;

public class DLX {
  static DLXNode h;
  public static int cnt=0;


  public static void search(int k) { // finds & counts solutions
    System.out.println(k);
    if (h.R == h) {
      cnt++;
     return;
    } // if empty: count & done
    DLXNode c = h.R; // choose next column c
    cover(c); // remove c from columns
    for (DLXNode r = c.D; r != c; r = r.D) { // forall rows with 1 in c
    //  System.out.println(1);
      for (DLXNode j = r.R; j != r; j = j.R){ // forall 1-elements in row
      //  System.out.println(2);
        cover(j.C); // remove column
      search(k + 1);
      } // recursion
      for (DLXNode j = r.L; j != r; j = j.L) { // forall 1-elements in row
        //System.out.println(3);
        uncover(j.C); // backtrack: un-remove
      }
    }
    uncover(c); // un-remove c to columns
  }

  public static void cover(DLXNode c) { // remove column c
    c.R.L = c.L; // remove header
    c.L.R = c.R; // .. from row list
    for (DLXNode i = c.D; i != c; i = i.D) {// forall rows with 1
      //System.out.println(4);
      for (DLXNode j = i.R; i != j; j = j.R) { // forall elem in row
        //System.out.println(5);
        j.D.U = j.U; // remove row element
        j.U.D = j.D; // .. from column list
      }
    }
  }

  public static void uncover(DLXNode c) {//undo remove col c
    for (DLXNode i = c.U; i != c; i = i.U) // forall rows with 1
      for (DLXNode j = i.L; i != j; j = j.L) { // forall elem in row
        j.D.U = j; // un-remove row elem
        j.U.D = j; // .. to column list
      }
    c.R.L = c; // un-remove header
    c.L.R = c; // .. to row list
  }
}

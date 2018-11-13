package Aufgabe6;

import Aufgabe6.Positions.PositionsOfFigures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class DLXPentominoDTXY {
  static DLXNode[] header;
  static DLXNode first;

  public static void main(String[] args) {
    System.out.println("Enter size");
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    PositionsOfFigures t = new PositionsOfFigures(n);
    ArrayList<int[]> positions = t.createPositions();
    for (int[] i : t.positionen) {
      System.out.println(Arrays.toString(i));
    }

    int länge = 6 * n;
    header = new DLXNode[länge];
    header[0] = new DLXNode(0,0);
    for (int i = 1; i < länge; i++) {
      header[i] = new DLXNode(i,0);
      header[i - 1].R = header[i];
      header[i].L = header[i - 1];
    }
    header[länge - 1].R = header[0];
    header[0].L = header[länge - 1];

    int j=0;
    for (int[] figur : positions) {
      DLXNode start = new DLXNode(figur[0],j+1);
      DLXNode current = start;

      for (int i = 0; i < figur.length - 1; i++, current = current.R) {
        current.R = new DLXNode(figur[i]+1,j+1);
        current.R.L = current;

      }
      current.R = start;
      start.L = current;
      current = start;
      for (int i = 0; i < figur.length; i++, current = current.R) {
        int pos=figur[i]-1;
        DLXNode up = header[pos].U;
        header[pos].U = current;
        current.U = up;
        up.D = current;
        current.D = header[pos];
        current.C = header[pos];
        System.out.print(current+" ");

      }
      System.out.println();
      j++;
    }
    for (DLXNode current = header[positions.get(0)[0]-1].D; current != current.C; current = current.D) {
      for (int i = 0; i < länge; i++) {
        if (current.C == header[i]) {
          current = current.R;

          System.out.print(1+" ");
        } else {
          System.out.print(0+" ");
        }
      }
      System.out.println();

    }

   // DLX.h = header[0];
    //DLX.search(0);
    //System.out.println(DLX.cnt);


  }}


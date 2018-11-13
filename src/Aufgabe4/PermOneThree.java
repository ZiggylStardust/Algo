package Aufgabe4;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;

public class PermOneThree {
  public static void main (String[] arg){
    System.out.println("Endzahl eingeben");
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.close();

    Perm p = new Perm (n); // Liefert Permutationen von 0 .. N-1 mit 0 fix
    int [] c;
    int anzahl=0;
    while ((c = p.getNext()) != null) { // Naechste Permutation
     /* boolean correct=true; //speichert, ob bedingung erfüllt sind
      for (int j=0; j<n-1; j++){
        if(!(abs(c[j]-c[j+1])==4||abs(c[j]-c[j+1])==1)){  //wenn bedingung nicht erfüllt
          correct=false;
          break;
        }
      }
      if(correct){*/
      System.out.println(Arrays.toString(c));
     anzahl++;

    //  }


    }
    System.out.println("Es gab genau " +anzahl+" Permutationen der verlangten Art");
    }
  } // main


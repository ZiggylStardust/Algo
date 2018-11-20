package Aufgabe7;

import java.util.*;

public class PermOneThree {
  public static void main (String[] arg){
    System.out.println("Endzahl eingeben");
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    scanner.close();

    Perm p = new Perm (n); // Liefert Permutationen von 0 .. N-1 mit 0 fix
    int [] c;
    int max=0;
    ArrayList<Integer> results=new ArrayList<>();
    while ((c = p.getNext()) != null) { // Naechste Permutation
      int i=DKnV.search(c);
      System.out.println(i);
      results.add(i);
      if(i>max) max=i;


    }
    //Collections.sort(results);
    int[] result=new int[(1<<n-1)];
    for(Integer i:results){
      result[i]=result[i]+1;
    }
    System.out.println();
    System.out.println("Verteilung der Ergebnisse");
    System.out.println(Arrays.toString(result));
    }
  } // main


package Aufgabe7;

import java.util.ArrayList;

public class DKnV {
  static ArrayList<Integer> permutation;

  public static void main(String[] args) {
    int[] intArray={4,1,2,3}; //largest: f(n)=2(f(n-1)+1, f(3)=3; f(n)=2^(n-1)-1

    System.out.println(    search(intArray)
    );
  }

  public static int search(int[] perm) {
    permutation=new ArrayList<>(perm.length);
    for(int i:perm){
      permutation.add(i);
    }
    //System.out.println(permutation);
    int swapped=0;
    while (true) {
      System.out.print(permutation+"-->");
      boolean correct=true;
      for (int i=0;i<permutation.size()-1;i++) {
        if(permutation.get(i)>permutation.get(i+1)){
          Integer k=permutation.get(i+1);
          permutation.remove(i+1);
          permutation.add(0,k);
          swapped++;
          correct=false;
          break;
        }

        }
        if(correct) {
          return swapped;
        }

      }
    }
  }


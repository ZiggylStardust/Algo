package Aufgabe9;

import java.io.*;
import java.util.Scanner;

public class WorstMergeSort {
    static int[] w;
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);

        int ziel=sc.nextInt();
        PrintWriter writer = new PrintWriter("worstMerge bis"+ziel+".txt", "UTF-8");


        w=new int[ziel+1];
        for(int n=0;n<=ziel;n++){
//            w=new int[n+1];
            writer.println(n+"--> "+sortCount(n));
        }
  //      w=new int[210+1];

    //    System.out.println(210+"→ "+sortCount(210));
        writer.close();
    }

    /*
    Recursively calculates the number of comparisons in the worst case. Merge sorts worst case has n-1 comparisons for
    a single merge operation, plus the comparisons for the merge operations of the subarrays that are merged
     */
    public static int sortCount(int n){
        if(n==0||n==1){
            return 0;
        }
        if(n==2) return 1;
        if(w[n]!=0) return w[n];
        //If the length is uneven, separate into the smaller left and bigger right part
        if(n%2!=0)w[n]= sortCount(n/2)+sortCount(((n+1)/2))+(n-1);
        //If it's even only uses one method call, and multiply it by 2.
        else w[n]=2*sortCount(n/2)+n-1;
        return w[n];

    }
}

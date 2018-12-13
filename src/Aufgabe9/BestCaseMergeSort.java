package Aufgabe9;

import java.util.Scanner;

public class BestCaseMergeSort {
    static int[] w;
    public static void main(String[] args) {
        //Scanner sc=new Scanner(System.in);
        //int n=sc.nextInt();
        for(int n=0;n<=13;n++){
        w=new int[n+1];
        System.out.println(n+"→ "+sortCount(n));
    }
        w=new int[210+1];

        System.out.println(210+"→ "+sortCount(210));
    }

    public static int sortCount(int n){
        if(n==0||n==1){
            return 0;
        }
        if(n==2) return 1;
        if(w[n]!=0) return w[n];
        if(n%2!=0){ w[n]= sortCount(n/2)+sortCount(((n+1)/2))+((n)/2);}
        else w[n]=2*sortCount(n/2)+n/2;
        return w[n];

    }
}

import javafx.print.Collation;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Divisible_by_all_numbers {
    public static ArrayList<Integer> primes;
    public static ArrayList<Integer>[] zerlegung;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ziel;
        for (int k = 1; k <= n; k++) {
                ziel=k;

            findPrimes(ziel);
            zerlegung = new ArrayList[ziel + 1];

            for (int i = 1; i <= ziel; i++) {
                zerlegung[i] = zerelge(i);
                Collections.sort(zerlegung[i]);
            }
            ArrayList<Integer> calc = new ArrayList<>();
            fillCalc(calc);
            BigInteger solution = BigInteger.ONE;
            for (Integer i : calc) {
                solution = solution.multiply(new BigInteger(i.toString()));
            }
            System.out.print(solution+", ");
        }
    }





    public static void findPrimes(int ziel){
        int d = ziel;
        int[] liste=new int[d+1];
        for (int i = 0; i <= d; i++) {
            liste[i] = i;
        }
        primes=new ArrayList<>(d);
        for (int i = 2; i <= d; i++) {
            if (liste[i] != 0) {
                primes.add(i);
                for (int j = i + i; j <= d; j = j + i) {
                    liste[j] = 0;
                }
            }
        }
    }
    public static ArrayList<Integer> zerelge(int ziel){
        ArrayList<Integer> faktoren=new ArrayList<>(ziel);
        int x=ziel;
        int u;

        boolean con=true;
        for (int i = 0; i < primes.size()&&con; i++) {
            u = primes.get(i);
            while (x%u == 0) {												//tests wether the entered number can be divided by one of the primes

                faktoren.add(u);										//if yes, the prime is added to a new list
                x = x / u;													//The entered number is then divided by the prime

                faktoren.addAll(zerlegung[x]);
                con=false;
                break;
            }
        }
        return faktoren;
    }
    public static void fillCalc(ArrayList<Integer> calc){
        for(ArrayList<Integer> i:zerlegung) {


            if (i != null&&i.size()!=0) {
                int[] occurencesInCalc = new int[i.get(i.size()-1)+1];
                int[] occurencesInI = new int[i.get(i.size()-1)+1];

                for (Integer in : i) {
                    occurencesInI[in]++;

                    int occurrences = Collections.frequency(calc, in);
                    if (occurencesInCalc[in] == 0)
                        occurencesInCalc[in]=occurrences;
                }

                for (int l = 0; l < occurencesInCalc.length; l++) {
                    if (occurencesInCalc[l] < occurencesInI[l]) {
                        for (int k = 0; k < occurencesInI[l] - occurencesInCalc[l]; k++) {
                            calc.add(l);
                        }
                    }
                }

            }
            }

            Collections.sort(calc);




    }
}

package Bai2;

import java.util.Scanner;

public class FiB {
    public static void main(String args[]) {
        int n;

        Scanner sc = new Scanner(System.in);
        do{
            System.out.print("n = ");
            n = sc.nextInt();
        }while(n <0);

        System.out.format("so Fibonacci thu %d la: %d", n, fiBo(n));

    }
    public static int fiBo(int n){
        int a = 2;
        int a0 = 5, a1 = 2, a2 = 7;
        if(n==0){
            return 5;
        }
        if(n == 1){
            return 2;
        } if(n ==2){
            return 7;
        }
        else{
            while(a++ <= n){
                a2 = a0 + a1;
                a0 = a1;
                a1 = a2;
            }
            return a2;
        }
    }
}

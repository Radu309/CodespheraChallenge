package com.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Ex_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give the number of columns: ");
        int N = sc.nextInt();
        System.out.println("Give the number of rows: ");
        int M = sc.nextInt();
        int[][] array = new int[M][N];
        int[] water = new int[N];
        int waterLost = 0;
        System.out.println("Give the numbers from first row: ");
        for(int i = 0; i < N; i++) {
            array[0][i] = sc.nextInt();
            water[i] = array[0][i];
        }
        for(int i = 0; i < N; i++) {
            System.out.print(water[i] + " ");
        }
        System.out.println("Give the table values: (1 - obstacle; 0 - blank)");

        for(int i = 1; i < M; i++) {
            for(int j = 0; j < N; j++) {
                array[i][j] = sc.nextInt();
                if(array[i][j] != 1 && array[i][j] != 0)
                {
                    System.out.println("wrong value for cell");
                    return;
                }
                if(array[i][j] == 1) {
                    if(j == 0){
                        waterLost += water[j]/2;
                        water[j+1] += water[j]/2;
                    }
                    else if(j == N-1){
                        waterLost += water[j]/2;
                        water[j-1] += water[j]/2;
                    }
                    else{
                        water[j-1] += water[j]/2;
                        water[j+1] += water[j]/2;
                    }
                    water[j] = 0;
                }
            }
        }
        for(int i = 0; i < N; i++) {
            System.out.print(water[i] + " ");
        }
        System.out.println();
        System.out.println(waterLost);
        sc.close();
    }
}

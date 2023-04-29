package com.chaoRen.test;

import java.util.Arrays;

public class TestChess {
    public static void main(String[] args) {
        int[][] che = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 0, 1, 1, 0},
                {1, 1, 0, 1, 1, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0}
        };
        sort(che);

        for (int[] ints : che) {
            System.out.println(Arrays.toString(ints));
        }

    }

    public static void sort(int[][] arr) {
        int end = arr.length - 1;
        int len = 0;
        int i1 = 0;
        int i2 = 0;
        while (true) {
            if (arr[end][len] == 0) {
                break;
            }
            len++;
        }

        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; arr[j][0] == 0; j++) {
                i1 = j + 1;
            }
            for (int j = 0; j < len - i -1; j++) {
                if (arr[i1][j + 1] == 0) {
                    for (int k = i1; arr[k][j + 1] == 0; k++) {
                        i2 = k;
                    }
                    for (int k = i2; k >= i1; k--) {
                        arr[k][j] = 0;
                        arr[k][j + 1] = 1;
                    }
                } else {
                    for (int k = i1; arr[k - 1][j + 1] == 1; k--) {
                        i1 = k - 1;
                    }
                }
            }
        }

    }


}

package homework3;

import java.util.Arrays;

public class HomeWork3 {
    public static void main(String[] args) {
        convertArray();
        fillArtray();
        arrayDouble();
        diagFill();
        System.out.println(Arrays.toString(returnArray(10, 5)));
        miniMax();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        System.out.println(eqSum(arr));
        arrayShift(-5, arr);
    }

    public static void convertArray() {
        int[] arr = {1, 1, 0, 0, 1, 1, 1, 0, 0};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) arr[i] = 1; else arr[i] = 0;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void fillArtray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void arrayDouble() {
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) arr[i] *= 2;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static  void diagFill() {
        int[][] arr = new int[10][10];
        for (int i = 0; i < arr.length; i ++) {
            for (int j = 0; j < arr[i].length; j ++) {
                if (i == j || j == arr[i].length - (i + 1)) arr[i][j] = 1;
            }
        }
        for (int i = 0; i < arr.length; i ++) {
            for (int j = 0; j< arr[i].length; j ++) System.out.print(arr[i][j]);
            System.out.print("\n");

        }

    }

    public static int[] returnArray (int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i ++) arr[i] = initialValue;
        return arr;
    }

    public static void miniMax () {

        int[] arr = { 1, 3, 5, 7, 11, 13, 17, 19 ,4, 8, 2};
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i ++) {
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }
        System.out.println("MAX = " + max);
        System.out.println("MIN = " + min);
    }

    public static boolean eqSum (int[] arr) {
        int sum1 = 0, sum2 = 0;
        boolean result = false;
        for (int i = 0; i < arr.length; i++) {
            sum2 += arr[arr.length - 1 - i];
            sum1 = 0;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                sum1 += arr[j];
            }
            if (sum1 == sum2) result = true;
            }

        return result;
    }

    public static void arrayShift(int n, int[] arr) {
        if (n > 0) {
            for (int j = 0; j < n; j++) {
                int tmp = arr[arr.length - 1];
                for (int i = arr.length - 1; i > 0; i--) {
                    arr[i] = arr[i - 1];
                }
                arr[0] = tmp;
            }
        } else {
            for (int j = 0; j > n; j--) {
                int tmp = arr[0];
                for (int i = 0; i < arr.length - 1; i++) {
                    arr[i] = arr[i + 1];
                }
                arr[arr.length - 1] = tmp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}

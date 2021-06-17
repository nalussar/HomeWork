package homework4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWork4 {

    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 4;
    public static final char DOT_EMPTY = '.';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';


    public static void main(String[] args) {

        initMap();
        printMap();

        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static Scanner sc = new Scanner(System.in);

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате x, y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[x][y] = DOT_X;

    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE) return false;
        if (map[x][y] == DOT_EMPTY) return true;
        return false;
    }

    public static Random rand = new Random();
    public static void aiTurn() {
        int x,y;
        int[] coord = recCoord(DOT_X);
        if (coord[2] != 0) {
            map[coord[0]][coord[1]] = DOT_O;
            System.out.println("Компьютер походил в точку " + (coord[0] + 1) + " " + (coord[1] + 1));
        } else {

            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (!isCellValid(x,y));
            System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
            map[x][y] = DOT_O;
        }
    }

    public static boolean checkWinOld(char symb) {
        if(map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) return true;
        if(map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) return true;
        if(map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) return true;
        if(map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) return true;
        if(map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) return true;
        if(map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) return true;
        if(map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
        if(map[2][0] == symb && map[1][1] == symb && map[0][2] == symb) return true;
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean checkWin (char symb) {
        int horCount = 0;
        int verCount = 0;
        int d1Count = 0;
        int d2Count = 0;
        for (int i = 0; i < SIZE; i++) {
            horCount = 0;
            verCount = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) horCount++;
                else horCount = 0;
                if (map[j][i] == symb) verCount++;
                else verCount = 0;
                if (i == j) {
                    if (map[i][j] == symb) d1Count++;
                    else d1Count =0;
                }
                if (j == map[i].length - 1 - i) {
                    if (map[i][j] == symb) d2Count++;
                    else d2Count = 0;
                }
                if (horCount == DOTS_TO_WIN || verCount == DOTS_TO_WIN || d1Count == DOTS_TO_WIN || d2Count == DOTS_TO_WIN) return true;
            }
        }

        return false;
    }

    public static int[] recCoord (char symb) {
        int[] coord = {0, 0, 0};
        for (int i = 0; i < SIZE; i++) {
            int horCount = 0;
            int verCount = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) horCount++;
                else horCount = 0;
                if (horCount == DOTS_TO_WIN - 1) {
                    if (j < SIZE-1 && map[i][j+1] == DOT_EMPTY ) {
                       coord[0] = i;
                       coord[1] = j + 1;
                       coord[2] = 1;
                    } else if (j - DOTS_TO_WIN +1 >= 0 && map[i][j - DOTS_TO_WIN + 1] == DOT_EMPTY) {
                        coord[0] = i;
                        coord[1] = j - DOTS_TO_WIN + 1;
                        coord[2] = 1;
                    }
                }
                if (map[j][i] == symb) verCount++;
                else verCount = 0;
                if (verCount == DOTS_TO_WIN - 1) {
                    if (i < SIZE-1 && map[j+1][i] == DOT_EMPTY ) {
                        coord[0] = j + 1;
                        coord[1] = i;
                        coord[2] = 1;
                    } else if (j - DOTS_TO_WIN + 1 >= 0 && map[j - DOTS_TO_WIN + 1][i] == DOT_EMPTY) {
                        coord[0] = j - DOTS_TO_WIN -1;
                        coord[1] = i;
                        coord[2] = 1;
                    }
                }
            }
        }
        return coord;
    }

}

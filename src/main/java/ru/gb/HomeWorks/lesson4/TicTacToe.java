package ru.gb.HomeWorks.lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '.';


    private static final Scanner scanner = new Scanner(System.in);
//    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final Random random = new Random();

    private static char[][] field;
    private static char dotHuman;
    private static char dotAi;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int scoreHuman;
    private static int scoreAi;
    private static int roundCounter;
    private static int winLength;


    public static void main(String[] args) throws IOException {
        intField(3, 3);
        printField();
        humanTurn();
        printField();
    }

    private static void humanTurn() throws IOException {
        int x;
        int y;

        System.out.println("Введи координаты x & y  >>>>>");

        x = scanner.nextInt()- 1;
        y = scanner.nextInt()- 1;

        field[x][y] = DOT_X;

    }

    private static void intField(int sizeX, int sizeY){
        fieldSizeY = sizeY;
        fieldSizeX = sizeX;
        field = new char[fieldSizeY][fieldSizeX];

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField(){
        System.out.print("+");

        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            System.out.print(i % 2 == 0 ? "-" : i / 2 + 1);
        }

        System.out.println();
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");

            for (int j = 0; j < fieldSizeX; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            System.out.print("_");
        }
        System.out.println();
    }
}

package ru.gb.HomeWorks.lesson4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '.';

    private static final Scanner scanner = new Scanner(System.in);
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
        startNewGame();
    }

    private static void startNewGame() throws IOException{
        while(true) {
            chooseDot();
            playRound();

            System.out.printf("СЧЕТ:          ЧЕЛОВЕК          КОМПЬЮТЕР\n" +
                    "                  %d                 %d\n", scoreHuman, scoreAi);
            System.out.print("Хотите сыграть еще раз? (Y или N) >>>>>");

            if (!scanner.next().toLowerCase(Locale.ROOT).equals("y")){
                System.out.println("Пока!");
                break;
            }
        }
    }

    private static void chooseDot(){
        System.out.println("Введи 'X' если хочешь играть крестиками или '0', если хочешь играть ноликами >>>>> ");

        if (scanner.next().toLowerCase(Locale.ROOT).equals("x")){
            dotHuman = DOT_X;
            dotAi = DOT_O;
        } else {
            dotHuman = DOT_O;
            dotAi = DOT_X;
        }
    }

    private static void playRound() throws IOException{
        System.out.printf("Раунд %d начался!\n", ++roundCounter);
        initField(3, 3);
        printField();
        if (dotHuman == DOT_X) {
            humanFirst();
        } else {
            aiFirst();
        }
    }

    private static void initField(int sizeX, int sizeY){
        fieldSizeY = sizeY;
        fieldSizeX = sizeX;
        winLength = sizeX;
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
        for (int i = 0; i < fieldSizeX * 2 + 2; i++) {
            System.out.print("_");
        }
        System.out.println();
    }

    private static void humanFirst() throws IOException {
        while (true){
            humanTurn();
            printField();
            if (gameCheck(dotHuman)) {
                break;
            }
            aiTurn();
            printField();
            if (gameCheck(dotAi)) {
                break;
            }
        }
    }

    private static void aiFirst() throws IOException {
        while (true){
            aiTurn();
            printField();
            if (gameCheck(dotAi)) {
                break;
            }
            humanTurn();
            printField();
            if (gameCheck(dotHuman)) {
                break;
            }
        }
    }

    private static boolean gameCheck(char dot){
        if (checkWin(dot) && dot == dotHuman) {
            System.out.println("Человек победил!");
            scoreHuman++;
            return true;
        } else if (checkWin(dot) && dot == dotAi) {
            System.out.println("Компьютер победил!");
            scoreAi++;
            return true;
        }
        return checkDraw();
    }

    private static void aiTurn() throws IOException {
        int x;
        int y;

        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }while (!isCellValid(y, x));

        field[y][x] = dotAi;

    }

    private static void humanTurn() throws IOException {
        int x;
        int y;

        do { System.out.println("Введи координаты x & y  >>>>>");

            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(y, x));

        field[y][x] = dotHuman;

    }

    private static boolean checkDraw(){
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == DOT_EMPTY){
                    return false;
                }
            }
        }
        System.out.println("Ничья!");
        return true;
    }

    private static boolean checkWin(char dot){
        boolean result = false;
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == dot){
                    if (checkingTheLine(y, x, 0, 1) ||
                            checkingTheLine(y, x, 1, 0) ||
                            checkingTheLine(y, x, 1, 1) ||
                            checkingTheLine(y, x, 1, -1)) {
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    private static boolean checkingTheLine(int y, int x, int deltaY, int deltaX){
        int count = 0;
        for (int i = y, j = x; i < fieldSizeY && j < fieldSizeX && i >=0 && j >= 0; i += deltaY, j += deltaX) {
            if (field[i][j] == field[y][x]){
                count++;
            } else {
                break;
            }
        }
        return count >= winLength;
    }

    private static boolean isCellValid(int y, int x){
        return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY && field[y][x] == DOT_EMPTY;
    }

}

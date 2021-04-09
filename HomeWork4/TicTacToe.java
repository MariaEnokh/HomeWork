package HomeWork4;


import java.util.Random;
import java.util.Scanner;

    public class TicTacToe {

        public static final int FIELD_SIZE = 5;
        public static final int DOTS_TO_WIN = 4;

        public static final char EMPTY_DOT = '.';
        public static final char PLAYER_1_DOT = 'X';
        public static final char PLAYER_2_DOT = 'O';

        public static Scanner input = new Scanner(System.in);
        public static char[][] gameField;

        public static void initGameField() {
            gameField = new char[FIELD_SIZE][FIELD_SIZE];
            for (int i = 0; i < FIELD_SIZE; i++) {
                for (int j = 0; j < FIELD_SIZE; j++) {
                    gameField[i][j] = EMPTY_DOT;
                }
            }
        }

        public static void printGameField() {
            for (int i = 0; i <= gameField.length; i++) {
                System.out.print(i == 0 ? "  " : i + " ");
            }
            System.out.println();
            for (int i = 0; i < gameField.length; i++) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < gameField.length; j++) {
                    System.out.print(gameField[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        public static boolean isCellAvailable(int x, int y) {
            return x >= 0 && x < FIELD_SIZE && y >= 0 && y < FIELD_SIZE && gameField[y][x] == EMPTY_DOT;
        }

        public static void player1Move() {
            int x, y;
            do {
                System.out.printf("Введите координаты хода через пробел в формате X(= 1..%d) Y(= 1..%d):\n", FIELD_SIZE, FIELD_SIZE);
                x = Integer.valueOf(input.next()) - 1;
                y = Integer.valueOf(input.next()) - 1;
            } while (!isCellAvailable(x, y));
            gameField[y][x] = PLAYER_1_DOT;
        }

        public static void player2Move() {
            int x, y;
            do {
                x = new Random().nextInt(FIELD_SIZE);
                y = new Random().nextInt(FIELD_SIZE);
            } while (!isCellAvailable(x, y));
            System.out.println("ИИ походил в ячейку " + (x + 1) + " " + (y + 1));
            gameField[y][x] = PLAYER_2_DOT;
        }

        public static boolean isWin(char playerDot) {
            int hor, ver;
            int diagMain, diagReverse;
            for (int i = 0; i < FIELD_SIZE; i++) {
                hor = 0;
                ver = 0;
                for (int j = 0; j < FIELD_SIZE; j++) {
                    if (gameField[i][j] == playerDot) {
                        hor++;
                    } else if (gameField[i][j] != playerDot && hor < DOTS_TO_WIN) {
                        hor = 0;
                    }
                    if (gameField[j][i] == playerDot) {
                        ver++;
                    }   else if (gameField[j][i] != playerDot && ver < DOTS_TO_WIN) {
                        ver = 0;
                    }
                }
                if (hor >= DOTS_TO_WIN || ver >= DOTS_TO_WIN) {
                    System.out.println("По горизонтали или вертикали " + hor + " " + ver);
                    return true;
                }
            }

            for (int j = 0; j < FIELD_SIZE; j++) {
                diagMain = 0;
                for (int i = 0; i < FIELD_SIZE; i++) {
                    int k = j + i;
                    if (k < FIELD_SIZE) {
                        if (gameField[i][k] == playerDot) {
                            diagMain++;
                        } else if (gameField[i][k] != playerDot && diagMain < DOTS_TO_WIN) {
                            diagMain = 0;
                        }
                    }
                    if (diagMain >= DOTS_TO_WIN) {
                        System.out.println("По главной диагонали от центральной оси вправо " + diagMain);
                        return true;
                    }
                }
            }
            for (int j = 1; j < FIELD_SIZE; j++) {
                diagMain = 0;
                for (int i = 0; i < FIELD_SIZE; i++) {
                    int k = j + i;
                    if (k < FIELD_SIZE) {
                        if (gameField[k][i] == playerDot) {
                            diagMain++;
                        } else if (gameField[k][i] != playerDot && diagMain < DOTS_TO_WIN) {
                            diagMain = 0;
                        }
                    }
                    if (diagMain >= DOTS_TO_WIN) {
                        System.out.println("По главной диагонали от центральной оси вниз " + diagMain);
                        return true;
                    }
                }
            }
            for (int j = 0; j < FIELD_SIZE; j++) {
                diagReverse = 0;
                for (int i = 0; i < FIELD_SIZE; i++) {
                    int k = (FIELD_SIZE - 1) - i;
                    int l = j + i;
                    if (k >= 0 && l < FIELD_SIZE) {
                        if (gameField[l][k] == playerDot) {
                            diagReverse++;
                        } else if (gameField[l][k] != playerDot && diagReverse < DOTS_TO_WIN) {
                            diagReverse = 0;
                        }
                    }
                    if (diagReverse >= DOTS_TO_WIN) {
                        System.out.println("По побочной диагонали от центральной оси вниз " + diagReverse);
                        return true;
                    }
                }
            }
            for (int j = 1; j < FIELD_SIZE; j++) {
                diagReverse = 0;
                for (int i = 0; i < FIELD_SIZE; i++) {
                    int k = (FIELD_SIZE - 1) - j - i;
                    if (k >= 0) {
                        if (gameField[i][k] == playerDot) {
                            diagReverse++;
                        } else if (gameField[i][k] != playerDot && diagReverse < DOTS_TO_WIN) {
                            diagReverse = 0;
                        }
                    }
                    if (diagReverse >= DOTS_TO_WIN) {
                        System.out.println("По побочной диагонали от центральной оси влево " + diagReverse);
                        return true;
                    }
                }
            }
            return false;
        }

        public static boolean isDraw() {
            for (char[] aGameField : gameField) {
                for (int j = 0; j < gameField.length; j++) {
                    if (aGameField[j] == EMPTY_DOT) {
                        return false;
                    }
                }
            }
            return true;
        }

        public static void main(String[] args) {
            initGameField();
            System.out.printf("Цель игры - заполнить подряд линию по вертикали, горизонтали или диагонали из %d Ваш%s символ%s.\n", DOTS_TO_WIN, (DOTS_TO_WIN % 10 == 1 && DOTS_TO_WIN % 100 != 11) ? "его" : "их", (DOTS_TO_WIN % 10 == 1 && DOTS_TO_WIN % 100 != 11) ? "а" : "ов");
            printGameField();

            switch (new Random().nextInt(2)) {
                case 0: {
                    System.out.println("Ваш ход первый!");
                    while (true) {
                        player1Move();
                        printGameField();
                        if (isWin(PLAYER_1_DOT)) {
                            System.out.println("Победил Игрок 1");
                            break;
                        }
                        if (isDraw()) {
                            System.out.println("Ничья");
                            break;
                        }
                        player2Move();
                        printGameField();
                        if (isWin(PLAYER_2_DOT)) {
                            System.out.println("Победил ИИ");
                            break;
                        }
                        if (isDraw()) {
                            System.out.println("Ничья");
                            break;
                        }
                    }
                    break;
                }
                case 1: {
                    System.out.println("Первый ход за ИИ!");
                    while (true) {
                        player2Move();
                        printGameField();
                        if (isWin(PLAYER_2_DOT)) {
                            System.out.println("Победил ИИ");
                            break;
                        }
                        if (isDraw()) {
                            System.out.println("Ничья");
                            break;
                        }
                        player1Move();
                        printGameField();
                        if (isWin(PLAYER_1_DOT)) {
                            System.out.println("Победил Игрок 1");
                            break;
                        }
                        if (isDraw()) {
                            System.out.println("Ничья");
                            break;
                        }
                    }
                }
            }
        }
    }


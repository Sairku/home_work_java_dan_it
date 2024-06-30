import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
            final int SIZE = 5;

            char[][] board = new char[SIZE][SIZE];
            initializeBoard(board);

            Random random = new Random();
            int targetRow = random.nextInt(SIZE);
            int targetCol = random.nextInt(SIZE);

            System.out.println("All Set. Get ready to rumble!");

            Scanner scanner = new Scanner(System.in);
            boolean game = true;

            while (game) {

                printBoard(board);

                System.out.print("Enter row (1-5): ");
                int row = scanner.nextInt() - 1;

                System.out.print("Enter column (1-5): ");
                int col = scanner.nextInt() - 1;

                if (row == targetRow && col == targetCol) {
                    board[row][col] = 'x';
                    printBoard(board);
                    System.out.println("You have won!");
                    game = false;
                } else {
                    board[row][col] = '*';
                }
            }
        }

        private static void initializeBoard(char[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    board[i][j] = '-';
                }
            }
        }

        private static void printBoard(char[][] board) {
            System.out.println("  1 2 3 4 5");
            for (int i = 0; i < board.length; i++) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < board[i].length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }

    }

/**
 * Simple Tic-Tac-Toe in Console
 *
 * This program allows two players to play Tic-Tac-Toe in the console.
 * The players take turns selecting fields on the board, and the game
 * checks for winning conditions after each move.
 *
 * @author Oskar Kalbarczyk
 * GitHub: https://github.com/oskalbarczyk
 *
 * @version 1
 */

import java.util.Scanner;

public class Main {

    public static Field [] board = new Field[9];
    public static void main(String[] args) {
         // Welcome message and author information
        System.out.println("Welcome to Simple Tic-Tac-Toe in Console" + "\n"
                + "@author Oskar Kalbarczyk" + "\n"
                + "Visit my gitHub at: https://github.com/oskalbarczyk" + "\n" +
                "Or my youtube channel: https://www.youtube.com/@codewithoskar" );

        Scanner sc = new Scanner(System.in);

        // O player is always first;
        boolean isOturn = true;

        createBoard();


    
        while (true) {
            printBoard();
            // Check if the game is over
            if (isGameOver()) {
                System.out.println("Game Over!");
                break;
            }
            // Player's turn
            System.out.println("Turn: " + (isOturn ? "O" : "X"));
            System.out.println("Select field you want to cover.");
            boolean correctMoveHappened = false;
            while (!correctMoveHappened ) {
                int selectedField = sc.nextInt();

                if (!board[selectedField - 1].getSymbol().equals(" ")) {
                    System.out.println("Field already covered..." + "\n"
                                        + " Select other field.");
                }else {
                    // Update the selected field with the player's symbol
                    board[selectedField - 1].setSymbol(isOturn ? "O" : "X");
                    correctMoveHappened = true;
                }

            }
            // Switch turns
            isOturn = !isOturn;
        }




    }
     /**
     * Creates the initial game board with empty fields.
     */

    public static void createBoard () {
        for (int i = 0; i < board.length; i++) {
            board[i] = new Field(" ");
        }
    }
    
    /**
     * Prints the current game board.
     */
    public static void printBoard() {
        for (int i = 0; i < board.length; i++) {
            String symbol = board[i].getSymbol();
            if (symbol.equals(" ")) {
                System.out.print("|" + (i+1));
            } else {
                System.out.print("|" + symbol);
            }
            if ((i+1) % 3 == 0) {
                System.out.println("|");
            }
        }
    }
     /**
     * Checks if the game is over by checking for winning conditions
     * and a full board.
     *
     * @return true if the game is over, false otherwise
     */

    public static boolean isGameOver () {

        //Check if Rows are taken by the same Player
        for (int i = 0; i < 9; i += 3) {
            if (!board[i].getSymbol().equals(" ")
                    && board[i].getSymbol().equals(board[i+1].getSymbol())
                    && board[i].getSymbol().equals(board[i+2].getSymbol())) {
                return true;
            }
        }

        // Check if Columns are taken by the same Player
        for (int i = 0; i < 3; i++) {
            if (!board[i].getSymbol().equals(" ")
                    && board[i].getSymbol().equals(board[i+3].getSymbol())
                    && board[i].getSymbol().equals(board[i+6].getSymbol())) {
                return true;
            }
        }
        // Check diagonals
        if (!board[0].getSymbol().equals(" ")
                && board[0].getSymbol().equals(board[4].getSymbol())
                && board[0].getSymbol().equals(board[8].getSymbol())) {
            return true;
        }
        if (!board[2].getSymbol().equals(" ")
                && board[2].getSymbol().equals(board[4].getSymbol())
                && board[2].getSymbol().equals(board[6].getSymbol())) {
            return true;
        }
        // Check if the board is full
        for (int i = 0; i < 9; i++) {
            if (board[i].getSymbol().equals(" ")) {
                return false;
            }
        }
        return true;
    }









}
/**
 * Represents a field on the Tic-Tac-Toe board.
 */

 class Field {

    private String symbol;

     public Field(String symbol) {
         this.symbol = symbol;
     }

     public String getSymbol() {
         return symbol;
     }

     public void setSymbol(String symbol) {
         this.symbol = symbol;
     }

     @Override
     public String toString() {
         return symbol;
     }
 }



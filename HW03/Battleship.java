import java.util.Scanner;

public class Battleship {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Battleship!\n");

        char[][] playerOneBoard = new char[5][5];
        char[][] playerTwoBoard = new char[5][5];
        char[][] playerOneTargetBoard = new char[5][5];
        char[][] playerTwoTargetBoard = new char[5][5];
        fillBoardWithDashes(playerOneTargetBoard);
        fillBoardWithDashes(playerTwoTargetBoard);

        //initialize Player One board
        fillBoardWithDashes(playerOneBoard);
        fillBoardWithUserCoordinates(1, playerOneBoard);
        printBattleShip(playerOneBoard);
        hideBoard();

        //initialize Player Two board
        fillBoardWithDashes(playerTwoBoard);
        fillBoardWithUserCoordinates(2, playerTwoBoard);
        printBattleShip(playerTwoBoard);
        hideBoard();

        boolean gameOver = false;

        int currentPlayer = 1;
        int playerOneHits = 0;
        int playerTwoHits = 0;

        while (!gameOver) {

            playerOneHits += didPlayerHit(1, playerTwoBoard, playerOneTargetBoard);
            if (playerOneHits == 5) {
                break;
            }
            System.out.println();
            playerTwoHits += didPlayerHit(2, playerOneBoard, playerTwoTargetBoard);
            if (playerTwoHits == 5) {
                break;
            }
            System.out.println();
        }

        if(playerOneHits > playerTwoHits) {
            System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!\n");
//            System.out.println("Final boards:");
//            printBattleShip(playerOneBoard);
//            printBattleShip(playerTwoBoard);
        } else {
            System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!\n");

//            System.out.println("Final boards:");
//            printBattleShip(playerTwoBoard);
//            printBattleShip(playerOneBoard);
        }
        System.out.println("Final boards:\n");
        printBattleShip(playerOneBoard);
        System.out.println();
        printBattleShip(playerTwoBoard);
    }

    // Use this method to print game boards to the console.
    private static void printBattleShip(char[][] player) {
        System.out.print("  ");
        for (int row = -1; row < 5; row++) {
            if (row > -1) {
                System.out.print(row + " ");
            }
            for (int column = 0; column < 5; column++) {
                if (row == -1) {
                    System.out.print(column + " ");
                } else {
                    System.out.print(player[row][column] + " ");
                }
            }
            System.out.println("");
        }
    }

    private static char[][] fillBoardWithDashes(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                board[i][j] = '-';
            }
        }
        return board;
    }

    private static char[][] fillBoardWithUserCoordinates(int player, char[][] board) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("PLAYER %d, ENTER YOUR SHIPS' COORDINATES.\n", player);
        int i = 1;

        do {
            System.out.printf("Enter ship %d location:\n", i);
            int coordinateOne = sc.nextInt();
            int coordinateTwo = sc.nextInt();
            if(validInputCheck(coordinateOne) && validInputCheck(coordinateTwo) && !isDuplicateCheck(coordinateOne, coordinateTwo, board)){
                board[coordinateOne][coordinateTwo] = '@';
                i++;
            } else if (!validInputCheck(coordinateOne) || !validInputCheck(coordinateTwo)) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
            }
            else {
                System.out.println("You already have a ship there. Choose different coordinates.");
            }
        }
        while (i < 6);
        return board;
    }

    private static int didPlayerHit(int player, char[][] board, char[][] targetBoard) {
        Scanner sc = new Scanner(System.in);
//        System.out.printf("Player %d, enter hit row/column:\n", player);
        boolean turnComplete = false;
        int hit = 0;

        while (!turnComplete) {
            System.out.printf("Player %d, enter hit row/column:\n", player);
            int coordinateOne = sc.nextInt();
            int coordinateTwo = sc.nextInt();
            if(validInputCheck(coordinateOne) && validInputCheck(coordinateTwo) && isValidFire(coordinateOne, coordinateTwo, targetBoard)){
                if(isHit(coordinateOne, coordinateTwo, board)){
                    board[coordinateOne][coordinateTwo] = 'X';
                    targetBoard[coordinateOne][coordinateTwo] = 'X';
                    System.out.printf("PLAYER %d HIT PLAYER %d's SHIP!\n", player, player == 1 ? 2 : 1);
                    printBattleShip(targetBoard);
                    hit = 1;
                }else {
                    board[coordinateOne][coordinateTwo] = 'O';
                    targetBoard[coordinateOne][coordinateTwo] = 'O';
                    System.out.printf("PLAYER %d MISSED!\n", player);
                    printBattleShip(targetBoard);
                }
                turnComplete = true;
            } else if (!validInputCheck(coordinateOne) || !validInputCheck(coordinateTwo)) {
                System.out.println("Invalid coordinates. Choose different coordinates.");
            }
            else {
                System.out.println("You already fired on this spot. Choose different coordinates.");
            }
        }

        return hit;
    }

    private static boolean isValidFire(int row, int col, char[][] targetBoard){
        if(targetBoard[row][col] == 'X' || targetBoard[row][col] == 'O'){
            return false;
        } else {
            return true;
        }
    }

    private static boolean isHit(int row, int col, char[][] board) {
        if(board[row][col] == '@'){
            return true;
        } else {
            return false;
        }
    }

    private static boolean validInputCheck(int userInput) {
        if(userInput < 0 || userInput >= 5) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean isDuplicateCheck(int one, int two, char[][] userBoard) {
        boolean duplicate = false;
        if(userBoard[one][two] == '@') {
            duplicate = true;
        }
        return duplicate;
    }

    private static void hideBoard() {
        int num = 0;
        while (num < 100) {
            System.out.print("\n");
            num++;
        }
    }
}

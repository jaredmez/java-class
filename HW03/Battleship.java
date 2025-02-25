import java.util.Scanner;

public class Battleship {

    public static void main(String[] args) {

        System.out.println("Welcome to the Battleship!");
        char[][] playerOneBoard = new char[5][5];
        char[][] playerTwoBoard = new char[5][5];
        fillBoardWithDashes(playerOneBoard);
        fillBoardWithUserCoordinates(1, playerOneBoard);
        printBattleShip(playerOneBoard);
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
                System.out.println("Invalid coordinates. Choose different coordinates.\n");
            }
            else {
                System.out.println("You already fired on this spot. Choose different coordinates.");
            }
        }
        while (i < 6);
        return board;
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
}

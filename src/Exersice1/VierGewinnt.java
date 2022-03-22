package Exersice1;

import java.util.Scanner;

public class VierGewinnt {

    static char Player1 = 'X';
    static char Player2 = 'O';
    static int rowCount = 6;
    static int columnCount = 7;
    static char[][] gameGrid = new char[rowCount][columnCount];

    static int[] playerMove(char player) {
        Scanner sc = new Scanner(System.in);
        char input;
        do {
            input = sc.next().charAt(0);
        } while (input < '0' || input > '6');
        int inputIndex = input - 48;
        for (int i = rowCount - 1; i >= 0; i--) {
            if (gameGrid[i][inputIndex] == '.') {
                gameGrid[i][inputIndex] = player;
                return new int[] {i, inputIndex};
            }
        }
        return new int[] {-1, -1};
    }

    static boolean hasPlayerWon(int gridIndexRow, int gridIndexColumn, char playerIdentifier){

        //always search for left/bottom most equal char
        int mutableRowIndex = gridIndexRow;
        int mutableColumnsIndex = gridIndexColumn;
        System.out.println(mutableColumnsIndex);

        //horizontal
        for(int i = mutableColumnsIndex; i >= 0; i--){
            mutableColumnsIndex = i;
            if (gameGrid[gridIndexRow][i] == playerIdentifier) {
                continue;
            }
            mutableColumnsIndex = i + 1;
            break;
        }
        System.out.println("search leftmost index index:" + mutableColumnsIndex);
        for(int i = mutableColumnsIndex; i < mutableColumnsIndex + 4; i++){
            if (gameGrid[gridIndexRow][i] != playerIdentifier) {
                break;
            }
            if(i == mutableColumnsIndex + 3) {
                System.out.println(i);
                return true;
            }
        }

        if(gridIndexRow > 2) return false;
        //vertical
        //search bottommost
        for(int i = gridIndexRow; i < rowCount; i++){
            mutableRowIndex = i;
            if (gameGrid[gridIndexRow][i] == playerIdentifier) {
                continue;
            }
            mutableRowIndex = i - 1;
            break;
        }
        System.out.println("search bottommost index index:" + mutableRowIndex);
        for(int i = mutableRowIndex; i < mutableRowIndex + 4; i++){
            if (gameGrid[gridIndexRow][i] != playerIdentifier) {
                break;
            }
            if(i == mutableRowIndex + 3) {
                System.out.println(i);
                return true;
            }
        }

        //diagonal
        for(int i = 0; i < 4; i++){

        }

        return false;
    }

    static void paintGrid(){
        for (int i = 0; i < columnCount; i++){
            System.out.printf("%02d ", i);
        }
        System.out.println();
        for (char[] row:gameGrid) {
            for (char c:row) {
                System.out.printf("%c  ", c);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //before game start
        for (int i = 0; i < rowCount; i++){
            for(int j = 0; j < columnCount;j++){
                gameGrid[i][j] = '.';
            }
        }

        int[] gridSlot;

        paintGrid();
        //game loop
        while(true){
            gridSlot = playerMove(Player1);
            paintGrid();
            if(hasPlayerWon(gridSlot[0], gridSlot[1], Player1)) {
                System.out.println("Player" + Player1 + "Won");
                break;
            }
            gridSlot = playerMove(Player2);
            paintGrid();
            if(hasPlayerWon(gridSlot[0], gridSlot[1], Player2)) {
                System.out.println("Player" + Player1 + "Won");
                break;
            }
        }
    }
}

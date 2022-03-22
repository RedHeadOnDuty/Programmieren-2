package Exersice1;

import java.util.Scanner;

public class VierGewinnt {

    static char Player1 = 'X';
    static char Player2 = 'O';
    static int rowCount = 6;
    static int columnCount = 7;
    static char[][] gameGrid = new char[rowCount][columnCount];

    static void playerMove(char player){
        Scanner sc = new Scanner(System.in);
        char input;
        do{
            input = sc.next().charAt(0);
        }while (input < '0' || input > '6');
        int inputIndex = input - 48;
        for(int i = rowCount - 1; i >= 0; i--){
            if (gameGrid[i][inputIndex] == '.')
            {
                gameGrid[i][inputIndex] = player;
                break;
            }
        }

        //

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

        //game loop
        while(true){
            paintGrid();
            playerMove(Player1);
            paintGrid();
            playerMove(Player2);
        }
    }
}

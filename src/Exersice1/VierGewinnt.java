package Exersice1;

public class VierGewinnt {

    static char Player1 = 'X';
    static char Player2 = 'O';
    static int rowCount = 5;
    static int columnCount = 6;
    static char[][] gameGrid = new char[5][6];

    static void playerMove(char player){

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
        paintGrid();
        //game loop
        while(true){
            playerMove(Player1);
            playerMove(Player2);
        }
    }
}

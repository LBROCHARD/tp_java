package com.tp_java;

public class Plateau {
    char[] board1 = { 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    char[] board2 = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    char[] board3 = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    char[] board4 = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    char[] board5 = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    char[] board6 = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

    char[][] board = { board1, board2, board3, board4, board5, board6 };

    public Boolean IsColonneFull(int colonneNumber) {
        if (board1[colonneNumber] == ' ') {
            Affichage.Print("fill column");
            return false;
        } else {
            return true;
        }
    }

    public void FillColumn(int colonneNumber) {
        Affichage.Print("fill column");
    }

    public Boolean isPlateauFull(){
        return false;
    }

}
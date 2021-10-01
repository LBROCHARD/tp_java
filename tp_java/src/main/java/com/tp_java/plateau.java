package com.tp_java;

<<<<<<< HEAD
public class plateau {
    char[] board1 = { 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
=======
public class Plateau {
    char[] board1 = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
>>>>>>> b9f3acecb9212df7581f5677d46a2027698572c7
    char[] board2 = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    char[] board3 = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    char[] board4 = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    char[] board5 = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    char[] board6 = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

    char[][] board = { board1, board2, board3, board4, board5, board6 };

    public Boolean IsColonneFull(int colonneNumber) {
<<<<<<< HEAD
        if (board1[colonneNumber] == ' ') {
            affichage.Print("fill column");
=======
        if (board[0][colonneNumber] == ' ') {
>>>>>>> b9f3acecb9212df7581f5677d46a2027698572c7
            return false;
        } else {
            return true;
        }
    }

    public void FillColumn(int colonneNumber) {
<<<<<<< HEAD
        affichage.Print("fill column");
=======

        Affichage.Print("fill column " + colonneNumber);
        for (int i = 5 ; i+1 > 0 ; i--) {

            if (board[i][colonneNumber] == ' '){

                if (Jeu.color == "Yellow") {
                    board[i][colonneNumber] = 'O';
                    break;
                } else {
                    board[i][colonneNumber] = 'X';
                    break;
                }
            }
        }
>>>>>>> b9f3acecb9212df7581f5677d46a2027698572c7
    }

    public Boolean isPlateauFull(){
        for (int i = 0; i < 8; i++) {

            if (IsColonneFull(i) == false) {
                return false;
            }
        }
        return true;
    }

    public Boolean Victory(){
        return false;
    }

}
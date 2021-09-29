package com.tp_java;

public class plateau {
    pion[] board1 ;
    pion[] board2 ;
    pion[] board3 ;
    pion[] board4 ;
    pion[] board5 ;
    pion[] board6 ;

    pion[][] board = { board1, board2, board3, board4, board5, board6 };

    plateau(){

    }

    public Boolean IsColonneFull(int colonneNumber) {
        //board[colonneNumber] != full
        return true;
    }

}

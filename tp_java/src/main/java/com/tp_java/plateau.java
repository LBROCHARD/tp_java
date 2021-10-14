package com.tp_java;

public class Plateau {
    int last_position_ligne = 0;
    int last_position_colonne = 0;
    char lastcolor = ' ';

    char[] board1 = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    char[] board2 = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    char[] board3 = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    char[] board4 = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    char[] board5 = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    char[] board6 = { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

    char[][] board = { board1, board2, board3, board4, board5, board6 };

    public Boolean IsColonneFull(int colonneNumber) {
        if (board[0][colonneNumber] == ' ') {
            return false;
        } else {
            return true;
        }
    }

    public void FillColumn(int colonneNumber) {

        Affichage.Print("fill column " + colonneNumber);
        for (int i = 5 ; i+1 > 0 ; i--) {

            if (board[i][colonneNumber] == ' '){

                if (Jeu.color  =="Yellow") {
                    board[i][colonneNumber] = 'O';
                    last_position_ligne = i;
                    last_position_colonne = colonneNumber;
                    Affichage.Print( "last_position = [" + last_position_ligne + "] ["  + last_position_colonne + "]");

                    break;

                } else {
                    board[i][colonneNumber] = 'X';
                    last_position_ligne = i;
                    last_position_colonne = colonneNumber;
                    Affichage.Print( "last_position = [" + last_position_ligne + "] ["  + last_position_colonne + "]");
                    break;
                }
            }
        }
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
        if(Jeu.color == "Yellow"){
            lastcolor = 'O';
            // Affichage.Print("last color = O");
        } else {
            lastcolor = 'X';
            // Affichage.Print("last color = X");

        }
        if (CheckSide(lastcolor)){
            return true;
        } else if (CheckUp(lastcolor)){
            return true;
        } else if (CheckDGD(lastcolor)){
            return true;
        } else if (CheckDDG(lastcolor)){
            return true;
        }


        return false;
    }

    public Boolean CheckSide(char lastcolor) {
        int in_a_row = 0;

        for ( int i = 0 ; last_position_colonne + i < 7 ; i++ ) {
            // Affichage.Printf( "[" + last_position_ligne + "] [" + (last_position_colonne + i) + "]" );
            if (board[last_position_ligne][(last_position_colonne + i)] == lastcolor ) {
                in_a_row += 1;
                // Affichage.Print(" there is an " + lastcolor + " here !");
                // Affichage.Print("in a row = " + in_a_row);
            } else {
                // Affichage.Print(" is a NULL or the other color here !");
                break;
            }
            if (in_a_row == 4) {
                return true;
            }
        }
        for ( int i = -1 ; last_position_colonne + i >= 0 ; i-- ) {
            // Affichage.Printf( "[" + last_position_ligne + "] [" + (last_position_colonne + i) + "]" );
            if (board[last_position_ligne][(last_position_colonne + i)] == lastcolor ) {
                in_a_row += 1;
                // Affichage.Print(" there is an " + lastcolor + " here !");
                // Affichage.Print("in a row = " + in_a_row);
            } else {
                // Affichage.Print(" is a NULL or the other color here !");
                return false;
            }
            if (in_a_row == 4) {
                return true;
            }
        }
        // Affichage.Print("end side");
        return false;
    }

    public Boolean CheckUp(char lastcolor) {
        int in_a_row = 0;

        for ( int i = 0; last_position_ligne + i < 6 ; i++ ) {
            // Affichage.Printf( "[" + (last_position_ligne + i) + "] [" + last_position_colonne + "]" );
            if (board[ (last_position_ligne + i) ][last_position_colonne] == lastcolor ) {
                in_a_row += 1;
                // Affichage.Print(" there is an " + lastcolor + " here !");
                // Affichage.Print("in a row = " + in_a_row);
            } else {
                // Affichage.Print(" is a NULL or the other color here !");
                return false;
            }
            if (in_a_row == 4) {
                return true;
            }
        }
        // Affichage.Print("end up");
        return false;
    }

    public Boolean CheckDGD(char lastcolor) {
        int in_a_row = 0;

        for ( int i = 0 ; last_position_colonne + i < 8 ; i++ ) {
            // Affichage.Printf( "[" + (last_position_ligne - i) + "] [" + (last_position_colonne + i) + "]" );
            if (last_position_ligne - i < 0 ) {
                // Affichage.Print("nop break");
                break;
            }
            if (board[last_position_ligne - i ][last_position_colonne + i] == lastcolor ) {
                in_a_row += 1;
                // Affichage.Print(" there is an " + lastcolor + " here !");
                // Affichage.Print("in a row = " + in_a_row);
            } else {
                // Affichage.Print(" is a NULL or the other color here !");
                break;
            }
            if (in_a_row == 4) {
                return true;
            }
        }
        for ( int i = 1 ; last_position_colonne - i >= 0; i++ ) {
            // Affichage.Printf( "[" + (last_position_ligne + i) + "] [" + (last_position_colonne - i) + "]" );
            if (last_position_ligne + i >= 6 ) {
                // Affichage.Print("nop break");
                break;
            }
            if (board[last_position_ligne + i][(last_position_colonne - i)] == lastcolor ) {
                in_a_row += 1;
                // Affichage.Print(" there is an " + lastcolor + " here !");
                // Affichage.Print("in a row = " + in_a_row);
            } else {
                // Affichage.Print(" is a NULL or the other color here !");
                return false;
            }
            if (in_a_row == 4) {
                return true;
            }
        }
        // Affichage.Print("end dgd");
        return false;
    }

    public Boolean CheckDDG(char lastcolor) {
        int in_a_row = 0;

        for ( int i = 0 ; last_position_colonne - i >= 0 ; i++ ) {
            // Affichage.Printf( "[" + (last_position_ligne - i) + "] [" + (last_position_colonne - i) + "]" );
            if (last_position_ligne - i < 0 ) {
                // Affichage.Print("nop break");
                break;
            }
            if (board[last_position_ligne - i ][last_position_colonne - i] == lastcolor ) {
                in_a_row += 1;
                // Affichage.Print(" there is an " + lastcolor + " here !");
                // Affichage.Print("in a row = " + in_a_row);
            } else {
                // Affichage.Print(" is a NULL or the other color here !");
                break;
            }
            if (in_a_row == 4) {
                return true;
            }
        }
        for ( int i = 1 ; last_position_colonne + i < 8; i++ ) {
            // Affichage.Printf( "[" + (last_position_ligne + i) + "] [" + (last_position_colonne + i) + "]" );
            if (last_position_ligne + i >= 6 ) {
                // Affichage.Print("nop break");
                break;
            }
            if (board[last_position_ligne + i][(last_position_colonne + i)] == lastcolor ) {
                in_a_row += 1;
                // Affichage.Print(" there is an " + lastcolor + " here !");
                // Affichage.Print("in a row = " + in_a_row);
            } else {
                // Affichage.Print(" is a NULL or the other color here !");
                return false;
            }
            if (in_a_row == 4) {
                return true;
            }
        }
        // Affichage.Print("end ddg");
        return false;
    }

}
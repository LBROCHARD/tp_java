package com.tp_java;


public class plateau {
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

        affichage.Print("fill column " + colonneNumber);
        for (int i = 5 ; i+1 > 0 ; i--) {

            if (board[i][colonneNumber] == ' '){

                if (jeu.color == "Yellow") {
                    board[i][colonneNumber] = 'O';
                    break;
                } else {
                    board[i][colonneNumber] = 'X';
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

    public void Victory(char symbol, int y , int x){
        int victory = 0;
        int somme;
        somme=-1;
        

        for(int i = 1; i <= 6*8; i++) {
            //-->  verticale:
            while(y < 8 && jeu.plateau.board[x][y] == symbol) {
                y++;
                victory++;
            } if(victory > somme) somme= victory;
            System.out.print("il y a " + victory + "de" + symbol);
           

            //-->  horizontale:
            
            while(x < 8 && jeu.plateau.board[x][y] == symbol) {
                x--;
                victory++;
            }
            if(victory > somme) somme= victory;
            while(x < 6 && jeu.plateau.board[x][y] == symbol) {
                x++;
                victory++;
            }
            if(victory > somme) somme= victory;
            System.out.print("il y a " + victory + "de" + symbol);
            
        } 
    }
    

}

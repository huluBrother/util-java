package org.zhx.tictactoe;

import java.util.Arrays;
import java.util.List;

public class TicTacToeGame {
    public static final int ROW = 3;
    public static final int COL = 3;
    public static final int BLACK = 1;
    public static final int WHITE = -1;
    public static final int EMPTY = 0;
    public static final int GAMEOVER = 2;



    private int game[][] = new int[3][3];
    private int curPlayer = WHITE;

    public TicTacToeGame(){

    }
    public void move(Point p){
        move(p.getX(),p.getY());
    }

    public void move(int x,int y){
        game[x][y] = curPlayer;
        curPlayer = curPlayer * -1;
    }

    public void unmove(Point p){
        unmove(p.getX(),p.getY());
    }

    public void unmove(int x,int y){
        game[x][y] = EMPTY;
        curPlayer = curPlayer * -1;
    }
    public void allMove(List<Point> allmove){
        allmove.clear();
        for(int i = 0;i<ROW;i++){
            for(int j=0;j<COL;j++){
                if(game[i][j] == EMPTY){
                    allmove.add(Point.getPoint(i,j));
                }
            }
        }
    }

    public void clean(){
        for(int i = 0;i<ROW;i++){
            for(int j=0;j<COL;j++){
                game[i][j] = 0;
            }
        }
        curPlayer = WHITE;
    }

    public void showGame(){
        System.out.println("");
        for(int i = 0;i<ROW;i++){
            for(int j=0;j<COL;j++){
                if(game[i][j] == WHITE){
                    System.out.print("-O-");
                }else if(game[i][j] == BLACK){
                    System.out.print("-X-");
                }else{
                    System.out.print("-*-");
                }
            }
            System.out.println();
        }
    }

    public int gameOver(){
        int size = 0;
        for(int i=0;i<ROW;i++){
            if(game[i][0] == WHITE && game[i][1] == WHITE && game[i][2] == WHITE) return WHITE;
            if(game[0][i] == WHITE && game[1][i] == WHITE && game[2][i] == WHITE) return WHITE;

            if(game[i][0] == BLACK && game[i][1] == BLACK && game[i][2] == BLACK) return BLACK;
            if(game[0][i] == BLACK && game[1][i] == BLACK && game[2][i] == BLACK) return BLACK;

            if(game[i][0] != EMPTY) size++;
            if(game[i][1] != EMPTY) size++;
            if(game[i][2] != EMPTY) size++;
        }
        if(size == 9){
            return GAMEOVER;
        }
        if(game[0][0] == WHITE && game[1][1] == WHITE && game[2][2] == WHITE ) return WHITE;
        if(game[0][2] == WHITE && game[1][1] == WHITE && game[2][0] == WHITE ) return WHITE;

        if(game[0][0] == BLACK && game[1][1] == BLACK && game[2][2] == BLACK ) return BLACK;
        if(game[0][2] == BLACK && game[1][1] == BLACK && game[2][0] == BLACK ) return BLACK;

        return EMPTY;
    }

    public int getCurPlayer() {
        return curPlayer;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("\n");
        for(int i = 0;i<ROW;i++){
            for(int j=0;j<COL;j++){
                if(game[i][j] == WHITE){
                    buffer.append("-O-");
                }else if(game[i][j] == BLACK){
                    buffer.append("-X-");
                }else{
                    buffer.append("-*-");
                }
            }
            buffer.append("\n");
        }
        return buffer.toString();
    }
}

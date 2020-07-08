package org.zhx.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    public static Scanner sc = new Scanner(System.in);
    private void showList(){
        System.out.println("输入数字进行测试游戏:");
        System.out.println("输入 1 进行人人测试");
        System.out.println("输入 2 进行人机测试");
        System.out.println("输入 3 进行机人测试");
        System.out.println("输入 4 进行机机测试");
        System.out.println("输入其他值退出.");
        System.out.print(">>>>>>");
    }

    public void run(){

        TicTacToeGame game = new TicTacToeGame();
        boolean gameOver = false;
        while(!gameOver)
        {
            showList();
            int responseCode = sc.nextInt();
            System.out.println("输入值为<<<<< " + responseCode);
            switch (responseCode)
            {
                case 1:
                    PvP(game);
                    break;
                case 2:
                    PvR(game);
                    break;
                case 3:
                    RvP(game);
                    break;
                case 4:
                    RvR(game);
                    break;
                default:
                    gameOver = true;
                    break;
            }
        }
        gameOver = true;
    }
    public void showAction(int i, Point p){
        System.out.print("输入->");
        System.out.print(i);
        System.out.print(" 获得下法(");
        System.out.print(p.getX());
        System.out.print(",");
        System.out.print(p.getY());
        System.out.println(")");
    }
    private void PvR(TicTacToeGame game){
        game.clean();
        game.showGame();
        int playerType = game.getCurPlayer() * -1;
        List<Point>  allMove = new ArrayList<>();
        while(game.gameOver() == TicTacToeGame.EMPTY){
            Point action = null;
            if(game.getCurPlayer() == playerType){
                action = robotMove(game);
            }else{
                game.allMove(allMove);
                for(int i = 0;i<allMove.size();i++){
                    showAction(i,allMove.get(i));
                }
                System.out.print("您的棋子为 ");
                if(game.getCurPlayer() == TicTacToeGame.WHITE){
                    System.out.print(" O ");
                }else{
                    System.out.print(" X ");
                }

                System.out.println("输入>>>>>>>");
                int movePos = sc.nextInt();
                action = allMove.get(movePos);
            }
            game.move(action);
            game.showGame();
        }
        switch (game.gameOver()){
            case TicTacToeGame.WHITE:
                System.out.println("O 赢了");
                break;
            case TicTacToeGame.BLACK:
                System.out.println("X 赢了");
                break;
            case TicTacToeGame.GAMEOVER:
                System.out.println("和了");
                break;
        }
    }

    private void RvR(TicTacToeGame game){
        game.clean();
        game.showGame();
        int playerType = game.getCurPlayer() * -1;
        List<Point>  allMove = new ArrayList<>();
        while(game.gameOver() == TicTacToeGame.EMPTY){
            Point action = null;
            if(game.getCurPlayer() == playerType){
                action = robotMove(game);
            }else{
                action = robotMove(game);
            }
            game.move(action);
            game.showGame();
        }
        switch (game.gameOver()){
            case TicTacToeGame.WHITE:
                System.out.println("O 赢了");
                break;
            case TicTacToeGame.BLACK:
                System.out.println("X 赢了");
                break;
            case TicTacToeGame.GAMEOVER:
                System.out.println("和了");
                break;
        }
    }

    private void RvP(TicTacToeGame game){
        game.clean();
        game.showGame();
        int playerType = game.getCurPlayer();
        List<Point>  allMove = new ArrayList<>();
        while(game.gameOver() == TicTacToeGame.EMPTY){
            Point action = null;
            if(game.getCurPlayer() == playerType){
                action = robotMove(game);
            }else{
                game.allMove(allMove);
                for(int i = 0;i<allMove.size();i++){
                    showAction(i,allMove.get(i));
                }
                System.out.print("您的棋子为 ");
                if(game.getCurPlayer() == TicTacToeGame.WHITE){
                    System.out.print(" O ");
                }else{
                    System.out.print(" X ");
                }

                System.out.println("输入(第几个走法)>>>>>>>");
                int movePos = sc.nextInt();
                action = allMove.get(movePos);

            }
            game.move(action);
            game.showGame();
        }
        switch (game.gameOver()){
            case TicTacToeGame.WHITE:
                System.out.println("O 赢了");
                break;
            case TicTacToeGame.BLACK:
                System.out.println("X 赢了");
                break;
            case TicTacToeGame.GAMEOVER:
                System.out.println("和了");
                break;
        }
    }


    private void PvP(TicTacToeGame game){
        game.clean();
        game.showGame();

        List<Point>  allMove = new ArrayList<>();
        while(game.gameOver() == TicTacToeGame.EMPTY){
            game.allMove(allMove);
            for(int i = 0;i<allMove.size();i++){
                showAction(i,allMove.get(i));
            }
            System.out.print("您的棋子为 ");
            if(game.getCurPlayer() == TicTacToeGame.WHITE){
                System.out.print(" O ");
            }else{
                System.out.print(" X ");
            }

            System.out.println("输入>>>>>>>");
            int movePos = sc.nextInt();
            game.move(allMove.get(movePos));
            game.showGame();
        }
        switch (game.gameOver()){
            case TicTacToeGame.WHITE:
                System.out.println("X 赢了");
                break;
            case TicTacToeGame.BLACK:
                System.out.println("O 赢了");
                break;
            case TicTacToeGame.GAMEOVER:
                System.out.println("和了");
                break;
        }

    }


    public Point robotMove(TicTacToeGame game){

        BestPoint best = new BestPoint();
        MiniMaxSearch.minimax(game,game.getCurPlayer(),0,best);

        return best.getPoint();
    }

}

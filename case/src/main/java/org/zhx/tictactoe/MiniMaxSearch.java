package org.zhx.tictactoe;

import java.util.ArrayList;
import java.util.List;

import static org.zhx.tictactoe.TicTacToeGame.WHITE;

public class MiniMaxSearch {
    public static int INF = (Integer.MAX_VALUE - 20);


    public static int minimax(TicTacToeGame game , int robotPlayer,int depth,BestPoint bestAction){
        int result = game.gameOver();
        if(result != TicTacToeGame.EMPTY){

            if(robotPlayer == WHITE) {//搜索起点是 白色玩家
                //这里无论如何都只针对机器人评分，不需要区分玩家类别
                if(result == robotPlayer){
                    return 1*(9 - depth);//自己赢了
                }else if(result == TicTacToeGame.GAMEOVER){
                    return 0;//和棋了
                }else {
                    return -1 * (depth);//输了
                }
            }else{//搜索起点是黑色玩家
                //这里无论如何都只针对机器人评分，不需要区分玩家类别
                if(result == robotPlayer){
                    return 1 * (9 - depth);//自己赢了
                }else if(result == TicTacToeGame.GAMEOVER){
                    return 0;//和棋了
                }else {
                    return -1 * (depth);//输了
                }
            }
        }

        List<Point> allPoint = new ArrayList<>();
        if(game.getCurPlayer() == robotPlayer){//机器操作
            //机器人向下取最大的
            int bestScore = -1 * INF;
            game.allMove(allPoint);
            for(Point p : allPoint){

                game.move(p);
                int score = minimax(game,robotPlayer,depth+1,bestAction);
                if(score > bestScore){
                    bestScore = score;
                    if(depth == 0){
                        bestAction.setPoint(p);
                    }
                }
                if(depth == 0){
                    System.out.println(score + " : " + p);
                }
                game.unmove(p);
            }
            return bestScore;
        }else{//真人操作
            //真人向下取最小值
            int bestScore = INF;
            game.allMove(allPoint);
            for(Point p : allPoint){
                game.move(p);
                int score = minimax(game,robotPlayer,depth + 1,bestAction);
                if(score < bestScore){
                    bestScore = score;
                }
                game.unmove(p);
            }
            return bestScore;
        }
    }


    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.move(0,2);
        game.move(0,0);
        game.move(1,0);

        game.move(0,1);
        game.move(1,2);
        game.move(1,1);

        int robotType = game.getCurPlayer();
        BestPoint best = new BestPoint();
        System.out.println(game);
        System.out.println(robotType);
        MiniMaxSearch.minimax(game,robotType,0,best);
        game.move(best.getPoint());
        System.out.println(game);

    }


}

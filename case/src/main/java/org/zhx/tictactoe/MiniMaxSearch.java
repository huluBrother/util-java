package org.zhx.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class MiniMaxSearch {
    public static int INF = (Integer.MAX_VALUE - 20);


    public static int minimax(TicTacToeGame game , int robotPlayer,int depth,BestPoint bestAction){
        int result = game.gameOver();
        if(result != TicTacToeGame.EMPTY){
            //在这里就需要评分了，这里可能是所有人赢，这个分数如何确定
            int curPlayer = game.getCurPlayer();//现在应该这个玩家操作
            if(curPlayer == robotPlayer){//上一层是机器人
                if(result == robotPlayer){//自己赢了
                    return 1;
                }else if(result == (robotPlayer * -1)){//对手赢了
                    return -1;
                }else{
                    return 0;//和了
                }
            }else{//上一层是真人
                if(result == robotPlayer){//自己输了
                    return -1;
                }else if(result == (robotPlayer * -1)){//对手输了
                    return 1;
                }else{
                    return 0;//和了
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

                StringBuffer buffer = new StringBuffer(depth).append(" 玩家为:").append(game.getCurPlayer());
                for(int i=0;i<depth;i++){
                    buffer.append(" -->");
                }
                buffer.append(game.toString());
                buffer.append(" 当前分数为:").append(score).append(" 走法为 ").append(p);
                buffer.append(" 最好分数 ").append(bestScore).append( " 走法为");
                if(bestAction.getPoint() == null){
                    buffer.append("未定");
                }else{
                    buffer.append(bestAction.getPoint());
                }
                System.out.println(buffer.toString());
                if(score > bestScore){
                    bestScore = score;
                    if(depth == 0){
                        bestAction.setPoint(p);
                    }
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

                StringBuffer buffer = new StringBuffer(depth).append(" 玩家为:").append(game.getCurPlayer());
                for(int i=0;i<depth;i++){
                    buffer.append("-->");
                }
                buffer.append(game.toString());
                buffer.append(" 当前分数为:").append(score).append(" 走法为 ").append(p);
                buffer.append(" 最好分数 ").append(bestScore).append( " 走法为");
                if(bestAction.getPoint() == null){
                    buffer.append("未定");
                }else{
                    buffer.append(bestAction.getPoint());
                }
                System.out.println(buffer.toString());
                game.unmove(p);
            }
            return bestScore;
        }
    }


}

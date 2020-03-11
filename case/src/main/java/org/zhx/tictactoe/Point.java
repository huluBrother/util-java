package org.zhx.tictactoe;

public class Point {
    private int x;
    private int y;

    private static Point allPoint[] = new Point[9];
    static {
        allPoint[0] = new Point(0,0);
        allPoint[1] = new Point(0,1);
        allPoint[2] = new Point(0,2);
        allPoint[3] = new Point(1,0);
        allPoint[4] = new Point(1,1);
        allPoint[5] = new Point(1,2);
        allPoint[6] = new Point(2,0);
        allPoint[7] = new Point(2,1);
        allPoint[8] = new Point(2,2);
    }

    private Point(int x,int y){
        this.x = x;
        this.y = y;
    }


    public static Point getPoint(int x,int y){
        int code = x * 3 + y;
        return allPoint[code];
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Point{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }
}

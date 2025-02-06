import java.util.ArrayList;

public class Directions {

    ChessboardPoint up        = new ChessboardPoint(-1,0);
    ChessboardPoint upLeft    = new ChessboardPoint(-1,-1);
    ChessboardPoint left      = new ChessboardPoint(0,-1);
    ChessboardPoint downLeft  = new ChessboardPoint(1,-1);
    ChessboardPoint down      = new ChessboardPoint(1,0);
    ChessboardPoint downRight = new ChessboardPoint(1,1);
    ChessboardPoint right     = new ChessboardPoint(0,1);
    ChessboardPoint upRight   = new ChessboardPoint(-1,1);

    public ChessboardPoint up() {
        return up;
    }
    public ChessboardPoint UpLeft(){
        return upLeft;
    }
    public ChessboardPoint left(){
        return left;
    }
    public ChessboardPoint downLeft(){
        return downLeft;
    }
    public ChessboardPoint down() {
        return down;
    }
    public ChessboardPoint downRight(){
        return downRight;
    }
    public ChessboardPoint right(){
        return right;
    }
    public ChessboardPoint upRight(){
        return upRight;
    }


    public ArrayList<ChessboardPoint> all() {
        ArrayList<ChessboardPoint> list = new ArrayList<>();
        list.add(up);
        list.add(upLeft);
        list.add(left);
        list.add(downLeft);
        list.add(down);
        list.add(downRight);
        list.add(right);
        list.add(upRight);
        return list;
    }

    public ArrayList<ChessboardPoint> cross() {
        ArrayList<ChessboardPoint> list = new ArrayList<>();
        list.add(up);
        list.add(left);
        list.add(down);
        list.add(right);
        return list;
    }
    public ArrayList<ChessboardPoint> fork() {
        ArrayList<ChessboardPoint> list = new ArrayList<>();
        list.add(upLeft);
        list.add(downLeft);
        list.add(downRight);
        list.add(upRight);
        return list;
    }
    public ArrayList<ChessboardPoint> knight(){
        ArrayList<ChessboardPoint> list = new ArrayList<>();
        list.add(new ChessboardPoint(1,2));
        list.add(new ChessboardPoint(1,-2));
        list.add(new ChessboardPoint(-1,2));
        list.add(new ChessboardPoint(-1,-2));

        list.add(new ChessboardPoint(2,1));
        list.add(new ChessboardPoint(2,-1));
        list.add(new ChessboardPoint(-2,1));
        list.add(new ChessboardPoint(-2,-1));

        return list;


    }


}
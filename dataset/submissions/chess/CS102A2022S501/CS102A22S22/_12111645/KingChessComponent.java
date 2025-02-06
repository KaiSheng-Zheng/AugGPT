import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessColor color;
    private char name;

    public void setPoint(ChessboardPoint point) {
        this.point = point;
    }

    private ChessboardPoint point;

    public KingChessComponent(ChessboardPoint point,ChessColor color,char name){
        this.color=color;
        this.point=point;
        this.name=name;
    }
    public ChessColor getChessColor() {
        return color;
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> canmove= new ArrayList<>();     // there may a "null", so maybe i should remove the "null"position

        if(point.getX()-1>=0&&chessboard[point.getX()-1][point.getY()].toString().equals("_")){
            canmove.add(point.offset(-1,0));
        }
        if(point.getX()+1<8&&chessboard[point.getX()+1][point.getY()].toString().equals("_")){
            canmove.add(point.offset(1,0));

        }
        if(point.getY()-1>=0&&chessboard[point.getX()][point.getY()-1].toString().equals("_")){
            canmove.add(point.offset(0,-1));

        }
        if(point.getY()+1<8&&chessboard[point.getX()][point.getY()+1].toString().equals("_")){
            canmove.add(point.offset(0,1));

        }


        if(point.getX()-1>=0&&point.getY()-1>=0&&chessboard[point.getX()-1][point.getY()-1].toString().equals("_")){
            canmove.add(point.offset(-1,-1));
        }
        if(point.getX()-1>=0&&point.getY()+1<=7&&chessboard[point.getX()-1][point.getY()+1].toString().equals("_")){
            canmove.add(point.offset(-1,1));
        }
        if(point.getX()+1<=7&&point.getY()-1>=0&&chessboard[point.getX()+1][point.getY()-1].toString().equals("_")){
            canmove.add(point.offset(1,-1));
        }
        if(point.getX()+1<=7&&point.getY()+1<=7&&chessboard[point.getX()+1][point.getY()+1].toString().equals("_")){
            canmove.add(point.offset(1,1));
        }


        return canmove;
    }
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }



}



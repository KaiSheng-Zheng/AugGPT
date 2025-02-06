import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessColor color;
    private char name;

    public void setPoint(ChessboardPoint point) {
        this.point = point;
    }

    private ChessboardPoint point;

    public ChessColor getChessColor() {
        return color;
    }

    public KnightChessComponent(ChessboardPoint point,ChessColor color,char name){
        this.color=color;
        this.point=point;
        this.name=name;
    }
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canmove = new ArrayList<>();

        if(point.getX()-1>=0&&point.getY()-2>=0&&chessboard[point.getX()-1][point.getY()-2].getChessColor()!=color){
            canmove.add(point.offset(-1,-2));
        }
        if(point.getX()-1>=0&&point.getY()+2<=7&&chessboard[point.getX()-1][point.getY()+2].getChessColor()!=color){
            canmove.add(point.offset(-1,2));
        }
        if(point.getX()+1<=7&&point.getY()-2>=0&&chessboard[point.getX()+1][point.getY()-2].getChessColor()!=color){
            canmove.add(point.offset(1,-2));
        }
        if(point.getX()+1<=7&&point.getY()+2<=7&&chessboard[point.getX()+1][point.getY()+2].getChessColor()!=color){
            canmove.add(point.offset(1,2));
        }

        if(point.getX()-2>=0&&point.getY()-1>=0&&chessboard[point.getX()-2][point.getY()-1].getChessColor()!=color){
            canmove.add(point.offset(-2,-1));
        }
        if(point.getX()-2>=0&&point.getY()+1<=7&&chessboard[point.getX()-2][point.getY()+1].getChessColor()!=color){
            canmove.add(point.offset(-2,1));
        }
        if(point.getX()+2<=7&&point.getY()+1<=7&&chessboard[point.getX()+2][point.getY()+1].getChessColor()!=color){
            canmove.add(point.offset(2,1));
        }
        if(point.getX()+2<=7&&point.getY()-1>=0&&chessboard[point.getX()+2][point.getY()-1].getChessColor()!=color){
            canmove.add(point.offset(2,-1));
        }

        return canmove;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}

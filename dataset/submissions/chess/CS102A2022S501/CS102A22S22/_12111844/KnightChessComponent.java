import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class KnightChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> list = new ArrayList<>();
        ChessboardPoint point = getSource();
        ChessColor color = getChessColor();
        int x = point.getX();
        int y = point.getY();
        if(x-2>=0 && y-1>=0 && x-2<=7 && y-1<=7){
            if(NotSameColor(x-2,y-1,color)){
                list.add(point.offset(-2,-1));
            }
        }
        if(x-2>=0 && y+1>=0 && x-2<=7 && y+1<=7){
            if(NotSameColor(x-2,y+1,color)){
                list.add(point.offset(-2,1));
            }
        }
        if(x-1>=0 && y-2>=0 && x-1<=7 && y-2<=7){
            if(NotSameColor(x-1,y-2,color)){
                list.add(point.offset(-1,-2));
            }
        }
        if(x-1>=0 && y+2>=0 && x-1<=7 && y+2<=7){
            if(NotSameColor(x-1,y+2,color)){
                list.add(point.offset(-1,2));
            }
        }
        if(x+1>=0 && y-2>=0 && x+1<=7 && y-2<=7){
            if(NotSameColor(x+1,y-2,color)){
                list.add(point.offset(1,-2));
            }
        }
        if(x+1>=0 && y+2>=0 && x+1<=7 && y+2<=7){
            if(NotSameColor(x+1,y+2,color)){
                list.add(point.offset(1,2));
            }
        }
        if(x+2>=0 && y-1>=0 && x+2<=7 && y-1<=7){
            if(NotSameColor(x+2,y-1,color)){
                list.add(point.offset(2,-1));
            }
        }
        if(x+2>=0 && y+1>=0 && x+2<=7 && y+1<=7){
            if(NotSameColor(x+2,y+1,color)){
                list.add(point.offset(2,1));
            }
        }
        return list;
    }
    public boolean NotSameColor(int x, int y, ChessColor color){
        return (!Objects.equals(chessboard[x][y].getChessColor(),color));
    }
    
    public boolean canMoveTo(ChessboardPoint target) {
        List<ChessboardPoint> chessboardPoints = canMoveTo();
        for (ChessboardPoint chessboardPoint : chessboardPoints) {
            if (target.getX() == chessboardPoint.getX() && target.getY() == chessboardPoint.getY()) return true;
        }
        return false;
    }

}

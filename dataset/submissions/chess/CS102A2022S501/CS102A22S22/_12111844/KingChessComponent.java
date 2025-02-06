import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class KingChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> list = new ArrayList<>();
        ChessboardPoint point = getSource();
        ChessColor color = getChessColor();
        int x = point.getX();
        int y = point.getY();
        if(x-1>=0 && y-1>=0 && x-1<=7 && y-1<=7){
            if(!Objects.equals(chessboard[point.offset(-1,-1).getX()][point.offset(-1,-1).getY()].getChessColor(),color)){
                list.add(point.offset(-1,-1));
            }
        }
        if(x-1>=0 && y>=0 && x-1<=7 && y<=7){
            if(!Objects.equals(chessboard[point.offset(-1,0).getX()][point.offset(-1,0).getY()].getChessColor(),color)) {
                list.add(point.offset(-1, 0));
            }
        }
        if(x-1>=0 && y+1>=0 && x-1<=7 && y+1<=7){
            if(!Objects.equals(chessboard[point.offset(-1,1).getX()][point.offset(-1,1).getY()].getChessColor(),color)){
                list.add(point.offset(-1,1));
            }
        }
        if(x>=0 && y-1>=0 && x<=7 && y-1<=7){
            if(!Objects.equals(chessboard[point.offset(0,-1).getX()][point.offset(0,-1).getY()].getChessColor(),color)){
                list.add(point.offset(0,-1));
            }
        }
        if(x>=0 && y+1>=0 && x<=7 && y+1<=7){
            if(!Objects.equals(chessboard[point.offset(0,1).getX()][point.offset(0,1).getY()].getChessColor(),color)){
                list.add(point.offset(0,1));
            }
        }
        if(x+1>=0 && y-1>=0 && x+1<=7 && y-1<=7){
            if(!Objects.equals(chessboard[point.offset(1,-1).getX()][point.offset(1,-1).getY()].getChessColor(),color)){
                list.add(point.offset(1,-1));
            }
        }
        if(x+1>=0 && y>=0 && x+1<=7 && y<=7){
            if(!Objects.equals(chessboard[point.offset(1,0).getX()][point.offset(1,0).getY()].getChessColor(),color)){
                list.add(point.offset(1,0));
            }
        }
        if(x+1>=0 && y+1>=0 && x+1<=7 && y+1<=7){
            if(!Objects.equals(chessboard[point.offset(1,1).getX()][point.offset(1,1).getY()].getChessColor(),color)){
                list.add(point.offset(1,1));
            }
        }
        return list;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PawnChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> list = new ArrayList<>();
        ChessboardPoint point = getSource();
        ChessColor color = getChessColor();
        int x = point.getX();
        int y = point.getY();
        if(Objects.equals(color,ChessColor.WHITE)){
            if(x==6){
                if(Objects.equals(chessboard[x-2][y].getChessColor(),ChessColor.NONE) && Objects.equals(chessboard[x-1][y].getChessColor(),ChessColor.NONE)){
                    list.add(point.offset(-2,0));
                }
            }
            if(point.offset(-1,0)!=null){
                if(Objects.equals(chessboard[x-1][y].getChessColor(),ChessColor.NONE)){
                    list.add(point.offset(-1,0));
                }
            }
            if(point.offset(-1,-1)!=null){
                if(IsOppositeColor(x-1,y-1,color)){
                    list.add(point.offset(-1,-1));
                }
            }
            if(point.offset(-1,1)!=null){
                if(IsOppositeColor(x-1,y+1,color)){
                    list.add(point.offset(-1,1));
                }
            }
        }
        if(Objects.equals(color,ChessColor.BLACK)){
            if(x==1){
                if(Objects.equals(chessboard[x+2][y].getChessColor(),ChessColor.NONE) && Objects.equals(chessboard[x+1][y].getChessColor(),ChessColor.NONE)){
                    list.add(point.offset(2,0));
                }
            }
            if(point.offset(1,0)!=null){
                if(Objects.equals(chessboard[x+1][y].getChessColor(),ChessColor.NONE)){
                    list.add(point.offset(1,0));
                }
            }
            if(point.offset(1,-1)!=null){
                if(IsOppositeColor(x+1,y-1,color)){
                    list.add(point.offset(1,-1));
                }
            }
            if(point.offset(1,1)!=null){
                if(IsOppositeColor(x+1,y+1,color)){
                    list.add(point.offset(1,1));
                }
            }
        }
        return list;
    }
    public boolean NotSameColor(int x, int y, ChessColor color){
        return (!Objects.equals(chessboard[x][y].getChessColor(),color));
    }
    public boolean IsOppositeColor(int x, int y, ChessColor color){
        return (((Objects.equals(chessboard[x][y].getChessColor(),ChessColor.WHITE))&&(Objects.equals(color,ChessColor.BLACK)))||
                ((Objects.equals(chessboard[x][y].getChessColor(),ChessColor.BLACK))&&(Objects.equals(color,ChessColor.WHITE))));
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BishopChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> list = new ArrayList<>();
        ChessboardPoint point = getSource();
        ChessColor color = getChessColor();
        int x = point.getX();
        int y = point.getY();
        for(int i=1; i<=7; i++){
            if(x-i>=0 && y-i>=0 && x-i<=7 && y-i<=7){
                if(NotSameColor(x-i,y-i,color)){
                    list.add(point.offset(-i,-i));
                    if(IsOppositeColor(x-i,y-i,color))
                        break;
                }else if(!NotSameColor(x-i,y-i,color))
                    break;
            }else break;
        }
        for(int i=1; i<=7; i++){
            if(x-i>=0 && y+i>=0 && x-i<=7 && y+i<=7){
                if(NotSameColor(x-i,y+i,color)){
                    list.add(point.offset(-i,i));
                    if(IsOppositeColor(x-i,y+i,color))
                        break;
                }else if(!NotSameColor(x-i,y+i,color))
                    break;
            }else break;
        }
        for(int i=1; i<=7; i++){
            if(x+i>=0 && y-i>=0 && x+i<=7 && y-i<=7){
                if(NotSameColor(x+i,y-i,color)){
                    list.add(point.offset(i,-i));
                    if(IsOppositeColor(x+i,y-i,color))
                        break;
                }else if(!NotSameColor(x+i,y-i,color))
                    break;
            }else break;
        }
        for(int i=1; i<=7; i++){
            if(x+i>=0 && y+i>=0 && x+i<=7 && y+i<=7){
                if(NotSameColor(x+i,y+i,color)){
                    list.add(point.offset(i,i));
                    if(IsOppositeColor(x+i,y+i,color))
                        break;
                }else if(!NotSameColor(x+i,y+i,color))
                    break;
            }else break;
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

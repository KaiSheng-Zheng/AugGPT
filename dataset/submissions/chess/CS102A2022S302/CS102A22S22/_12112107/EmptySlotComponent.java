import java.util.ArrayList;
import java.util.List;
public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint chessboardPoint){
        this.chessboardPoint = chessboardPoint;
        this.chessColor = ChessColor.NONE;
        name = '_';
    }

    public EmptySlotComponent(int sourceX, int sourceY) {
        this.chessboardPoint = new ChessboardPoint(sourceX,sourceY);
        this.chessColor = ChessColor.NONE;
        name = '_';
    }

    public List<ChessboardPoint> canMoveTo(){
        return new ArrayList<>();
    }
    public boolean moveChess(int sourceX,int sourceY,int targetX,int targetY){
        return false;
    }
    public char getName(){
        return name;
    }
    public String toString(){
        return String.valueOf(name);
    }
}
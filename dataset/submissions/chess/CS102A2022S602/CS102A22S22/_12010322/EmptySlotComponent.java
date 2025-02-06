import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
    public EmptySlotComponent(int x,int y){
        ChessboardPoint source=new ChessboardPoint(x,y);
        this.name = '_';
        this.setSource(source);
    }

    public  boolean canMoveTo(int x2, int y2){return true;}

    boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){return true;};

    List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){return null;};


}

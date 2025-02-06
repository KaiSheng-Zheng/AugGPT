import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    int x,y;

    public EmptySlotComponent(ChessColor color,int x,int y){
        super();
        super.chessColor1=color;
        super.source1=new ChessboardPoint(x,y);
        this.x=x;
        this.y=y;
        name='_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

}
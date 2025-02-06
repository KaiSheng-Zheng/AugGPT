import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(int x,int y,ChessColor color) {
        setChessColor(ChessColor.NONE);setName('_');setSource(new  ChessboardPoint(x,y));
        setCheckPolymorphism(1);
    }

    public EmptySlotComponent(int a,int b) {setChessColor(ChessColor.NONE);setName('_');setSource(new  ChessboardPoint(a,b));
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return  new ArrayList<>();
    }
}

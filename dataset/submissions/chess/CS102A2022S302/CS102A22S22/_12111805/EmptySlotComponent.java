import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{



    public EmptySlotComponent(ChessboardPoint source){
        setName('_');
        setChessColor(ChessColor.NONE);
        setSource(source);
    }

    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
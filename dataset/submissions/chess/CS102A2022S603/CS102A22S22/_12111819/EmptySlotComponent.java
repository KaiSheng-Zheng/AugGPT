
import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{

    public EmptySlotComponent(char name, ChessboardPoint source){
        setName(name);
        setChessColor(ChessColor.NONE);
        setSource(source);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}

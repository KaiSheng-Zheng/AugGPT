import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{

    public EmptySlotComponent(char name,ChessboardPoint point,ChessColor color){
        super.name = name;
        super.setSource(point);
        super.setChessColor(color);

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
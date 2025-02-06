import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{

    public EmptySlotComponent(char name,ChessboardPoint pos,ChessColor color){
        this.name = name;
        this.setSource(pos);
        this.setChessColor(color);

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}

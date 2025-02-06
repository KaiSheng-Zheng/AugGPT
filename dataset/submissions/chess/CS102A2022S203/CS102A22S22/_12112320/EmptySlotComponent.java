import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {

    public EmptySlotComponent(ChessboardPoint source,ChessColor color,char name) {
        super.setSource(source); super.setChessColor(color); super.setName(name);
        super.add(source,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}

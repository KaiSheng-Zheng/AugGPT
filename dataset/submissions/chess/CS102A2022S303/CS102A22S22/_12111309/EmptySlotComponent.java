import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    private ChessboardPoint source;
    protected char name='_';

    public EmptySlotComponent(ChessboardPoint location,ChessColor color,char name) {
        source = location;
//        chessColor = color;
        this.name = name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
    @Override
    public char getName() {
        return name;
    }
}

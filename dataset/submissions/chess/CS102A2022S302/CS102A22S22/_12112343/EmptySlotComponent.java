import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent() {
    }

    public EmptySlotComponent(ChessboardPoint source, char c) {
        this.setSource(source);
        this.setChessColor(ChessColor.NONE);
        this.name = c;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
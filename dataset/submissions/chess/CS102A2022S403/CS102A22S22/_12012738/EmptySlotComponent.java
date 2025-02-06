import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(int indexOf, int i, ChessColor color, char e) {
        super(indexOf, i, color, e);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(ChessboardPoint point, ChessColor color) {
        super(point, color);
        this.name = '_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    };
}

import java.util.ArrayList;
import java.util.List;
public abstract class EmptySlotComponent extends ChessComponent {
    //@Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}


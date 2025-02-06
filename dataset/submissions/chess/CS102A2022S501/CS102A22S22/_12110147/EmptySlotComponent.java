import java.util.*;

public class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent() {
        super();
    }

    @Override
    public char getName() {
        return '_';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
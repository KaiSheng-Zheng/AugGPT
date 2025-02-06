import java.util.*;
public class EmptySlotComponent extends ChessComponent {

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}

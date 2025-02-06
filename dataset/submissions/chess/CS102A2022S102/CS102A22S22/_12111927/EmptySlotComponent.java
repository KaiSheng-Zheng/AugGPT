import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove = new ArrayList<>();
        return canMove;
    }
}
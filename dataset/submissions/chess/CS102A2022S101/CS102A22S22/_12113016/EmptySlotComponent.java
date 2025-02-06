import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{

    @Override
    public String toString() {
        return "_";
    }

    @Override
    public void giveValueTo(ChessComponent target) {

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
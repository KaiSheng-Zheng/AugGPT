import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{


    public EmptySlotComponent(ChessboardPoint chessboardPoint, ChessColor none, char c) {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
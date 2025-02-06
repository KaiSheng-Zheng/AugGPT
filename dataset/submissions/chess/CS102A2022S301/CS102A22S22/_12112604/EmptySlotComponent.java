import java.util.ArrayList;
import java.util.List;

class EmptySlotComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

    @Override
    public void beEaten() {
    }

    public EmptySlotComponent(ChessColor chessColor){
        super(chessColor);
    }
}

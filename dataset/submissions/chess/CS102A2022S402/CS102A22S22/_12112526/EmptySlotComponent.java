import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessColor chessColor) {
        super(chessColor);
        this.name='_';
    }

    public EmptySlotComponent(ChessComponent[][] chessboard) {
        super(chessboard);
        this.name='_';
    }

    public EmptySlotComponent(ChessboardPoint source) {
        super(source);
        this.name='_';
    }

    public EmptySlotComponent() {
        this.name='_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
    @Override
    public String toString() {
        return "_";
    }
}

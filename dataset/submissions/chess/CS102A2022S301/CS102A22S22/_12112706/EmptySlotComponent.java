import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor) {

        this.source=source;
        this.chessColor=chessColor;
        super.name='_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

    public String toString() {
        return String.valueOf(super.name);
    }
}
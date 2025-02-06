import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(ChessColor chessColor, ChessboardPoint source) {
        setSource(source);
        setChessColor(chessColor);
        if (chessColor == ChessColor.NONE) {
            name = '_';
        }
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}



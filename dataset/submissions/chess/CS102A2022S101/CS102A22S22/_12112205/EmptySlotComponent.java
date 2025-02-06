import java.util.ArrayList;
import java.util.*;

public class EmptySlotComponent extends ChessComponent {

    public EmptySlotComponent(ChessComponent[][] chessboard, ChessColor color, ChessboardPoint point) {
        super.chessboard = chessboard;
        super.setChessColor(color);
        super.setChessPoint(point);
        super.name = '_';

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

}

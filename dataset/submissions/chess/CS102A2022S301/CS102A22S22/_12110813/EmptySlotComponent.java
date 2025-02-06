

import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }


    public boolean canMoveChess(int sourceX, int sourceY, int targetX, int targetY) {
        return false;
    }

    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }
}

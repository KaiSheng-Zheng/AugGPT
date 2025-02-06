import java.util.ArrayList;
import java.util.List;

public class EmptySlotChessComponent extends ChessComponent{
    public EmptySlotChessComponent(ChessboardPoint chessboardPoint) {
        super(chessboardPoint, ChessColor.NONE, '_');
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
            return new ArrayList<>();
        }
    }

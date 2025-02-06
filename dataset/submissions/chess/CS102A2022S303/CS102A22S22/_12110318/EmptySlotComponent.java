import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor) {
        super();
        setSource(source);
        setChessColor(chessColor);
        chessNum=32;
        name = '_';
    }


    @Override
    public int countCapturedChess() {
        return 0;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> point= new ArrayList<>();
        return point;
    }
}

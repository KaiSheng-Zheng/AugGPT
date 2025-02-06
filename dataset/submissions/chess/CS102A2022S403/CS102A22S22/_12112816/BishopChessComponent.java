import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor) {
        setSource(chessboardPoint);
        setChessColor(chessColor);
        if (chessColor == ChessColor.BLACK) name = 'B';
        else name = 'b';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> can = new ArrayList<>();
        can.addAll(goNE());
        can.addAll(goNW());
        can.addAll(goSE());
        can.addAll(goSW());
        return can;
    }
}


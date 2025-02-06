import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public RookChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor) {
        setSource(chessboardPoint);
        setChessColor(chessColor);
        if (chessColor == ChessColor.BLACK) name = 'R';
        else name = 'r';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> can = new ArrayList<>();
        can.addAll(goN());
        can.addAll(goS());
        can.addAll(goW());
        can.addAll(goE());
        return can;
    }
}

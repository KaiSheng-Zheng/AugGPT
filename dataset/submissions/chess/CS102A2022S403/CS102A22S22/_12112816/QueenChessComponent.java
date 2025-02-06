import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {

    public QueenChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor) {
        setSource(chessboardPoint);
        setChessColor(chessColor);
        if (chessColor == ChessColor.BLACK) name = 'Q';
        else name = 'q';
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> can = new ArrayList<>();
        can.addAll(goN());
        can.addAll(goS());
        can.addAll(goW());
        can.addAll(goE());
        can.addAll(goNE());
        can.addAll(goNW());
        can.addAll(goSE());
        can.addAll(goSW());
        return can;
    }
}

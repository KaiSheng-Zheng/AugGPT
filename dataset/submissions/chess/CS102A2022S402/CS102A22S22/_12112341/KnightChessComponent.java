import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnightChessComponent extends ChessComponent{


    public KnightChessComponent(ChessboardPoint chessboardPoint, ChessColor black, char n) {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int r = Math.abs(source.getX() - destination.getX());
        int c = Math.abs(source.getY() - destination.getY());
        if ((r == 1 && c == 2) || (r == 2 && c == 1)) {
            return Collections.singletonList(destination);
        }else return new ArrayList<>();
    }
}
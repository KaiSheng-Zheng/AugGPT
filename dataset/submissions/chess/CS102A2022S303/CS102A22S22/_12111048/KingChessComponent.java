

import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    private ChessboardPoint source;

    public KingChessComponent(ChessColor chessColor, char name) {
        super(chessColor, name);
    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
        this.source = source;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPointList = new ArrayList<>();

        for (int dx = -1; dx < 2; dx++) {
            for (int dy = -1; dy < 2; dy++) {
                if (dx == 0 && dy == 0) {
                    continue;
                }
                ChessboardPoint point = this.getSource().offset(dx, dy);
                if (point != null) {
                    chessboardPointList.add(point);
                }
            }
        }

        return chessboardPointList;
    }

    @Override
    public ChessboardPoint getSource() {
        return source;
    }

    @Override
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
}



import java.util.List;
import java.util.ArrayList;

public class KnightChessComponent extends ChessComponent {
    private ChessboardPoint source;

    public KnightChessComponent(ChessColor chessColor, char name) {
        super(chessColor, name);
    }

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
        this.source = source;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPointList = new ArrayList<>();

        for (int dx = -2; dx < 3; dx++) {
            for (int dy = -2; dy < 3; dy++) {
                if (dx == 0 && dy == 0) {
                    continue;
                }

                if (dx == 0 || dy == 0 || dx == dy || Math.abs(dx) == Math.abs(dy)) {
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
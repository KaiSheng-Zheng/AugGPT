import java.util.ArrayList;
import java.util.List;

class BishopChessComponent extends ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color

    public BishopChessComponent(ChessColor chessColor, ChessboardPoint source) {
        this.chessColor = chessColor;
        this.source = source;
        switch (chessColor) {
            case BLACK:
                name = 'B';
                break;
            case WHITE:
                name = 'b';
                break;
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMovePoints = new ArrayList<>();
        ChessboardPoint origin = new ChessboardPoint(source.getX(), source.getY());
        for (int i = 1; i < 8; i++) {
            canMovePoints.add(origin.offset(i, i));
            canMovePoints.add(origin.offset(i, -i));
            canMovePoints.add(origin.offset(-i, -i));
            canMovePoints.add(origin.offset(-i, i));
        }
        int a;
        for (int i = 0; i < canMovePoints.size(); i++) {
            if (canMovePoints.get(i).getX() == source.getX()&&canMovePoints.get(i).getY() == source.getY()) {
                canMovePoints.remove(i);
            }
        }
        return canMovePoints;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
}


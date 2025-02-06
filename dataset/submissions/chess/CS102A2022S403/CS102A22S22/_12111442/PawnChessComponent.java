import java.util.ArrayList;
import java.util.List;

class PawnChessComponent extends ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color

    public PawnChessComponent(ChessColor chessColor,ChessboardPoint source) {
        this.chessColor=chessColor;
        this.source=source;
        switch (chessColor) {
            case BLACK:
                name = 'P';
                break;
            case WHITE:
                name = 'p';
                break;
        }

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMovePoints = new ArrayList<>();
        ChessboardPoint origin = new ChessboardPoint(source.getX(),source.getY());
        if (chessColor == ChessColor.WHITE) {
            canMovePoints.add(origin.offset(-1, 0));
            if (source.getX() == 6) {
                canMovePoints.add(origin.offset(-2, 0));
            }
        }
        if (chessColor == ChessColor.BLACK) {
            canMovePoints.add(origin.offset(1, 0));
            if (source.getX() == 1) {
                canMovePoints.add(origin.offset(2, 0));
            }
        }
        for (int i = 0; i < canMovePoints.size(); i++) {
            if (canMovePoints.get(i) == source) {
                canMovePoints.remove(i);
            }
        }
        return canMovePoints;
    }



    public ChessColor getChessColor() {
        return chessColor;
    }
}
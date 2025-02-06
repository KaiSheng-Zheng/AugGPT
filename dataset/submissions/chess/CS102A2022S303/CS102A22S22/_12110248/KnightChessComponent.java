import java.util.ArrayList;
import java.util.List;

class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        this.name = chessColor == ChessColor.BLACK ? 'N' : 'n';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> moveTo = new ArrayList<>();
        ChessboardPoint[] newPlace = {
                source.offset(-2, -1),
                source.offset(-2, 1),
                source.offset(-1, -2),
                source.offset(-1, 2),
                source.offset(1, -2),
                source.offset(1, 2),
                source.offset(2, -1),
                source.offset(2, 1)};
        for (int i = 0; i < newPlace.length; i++) {
            if (newPlace[i] != null && getComponentColor(chessboard[newPlace[i].getX()][newPlace[i].getY()].toString().charAt(0)) != chessColor) {
                moveTo.add(newPlace[i]);
            }
        }
        return moveTo;
    }

}
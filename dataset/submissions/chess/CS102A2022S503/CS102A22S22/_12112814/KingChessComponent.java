import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    public KingChessComponent(ConcreteChessGame chessGame, ChessboardPoint source, ChessColor chessColor) {
        super(chessGame, source, chessColor);
        name = chessColor == ChessColor.BLACK ? 'K' : 'k';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        ChessboardPoint source = getSource();
        int sourceX = source.getX();
        int sourceY = source.getY();

        if (checkPoint(sourceX + 1, sourceY)) {
            result.add(new ChessboardPoint(sourceX + 1, sourceY));
        }
        if (checkPoint(sourceX - 1, sourceY)) {
            result.add(new ChessboardPoint(sourceX - 1, sourceY));
        }
        if (checkPoint(sourceX, sourceY + 1)) {
            result.add(new ChessboardPoint(sourceX, sourceY + 1));
        }
        if (checkPoint(sourceX, sourceY - 1)) {
            result.add(new ChessboardPoint(sourceX, sourceY - 1));
        }
        if (checkPoint(sourceX - 1, sourceY - 1)) {
            result.add(new ChessboardPoint(sourceX - 1, sourceY - 1));
        }
        if (checkPoint(sourceX - 1, sourceY + 1)) {
            result.add(new ChessboardPoint(sourceX - 1, sourceY + 1));
        }
        if (checkPoint(sourceX + 1, sourceY - 1)) {
            result.add(new ChessboardPoint(sourceX + 1, sourceY - 1));
        }
        if (checkPoint(sourceX + 1, sourceY + 1)) {
            result.add(new ChessboardPoint(sourceX + 1, sourceY + 1));
        }
        result.sort((o1, o2) -> {
            if (o1.getX() == o2.getX()) {
                return o1.getY() - o2.getY();
            } else {
                return o1.getX() - o2.getX();
            }
        });
        return result;
    }
}

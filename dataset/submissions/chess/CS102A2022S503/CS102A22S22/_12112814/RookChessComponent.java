import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {

    public RookChessComponent(ConcreteChessGame chessGame, ChessboardPoint source, ChessColor chessColor) {
        super(chessGame, source, chessColor);
        name = chessColor == ChessColor.BLACK ? 'R' : 'r';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        ChessboardPoint source = getSource();
        int sourceX = source.getX();
        int sourceY = source.getY();

        for (int i = sourceX + 1; i < 8; i++) { 
            if (checkPoint(i, sourceY)) {
                result.add(new ChessboardPoint(i, sourceY));
                if (!(chessGame.getChess(i, sourceY) instanceof EmptySlotComponent)) {
                    break;
                }
            } else {
                break;
            }
        }
        for (int i = sourceX - 1; i >= 0; i--) { 
            if (checkPoint(i, sourceY)) {
                result.add(new ChessboardPoint(i, sourceY));
                if (!(chessGame.getChess(i, sourceY) instanceof EmptySlotComponent)) {
                    break;
                }
            } else {
                break;
            }
        }
        for (int i = sourceY + 1; i < 8; i++) { 
            if (checkPoint(sourceX, i)) {
                result.add(new ChessboardPoint(sourceX, i));
                if (!(chessGame.getChess(sourceX, i) instanceof EmptySlotComponent)) {
                    break;
                }
            } else {
                break;
            }
        }
        for (int i = sourceY - 1; i >= 0; i--) {
            if (checkPoint(sourceX, i)) {
                result.add(new ChessboardPoint(sourceX, i));
                if (!(chessGame.getChess(sourceX, i) instanceof EmptySlotComponent)) {
                    break;
                }
            } else {
                break;
            }
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
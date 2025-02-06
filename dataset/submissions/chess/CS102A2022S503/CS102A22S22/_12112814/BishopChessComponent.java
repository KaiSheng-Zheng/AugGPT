import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {

    public BishopChessComponent(ConcreteChessGame chessGame, ChessboardPoint source, ChessColor chessColor) {
        super(chessGame, source, chessColor);
        name = chessColor == ChessColor.BLACK ? 'B' : 'b';
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        ChessboardPoint source = getSource();
        int sourceX = source.getX();
        int sourceY = source.getY();
        for (int i = 1; i <= Math.min(sourceX, sourceY); i++) {
            if (checkPoint(sourceX - i, sourceY - i)) {
                result.add(new ChessboardPoint(sourceX - i, sourceY - i));
                if (!(chessGame.getChess(sourceX - i, sourceY - i) instanceof EmptySlotComponent)) {
                    break;
                }
            } else {
                break;
            }
        }

        for (int i = 1; i <= 7 - Math.max(sourceX, sourceY); i++) {
            if (checkPoint(sourceX + i, sourceY + i)) {
                result.add(new ChessboardPoint(sourceX + i, sourceY + i));
                if (!(chessGame.getChess(sourceX + i, sourceY + i) instanceof EmptySlotComponent)) {
                    break;
                }
            } else {
                break;
            }
        }

        for (int i = 1; i <= Math.min(Math.abs(-sourceX), 7 - sourceY); i++) {
            if (checkPoint(sourceX - i, sourceY + i)) {
                result.add(new ChessboardPoint(sourceX - i, sourceY + i));
                if (!(chessGame.getChess(sourceX - i, sourceY + i) instanceof EmptySlotComponent)) {
                    break;
                }
            }
        }

        for (int i = 1; i <= Math.min(7 - sourceX, Math.abs(-sourceY)); i++) {
            if (checkPoint(sourceX + i, sourceY - i)) {
                result.add(new ChessboardPoint(sourceX + i, sourceY - i));
                if (!(chessGame.getChess(sourceX + i, sourceY - i) instanceof EmptySlotComponent)) {
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
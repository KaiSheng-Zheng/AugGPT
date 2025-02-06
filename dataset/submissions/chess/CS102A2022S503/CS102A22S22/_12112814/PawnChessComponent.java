import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {

    public PawnChessComponent(ConcreteChessGame chessGame, ChessboardPoint source, ChessColor chessColor) {
        super(chessGame, source, chessColor);
        name = chessColor == ChessColor.BLACK ? 'P' : 'p';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        ChessboardPoint source = getSource();
        int sourceX = source.getX();
        int sourceY = source.getY();

        if (getChessColor() == ChessColor.BLACK) {
            boolean hasMove = sourceX != 1;
            for (int i = 1; i <= (hasMove ? 1 : 2); i++) {
                if (checkPoint(sourceX + i, sourceY)) {
                    result.add(new ChessboardPoint(sourceX + i, sourceY));
                } else {
                    break;
                }
            }
            if (checkKill(sourceX + 1, sourceY + 1)) {
                result.add(new ChessboardPoint(sourceX + 1, sourceY + 1));
            }
            if (checkKill(sourceX + 1, sourceY - 1)) {
                result.add(new ChessboardPoint(sourceX + 1, sourceY - 1));
            }
        } else if (getChessColor() == ChessColor.WHITE) {
            boolean hasMove = sourceX != 6;
            for (int i = 1; i <= (hasMove ? 1 : 2); i++) {
                if (checkPoint(sourceX - i, sourceY)) {
                    result.add(new ChessboardPoint(sourceX - i, sourceY));
                } else {
                    break;
                }
            }
            if (checkKill(sourceX - 1, sourceY + 1)) {
                result.add(new ChessboardPoint(sourceX - 1, sourceY + 1));
            }
            if (checkKill(sourceX - 1, sourceY - 1)) {
                result.add(new ChessboardPoint(sourceX - 1, sourceY - 1));
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

    private boolean checkKill(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return false;
        }
        ChessComponent component = chessGame.getChessComponents()[x][y];
        return component.getChessColor() != ChessColor.NONE && component.getChessColor() != getChessColor();
    }

    @Override
    protected boolean checkPoint(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return false;
        }
        return chessGame.getChessComponents()[x][y].getChessColor() == ChessColor.NONE;
    }
}
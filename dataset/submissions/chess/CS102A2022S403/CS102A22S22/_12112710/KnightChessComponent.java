import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {

    public KnightChessComponent(ChessColor color, char name) {
        setChessColor(color);
        setName(name);
    }

    private ChessColor checkBoardPosition(int x, int y) {
        ChessComponent chess = game.getChess(x, y);
        if (chess.getChessColor() == ChessColor.NONE) {
            return ChessColor.NONE;
        }
        return chess.getChessColor();
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        result.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 2));
        result.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 2));
        result.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 2));
        result.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 2));
        result.add(new ChessboardPoint(getSource().getX() + 2, getSource().getY() - 1));
        result.add(new ChessboardPoint(getSource().getX() + 2, getSource().getY() + 1));
        result.add(new ChessboardPoint(getSource().getX() - 2, getSource().getY() + 1));
        result.add(new ChessboardPoint(getSource().getX() - 2, getSource().getY() - 1));
        result.removeIf(p -> p.getX() < 0 || p.getX() >= 8 || p.getY() < 0 || p.getY() >= 8);
        result.removeIf(p -> checkBoardPosition(p.getX(), p.getY()) == getChessColor());
        return result;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}

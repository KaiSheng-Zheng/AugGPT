import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    public KingChessComponent(ChessboardPoint source, ChessColor color, char name, ConcreteChessGame concreteChessGame) {
        super(source, color, name, concreteChessGame);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> result = new ArrayList<>();
        if (super.getSource().getX() - 1 >= 0 && super.getSource().getY() - 1 >= 0
                && !game.getChess(super.getSource().getX() - 1, super.getSource().getY() - 1).getChessColor().equals(super.getChessColor())) {
            result.add(new ChessboardPoint(super.getSource().getX() - 1, super.getSource().getY() - 1));
        }
        if (super.getSource().getX() - 1 >= 0
                && !game.getChess(super.getSource().getX() - 1, super.getSource().getY()).getChessColor().equals(super.getChessColor())) {
            result.add(new ChessboardPoint(super.getSource().getX() - 1, super.getSource().getY()));
        }
        if (super.getSource().getX() - 1 >= 0 && super.getSource().getY() + 1 < 8
                && !game.getChess(super.getSource().getX() - 1, super.getSource().getY() + 1).getChessColor().equals(super.getChessColor())) {
            result.add(new ChessboardPoint(super.getSource().getX() - 1, super.getSource().getY() + 1));
        }
        if (super.getSource().getY() - 1 >= 0
                && !game.getChess(super.getSource().getX(), super.getSource().getY() - 1).getChessColor().equals(super.getChessColor())) {
            result.add(new ChessboardPoint(super.getSource().getX(), super.getSource().getY() - 1));
        }
        if (super.getSource().getY() + 1 < 8
                && !game.getChess(super.getSource().getX(), super.getSource().getY() + 1).getChessColor().equals(super.getChessColor())) {
            result.add(new ChessboardPoint(super.getSource().getX(), super.getSource().getY() + 1));
        }
        if (super.getSource().getX() + 1 < 8 && super.getSource().getY() - 1 >= 0
                && !game.getChess(super.getSource().getX() + 1, super.getSource().getY() - 1).getChessColor().equals(super.getChessColor())) {
            result.add(new ChessboardPoint(super.getSource().getX() + 1, super.getSource().getY() - 1));
        }
        if (super.getSource().getX() + 1 < 8
                && !game.getChess(super.getSource().getX() + 1, super.getSource().getY()).getChessColor().equals(super.getChessColor())) {
            result.add(new ChessboardPoint(super.getSource().getX() + 1, super.getSource().getY()));
        }
        if (super.getSource().getX() + 1 < 8 && super.getSource().getY() + 1 < 8
                && !game.getChess(super.getSource().getX() + 1, super.getSource().getY() + 1).getChessColor().equals(super.getChessColor())) {
            result.add(new ChessboardPoint(super.getSource().getX() + 1, super.getSource().getY() + 1));
        }
        return result;
    }
}

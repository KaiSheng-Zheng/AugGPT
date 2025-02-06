import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {

    public KnightChessComponent(ChessboardPoint source, ChessColor color, char name, ConcreteChessGame concreteChessGame) {
        super(source, color, name, concreteChessGame);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> result = new ArrayList<>();
        if (super.getSource().getX() - 1 >= 0) {
            if (super.getSource().getX() - 2 >= 0) {
                if (super.getSource().getY() - 1 >= 0) {
                    if (!game.getChess(super.getSource().getX() - 2, super.getSource().getY() - 1).getChessColor().equals(super.getChessColor())) {
                        result.add(new ChessboardPoint(super.getSource().getX() - 2, super.getSource().getY() - 1));
                    }
                }
                if (super.getSource().getY() + 1 < 8) {
                    if (!game.getChess(super.getSource().getX() - 2, super.getSource().getY() + 1).getChessColor().equals(super.getChessColor())) {
                        result.add(new ChessboardPoint(super.getSource().getX() - 2, super.getSource().getY() + 1));
                    }
                }
            }
            if (super.getSource().getY() - 2 >= 0) {
                if (!game.getChess(super.getSource().getX() - 1, super.getSource().getY() - 2).getChessColor().equals(super.getChessColor())) {
                    result.add(new ChessboardPoint(super.getSource().getX() - 1, super.getSource().getY() - 2));
                }
            }
            if (super.getSource().getY() + 2 < 8) {
                if (!game.getChess(super.getSource().getX() - 1, super.getSource().getY() + 2).getChessColor().equals(super.getChessColor())) {
                    result.add(new ChessboardPoint(super.getSource().getX() - 1, super.getSource().getY() + 2));
                }
            }
        }
        if (super.getSource().getX() + 1 < 8) {
            if (super.getSource().getY() - 2 >= 0) {
                if (!game.getChess(super.getSource().getX() + 1, super.getSource().getY() - 2).getChessColor().equals(super.getChessColor())) {
                    result.add(new ChessboardPoint(super.getSource().getX() + 1, super.getSource().getY() - 2));
                }
            }
            if (super.getSource().getY() + 2 < 8) {
                if (!game.getChess(super.getSource().getX() + 1, super.getSource().getY() + 2).getChessColor().equals(super.getChessColor())) {
                    result.add(new ChessboardPoint(super.getSource().getX() + 1, super.getSource().getY() + 2));
                }
            }
            if (super.getSource().getX() + 2 < 8) {
                if (super.getSource().getY() - 1 >= 0) {
                    if (!game.getChess(super.getSource().getX() + 2, super.getSource().getY() - 1).getChessColor().equals(super.getChessColor())) {
                        result.add(new ChessboardPoint(super.getSource().getX() + 2, super.getSource().getY() - 1));
                    }
                }
                if (super.getSource().getY() + 1 < 8) {
                    if (!game.getChess(super.getSource().getX() + 2, super.getSource().getY() + 1).getChessColor().equals(super.getChessColor())) {
                        result.add(new ChessboardPoint(super.getSource().getX() + 2, super.getSource().getY() + 1));
                    }
                }
            }
        }
        return result;
    }
}

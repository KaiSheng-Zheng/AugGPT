import java.util.*;

public class RookChessComponent extends ChessComponent {

    public RookChessComponent(ChessboardPoint source, ChessColor color, char name, ConcreteChessGame concreteChessGame) {
        super(source, color, name, concreteChessGame);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> result = new ArrayList<>();
        for (int i = super.getSource().getX() + 1; i < 8; i++) {
            if (game.getChessComponents()[i][super.getSource().getY()] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(i, super.getSource().getY()));
            } else if (!game.getChessComponents()[i][super.getSource().getY()].getChessColor().equals(super.getChessColor())) {
                result.add(new ChessboardPoint(i, super.getSource().getY()));
                break;
            } else {
                break;
            }
        }
        for (int i = super.getSource().getX() - 1; i >= 0; i--) {
            if (game.getChessComponents()[i][super.getSource().getY()] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(i, super.getSource().getY()));
            } else if (!game.getChessComponents()[i][super.getSource().getY()].getChessColor().equals(super.getChessColor())) {
                result.add(new ChessboardPoint(i, super.getSource().getY()));
                break;
            } else {
                break;
            }
        }
        for (int i = super.getSource().getY() + 1; i < 8; i++) {
            if (game.getChessComponents()[super.getSource().getX()][i] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(super.getSource().getX(), i));
            } else if (!game.getChessComponents()[super.getSource().getX()][i].getChessColor().equals(super.getChessColor())) {
                result.add(new ChessboardPoint(super.getSource().getX(), i));
                break;
            } else {
                break;
            }
        }
        for (int i = super.getSource().getY() - 1; i >= 0; i--) {
            if (game.getChessComponents()[super.getSource().getX()][i] instanceof EmptySlotComponent) {
                result.add(new ChessboardPoint(super.getSource().getX(), i));
            } else if (!game.getChessComponents()[super.getSource().getX()][i].getChessColor().equals(super.getChessColor())) {
                result.add(new ChessboardPoint(super.getSource().getX(), i));
                break;
            } else {
                break;
            }
        }
        Collections.sort(result, new Comparator<ChessboardPoint>() {
                    @Override
                    public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                        if (o1.getX() < o2.getX()) {
                            return -1;
                        } else if (o1.getX() > o2.getX()) {
                            return 1;
                        } else {
                            if (o1.getY() < o2.getY()) {
                                return -1;
                            } else if (o1.getY() > o2.getY()) {
                                return 1;
                            } else {
                                return 0;
                            }
                        }
                    }
                }
        );
        return result;
    }
}

import java.util.*;

public class BishopChessComponent extends ChessComponent {

    public BishopChessComponent(ChessboardPoint source, ChessColor color, char name, ConcreteChessGame concreteChessGame) {
        super(source, color, name, concreteChessGame);
    }

    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> result = new ArrayList<>();
        for (int i = super.getSource().getX() + 1; i < 8; i++) {
            if (super.getSource().getY() - super.getSource().getX() + i < 8) {
                if (game.getChess(i, super.getSource().getY() - super.getSource().getX() + i).name == '_') {
                    result.add(new ChessboardPoint(i, i + super.getSource().getY() - super.getSource().getX()));
                } else if (!game.getChess(i, super.getSource().getY() - super.getSource().getX() + i).getChessColor().equals(super.getChessColor())) {
                    result.add(new ChessboardPoint(i, i + super.getSource().getY() - super.getSource().getX()));
                    break;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        for (int i = super.getSource().getX() - 1; i >= 0; i--) {
            if (super.getSource().getY() - super.getSource().getX() + i >= 0) {
                if (game.getChess(i, super.getSource().getY() - super.getSource().getX() + i).name == '_') {
                    result.add(new ChessboardPoint(i, i + super.getSource().getY() - super.getSource().getX()));
                } else if (!game.getChess(i, super.getSource().getY() - super.getSource().getX() + i).getChessColor().equals(super.getChessColor())) {
                    result.add(new ChessboardPoint(i, i + super.getSource().getY() - super.getSource().getX()));
                    break;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        for (int i = super.getSource().getX() + 1; i < 8; i++) {
            if (super.getSource().getX() + super.getSource().getY() - i >= 0) {
                if (game.getChess(i, super.getSource().getX() + super.getSource().getY() - i).name == '_') {
                    result.add(new ChessboardPoint(i, super.getSource().getX() + super.getSource().getY() - i));
                } else if (!game.getChess(i, super.getSource().getX() + super.getSource().getY() - i).getChessColor().equals(super.getChessColor())) {
                    result.add(new ChessboardPoint(i, super.getSource().getX() + super.getSource().getY() - i));
                    break;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        for (int i = super.getSource().getX() - 1; i >= 0; i--) {
            if (super.getSource().getX() + super.getSource().getY() - i < 8) {
                if (game.getChess(i, super.getSource().getX() + super.getSource().getY() - i).name == '_') {
                    result.add(new ChessboardPoint(i, super.getSource().getX() + super.getSource().getY() - i));
                } else if (!game.getChess(i, super.getSource().getX() + super.getSource().getY() - i).getChessColor().equals(super.getChessColor())) {
                    result.add(new ChessboardPoint(i, super.getSource().getX() + super.getSource().getY() - i));
                    break;
                } else {
                    break;
                }
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
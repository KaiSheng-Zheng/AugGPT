import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PawnChessComponent extends ChessComponent {

    public PawnChessComponent(ChessboardPoint source, ChessColor color, char name, ConcreteChessGame concreteChessGame) {
        super(source, color, name, concreteChessGame);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> result = new ArrayList<>();
//        if (game.getBeginPlayer().equals(ChessColor.WHITE)) {
        if (super.getChessColor().equals(ChessColor.WHITE)) {
            if (super.getSource().getX() - 1 >= 0
                    && game.getChess(super.getSource().getX() - 1, super.getSource().getY()).name == '_') {
                result.add(new ChessboardPoint(super.getSource().getX() - 1, super.getSource().getY()));
                if (super.getSource().getX() == 6
                        && game.getChess(super.getSource().getX() - 2, super.getSource().getY()).name == '_') {
                    result.add(new ChessboardPoint(super.getSource().getX() - 2, super.getSource().getY()));
                }
            }
            if (super.getSource().getX() - 1 >= 0 && super.getSource().getY() - 1 >= 0
                    && game.getChess(super.getSource().getX() - 1, super.getSource().getY() - 1).getChessColor().equals(ChessColor.BLACK)) {
                result.add(new ChessboardPoint(super.getSource().getX() - 1, super.getSource().getY() - 1));
            }
            if (super.getSource().getX() - 1 >= 0 && super.getSource().getY() + 1 < 8
                    && game.getChess(super.getSource().getX() - 1, super.getSource().getY() + 1).getChessColor().equals(ChessColor.BLACK)) {
                result.add(new ChessboardPoint(super.getSource().getX() - 1, super.getSource().getY() + 1));
            }
        } else if (super.getChessColor().equals(ChessColor.BLACK)) {
            if (super.getSource().getX() + 1 < 8
                    && game.getChess(super.getSource().getX() + 1, super.getSource().getY()).name == '_') {
                result.add(new ChessboardPoint(super.getSource().getX() + 1, super.getSource().getY()));
                if (super.getSource().getX() == 1
                        && game.getChess(super.getSource().getX() + 2, super.getSource().getY()).name == '_') {
                    result.add(new ChessboardPoint(super.getSource().getX() + 2, super.getSource().getY()));
                }
            }
            if (super.getSource().getX() + 1 < 8 && super.getSource().getY() - 1 >= 0
                    && game.getChess(super.getSource().getX() + 1, super.getSource().getY() - 1).getChessColor().equals(ChessColor.WHITE)) {
                result.add(new ChessboardPoint(super.getSource().getX() + 1, super.getSource().getY() - 1));
            }
            if (super.getSource().getX() + 1 < 8 && super.getSource().getY() + 1 < 8
                    && game.getChess(super.getSource().getX() + 1, super.getSource().getY() + 1).getChessColor().equals(ChessColor.WHITE)) {
                result.add(new ChessboardPoint(super.getSource().getX() + 1, super.getSource().getY() + 1));
            }
        }
//        } else {
//            if (super.getChessColor().equals(ChessColor.BLACK)) {
//                if (super.getSource().getX() - 1 >= 0
//                        && game.getChess(super.getSource().getX() - 1, super.getSource().getY()).name == '_') {
//                    result.add(new ChessboardPoint(super.getSource().getX() - 1, super.getSource().getY()));
//                    if (super.getSource().getX() - 2 >= 0
//                            && game.getChess(super.getSource().getX() - 2, super.getSource().getY()).name == '_' && super.getSource().getX() == 6) {
//                        result.add(new ChessboardPoint(super.getSource().getX() - 2, super.getSource().getY()));
//                    }
//                }
//                if (super.getSource().getX() - 1 >= 0 && super.getSource().getY() - 1 >= 0
//                        && game.getChess(super.getSource().getX() - 1, super.getSource().getY() - 1).getChessColor().equals(ChessColor.WHITE)) {
//                    result.add(new ChessboardPoint(super.getSource().getX() - 1, super.getSource().getY() - 1));
//                }
//                if (super.getSource().getX() - 1 >= 0 && super.getSource().getY() + 1 < 8
//                        && game.getChess(super.getSource().getX() - 1, super.getSource().getY() + 1).getChessColor().equals(ChessColor.WHITE)) {
//                    result.add(new ChessboardPoint(super.getSource().getX() - 1, super.getSource().getY() + 1));
//                }
//            } else if (super.getChessColor().equals(ChessColor.WHITE)) {
//                if (super.getSource().getX() + 1 < 8
//                        && game.getChess(super.getSource().getX() + 1, super.getSource().getY()).name == '_') {
//                    result.add(new ChessboardPoint(super.getSource().getX() + 1, super.getSource().getY()));
//                    if (super.getSource().getX() + 2 < 8
//                            && game.getChess(super.getSource().getX() + 2, super.getSource().getY()).name == '_' && super.getSource().getX() == 1) {
//                        result.add(new ChessboardPoint(super.getSource().getX() + 2, super.getSource().getY()));
//                    }
//                }
//                if (super.getSource().getX() + 1 < 8 && super.getSource().getY() - 1 >= 0
//                        && game.getChess(super.getSource().getX() + 1, super.getSource().getY() - 1).getChessColor().equals(ChessColor.BLACK)) {
//                    result.add(new ChessboardPoint(super.getSource().getX() + 1, super.getSource().getY() - 1));
//                }
//                if (super.getSource().getX() + 1 < 8 && super.getSource().getY() + 1 < 8
//                        && game.getChess(super.getSource().getX() + 1, super.getSource().getY() + 1).getChessColor().equals(ChessColor.BLACK)) {
//                    result.add(new ChessboardPoint(super.getSource().getX() + 1, super.getSource().getY() + 1));
//                }
//            }
//        }
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

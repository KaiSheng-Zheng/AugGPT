import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessColor color, ChessboardPoint cp, char name) {
        this.chessColor = color;
        this.source = cp;
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> a = new ArrayList<>();
        if (source.getX() == 1 && chessComponent[source.getX()][source.getY()].getChessColor() == ChessColor.BLACK) {
            if (chessComponent[source.getX() + 1][source.getY()].getChessColor() == ChessColor.NONE) {
                a.add(new ChessboardPoint(source.getX() + 1, source.getY()));
                if (chessComponent[source.getX() + 2][source.getY()].getChessColor() == ChessColor.NONE) {
                    a.add(new ChessboardPoint(source.getX() + 2, source.getY()));
                }
            }
            if (chessComponent[source.getX() + 1][source.getY() - 1].getChessColor() == ChessColor.WHITE) {
                a.add(new ChessboardPoint(source.getX() + 1, source.getY() - 1));
            }
            if (chessComponent[source.getX() + 1][source.getY() + 1].getChessColor() == ChessColor.WHITE) {
                a.add(new ChessboardPoint(source.getX() + 1, source.getY() + 1));
            }
        }
        if (source.getX() == 6 && chessComponent[source.getX()][source.getY()].getChessColor() == ChessColor.WHITE) {
            if (chessComponent[source.getX() - 1][source.getY()].getChessColor() == ChessColor.NONE) {
                a.add(new ChessboardPoint(source.getX() - 1, source.getY()));
                if (chessComponent[source.getX() - 2][source.getY()].getChessColor() == ChessColor.NONE) {
                    a.add(new ChessboardPoint(source.getX() - 2, source.getY()));
                }
            }
            if (chessComponent[source.getX() - 1][source.getY() - 1].getChessColor() == ChessColor.BLACK) {
                a.add(new ChessboardPoint(source.getX() - 1, source.getY() - 1));
            }
            if (chessComponent[source.getX() - 1][source.getY() + 1].getChessColor() == ChessColor.BLACK) {
                a.add(new ChessboardPoint(source.getX() - 1, source.getY() + 1));
            }
        }
        if (source.getX() != 1 && chessComponent[source.getX()][source.getY()].getChessColor() == ChessColor.BLACK) {
                    if (chessComponent[source.getX() + 1][source.getY()].getChessColor() == ChessColor.NONE) {
                        a.add(new ChessboardPoint(source.getX() + 1, source.getY()));
                    }
                    if (chessComponent[source.getX() + 1][source.getY() - 1].getChessColor() == ChessColor.WHITE) {
                        a.add(new ChessboardPoint(source.getX() + 1, source.getY() - 1));
                    }
                    if (chessComponent[source.getX() + 1][source.getY() + 1].getChessColor() == ChessColor.WHITE) {
                        a.add(new ChessboardPoint(source.getX() + 1, source.getY() + 1));
                    }
            }
        if (source.getX() != 6 && chessComponent[source.getX()][source.getY()].getChessColor() == ChessColor.WHITE) {
                    if (chessComponent[source.getX() - 1][source.getY()].getChessColor() == ChessColor.NONE) {
                        a.add(new ChessboardPoint(source.getX() - 1, source.getY()));
                    }
                    if (chessComponent[source.getX() - 1][source.getY() - 1].getChessColor() == ChessColor.BLACK) {
                        a.add(new ChessboardPoint(source.getX() - 1, source.getY() - 1));
                    }
                    if (chessComponent[source.getX() - 1][source.getY() + 1].getChessColor() == ChessColor.BLACK) {
                        a.add(new ChessboardPoint(source.getX() - 1, source.getY() + 1));
                    }
            }
        return a;
    }
}


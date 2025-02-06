import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int xAxis = source.getX();
        int yAxis = source.getY();
        List<ChessboardPoint> returnValue = new ArrayList<>();
        if (chessColor == ChessColor.WHITE) {
            if (source.getX() == 6) {
                if (chessComponents[source.getX() - 1][source.getY()].getChessColor() == ChessColor.NONE) {
                    returnValue.add(new ChessboardPoint(xAxis - 1, yAxis));
                    if (chessComponents[source.getX() - 2][source.getY()].getChessColor() == ChessColor.NONE) {
                        returnValue.add(new ChessboardPoint(xAxis - 2, yAxis));
                    }
                }
            }
            if (source.getX() != 6) {
                if (source.offset(-1, 0) != null) {
                    if (chessComponents[source.getX() - 1][source.getY()].getChessColor() == ChessColor.NONE) {
                        returnValue.add(new ChessboardPoint(xAxis - 1, yAxis));
                    }
                }
            }
            if (source.offset(-1, -1) != null) {
                if (chessComponents[source.getX() - 1][source.getY() - 1].getChessColor() != chessColor && chessComponents[source.getX() - 1][source.getY() - 1].getChessColor() != ChessColor.NONE) {
                    returnValue.add(new ChessboardPoint(xAxis - 1, yAxis - 1));
                }
            }
            if (source.offset(-1, +1) != null) {
                if (chessComponents[source.getX() - 1][source.getY() + 1].getChessColor() != chessColor && chessComponents[source.getX() - 1][source.getY() + 1].getChessColor() != ChessColor.NONE) {
                    returnValue.add(new ChessboardPoint(xAxis - 1, yAxis + 1));
                }
            }
        }
        if (chessColor == ChessColor.BLACK) {
            if (source.getX() == 1) {
                if (chessComponents[source.getX() + 1][source.getY()].getChessColor() == ChessColor.NONE) {
                    returnValue.add(new ChessboardPoint(xAxis + 1, yAxis));
                    if (chessComponents[source.getX() + 2][source.getY()].getChessColor() == ChessColor.NONE) {
                        returnValue.add(new ChessboardPoint(xAxis + 2, yAxis));
                    }
                }
            }
            if (source.getX() != 1) {
                if (source.offset(+1, 0) != null) {
                    if (chessComponents[source.getX() + 1][source.getY()].getChessColor() == ChessColor.NONE) {
                        returnValue.add(new ChessboardPoint(xAxis + 1, yAxis));
                    }
                }
            }
            if (source.offset(+1, +1) != null) {
                if (chessComponents[source.getX() + 1][source.getY() + 1].getChessColor() != chessColor && chessComponents[source.getX() + 1][source.getY() + 1].getChessColor() != ChessColor.NONE) {
                    returnValue.add(new ChessboardPoint(xAxis + 1, yAxis + 1));
                }
            }
            if (source.offset(+1, -1) != null) {
                if (chessComponents[source.getX() + 1][source.getY() - 1].getChessColor() != chessColor && chessComponents[source.getX() + 1][source.getY() - 1].getChessColor() != ChessColor.NONE) {
                    returnValue.add(new ChessboardPoint(xAxis + 1, yAxis - 1));
                }
            }
        }
        return returnValue;
    }
}

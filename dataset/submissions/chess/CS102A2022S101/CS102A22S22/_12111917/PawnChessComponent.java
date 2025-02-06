import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    private ChessComponent[][] chessComponents;

    public PawnChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        setChessboardPoint(chessboardPoint);
        setChessColor(chessColor);
        setName(name);
        this.chessComponents = chessComponents;
    }

    List<ChessboardPoint> lChessboardPoints = new ArrayList<>();

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getChessboardPoint();
        int row = source.getX(), col = source.getY();
        lChessboardPoints.clear();
        ChessColor chessColor = getChessColor();
        switch (chessColor) {
            case BLACK : {
                if (source.getX() == 1) { //First step
                    if (chessComponents[2][col] instanceof EmptySlotComponent) {
                        lChessboardPoints.add(source.offset(1, 0));
                        if (chessComponents[3][col] instanceof EmptySlotComponent)
                            lChessboardPoints.add(source.offset(2, 0));
                    }

                } else { //not first step
                    if (source.offset(1, 0) != null) {
                        if (chessComponents[row + 1][col] instanceof EmptySlotComponent) {
                            lChessboardPoints.add(source.offset(1, 0));
                        }
                    }
                }

                if (source.offset(1, 1) != null) { // chess can eat
                    if (chessComponents[row + 1][col + 1].getChessColor() == ChessColor.WHITE)
                        lChessboardPoints.add(source.offset(1, 1));
                }

                if (source.offset(1, -1) != null) {// chess can eat
                    if (chessComponents[row + 1][col - 1].getChessColor() == ChessColor.WHITE)
                        lChessboardPoints.add(source.offset(1, -1));
                }
                // Capture the passing way Pawn
                // Should Design here
            }
            break;
            case WHITE : {
                if (source.getX() == 6) {
                    if (chessComponents[5][col] instanceof EmptySlotComponent) {
                        lChessboardPoints.add(source.offset(-1, 0));
                        if (chessComponents[4][col] instanceof EmptySlotComponent)
                            lChessboardPoints.add(source.offset(-2, 0));
                    }

                } else {
                    if (source.offset(-1, 0) != null) {
                        if (chessComponents[row - 1][col] instanceof EmptySlotComponent) {
                            lChessboardPoints.add(source.offset(-1, 0));
                        }
                    }
                }
                if (source.offset(-1, -1) != null) {
                    if (chessComponents[row - 1][col - 1].getChessColor() == ChessColor.BLACK)
                        lChessboardPoints.add(source.offset(-1, -1));
                }
                if (source.offset(-1, 1) != null) {
                    if (chessComponents[row - 1][col + 1].getChessColor() == ChessColor.BLACK)
                        lChessboardPoints.add(source.offset(-1, 1));
                }
            }
            break;
            default :{

            }

            break;
        }
        lChessboardPoints.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
        return lChessboardPoints;
    }
}

import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(chessboardPoint, chessColor, name, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        List<ChessboardPoint> getCanMovePoints = new ArrayList<>();
        if (source.offset(2, 1) != null &&
                chessComponents[source.offset(2, 1).getX()][source.offset(2, 1).getY()].getChessColor() != chessColor) {
        if (getSource().offset(2, 1) != null) {
                        chessboardPoints.add(getSource().offset(2, 1));
                    }}
        if (source.offset(2, -1) != null &&
                chessComponents[source.offset(2, -1).getX()][source.offset(2, -1).getY()].getChessColor() != chessColor) {
        if (getSource().offset(2, -1) != null) {
                        chessboardPoints.add(getSource().offset(2, -1));
                    }}
        if (source.offset(-2, 1) != null &&
                chessComponents[source.offset(-2, 1).getX()][source.offset(-2, 1).getY()].getChessColor() != chessColor) {
        if (getSource().offset(-2, 1) != null) {
                        chessboardPoints.add(getSource().offset(-2, 1));
                    }}
        if (source.offset(-2, -1) != null &&
                chessComponents[source.offset(-2, -1).getX()][source.offset(-2, -1).getY()].getChessColor() != chessColor) {
            if (getSource().offset(-2, -1) != null) {
                chessboardPoints.add(getSource().offset(-2, -1));
            }
        }
        if (source.offset(1, 2) != null &&
                chessComponents[source.offset(1, 2).getX()][source.offset(1, 2).getY()].getChessColor() != chessColor) {
        if (getSource().offset(1, 2) != null) {
            chessboardPoints.add(getSource().offset(1, 2));
        }}
        if (source.offset(1, -2) != null &&
                chessComponents[source.offset(1, -2).getX()][source.offset(1, -2).getY()].getChessColor() != chessColor) {
        if (getSource().offset(1, -2) != null) {
            chessboardPoints.add(getSource().offset(1, -2));
        }}
        if (source.offset(-1, 2) != null &&
                chessComponents[source.offset(-1, 2).getX()][source.offset(-1, 2).getY()].getChessColor() != chessColor) {
        if (getSource().offset(-1, 2) != null) {
            chessboardPoints.add(getSource().offset(-1, 2));
        }}
        if (source.offset(-1, -2) != null &&
                chessComponents[source.offset(-1, -2).getX()][source.offset(-1, -2).getY()].getChessColor() != chessColor) {
        if (getSource().offset(-1, -2) != null) {
            chessboardPoints.add(getSource().offset(-1, -2));
        }}
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (ChessboardPoint k : chessboardPoints) {
                    if (k.getX() == i && k.getY() == j)
                        getCanMovePoints.add(new ChessboardPoint(i, j));
                }
            }
        }
        return getCanMovePoints;
    }
}
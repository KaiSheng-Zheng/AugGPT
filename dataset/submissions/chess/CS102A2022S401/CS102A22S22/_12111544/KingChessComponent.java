import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
        this.chessComponents = chessComponents;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        List<ChessboardPoint> getCanMovePoints = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (source.offset(i, j) != null &&
                        chessComponents[source.offset(i, j).getX()][source.offset(i, j).getY()].getChessColor() != chessColor) {
                    if (source.offset(i, j) != getSource()) {
                        chessboardPoints.add(source.offset(i, j));
                    }
                }
            }
        }
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
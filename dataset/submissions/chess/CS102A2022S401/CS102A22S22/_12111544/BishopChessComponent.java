import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
        this.chessComponents = chessComponents;
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        int a = 0;
        int b = 0;
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        List<ChessboardPoint> getCanMovePoints = new ArrayList<>();
        for (int i = -7; i <= 7; i++) {
            if (source.offset(i, i) != null &&
                    chessComponents[source.offset(i, i).getX()][source.offset(i, i).getY()].getChessColor() != chessColor) {
                if (getSource().offset(i, i) != getSource()) {
                    for (int j = Math.min(0, i) + 1; j < Math.max(0, i); j++) {
                        if (chessComponents[getSource().getX() + j][getSource().getY() + j].name != '_') {
                            a = 1;
                        }
                    }
                    if (a == 0) {
                        if (getSource().offset(i, i) != null) {
                            chessboardPoints.add(getSource().offset(i, i));
                        }
                    }
                }
            }
            if (source.offset(i, -i) != null &&
                    chessComponents[source.offset(i, -i).getX()][source.offset(i, -i).getY()].getChessColor() != chessColor) {
                if (getSource().offset(i, -i) != getSource()) {
                    for (int j = Math.min(0, i) + 1; j < Math.max(0, i); j++) {
                        if (chessComponents[getSource().getX() + j][getSource().getY() - j].name != '_') {
                            b = 1;
                        }
                    }
                    if (b == 0) {
                        if (getSource().offset(i, -i) != null) {
                            chessboardPoints.add(getSource().offset(i, -i));
                        }
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
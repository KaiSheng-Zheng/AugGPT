import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends  ChessComponent {
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
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
            if (getSource().offset(0, i) != getSource()) {
                for (int j = Math.min(0, i) + 1; j < Math.max(0, i); j++) {
                    if(getSource().offset(0, j) != null) {
                        if (chessComponents[getSource().offset(0, j).getX()][getSource().offset(0, j).getY()].name != '_') {
                            b = 1;
                        }
                    }
                }if(b == 0){
                    if (getSource().offset(0, i) != null) {
                        chessboardPoints.add(getSource().offset(0, i));
                    }
                }
            }
            if (getSource().offset(i, 0) != getSource()) {
                for (int j = Math.min(0, i) + 1; j < Math.max(0, i); j++) {
                    if(getSource().offset(j, 0) != null) {
                        if (chessComponents[getSource().offset(j, 0).getX()][getSource().offset(j, 0).getY()].name != '_') {
                            a = 1;
                        }
                    }
                }if(a == 0){
                    if (getSource().offset(i, 0) != null) {
                        chessboardPoints.add(getSource().offset(i, 0));
                    }
                }
            }
        }for (int i = 0; i < 8; i++) {
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

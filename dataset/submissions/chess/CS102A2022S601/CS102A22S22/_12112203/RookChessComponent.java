import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> targetPoint = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == getSource().getX()) {
                    int counter = 0;
                    for (int k = Math.min(j, getSource().getY())+1; k < Math.max(j, getSource().getY()); k++) {
                        if (chessComponents[i][k].name != '_') {
                            counter++;
                        }
                    }
                    if (counter == 0) {
                        if (chessComponents[i][j].getChessColor() != getChessColor()) {
                            targetPoint.add(new ChessboardPoint(i, j));
                        }
                    }
                } else if (j == getSource().getY()) {
                    int counter = 0;
                    for (int k = Math.min(i, getSource().getX())+1; k < Math.max(i, getSource().getX()); k++) {
                        if (chessComponents[k][j].name != '_') {
                            counter++;
                        }
                    }
                    if (counter == 0) {
                        if (chessComponents[i][j].getChessColor() != getChessColor()) {
                            targetPoint.add(new ChessboardPoint(i, j));
                        }
                    }
                }
            }
        }
        return targetPoint;
    }

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.setSource(source);
        this.setChessColor(chessColor);
        if (chessColor == ChessColor.WHITE) {
            this.name = 'r';
        } else {
            this.name = 'R';
        }
    }
}

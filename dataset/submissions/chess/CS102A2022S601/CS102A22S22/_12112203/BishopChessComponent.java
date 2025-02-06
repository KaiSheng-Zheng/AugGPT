import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> targetPoint = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Math.abs(i - getSource().getX()) == Math.abs(j - getSource().getY())) {
                    int counter = 0;
                    for (int k = 1; k < Math.abs(i - getSource().getX()); k++) {
                        if (chessComponents[(i - getSource().getX() == j - getSource().getY()) ? Math.min(i, getSource().getX()) + k : Math.max(i, getSource().getX()) - k][Math.min(j, getSource().getY()) + k].name != '_') {
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

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.setSource(source);
        this.setChessColor(chessColor);
        if (chessColor == ChessColor.WHITE) {
            this.name = 'b';
        } else {
            this.name = 'B';
        }
    }
}
import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> targetPoint = new ArrayList<>();
        if (getChessColor() == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (j == getSource().getY() && i == getSource().getX() + 1 && chessComponents[i][j].name == '_') {
                        targetPoint.add(new ChessboardPoint(i, j));
                        if (getSource().getX() == 1 && chessComponents[3][j].name == '_') {
                            targetPoint.add(new ChessboardPoint(3, j));
                        }
                    }
                    if (i == getSource().getX() + 1 && j == getSource().getY() - 1 && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                        targetPoint.add(new ChessboardPoint(i, j));
                    }
                    if (i == getSource().getX() + 1 && j == getSource().getY() + 1 && chessComponents[i][j].getChessColor() == ChessColor.WHITE) {
                        targetPoint.add(new ChessboardPoint(i, j));
                    }
                }
            }
        } else if (getChessColor() == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (j == getSource().getY() && i == getSource().getX() - 1 && chessComponents[i][j].name == '_') {
                        targetPoint.add(new ChessboardPoint(i, j));
                        if (getSource().getX() == 6 && chessComponents[4][j].name == '_') {
                            targetPoint.add(new ChessboardPoint(4, j));
                        }
                    }
                    if (i == getSource().getX() - 1 && j == getSource().getY() - 1 && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                        targetPoint.add(new ChessboardPoint(i, j));
                    }
                    if (i == getSource().getX() - 1 && j == getSource().getY() + 1 && chessComponents[i][j].getChessColor() == ChessColor.BLACK) {
                        targetPoint.add(new ChessboardPoint(i, j));
                    }
                }
            }
        }
        return targetPoint;
    }

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.setSource(source);
        this.setChessColor(chessColor);
        if (chessColor == ChessColor.WHITE) {
            this.name = 'p';
        } else {
            this.name = 'P';
        }
    }
}

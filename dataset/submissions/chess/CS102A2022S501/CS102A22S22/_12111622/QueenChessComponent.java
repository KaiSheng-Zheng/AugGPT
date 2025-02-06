import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    private ChessColor color;
    private ChessboardPoint chessboardPoint;

    public ChessColor getColor() {
        return color;
    }

    public ChessboardPoint getChessboardPoint() {
        return chessboardPoint;
    }
public void setChessboardPoint(ChessboardPoint chessboardPoint) {
        this.chessboardPoint = chessboardPoint;
    }
    public QueenChessComponent(ChessColor color, ChessboardPoint chessboardPoint, char name) {
        this.color = color;
        this.chessboardPoint = chessboardPoint;
        super.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            tab:
            for (int j = 0; j < 8; j++) {
                if(chessboardPoint.getX() == i && chessboardPoint.getY() == j)
                    continue;
                if ((chessboardPoint.getX() - i == chessboardPoint.getY() - j)
                        && (chessboardPoint.getX() != i || chessboardPoint.getY() != j)) {
                    for (int k = Math.min(chessboardPoint.getX(), i) + 1, l = Math.min(chessboardPoint.getY(), j) + 1;
                         k < Math.max(chessboardPoint.getX(), i); k++, l++) {
                        if (!(chessboard[k][l] instanceof EmptySlotComponent)) {
                            continue tab;
                        }
                    }
                    if (//itsConcreteGame.getCurrentPlayer() == color &&
                            color!=chessboard[i][j].getColor())
                        chessboardPoints.add(new ChessboardPoint(i, j));
                }
                if ((chessboardPoint.getX() - i == -chessboardPoint.getY() + j)
                        && (chessboardPoint.getX() != i || chessboardPoint.getY() != j)) {
                    for (int k = Math.min(chessboardPoint.getX(), i) + 1, l = Math.max(chessboardPoint.getY(), j) -1;
                         k < Math.max(chessboardPoint.getX(), i); k++, l--) {
                        if (!(chessboard[k][l] instanceof EmptySlotComponent)) {
                            continue tab;
                        }
                    }
                    if (//itsConcreteGame.getCurrentPlayer() == color &&
                            color!=chessboard[i][j].getColor())
                        chessboardPoints.add(new ChessboardPoint(i, j));
                }
                if (chessboardPoint.getY() == j && chessboardPoint.getX() != i) {
                    for (int k = Math.min(chessboardPoint.getX(), i) + 1; k < Math.max(chessboardPoint.getX(), i); k++) {
                        if (!(chessboard[k][chessboardPoint.getY()] instanceof EmptySlotComponent)) {
                            continue tab;
                        }
                    }
                    if (//itsConcreteGame.getCurrentPlayer() == color &&
                            color!=chessboard[i][j].getColor())
                        chessboardPoints.add(new ChessboardPoint(i, j));
                }
                if (chessboardPoint.getX() == i && chessboardPoint.getY() != j) {
                    for (int k = Math.min(chessboardPoint.getY() , j) + 1;
                         k < Math.max(chessboardPoint.getY() , j); k++) {
                        if (!(chessboard[chessboardPoint.getX()][k] instanceof EmptySlotComponent)) {
                            continue tab;
                        }
                    }
                    if (//itsConcreteGame.getCurrentPlayer() == color &&
                            color!=chessboard[i][j].getColor())
                        chessboardPoints.add(new ChessboardPoint(i, j));
                }
            }
        }
        return chessboardPoints;
    }
}

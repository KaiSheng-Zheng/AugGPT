import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    public KingChessComponent(char name) {
        super(name);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (i > -1 && i < 8 && j > -1 && j < 8) {
                    if (chessComponents[i][j].getChessColor() != this.getChessColor()) {
                        chessboardPoints.add(new ChessboardPoint(i, j));
                    }
                }
            }

        }
        return chessboardPoints;

    }
}



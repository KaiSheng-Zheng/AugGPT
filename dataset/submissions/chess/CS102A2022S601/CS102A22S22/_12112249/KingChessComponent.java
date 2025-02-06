import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    public KingChessComponent(ChessColor chessColor, ChessboardPoint source) {
        this.setChessColor(chessColor);
        this.setSource(source);
        if (chessColor == ChessColor.BLACK) {
            name = 'K';
        }
        if (chessColor == ChessColor.WHITE) {
            name = 'k';
        }

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> chessboardPoints = new ArrayList<>();
        int chushiX = getSource().getX();
        int chushiY = getSource().getY();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Math.abs(chushiX - i) <= 1 && Math.abs(chushiY - j) <= 1 && chessboard[i][j].getChessColor() != this.getChessColor()) {
                    ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                    chessboardPoints.add(chessboardPoint);
                }
            }
        }
        return chessboardPoints;
    }
}


















































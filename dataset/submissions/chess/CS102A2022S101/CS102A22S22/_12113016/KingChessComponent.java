import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((Math.abs(this.getSource().getX() - i) == 1 && this.getSource().getY() == j) || (Math.abs(this.getSource().getY() - j) == 1 && this.getSource().getX() == i) || (Math.abs(this.getSource().getX() - i) == Math.abs(this.getSource().getY() - j) && Math.abs(this.getSource().getX() - i) == 1)) {
                    if (getChesses()[i][j].getChessColor() != this.getChessColor()) {
                        chessboardPoints.add(new ChessboardPoint(i, j));
                    }

                }
            }
        }
        return chessboardPoints;
    }

    @Override
    public String toString() {
        return getChessColor() == ChessColor.WHITE ? "k" : "K";
    }

    @Override
    public void giveValueTo(ChessComponent target) {
        target = new KingChessComponent();
        target.setChessColor(this.getChessColor());
        target.setSource(new ChessboardPoint(this.getSource().getX(), this.getSource().getY()));
    }
}

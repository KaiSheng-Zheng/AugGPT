import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    public KingChessComponent(int x, int y, boolean player) {
        ChessboardPoint location = new ChessboardPoint(x, y);
        super.setSource(location);
        if (player) {
            super.setChessColor(ChessColor.BLACK);
            super.setName('K');
        } else {
            super.setChessColor(ChessColor.WHITE);
            super.setName('k');
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> can = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.getChessColor() != chessComponents[i][j].getChessColor()) {
                    if (Math.abs(this.getSource().getX() - i) == 1 && this.getSource().getY() == j) {
                        can.add(new ChessboardPoint(i, j));
                    } else if (Math.abs(this.getSource().getY() - j) == 1 && this.getSource().getX() == i) {
                        can.add(new ChessboardPoint(i, j));
                    } else if (Math.abs(this.getSource().getX() - i) == 1 && Math.abs(this.getSource().getY() - j) == 1) {
                        can.add(new ChessboardPoint(i, j));
                    }
                }
            }
        }
        return can;
    }
}

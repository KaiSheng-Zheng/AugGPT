import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent() {
    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> cs = new ArrayList<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {

                if (this.getSource().getX() + i >= 0 && this.getSource().getX() + i < 8 && this.getSource().getY() + j >= 0 && this.getSource().getY() + j < 8) {
                    if (chessboard[this.getSource().getX() + i][this.getSource().getY() + j].getChessColor().equals(ChessColor.NONE)) {
                        cs.add(this.getSource().offset(i, j));
                        continue;
                    }
                    if (chessboard[this.getSource().getX() + i][this.getSource().getY() + j].getChessColor().equals(this.getChessColor())) {
                    } else {
                        cs.add(this.getSource().offset(i, j));
                    }
                }
            }
        }

        return cs;
    }
}

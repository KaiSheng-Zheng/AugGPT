import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent() {
    }

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> cs = new ArrayList<>();

        for (int i = 1; i < 3; i++) {
            if (this.getSource().getX() + i >= 0 && this.getSource().getX() + i < 8 && this.getSource().getY() + 3 - i >= 0 && this.getSource().getY() + 3 - i < 8) {
                if (chessboard[this.getSource().getX() + i][this.getSource().getY() + 3 - i].getChessColor().equals(ChessColor.NONE)) {
                    cs.add(this.getSource().offset(i, 3 - i));
               continue;
                }
                if (chessboard[this.getSource().getX() + i][this.getSource().getY() + 3 - i].getChessColor().equals(this.getChessColor())) {

                } else {
                    cs.add(this.getSource().offset(i, 3 - i));

                }
            }
        }

        for (int i = 1; i < 3; i++) {
            if (this.getSource().getX() - i >= 0 && this.getSource().getX() - i < 8 && this.getSource().getY() + 3 - i >= 0 && this.getSource().getY() + 3 - i < 8) {
                if (chessboard[this.getSource().getX() - i][this.getSource().getY() + 3 - i].getChessColor().equals(ChessColor.NONE)) {
                    cs.add(this.getSource().offset(-i, 3 - i));
                continue;
                }
                if (chessboard[this.getSource().getX() - i][this.getSource().getY() + 3 - i].getChessColor().equals(this.getChessColor())) {

                } else {
                    cs.add(this.getSource().offset(-i, 3 - i));

                }
            }
        }

        for (int i = 1; i < 3; i++) {
            if (this.getSource().getX() + i >= 0 && this.getSource().getX() + i < 8 && this.getSource().getY() + i - 3 >= 0 && this.getSource().getY() + i - 3 < 8) {
                if (chessboard[this.getSource().getX() + i][this.getSource().getY() + i - 3].getChessColor().equals(ChessColor.NONE)) {
                    cs.add(this.getSource().offset(i, i - 3));
                    continue;
                }
                if (chessboard[this.getSource().getX() + i][this.getSource().getY() + i - 3].getChessColor().equals(this.getChessColor())) {
                } else {
                    cs.add(this.getSource().offset(i, i - 3));

                }
            }
        }

        for (int i = 1; i < 3; i++) {
            if (this.getSource().getX() - i >= 0 && this.getSource().getX() - i < 8 && this.getSource().getY() + i - 3 >= 0 && this.getSource().getY() + i - 3 < 8) {
                if (chessboard[this.getSource().getX() - i][this.getSource().getY() + i - 3].getChessColor().equals(ChessColor.NONE)) {
                    cs.add(this.getSource().offset(-i, i - 3));
                    continue;
                }
                if (chessboard[this.getSource().getX() - i][this.getSource().getY() + i - 3].getChessColor().equals(this.getChessColor())) {
                } else {
                    cs.add(this.getSource().offset(-i, i - 3));

                }
            }
        }

        return cs;
    }
}

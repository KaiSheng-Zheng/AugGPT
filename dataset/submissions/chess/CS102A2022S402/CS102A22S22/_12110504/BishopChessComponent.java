import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent() {
    }

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> cs = new ArrayList<>();
        int min1 = Math.min(this.getSource().getX(), 7 - this.getSource().getY());
        int min2 = Math.min(this.getSource().getX(), this.getSource().getY());
        int min3 = Math.min(7 - this.getSource().getX(), this.getSource().getY());
        int min4 = Math.min(7 - this.getSource().getX(), 7 - this.getSource().getY());

        for (int i = 1; i <= min1; i++) {
            if (chessboard[this.getSource().getX() - i][this.getSource().getY() + i].getChessColor().equals(ChessColor.NONE)) {
                cs.add(this.getSource().offset(-i, i));
                continue;
            }
            if (chessboard[this.getSource().getX() - i][this.getSource().getY() + i].getChessColor().equals(this.getChessColor())) {
                break;
            } else {
                cs.add(this.getSource().offset(-i, i));
                break;
            }
        }

        for (int i = 1; i <= min2; i++) {
            if (chessboard[this.getSource().getX() - i][this.getSource().getY() - i].getChessColor().equals(ChessColor.NONE)) {
                cs.add(this.getSource().offset(-i, -i));
                continue;
            }
            if (chessboard[this.getSource().getX() - i][this.getSource().getY() - i].getChessColor().equals(this.getChessColor())) {
                break;
            } else {
                cs.add(this.getSource().offset(-i, -i));
                break;
            }
        }

        for (int i = 1; i <= min3; i++) {
            if (chessboard[this.getSource().getX() + i][this.getSource().getY() - i].getChessColor().equals(ChessColor.NONE)) {
                cs.add(this.getSource().offset(i, -i));
                continue;
            }
            if (chessboard[this.getSource().getX() + i][this.getSource().getY() - i].getChessColor().equals(this.getChessColor())) {
                break;
            } else {
                cs.add(this.getSource().offset(i, -i));
                break;
            }
        }

        for (int i = 1; i <= min4; i++) {
            if (chessboard[this.getSource().getX() + i][this.getSource().getY() + i].getChessColor().equals(ChessColor.NONE)) {
                cs.add(this.getSource().offset(i, i));
                continue;
            }
            if (chessboard[this.getSource().getX() + i][this.getSource().getY() + i].getChessColor().equals(this.getChessColor())) {
                break;
            } else {
                cs.add(this.getSource().offset(i, i));
                break;
            }
        }


        return cs;
    }
}
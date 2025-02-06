import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {

    public RookChessComponent() {
    }

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> cs = new ArrayList<>();

        for (int i = 1; i <= 7 - this.getSource().getY(); i++) {
            if (chessboard[this.getSource().getX()][this.getSource().getY() + i].getChessColor().equals(ChessColor.NONE)) {
                cs.add(this.getSource().offset(0, i));
                continue;
            }
            if (chessboard[this.getSource().getX()][this.getSource().getY() + i].getChessColor().equals(this.getChessColor())) {
                break;
            } else {
                cs.add(this.getSource().offset(0, i));
                break;
            }
        }

        for (int i = 1; i <= this.getSource().getY(); i++) {
            if (chessboard[this.getSource().getX()][this.getSource().getY() - i].getChessColor().equals(ChessColor.NONE)) {
                cs.add(this.getSource().offset(0, -i));
                continue;
            }
            if (chessboard[this.getSource().getX()][this.getSource().getY() - i].getChessColor().equals(this.getChessColor())) {
                break;
            } else {
                cs.add(this.getSource().offset(0, -i));
                break;
            }
        }

        for (int i = 1; i <= this.getSource().getX(); i++) {
            if (chessboard[this.getSource().getX()-i][this.getSource().getY() ].getChessColor().equals(ChessColor.NONE)) {
                cs.add(this.getSource().offset(-i, 0));
                continue;
            }
            if (chessboard[this.getSource().getX()-i][this.getSource().getY()].getChessColor().equals(this.getChessColor())) {
                break;
            } else {
                cs.add(this.getSource().offset(-i, 0));
                break;
            }
        }

        for (int i = 1; i <= 7-this.getSource().getX(); i++) {
            if (chessboard[this.getSource().getX()+i][this.getSource().getY() ].getChessColor().equals(ChessColor.NONE)) {
                cs.add(this.getSource().offset(i, 0));
                continue;
            }
            if (chessboard[this.getSource().getX()+i][this.getSource().getY()].getChessColor().equals(this.getChessColor())) {
                break;
            } else {
                cs.add(this.getSource().offset(i, 0));
                break;
            }
        }
        return cs;
    }
}

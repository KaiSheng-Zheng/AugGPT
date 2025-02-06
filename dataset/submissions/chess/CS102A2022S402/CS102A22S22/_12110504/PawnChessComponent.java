import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent() {
    }

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> cs = new ArrayList<>();

        if (this.getChessColor().equals(ChessColor.BLACK)) {
            if (this.getSource().getX() == 1) {
                for (int i = 1; i < 3; i++) {
                    if (chessboard[this.getSource().getX() + i][this.getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                        cs.add(this.getSource().offset(i, 0));
                    } else {
                        break;
                    }
                }
            } else {
                if (this.getSource().getX() + 1 <8) {
                    if (chessboard[this.getSource().getX() + 1][this.getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                        cs.add(this.getSource().offset(1, 0));
                    }
                }
            }

            if (this.getSource().getX() + 1 >= 0 && this.getSource().getX() + 1 < 8 && this.getSource().getY() + 1 >= 0 && this.getSource().getY() + 1 < 8) {
                if (chessboard[this.getSource().getX() +1][this.getSource().getY() + 1].getChessColor().equals(ChessColor.WHITE)) {
                    cs.add(this.getSource().offset(1, 1));
                }
            }
            if (this.getSource().getX() + 1 >= 0 && this.getSource().getX() + 1 < 8 && this.getSource().getY() - 1 >= 0 && this.getSource().getY() - 1 < 8) {
                if (chessboard[this.getSource().getX() +1][this.getSource().getY() - 1].getChessColor().equals(ChessColor.WHITE)) {
                    cs.add(this.getSource().offset(1, -1));
                }
            }
        }


        if (this.getChessColor().equals(ChessColor.WHITE)) {
            if (this.getSource().getX() == 6) {
                for (int i = 1; i < 3; i++) {
                    if (chessboard[this.getSource().getX() - i][this.getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                        cs.add(this.getSource().offset(-i, 0));
                    } else {
                        break;
                    }
                }
            } else {
                if (this.getSource().getX() - 1 >= 0) {
                    if (chessboard[this.getSource().getX() - 1][this.getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                        cs.add(this.getSource().offset(-1, 0));
                    }
                }
            }

            if (this.getSource().getX() - 1 >= 0 && this.getSource().getX() - 1 < 8 && this.getSource().getY() + 1 >= 0 && this.getSource().getY() + 1 < 8) {
                if (chessboard[this.getSource().getX() - 1][this.getSource().getY() + 1].getChessColor().equals(ChessColor.BLACK)) {
                    cs.add(this.getSource().offset(-1, 1));
                }
            }
            if (this.getSource().getX() - 1 >= 0 && this.getSource().getX() - 1 < 8 && this.getSource().getY() - 1 >= 0 && this.getSource().getY() - 1 < 8) {
                if (chessboard[this.getSource().getX() - 1][this.getSource().getY() - 1].getChessColor().equals(ChessColor.BLACK)) {
                    cs.add(this.getSource().offset(-1, -1));
                }
            }
        }
        return cs;
    }
}

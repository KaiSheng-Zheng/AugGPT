import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public PawnChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> move = new ArrayList<>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        if (this.getChessColor().equals(ChessColor.WHITE)) {
            if (this.getSource().getX() == 6) {
                if (this.getChessboard()[x - 1][y].getChessColor().equals(ChessColor.NONE)) {
                    move.add(this.getSource().offset(-1, 0));
                    if (this.getChessboard()[x - 2][y].getChessColor().equals(ChessColor.NONE)) {
                        move.add(this.getSource().offset(-2, 0));
                    }
                }
                if (x - 1 >= 0 && y + 1 < 8 && this.getChessboard()[x - 1][y + 1].getChessColor().equals(ChessColor.BLACK)) {
                    move.add(this.getSource().offset(-1, 1));
                }
                if (x - 1 >= 0 && y - 1 >= 0 && this.getChessboard()[x - 1][y - 1].getChessColor().equals(ChessColor.BLACK)) {
                    move.add(this.getSource().offset(-1, -1));
                }
            } else {
                if (x - 1 >= 0 && this.getChessboard()[x - 1][y].getChessColor().equals(ChessColor.NONE)) {
                    move.add(this.getSource().offset(-1, 0));
                }
                if (x - 1 >= 0 && y + 1 < 8 && this.getChessboard()[x - 1][y + 1].getChessColor().equals(ChessColor.BLACK)) {
                    move.add(this.getSource().offset(-1, 1));
                }
                if (x - 1 >= 0 && y - 1 >= 0 && this.getChessboard()[x - 1][y - 1].getChessColor().equals(ChessColor.BLACK)) {
                    move.add(this.getSource().offset(-1, -1));
                }
            }
        }
        if (this.getChessColor().equals(ChessColor.BLACK)) {
            if (this.getSource().getX() == 1) {
                if (this.getChessboard()[x + 1][y].getChessColor().equals(ChessColor.NONE)) {
                    move.add(this.getSource().offset(1, 0));
                    if (this.getChessboard()[x + 2][y].getChessColor().equals(ChessColor.NONE)) {
                        move.add(this.getSource().offset(2, 0));
                    }
                }
                if (x + 1 < 8 && y + 1 < 8 && this.getChessboard()[x + 1][y + 1].getChessColor().equals(ChessColor.WHITE)) {
                    move.add(this.getSource().offset(1, 1));
                }
                if (x + 1 < 8 && y - 1 >= 0 && this.getChessboard()[x + 1][y - 1].getChessColor().equals(ChessColor.WHITE)) {
                    move.add(this.getSource().offset(1, -1));
                }
            } else {
                if (x + 1 < 8 && this.getChessboard()[x + 1][y].getChessColor().equals(ChessColor.NONE)) {
                    move.add(this.getSource().offset(1, 0));
                }
                if (x + 1 < 8 && y + 1 < 8 && this.getChessboard()[x + 1][y + 1].getChessColor().equals(ChessColor.WHITE)) {
                    move.add(this.getSource().offset(1, 1));
                }
                if (x + 1 < 8 && y - 1 >= 0 && this.getChessboard()[x + 1][y - 1].getChessColor().equals(ChessColor.WHITE)) {
                    move.add(this.getSource().offset(1, -1));
                }
            }
        }

        return move;
    }
}

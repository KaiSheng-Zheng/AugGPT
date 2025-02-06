import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public KingChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> move = new ArrayList<>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        if (x + 1 < 8 && y + 1 < 8) {
            if (this.getChessboard()[x + 1][y + 1].getChessColor().equals(ChessColor.NONE)) {
                move.add(this.getSource().offset(1, 1));
            } else if (!this.getChessboard()[x + 1][y + 1].getChessColor().equals(this.getChessColor())) {
                move.add(this.getSource().offset(1, 1));
            }
        }
        if (x + 1 < 8 && y + 0 < 8) {
            if (this.getChessboard()[x + 1][y + 0].getChessColor().equals(ChessColor.NONE)) {
                move.add(this.getSource().offset(1, 0));
            } else if (!this.getChessboard()[x + 1][y + 0].getChessColor().equals(this.getChessColor())) {
                move.add(this.getSource().offset(1, 0));
            }
        }
        if (x + 1 < 8 && y - 1 >= 0) {
            if (this.getChessboard()[x + 1][y - 1].getChessColor().equals(ChessColor.NONE)) {
                move.add(this.getSource().offset(1, -1));
            } else if (!this.getChessboard()[x + 1][y - 1].getChessColor().equals(this.getChessColor())) {
                move.add(this.getSource().offset(1, -1));
            }
        }
        if (x + 0 < 8 && y - 1 >= 0) {
            if (this.getChessboard()[x + 0][y - 1].getChessColor().equals(ChessColor.NONE)) {
                move.add(this.getSource().offset(0, -1));
            } else if (!this.getChessboard()[x + 0][y - 1].getChessColor().equals(this.getChessColor())) {
                move.add(this.getSource().offset(0, -1));
            }
        }
        if (x + 0 < 8 && y + 1 < 8) {
            if (this.getChessboard()[x + 0][y + 1].getChessColor().equals(ChessColor.NONE)) {
                move.add(this.getSource().offset(0, 1));
            } else if (!this.getChessboard()[x + 0][y + 1].getChessColor().equals(this.getChessColor())) {
                move.add(this.getSource().offset(0, 1));
            }
        }
        if (x - 1 >= 0 && y - 1 >= 0) {
            if (this.getChessboard()[x - 1][y - 1].getChessColor().equals(ChessColor.NONE)) {
                move.add(this.getSource().offset(-1, -1));
            } else if (!this.getChessboard()[x - 1][y - 1].getChessColor().equals(this.getChessColor())) {
                move.add(this.getSource().offset(-1, -1));
            }
        }
        if (x - 1 >= 0 && y + 0 < 8) {
            if (this.getChessboard()[x - 1][y].getChessColor().equals(ChessColor.NONE)) {
                move.add(this.getSource().offset(-1, 0));
            } else if (!this.getChessboard()[x - 1][y].getChessColor().equals(this.getChessColor())) {
                move.add(this.getSource().offset(-1, 0));
            }
        }
        if (x - 1 >= 0 && y + 1 < 8) {
            if (this.getChessboard()[x - 1][y + 1].getChessColor().equals(ChessColor.NONE)) {
                move.add(this.getSource().offset(-1, 1));
            } else if (!this.getChessboard()[x - 1][y + 1].getChessColor().equals(this.getChessColor())) {
                move.add(this.getSource().offset(-1, 1));
            }
        }

        return move;
    }
}










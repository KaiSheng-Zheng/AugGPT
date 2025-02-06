import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public KnightChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> move = new ArrayList<>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        if (x + 1 < 8 && y + 2 < 8) {
            if (this.getChessboard()[x + 1][y + 2].getChessColor().equals(ChessColor.NONE)) {
                move.add(this.getSource().offset(1, 2));
            } else if (!this.getChessboard()[x + 1][y + 2].getChessColor().equals(this.getChessColor())) {
                move.add(this.getSource().offset(1, 2));
            }
        }
        if (x + 2 < 8 && y + 1 < 8) {
            if (this.getChessboard()[x + 2][y + 1].getChessColor().equals(ChessColor.NONE)) {
                move.add(this.getSource().offset(2, 1));
            } else if (!this.getChessboard()[x + 2][y + 1].getChessColor().equals(this.getChessColor())) {
                move.add(this.getSource().offset(2, 1));
            }
        }
        if (x + 2 < 8 && y - 1 >= 0) {
            if (this.getChessboard()[x + 2][y - 1].getChessColor().equals(ChessColor.NONE)) {
                move.add(this.getSource().offset(2, -1));
            } else if (!this.getChessboard()[x + 2][y - 1].getChessColor().equals(this.getChessColor())) {
                move.add(this.getSource().offset(2, -1));
            }
        }
        if (x + 1 < 8 && y - 2 >= 0) {
            if (this.getChessboard()[x + 1][y - 2].getChessColor().equals(ChessColor.NONE)) {
                move.add(this.getSource().offset(1, -2));
            } else if (!this.getChessboard()[x + 1][y - 2].getChessColor().equals(this.getChessColor())) {
                move.add(this.getSource().offset(1, -2));
            }
        }
        if (x - 1 >= 0 && y - 2 >= 0) {
            if (this.getChessboard()[x - 1][y - 2].getChessColor().equals(ChessColor.NONE)) {
                move.add(this.getSource().offset(-1, -2));
            } else if (!this.getChessboard()[x - 1][y - 2].getChessColor().equals(this.getChessColor())) {
                move.add(this.getSource().offset(-1, -2));
            }
        }
        if (x - 2 >= 0 && y - 1 >= 0) {
            if (this.getChessboard()[x - 2][y - 1].getChessColor().equals(ChessColor.NONE)) {
                move.add(this.getSource().offset(-2, -1));
            } else if (!this.getChessboard()[x - 2][y - 1].getChessColor().equals(this.getChessColor())) {
                move.add(this.getSource().offset(-2, -1));
            }
        }
        if (x-2>=0&&y+1<8){
            if (this.getChessboard()[x -2][y + 1].getChessColor().equals(ChessColor.NONE)) {
                move.add(this.getSource().offset(-2, 1));
            } else if (!this.getChessboard()[x -2][y + 1].getChessColor().equals(this.getChessColor())) {
                move.add(this.getSource().offset(-2, 1));
            }
        }
        if (x-1<8&&y+2<8){ // should be x-1>=0
            if (this.getChessboard()[x - 1][y + 2].getChessColor().equals(ChessColor.NONE)) {
                move.add(this.getSource().offset(-1, 2));
            } else if (!this.getChessboard()[x - 1][y + 2].getChessColor().equals(this.getChessColor())) {
                move.add(this.getSource().offset(-1, 2));
            }
        }
        return move;
    }
}

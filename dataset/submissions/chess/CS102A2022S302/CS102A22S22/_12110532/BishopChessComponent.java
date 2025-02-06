import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public BishopChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> move = new ArrayList<>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        for (int i = 1; x + i < 8 && y + i < 8; i++) {
            if (this.getChessboard()[x + i][y + i].getChessColor().equals(ChessColor.NONE)) {
                move.add(this.getSource().offset(i, i));
            } else if (this.getChessboard()[x + i][y + i].getChessColor().equals(this.getChessColor())) {
                break;
            } else {
                move.add(this.getSource().offset(i, i));
                break;
            }
        }
        for (int i = 1; x - i >= 0 && y + i < 8; i++) {
            if (this.getChessboard()[x - i][y + i].getChessColor().equals(ChessColor.NONE)) {
                move.add(this.getSource().offset(-i, i));
            } else if (this.getChessboard()[x - i][y + i].getChessColor().equals(this.getChessColor())) {
                break;
            } else {
                move.add(this.getSource().offset(-i, i));
                break;
            }
        }
        for (int i = 1; x - i >= 0 && y - i >= 0; i++) {
            if (this.getChessboard()[x - i][y - i].getChessColor().equals(ChessColor.NONE)) {
                move.add(this.getSource().offset(-i, -i));
            } else if (this.getChessboard()[x - i][y - i].getChessColor().equals(this.getChessColor())) {
                break;
            } else {
                move.add(this.getSource().offset(-i, -i));
                break;
            }
        }
        for (int i = 1; x + i < 8 && y - i >= 0; i++) {
            if (this.getChessboard()[x + i][y - i].getChessColor().equals(ChessColor.NONE)) {
                move.add(this.getSource().offset(i, -i));
            } else if (this.getChessboard()[x + i][y - i].getChessColor().equals(this.getChessColor())) {
                break;
            } else {
                move.add(this.getSource().offset(i, -i));
                break;
            }
        }
        return move;
    }
}












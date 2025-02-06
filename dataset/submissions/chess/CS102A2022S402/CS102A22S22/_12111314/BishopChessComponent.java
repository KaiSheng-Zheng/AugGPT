import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor == ChessColor.WHITE) super.name = 'b';
        else if (chessColor == ChessColor.BLACK) super.name = 'B';
    }

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, ChessComponent[][] chessboard) {
        super(source, chessColor, chessboard);
        if (chessColor == ChessColor.WHITE) super.name = 'b';
        else if (chessColor == ChessColor.BLACK) super.name = 'B';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            if (super.getSource().offset(i, i) != null) {
                if (super.chessboard[super.getSource().getX() + i][super.getSource().getY() + i].getChessColor() == this.getChessColor()) {
                    break;
                } else {
                    move.add(super.getSource().offset(i, i));
                    if (super.chessboard[super.getSource().getX() + i][super.getSource().getY() + i].getChessColor() != ChessColor.NONE) {
                        break;
                    }
                }
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (super.getSource().offset(i, -i) != null) {
                if (super.chessboard[super.getSource().getX() + i][super.getSource().getY() - i].getChessColor() == this.getChessColor()) {
                    break;
                } else {
                    move.add(super.getSource().offset(i, -i));
                    if (super.chessboard[super.getSource().getX() + i][super.getSource().getY() - i].getChessColor() != ChessColor.NONE) {
                        break;
                    }
                }
            }
        }
        for (int i = -1; i >= -7; i--) {
            if (super.getSource().offset(i, i) != null) {
                if (super.chessboard[super.getSource().getX() + i][super.getSource().getY() + i].getChessColor() == this.getChessColor()) {
                    break;
                } else {
                    move.add(super.getSource().offset(i, i));
                    if (super.chessboard[super.getSource().getX() + i][super.getSource().getY() + i].getChessColor() != ChessColor.NONE) {
                        break;
                    }
                }
            }
        }
        for (int i = -1; i >= -7; i--) {
            if (super.getSource().offset(i, -i) != null) {
                if (super.chessboard[super.getSource().getX() + i][super.getSource().getY() - i].getChessColor() == this.getChessColor()) {
                    break;
                } else {
                    move.add(super.getSource().offset(i, -i));
                    if (super.chessboard[super.getSource().getX() + i][super.getSource().getY() - i].getChessColor() != ChessColor.NONE) {
                        break;
                    }
                }
            }
        }
        return move;
    }
}

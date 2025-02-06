import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor == ChessColor.WHITE) super.name = 'q';
        else if (chessColor == ChessColor.BLACK) super.name = 'Q';
    }

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, ChessComponent[][] chessboard) {
        super(source, chessColor, chessboard);
        if (chessColor == ChessColor.WHITE) super.name = 'q';
        else if (chessColor == ChessColor.BLACK) super.name = 'Q';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            if (super.getSource().offset(0, i) != null) {
                if (super.chessboard[super.getSource().getX()][super.getSource().getY() + i].getChessColor() == this.getChessColor()) {
                    break;
                } else {
                    move.add(super.getSource().offset(0, i));
                    if (super.chessboard[super.getSource().getX()][super.getSource().getY() + i].getChessColor() != ChessColor.NONE) {
                        break;
                    }
                }
            }
        }
        for (int i = 1; i <=7 ; i++) {
            if (super.getSource().offset(i, 0) != null) {
                if (super.chessboard[super.getSource().getX() + i][super.getSource().getY()].getChessColor() == this.getChessColor()) {
                    break;
                } else {
                    move.add(super.getSource().offset(i, 0));
                    if (super.chessboard[super.getSource().getX() + i][super.getSource().getY()].getChessColor() != ChessColor.NONE) {
                        break;
                    }
                }
            }
        }
        for (int i = -1; i >= -7; i--) {
            if (super.getSource().offset(0, i) != null) {
                if (super.chessboard[super.getSource().getX()][super.getSource().getY() + i].getChessColor() == this.getChessColor()) {
                    break;
                } else {
                    move.add(super.getSource().offset(0, i));
                    if (super.chessboard[super.getSource().getX()][super.getSource().getY() + i].getChessColor() != ChessColor.NONE) {
                        break;
                    }
                }
            }
        }
        for (int i = -1; i >= -7; i--) {
            if (super.getSource().offset(i, 0) != null) {
                if (super.chessboard[super.getSource().getX() + i][super.getSource().getY()].getChessColor() == this.getChessColor()) {
                    break;
                } else {
                    move.add(super.getSource().offset(i, 0));
                    if (super.chessboard[super.getSource().getX() + i][super.getSource().getY()].getChessColor() != ChessColor.NONE) {
                        break;
                    }
                }
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (super.getSource().offset(i, i) != null) {
                if (super.chessboard[super.getSource().getX()+i][super.getSource().getY() + i].getChessColor() == this.getChessColor()) {
                    break;
                } else {
                    move.add(super.getSource().offset(i, i));
                    if (super.chessboard[super.getSource().getX()+i][super.getSource().getY() + i].getChessColor() != ChessColor.NONE) {
                        break;
                    }
                }
            }
        }
        for (int i = 1; i <= 7; i++) {
            if (super.getSource().offset(i, -i) != null) {
                if (super.chessboard[super.getSource().getX() + i][super.getSource().getY()-i].getChessColor() == this.getChessColor()) {
                    break;
                } else {
                    move.add(super.getSource().offset(i, -i));
                    if (super.chessboard[super.getSource().getX() + i][super.getSource().getY()-i].getChessColor() != ChessColor.NONE) {
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

import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor == ChessColor.WHITE) super.name = 'p';
        else if (chessColor == ChessColor.BLACK) super.name = 'P';
    }

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, ChessComponent[][] chessboard) {
        super(source, chessColor, chessboard);
        if (chessColor == ChessColor.WHITE) super.name = 'p';
        else if (chessColor == ChessColor.BLACK) super.name = 'P';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        if (super.getChessColor() == ChessColor.BLACK) {
            if (super.getSource().offset(1, 0) != null && super.chessboard[super.getSource().getX() + 1][super.getSource().getY()].getChessColor() == ChessColor.NONE) {
                move.add(super.getSource().offset(1, 0));
                if (super.getSource().getX() == 1 && super.chessboard[super.getSource().getX() + 2][super.getSource().getY()].getChessColor() == ChessColor.NONE)
                    move.add(super.getSource().offset(2, 0));
            }
            if (super.getSource().offset(1, 1) != null && super.chessboard[super.getSource().getX() + 1][super.getSource().getY() + 1].getChessColor() == ChessColor.WHITE)
                move.add(super.getSource().offset(1, 1));
            if (super.getSource().offset(1, -1) != null && super.chessboard[super.getSource().getX() + 1][super.getSource().getY() - 1].getChessColor() == ChessColor.WHITE)
                move.add(super.getSource().offset(1, -1));
        }
        if (super.getChessColor() == ChessColor.WHITE) {
            if (super.getSource().offset(-1, 0) != null && super.chessboard[super.getSource().getX() -1][super.getSource().getY()].getChessColor() == ChessColor.NONE) {
                move.add(super.getSource().offset(-1, 0));
                if (super.getSource().getX() == 6 && super.chessboard[super.getSource().getX() - 2][super.getSource().getY()].getChessColor() == ChessColor.NONE)
                    move.add(super.getSource().offset(-2, 0));
            }
            if (super.getSource().offset(-1, -1) != null && super.chessboard[super.getSource().getX() - 1][super.getSource().getY() - 1].getChessColor() == ChessColor.WHITE)
                move.add(super.getSource().offset(-1, -1));
            if (super.getSource().offset(-1, 1) != null && super.chessboard[super.getSource().getX() - 1][super.getSource().getY() + 1].getChessColor() == ChessColor.WHITE)
                move.add(super.getSource().offset(-1, 1));
        }
        return move;
    }
}

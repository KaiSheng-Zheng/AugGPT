import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor == ChessColor.WHITE) super.name = 'n';
        else if (chessColor == ChessColor.BLACK) super.name = 'N';
    }

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, ChessComponent[][] chessboard) {
        super(source, chessColor, chessboard);
        if (chessColor == ChessColor.WHITE) super.name = 'n';
        else if (chessColor == ChessColor.BLACK) super.name = 'N';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        if (super.getSource().offset(1, 2) != null && super.chessboard[super.getSource().getX() + 1][super.getSource().getY() + 2].getChessColor() != this.getChessColor())
            move.add(super.getSource().offset(1, 2));
        if (super.getSource().offset(2, 1) != null && super.chessboard[super.getSource().getX() + 2][super.getSource().getY() + 1].getChessColor() != this.getChessColor())
            move.add(super.getSource().offset(2, 1));
        if (super.getSource().offset(1, -2) != null && super.chessboard[super.getSource().getX() + 1][super.getSource().getY() - 2].getChessColor() != this.getChessColor())
            move.add(super.getSource().offset(1, -2));
        if (super.getSource().offset(-2, 1) != null && super.chessboard[super.getSource().getX() - 2][super.getSource().getY() + 1].getChessColor() != this.getChessColor())
            move.add(super.getSource().offset(-2, 1));
        if (super.getSource().offset(2, -1) != null && super.chessboard[super.getSource().getX() + 2][super.getSource().getY() - 1].getChessColor() != this.getChessColor())
            move.add(super.getSource().offset(2, -1));
        if (super.getSource().offset(-1, 2) != null && super.chessboard[super.getSource().getX() - 1][super.getSource().getY() + 2].getChessColor() != this.getChessColor())
            move.add(super.getSource().offset(-1, 2));
        if (super.getSource().offset(-2, -1) != null && super.chessboard[super.getSource().getX() - 2][super.getSource().getY() - 1].getChessColor() != this.getChessColor())
            move.add(super.getSource().offset(-2, -1));
        if (super.getSource().offset(-1, -2) != null && super.chessboard[super.getSource().getX() - 1][super.getSource().getY() - 2].getChessColor() != this.getChessColor())
            move.add(super.getSource().offset(-1, -2));
        return move;
    }
}

import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor == ChessColor.WHITE) super.name = 'k';
        else if (chessColor == ChessColor.BLACK) super.name = 'K';
    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, ChessComponent[][] chessboard) {
        super(source, chessColor, chessboard);
        if (chessColor == ChessColor.WHITE) super.name = 'k';
        else if (chessColor == ChessColor.BLACK) super.name = 'K';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        if (super.getSource().offset(1, 1) != null && super.chessboard[super.getSource().getX() + 1][super.getSource().getY() + 1].getChessColor() != this.getChessColor())
            move.add(super.getSource().offset(1, 1));
        if (super.getSource().offset(0, 1) != null && super.chessboard[super.getSource().getX()][super.getSource().getY() + 1].getChessColor() != this.getChessColor())
            move.add(super.getSource().offset(0, 1));
        if (super.getSource().offset(1, 0) != null && super.chessboard[super.getSource().getX() + 1][super.getSource().getY()].getChessColor() != this.getChessColor())
            move.add(super.getSource().offset(1, 0));
        if (super.getSource().offset(1, -1) != null && super.chessboard[super.getSource().getX() + 1][super.getSource().getY() - 1].getChessColor() != this.getChessColor())
            move.add(super.getSource().offset(1, -1));
        if (super.getSource().offset(-1, 1) != null && super.chessboard[super.getSource().getX() - 1][super.getSource().getY() + 1].getChessColor() != this.getChessColor())
            move.add(super.getSource().offset(-1, 1));
        if (super.getSource().offset(-1, -1) != null && super.chessboard[super.getSource().getX() - 1][super.getSource().getY() - 1].getChessColor() != this.getChessColor())
            move.add(super.getSource().offset(-1, -1));
        if (super.getSource().offset(-1, 0) != null && super.chessboard[super.getSource().getX() - 1][super.getSource().getY()].getChessColor() != this.getChessColor())
            move.add(super.getSource().offset(-1, 0));
        if (super.getSource().offset(0, -1) != null && super.chessboard[super.getSource().getX()][super.getSource().getY() - 1].getChessColor() != this.getChessColor())
            move.add(super.getSource().offset(0, -1));
        return move;
    }
}

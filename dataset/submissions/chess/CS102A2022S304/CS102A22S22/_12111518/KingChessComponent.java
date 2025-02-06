import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    public KingChessComponent(int x, int y, ChessColor chessColor) {
        super(x, y, chessColor);
        if (chessColor == ChessColor.BLACK) {
            name = 'K';
        } else {
            name = 'k';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove = new ArrayList<>();
        ChessboardPoint[] in = new ChessboardPoint[8];
        in[0] = super.getSource().offset(-1, -1);
        in[1] = super.getSource().offset(-1, 0);
        in[2] = super.getSource().offset(-1, 1);
        in[3] = super.getSource().offset(0, -1);
        in[4] = super.getSource().offset(0, 1);
        in[5] = super.getSource().offset(1, -1);
        in[6] = super.getSource().offset(1, 0);
        in[7] = super.getSource().offset(1, 1);
        for (ChessboardPoint chessboardPoint : in) {
            if (chessboardPoint != null && chessboard[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor() != this.getChessColor()) {
                canMove.add(chessboardPoint);
            }
        }
        return canMove;
    }
}

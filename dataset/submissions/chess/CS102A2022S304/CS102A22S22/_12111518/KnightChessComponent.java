import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(int x, int y, ChessColor chessColor) {
        super(x, y, chessColor);
        if (chessColor == ChessColor.BLACK){
            name = 'N';
        }else {
            name = 'n';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove = new ArrayList<>();
        ChessboardPoint[] in = new ChessboardPoint[8];
        in[0] = super.getSource().offset(-2, -1);
        in[1] = super.getSource().offset(-2, 1);
        in[2] = super.getSource().offset(-1, -2);
        in[3] = super.getSource().offset(-1, 2);
        in[4] = super.getSource().offset(1, -2);
        in[5] = super.getSource().offset(1, 2);
        in[6] = super.getSource().offset(2, -1);
        in[7] = super.getSource().offset(2, 1);
        for (ChessboardPoint chessboardPoint : in) {
            if (chessboardPoint != null && chessboard[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor() != this.getChessColor()) {
                canMove.add(chessboardPoint);
            }
        }
        return canMove;
    }
}

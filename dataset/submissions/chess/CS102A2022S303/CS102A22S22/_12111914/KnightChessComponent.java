import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove = new ArrayList<>();
        ChessColor color = super.getChessColor();
        ChessboardPoint[] knightMove = {new ChessboardPoint(1, 2), new ChessboardPoint(1, -2),
                new ChessboardPoint(-1, 2), new ChessboardPoint(-1, -2),
                new ChessboardPoint(2, 1), new ChessboardPoint(2, -1),
                new ChessboardPoint(-2, 1), new ChessboardPoint(-2, -1)};

        for (int i = 0; i < 8; i++) {
            if (super.getSource().canMove(knightMove[i].getX(),knightMove[i].getY())) {
                ChessboardPoint chessboardPointNew = super.getSource().offset(knightMove[i].getX(),knightMove[i].getY());
                if (!super.chessBoard[chessboardPointNew.getX()][chessboardPointNew.getY()].getChessColor().equals(color))
                canMove.add(chessboardPointNew);
            }
        }

        super.Ordered(canMove);

        return canMove;    
    }
}

import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove = new ArrayList<>();
        ChessColor color = super.getChessColor();

        for (int i = 1; i < 2; i++) {
            if (!super.getSource().canMove(i,0)) break;
            ChessboardPoint chessboardPointNew = super.getSource().offset(i,0);
            if (super.chessBoard[chessboardPointNew.getX()][chessboardPointNew.getY()].getChessColor().equals(color)) break;
            if (!super.chessBoard[chessboardPointNew.getX()][chessboardPointNew.getY()].getChessColor().equals(ChessColor.NONE)) {
                canMove.add(chessboardPointNew);
                break;
            }
            canMove.add(chessboardPointNew);
        }
        for (int i = 1; i < 2; i++) {
            if (!super.getSource().canMove(-i,0)) break;
            ChessboardPoint chessboardPointNew = super.getSource().offset(-i,0);
            if (super.chessBoard[chessboardPointNew.getX()][chessboardPointNew.getY()].getChessColor().equals(color)) break;
            if (!super.chessBoard[chessboardPointNew.getX()][chessboardPointNew.getY()].getChessColor().equals(ChessColor.NONE)) {
                canMove.add(chessboardPointNew);
                break;
            }
            canMove.add(chessboardPointNew);
        }
        for (int i = 1; i < 2; i++) {
            if (!super.getSource().canMove(0,i)) break;
            ChessboardPoint chessboardPointNew = super.getSource().offset(0,i);
            if (super.chessBoard[chessboardPointNew.getX()][chessboardPointNew.getY()].getChessColor().equals(color)) break;
            if (!super.chessBoard[chessboardPointNew.getX()][chessboardPointNew.getY()].getChessColor().equals(ChessColor.NONE)) {
                canMove.add(chessboardPointNew);
                break;
            }
            canMove.add(chessboardPointNew);
        }
        for (int i = 1; i < 2; i++) {
            if (!super.getSource().canMove(0,-i)) break;
            ChessboardPoint chessboardPointNew = super.getSource().offset(0,-i);
            if (super.chessBoard[chessboardPointNew.getX()][chessboardPointNew.getY()].getChessColor().equals(color)) break;
            if (!super.chessBoard[chessboardPointNew.getX()][chessboardPointNew.getY()].getChessColor().equals(ChessColor.NONE)) {
                canMove.add(chessboardPointNew);
                break;
            }
            canMove.add(chessboardPointNew);
        }
        for (int i = 1; i < 2; i++) {
            if (!super.getSource().canMove(i,i)) break;
            ChessboardPoint chessboardPointNew = super.getSource().offset(i,i);
            if (super.chessBoard[chessboardPointNew.getX()][chessboardPointNew.getY()].getChessColor().equals(color)) break;
            if (!super.chessBoard[chessboardPointNew.getX()][chessboardPointNew.getY()].getChessColor().equals(ChessColor.NONE)) {
                canMove.add(chessboardPointNew);
                break;
            }
            canMove.add(chessboardPointNew);
        }
        for (int i = 1; i < 2; i++) {
            if (!super.getSource().canMove(-i,-i)) break;
            ChessboardPoint chessboardPointNew = super.getSource().offset(-i,-i);
            if (super.chessBoard[chessboardPointNew.getX()][chessboardPointNew.getY()].getChessColor().equals(color)) break;
            if (!super.chessBoard[chessboardPointNew.getX()][chessboardPointNew.getY()].getChessColor().equals(ChessColor.NONE)) {
                canMove.add(chessboardPointNew);
                break;
            }
            canMove.add(chessboardPointNew);
        }
        for (int i = 1; i < 2; i++) {
            if (!super.getSource().canMove(i,-i)) break;
            ChessboardPoint chessboardPointNew = super.getSource().offset(i,-i);
            if (super.chessBoard[chessboardPointNew.getX()][chessboardPointNew.getY()].getChessColor().equals(color)) break;
            if (!super.chessBoard[chessboardPointNew.getX()][chessboardPointNew.getY()].getChessColor().equals(ChessColor.NONE)) {
                canMove.add(chessboardPointNew);
                break;
            }
            canMove.add(chessboardPointNew);
        }
        for (int i = 1; i < 2; i++) {
            if (!super.getSource().canMove(-i,i)) break;
            ChessboardPoint chessboardPointNew = super.getSource().offset(-i,i);
            if (super.chessBoard[chessboardPointNew.getX()][chessboardPointNew.getY()].getChessColor().equals(color)) break;
            if (!super.chessBoard[chessboardPointNew.getX()][chessboardPointNew.getY()].getChessColor().equals(ChessColor.NONE)) {
                canMove.add(chessboardPointNew);
                break;
            }
            canMove.add(chessboardPointNew);
        }
        super.Ordered(canMove);

        return canMove;
    }
}

import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove = new ArrayList<>();
        ChessColor color = super.getChessColor();

        if (super.getSource().getX() == 1 && color == ChessColor.BLACK){
            if (super.getSource().canMove(2,0)) {
                ChessboardPoint chessboardPointNew = super.getSource().offset(2,0);
                if (super.chessBoard[chessboardPointNew.getX()][chessboardPointNew.getY()].getChessColor().equals(ChessColor.NONE)){
                    canMove.add(chessboardPointNew);
                }
            }
        }
        if (super.getSource().getX() == 6 && color == ChessColor.WHITE){
            if (super.getSource().canMove(-2,0)) {
                ChessboardPoint chessboardPointNew = super.getSource().offset(-2,0);
                if (super.chessBoard[chessboardPointNew.getX()][chessboardPointNew.getY()].getChessColor().equals(ChessColor.NONE)){
                    canMove.add(chessboardPointNew);
                }
            }
        }

        if (super.getSource().canMove(1,0) && color == ChessColor.BLACK) {
            ChessboardPoint chessboardPointNew = super.getSource().offset(1,0);
            if (super.chessBoard[chessboardPointNew.getX()][chessboardPointNew.getY()].getChessColor().equals(ChessColor.NONE)){
                canMove.add(chessboardPointNew);
            }
        }
        if (super.getSource().canMove(-1,0)  && color == ChessColor.WHITE) {
            ChessboardPoint chessboardPointNew = super.getSource().offset(-1,0);
            if (super.chessBoard[chessboardPointNew.getX()][chessboardPointNew.getY()].getChessColor().equals(ChessColor.NONE)){
                canMove.add(chessboardPointNew);
            }
        }

        if (color == ChessColor.BLACK){
            if (super.getSource().canMove(1,-1)) {
                ChessboardPoint chessboardPointNew = super.getSource().offset(1,-1);
                if (super.chessBoard[chessboardPointNew.getX()][chessboardPointNew.getY()].getChessColor().equals(ChessColor.WHITE)){
                    canMove.add(chessboardPointNew);
                }
            }
            if (super.getSource().canMove(1,1)) {
                ChessboardPoint chessboardPointNew = super.getSource().offset(1,1);
                if (super.chessBoard[chessboardPointNew.getX()][chessboardPointNew.getY()].getChessColor().equals(ChessColor.WHITE)){
                    canMove.add(chessboardPointNew);
                }
            }
        }
        if (color == ChessColor.WHITE){
            if (super.getSource().canMove(-1,1)) {
                ChessboardPoint chessboardPointNew = super.getSource().offset(-1,1);
                if (super.chessBoard[chessboardPointNew.getX()][chessboardPointNew.getY()].getChessColor().equals(ChessColor.BLACK)){
                    canMove.add(chessboardPointNew);
                }
            }
            if (super.getSource().canMove(-1,-1)) {
                ChessboardPoint chessboardPointNew = super.getSource().offset(-1,-1);
                if (super.chessBoard[chessboardPointNew.getX()][chessboardPointNew.getY()].getChessColor().equals(ChessColor.BLACK)){
                    canMove.add(chessboardPointNew);
                }
            }
        }
        super.Ordered(canMove);

        return canMove;
    }
}

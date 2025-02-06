import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public PawnChessComponent(char name,ChessboardPoint source,ChessColor chessColor){
        super(name,source,chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> pawn = new ArrayList<>();
        int row = getSource().getX();
        int col = getSource().getY();

        if (row == 1 && getChessColor() == ChessColor.BLACK){
            if (getChessComponents()[row+1][col].getChessColor() == ChessColor.NONE){
                pawn.add(new ChessboardPoint(row+1,col));
            }
            if (getChessComponents()[row+2][col].getChessColor() == ChessColor.NONE){
                pawn.add(new ChessboardPoint(row+2,col));
            }
        }
        if (row == 6 && getChessColor() == ChessColor.WHITE){
            if (getChessComponents()[row-1][col].getChessColor() == ChessColor.NONE){
                pawn.add(new ChessboardPoint(row-1,col));
            }
            if (getChessComponents()[row-2][col].getChessColor() == ChessColor.NONE){
                pawn.add(new ChessboardPoint(row-2,col));
            }
        }
        if (row != 1 && getChessColor() == ChessColor.BLACK){
            if (row+1 < 8) {
                if (getChessComponents()[row + 1][col].getChessColor() == ChessColor.NONE) {
                    pawn.add(new ChessboardPoint(row + 1, col));
                }
            }
        }
        if (row != 6 && getChessColor() == ChessColor.WHITE){
            if (row-1 > -1) {
                if (getChessComponents()[row - 1][col].getChessColor() == ChessColor.NONE) {
                    pawn.add(new ChessboardPoint(row - 1, col));
                }
            }
        }
        if (getChessColor() == ChessColor.BLACK){
            if (row+1 < 8 && col+1 < 8) {
                if (getChessComponents()[row + 1][col + 1].getChessColor() == ChessColor.WHITE) {
                    pawn.add(new ChessboardPoint(row + 1, col + 1));
                }
            }
            if(row+1 < 8 && col-1 > -1) {
                if (getChessComponents()[row + 1][col - 1].getChessColor() == ChessColor.WHITE) {
                    pawn.add(new ChessboardPoint(row + 1, col - 1));
                }
            }
        }
        if (getChessColor() == ChessColor.WHITE){
            if (row-1 > -1 && col+1 < 8) {
                if (getChessComponents()[row - 1][col + 1].getChessColor() == ChessColor.BLACK) {
                    pawn.add(new ChessboardPoint(row - 1, col + 1));
                }
            }
            if(row-1 > -1 && col-1 > -1) {
                if (getChessComponents()[row - 1][col - 1].getChessColor() == ChessColor.BLACK) {
                    pawn.add(new ChessboardPoint(row - 1, col - 1));
                }
            }
        }

        return pawn;
    }

}

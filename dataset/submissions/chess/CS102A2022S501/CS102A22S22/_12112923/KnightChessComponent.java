import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent (ChessboardPoint chessboardPoint,ChessColor chessColor,char name){
        super(chessboardPoint,chessColor,name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>canMove=new ArrayList<>();
        ChessComponent[][] a = super.getChessComponents();
        ChessColor color = super.getChessColor();
        int row = super.getSource().getX();
        int col = super.getSource().getY();
        if(color==ChessColor.BLACK){
            if(row+1<8 && col+2<8) {
                if ((a[row + 1][col + 2].getChessColor() == ChessColor.WHITE || a[row + 1][col + 2].getChessColor() == ChessColor.NONE)) {
                    canMove.add(new ChessboardPoint(row + 1, col + 2));
                }
            }
            if(row+2<8 && col+1<8) {
                if ((a[row + 2][col + 1].getChessColor() == ChessColor.WHITE || a[row + 2][col + 1].getChessColor() == ChessColor.NONE)) {
                    canMove.add(new ChessboardPoint(row + 2, col + 1));
                }
            }
            if(row-1>=0 && col + 2 < 8) {
                if ((a[row - 1][col + 2].getChessColor() == ChessColor.NONE || a[row - 1][col + 2].getChessColor() == ChessColor.WHITE)) {
                    canMove.add(new ChessboardPoint(row - 1, col + 2));
                }
            }
            if(row-2>=0 && col+1<8) {
                if ((a[row - 2][col + 1].getChessColor() == ChessColor.NONE || a[row - 2][col + 1].getChessColor() == ChessColor.WHITE)) {
                    canMove.add(new ChessboardPoint(row - 2, col + 1));
                }
            }
            if(row+1<8&&col-2>=0) {
                if ((a[row + 1][col - 2].getChessColor() == ChessColor.WHITE || a[row + 1][col - 2].getChessColor() == ChessColor.NONE)) {
                    canMove.add(new ChessboardPoint(row + 1, col - 2));
                }
            }
            if(row+2<8&&col-1>=0) {
                if ((a[row + 2][col - 1].getChessColor() == ChessColor.WHITE || a[row + 2][col - 1].getChessColor() == ChessColor.NONE)) {
                    canMove.add(new ChessboardPoint(row + 2, col - 1));
                }
            }
            if(row-1>=0&&col-2>=0) {
                if (a[row - 1][col - 2].getChessColor() == ChessColor.NONE || a[row - 1][col - 2].getChessColor() == ChessColor.WHITE) {
                    canMove.add(new ChessboardPoint(row - 1, col - 2));
                }
            }
            if(row-2>=0&&col-1>=0) {
                if (a[row - 2][col - 1].getChessColor() == ChessColor.NONE || a[row - 2][col - 1].getChessColor() == ChessColor.WHITE) {
                    canMove.add(new ChessboardPoint(row - 2, col - 1));
                }
            }
        }else {
            if(row+1<8 && col+2<8) {
                if ((a[row + 1][col + 2].getChessColor() == ChessColor.BLACK || a[row + 1][col + 2].getChessColor() == ChessColor.NONE)) {
                    canMove.add(new ChessboardPoint(row + 1, col + 2));
                }
            }
            if(row+2<8 && col+1<8) {
                if ((a[row + 2][col + 1].getChessColor() == ChessColor.BLACK || a[row + 2][col + 1].getChessColor() == ChessColor.NONE)) {
                    canMove.add(new ChessboardPoint(row + 2, col + 1));
                }
            }
            if(row-1>=0 && col + 2 < 8) {
                if ((a[row - 1][col + 2].getChessColor() == ChessColor.NONE || a[row - 1][col + 2].getChessColor() == ChessColor.BLACK) ) {
                    canMove.add(new ChessboardPoint(row - 1, col + 2));
                }
            }
            if(row-2>=0 && col+1<8) {
                if ((a[row - 2][col + 1].getChessColor() == ChessColor.NONE || a[row - 2][col + 1].getChessColor() == ChessColor.BLACK)) {
                    canMove.add(new ChessboardPoint(row - 2, col + 1));
                }
            }
            if(row+1<8&&col-2>=0) {
                if ((a[row + 1][col - 2].getChessColor() == ChessColor.BLACK || a[row + 1][col - 2].getChessColor() == ChessColor.NONE)) {
                    canMove.add(new ChessboardPoint(row + 1, col - 2));
                }
            }
            if(row+2<8&&col-1>=0) {
                if ((a[row + 2][col - 1].getChessColor() == ChessColor.BLACK || a[row + 2][col - 1].getChessColor() == ChessColor.NONE)) {
                    canMove.add(new ChessboardPoint(row + 2, col - 1));
                }
            }
            if(row-1>=0&&col-2>=0) {
                if (a[row - 1][col - 2].getChessColor() == ChessColor.NONE || a[row - 1][col - 2].getChessColor() == ChessColor.BLACK) {
                    canMove.add(new ChessboardPoint(row - 1, col - 2));
                }
            }
            if(row-2>=0&&col-1>=0) {
                if (a[row - 2][col - 1].getChessColor() == ChessColor.NONE || a[row - 2][col - 1].getChessColor() == ChessColor.BLACK) {
                    canMove.add(new ChessboardPoint(row - 2, col - 1));
                }
            }
        }
        return canMove;
    }
}

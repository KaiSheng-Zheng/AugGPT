import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent (ChessboardPoint chessboardPoint,ChessColor chessColor,char name){
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
            if(row+1<8&&col+1<8) {
                if ((a[row + 1][col + 1].getChessColor() == ChessColor.WHITE || a[row + 1][col + 1].getChessColor() == ChessColor.NONE)) {
                    canMove.add(new ChessboardPoint(row + 1, col + 1));
                }
            }
            if(row+1<8&&col-1>=0) {
                if ((a[row + 1][col - 1].getChessColor() != ChessColor.BLACK)) {
                    canMove.add(new ChessboardPoint(row + 1, col - 1));
                }
            }
            if(row-1>=0&&col+1<8) {
                if (a[row - 1][col + 1].getChessColor() != ChessColor.BLACK && col + 1 < 8) {
                    canMove.add(new ChessboardPoint(row - 1, col + 1));
                }
            }
            if(row-1>=0&&col-1>=0) {
                if (a[row - 1][col - 1].getChessColor() != ChessColor.BLACK) {
                    canMove.add(new ChessboardPoint(row - 1, col - 1));
                }
            }
            if(col+1<8) {
                if (a[row][col + 1].getChessColor() != ChessColor.BLACK && col + 1 < 8) {
                    canMove.add(new ChessboardPoint(row, col + 1));
                }
            }
            if(col-1>=0) {
                if (a[row][col - 1].getChessColor() != ChessColor.BLACK) {
                    canMove.add(new ChessboardPoint(row, col - 1));
                }
            }
            if(row+1<8) {
                if (a[row + 1][col].getChessColor() != ChessColor.BLACK && row + 1 < 8) {
                    canMove.add(new ChessboardPoint(row + 1, col));
                }
            }
            if(row-1>=0) {
                if (a[row - 1][col].getChessColor() != ChessColor.BLACK) {
                    canMove.add(new ChessboardPoint(row - 1, col));
                }
            }
        }else {
            if (row + 1 < 8 && col + 1 < 8) {
                if ((a[row + 1][col + 1].getChessColor() != ChessColor.WHITE)) {
                    canMove.add(new ChessboardPoint(row + 1, col + 1));
                }
            }
            if (row + 1 < 8 && col - 1 >= 0) {
                if ((a[row + 1][col - 1].getChessColor() != ChessColor.WHITE)) {
                    canMove.add(new ChessboardPoint(row + 1, col - 1));
                }
            }
            if (row - 1 >= 0 && col + 1 < 8) {
                if (a[row - 1][col + 1].getChessColor() != ChessColor.WHITE && col + 1 < 8) {
                    canMove.add(new ChessboardPoint(row - 1, col + 1));
                }
            }
            if (row - 1 >= 0 && col - 1 >= 0) {
                if (a[row - 1][col - 1].getChessColor() != ChessColor.WHITE) {
                    canMove.add(new ChessboardPoint(row - 1, col - 1));
                }
            }
            if (col + 1 < 8) {
                if (a[row][col + 1].getChessColor() != ChessColor.WHITE && col + 1 < 8) {
                    canMove.add(new ChessboardPoint(row, col + 1));
                }
            }
            if (col - 1 >= 0) {
                if (a[row][col - 1].getChessColor() != ChessColor.WHITE) {
                    canMove.add(new ChessboardPoint(row, col - 1));
                }
            }
            if (row + 1 < 8) {
                if (a[row + 1][col].getChessColor() != ChessColor.WHITE && row + 1 < 8) {
                    canMove.add(new ChessboardPoint(row + 1, col));
                }
            }
            if (row - 1 >= 0) {
                if (a[row - 1][col].getChessColor() != ChessColor.WHITE) {
                    canMove.add(new ChessboardPoint(row - 1, col));
                }
            }
        }
        return canMove;
    }
}

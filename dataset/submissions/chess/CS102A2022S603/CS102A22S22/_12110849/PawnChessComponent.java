import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] a = super.getChessComponents();
        ArrayList<ChessboardPoint> chessboardPoints = new ArrayList<>();
        ChessComponent e = new EmptySlotComponent();
        int row = super.getSource().getX();
        int col = super.getSource().getY();
        if (a[row][col].getChessColor()==ChessColor.BLACK){
            if(row==1){
                if(a[row+1][col].getChessColor()==ChessColor.NONE){
                    chessboardPoints.add(new ChessboardPoint(row+1,col));
                }
                if(a[row+2][col].getChessColor()==ChessColor.NONE && a[row+1][col].getChessColor()==ChessColor.NONE){
                    chessboardPoints.add(new ChessboardPoint(row+2,col));
                }
                if(col+1<8) {
                    if (a[row + 1][col + 1].getChessColor() == ChessColor.WHITE ) {
                        chessboardPoints.add(new ChessboardPoint(row + 1, col + 1));
                    }
                }
                if(col-1>=0) {
                    if (a[row + 1][col - 1].getChessColor() == ChessColor.WHITE && col - 1 >= 0) {
                        chessboardPoints.add(new ChessboardPoint(row + 1, col - 1));
                    }
                }
            }
            if(row>1 && row<7){
                if(a[row+1][col].getChessColor()==ChessColor.NONE){
                    chessboardPoints.add(new ChessboardPoint(row+1,col));
                }
                if(col+1<8) {
                    if (a[row + 1][col + 1].getChessColor() == ChessColor.WHITE && col + 1 < 8) {
                        chessboardPoints.add(new ChessboardPoint(row + 1, col + 1));
                    }
                }
                if(col-1>=0) {
                    if (a[row + 1][col - 1].getChessColor() == ChessColor.WHITE && col - 1 >= 0) {
                        chessboardPoints.add(new ChessboardPoint(row + 1, col - 1));
                    }
                }
            }
        }
        else if (a[row][col].getChessColor()==ChessColor.WHITE){
            if(row==6){
                if(a[row-1][col].getChessColor()==ChessColor.NONE){
                    chessboardPoints.add(new ChessboardPoint(row-1,col));
                }
                if(a[row-2][col].getChessColor()==ChessColor.NONE && a[row-1][col].getChessColor()==ChessColor.NONE){
                    chessboardPoints.add(new ChessboardPoint(row-2,col));
                }
                if(col+1<8) {
                    if (a[row - 1][col + 1].getChessColor() == ChessColor.BLACK ) {
                        chessboardPoints.add(new ChessboardPoint(row - 1, col + 1));
                    }
                }
                if(col-1>=0) {
                    if (a[row - 1][col - 1].getChessColor() == ChessColor.BLACK) {
                        chessboardPoints.add(new ChessboardPoint(row - 1, col - 1));
                    }
                }
            }
            if(row<6&&row>0){
                if(a[row-1][col].getChessColor()==ChessColor.NONE){
                    chessboardPoints.add(new ChessboardPoint(row-1,col));
                }
                if(col+1<8) {
                    if (a[row - 1][col + 1].getChessColor() == ChessColor.BLACK && col + 1 < 8) {
                        chessboardPoints.add(new ChessboardPoint(row - 1, col + 1));
                    }
                }
                if(col-1>=0) {
                    if (a[row - 1][col - 1].getChessColor() == ChessColor.BLACK) {
                        chessboardPoints.add(new ChessboardPoint(row - 1, col - 1));
                    }
                }
            }
        }
        return chessboardPoints;
    }
}

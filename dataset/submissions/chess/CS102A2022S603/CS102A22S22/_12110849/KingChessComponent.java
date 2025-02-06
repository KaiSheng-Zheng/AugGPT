import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] a = super.getChessComponents();
        ArrayList<ChessboardPoint> chessboardPoints = new ArrayList<>();
        ChessComponent e = new EmptySlotComponent();
        int row = super.getSource().getX();
        int col = super.getSource().getY();
        if (a[row][col].getChessColor()==ChessColor.BLACK){
            if (row<7 && (a[row+1][col].getChessColor()==ChessColor.NONE||a[row+1][col].getChessColor()==ChessColor.WHITE)){
                chessboardPoints.add(new ChessboardPoint(row+1,col));
            }
            if (row>0 && (a[row-1][col].getChessColor()==ChessColor.NONE||a[row-1][col].getChessColor()==ChessColor.WHITE)){
                chessboardPoints.add(new ChessboardPoint(row-1,col));
            }
            if (col<7 && (a[row][col+1].getChessColor()==ChessColor.NONE||a[row][col+1].getChessColor()==ChessColor.WHITE)){
                chessboardPoints.add(new ChessboardPoint(row,col+1));
            }
            if (col>0 && (a[row][col-1].getChessColor()==ChessColor.NONE||a[row][col-1].getChessColor()==ChessColor.WHITE)){
                chessboardPoints.add(new ChessboardPoint(row,col-1));
            }
            if (row<7 &&col<7&& (a[row+1][col+1].getChessColor()==ChessColor.NONE||a[row+1][col+1].getChessColor()==ChessColor.WHITE)){
                chessboardPoints.add(new ChessboardPoint(row+1,col+1));
            }
            if (row>0 && col<7&&(a[row-1][col+1].getChessColor()==ChessColor.NONE||a[row-1][col+1].getChessColor()==ChessColor.WHITE)){
                chessboardPoints.add(new ChessboardPoint(row-1,col+1));
            }
            if (row<7 && col>0&&(a[row+1][col-1].getChessColor()==ChessColor.NONE||a[row+1][col-1].getChessColor()==ChessColor.WHITE)){
                chessboardPoints.add(new ChessboardPoint(row+1,col-1));
            }
            if (col>0 && row>0&&(a[row-1][col-1].getChessColor()==ChessColor.NONE||a[row-1][col-1].getChessColor()==ChessColor.WHITE)){
                chessboardPoints.add(new ChessboardPoint(row-1,col-1));
            }
        }
        else if (a[row][col].getChessColor()==ChessColor.WHITE){
            if (row<7 && (a[row+1][col].getChessColor()==ChessColor.NONE||a[row+1][col].getChessColor()==ChessColor.BLACK)){
                chessboardPoints.add(new ChessboardPoint(row+1,col));
            }
            if (row>0 && (a[row-1][col].getChessColor()==ChessColor.NONE||a[row-1][col].getChessColor()==ChessColor.BLACK)){
                chessboardPoints.add(new ChessboardPoint(row-1,col));
            }
            if (col<7 && (a[row][col+1].getChessColor()==ChessColor.NONE||a[row][col+1].getChessColor()==ChessColor.BLACK)){
                chessboardPoints.add(new ChessboardPoint(row,col+1));
            }
            if (col>0 && (a[row][col-1].getChessColor()==ChessColor.NONE||a[row][col-1].getChessColor()==ChessColor.BLACK)){
                chessboardPoints.add(new ChessboardPoint(row,col-1));
            }
            if (row<7 &&col<7&& (a[row+1][col+1].getChessColor()==ChessColor.NONE||a[row+1][col+1].getChessColor()==ChessColor.BLACK)){
                chessboardPoints.add(new ChessboardPoint(row+1,col+1));
            }
            if (row>0 && col<7&&(a[row-1][col+1].getChessColor()==ChessColor.NONE||a[row-1][col+1].getChessColor()==ChessColor.BLACK)){
                chessboardPoints.add(new ChessboardPoint(row-1,col+1));
            }
            if (row<7 && col>0&&(a[row+1][col-1].getChessColor()==ChessColor.NONE||a[row+1][col-1].getChessColor()==ChessColor.BLACK)){
                chessboardPoints.add(new ChessboardPoint(row+1,col-1));
            }
            if (col>0 && row>0&&(a[row-1][col-1].getChessColor()==ChessColor.NONE||a[row-1][col-1].getChessColor()==ChessColor.BLACK)){
                chessboardPoints.add(new ChessboardPoint(row-1,col-1));
            }
        }
        return chessboardPoints;
    }

//    @Override
//    public ChessColor getChessColor() {
//        return super.getChessColor();
//    }

//    @Override
//    public String toString() {
//        if (getChessColor()==ChessColor.BLACK)  return "K";
//        else return "k";
//    }

}

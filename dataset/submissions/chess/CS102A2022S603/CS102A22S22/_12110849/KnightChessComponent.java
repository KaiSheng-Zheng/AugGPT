import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] a = super.getChessComponents();
        ArrayList<ChessboardPoint> chessboardPoints = new ArrayList<>();
        ChessComponent e = new EmptySlotComponent();
        int row = super.getSource().getX();
        int col = super.getSource().getY();
        
                if (a[row][col].getChessColor()==ChessColor.BLACK){
                    if (row<=6&&col<=5&& (a[row+1][col+2].getChessColor()==ChessColor.NONE||a[row+1][col+2].getChessColor()==ChessColor.WHITE)){
                        chessboardPoints.add(new ChessboardPoint(row+1,col+2));
                    }
                    if (row-1>=0&&col<=5&& (a[row-1][col+2].getChessColor()==ChessColor.NONE||a[row-1][col+2].getChessColor()==ChessColor.WHITE)){
                        chessboardPoints.add(new ChessboardPoint(row-1,col+2));
                    }
                    if (row>=1&&col>=2&& (a[row-1][col-2].getChessColor()==ChessColor.NONE||a[row-1][col-2].getChessColor()==ChessColor.WHITE)){
                        chessboardPoints.add(new ChessboardPoint(row-1,col-2));
                    }
                    if (row<=6&&col>=2&& (a[row+1][col-2].getChessColor()==ChessColor.NONE||a[row+1][col-2].getChessColor()==ChessColor.WHITE)){
                        chessboardPoints.add(new ChessboardPoint(row+1,col-2));
                    }
                    if (row<=5&&col<=6&& (a[row+2][col+1].getChessColor()==ChessColor.NONE||a[row+2][col+1].getChessColor()==ChessColor.WHITE)){
                        chessboardPoints.add(new ChessboardPoint(row+2,col+1));
                    }
                    if (row>=2&&col<=6&& (a[row-2][col+1].getChessColor()==ChessColor.NONE||a[row-2][col+1].getChessColor()==ChessColor.WHITE)){
                        chessboardPoints.add(new ChessboardPoint(row-2,col+1));
                    }
                    if (row>=2&&col>=1&& (a[row-2][col-1].getChessColor()==ChessColor.NONE||a[row-2][col-1].getChessColor()==ChessColor.WHITE)){
                        chessboardPoints.add(new ChessboardPoint(row-2,col-1));
                    }
                    if (row<=5&&col>=1&& (a[row+2][col-1].getChessColor()==ChessColor.NONE||a[row+2][col-1].getChessColor()==ChessColor.WHITE)){
                        chessboardPoints.add(new ChessboardPoint(row+2,col-1));
                    }
                }
                else if (a[row][col].getChessColor()==ChessColor.WHITE){
                    if (row<=6&&col<=5&& (a[row+1][col+2].getChessColor()==ChessColor.NONE||a[row+1][col+2].getChessColor()==ChessColor.BLACK)){
                        chessboardPoints.add(new ChessboardPoint(row+1,col+2));
                    }
                    if (row-1>=0&&col<=5&& (a[row-1][col+2].getChessColor()==ChessColor.NONE||a[row-1][col+2].getChessColor()==ChessColor.BLACK)){
                        chessboardPoints.add(new ChessboardPoint(row-1,col+2));
                    }
                    if (row>=1&&col>=2&& (a[row-1][col-2].getChessColor()==ChessColor.NONE||a[row-1][col-2].getChessColor()==ChessColor.BLACK)){
                        chessboardPoints.add(new ChessboardPoint(row-1,col-2));
                    }
                    if (row<=6&&col>=2&& (a[row+1][col-2].getChessColor()==ChessColor.NONE||a[row+1][col-2].getChessColor()==ChessColor.BLACK)){
                        chessboardPoints.add(new ChessboardPoint(row+1,col-2));
                    }
                    if (row<=5&&col<=6&& (a[row+2][col+1].getChessColor()==ChessColor.NONE||a[row+2][col+1].getChessColor()==ChessColor.BLACK)){
                        chessboardPoints.add(new ChessboardPoint(row+2,col+1));
                    }
                    if (row>=2&&col<=6&& (a[row-2][col+1].getChessColor()==ChessColor.NONE||a[row-2][col+1].getChessColor()==ChessColor.BLACK)){
                        chessboardPoints.add(new ChessboardPoint(row-2,col+1));
                    }
                    if (row>=2&&col>=1&& (a[row-2][col-1].getChessColor()==ChessColor.NONE||a[row-2][col-1].getChessColor()==ChessColor.BLACK)){
                        chessboardPoints.add(new ChessboardPoint(row-2,col-1));
                    }
                    if (row<=5&&col>=1&& (a[row+2][col-1].getChessColor()==ChessColor.NONE||a[row+2][col-1].getChessColor()==ChessColor.BLACK)){
                        chessboardPoints.add(new ChessboardPoint(row+2,col-1));
                    }
                }
            
        
        return chessboardPoints;
    }
//    @Override
//    public String toString() {
//        if (getChessColor()==ChessColor.BLACK)  return "N";
//        else return "n";
//    }
}

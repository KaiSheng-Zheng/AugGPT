import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    int x=this.getSource().getX();
    int y=this.getSource().getY();
    public PawnChessComponent(int indexOf, int i, ChessColor black, char b) {
        super(indexOf, i, black, b);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> point=new ArrayList<>();
        if (this.getChessColor()==ChessColor.BLACK){
         if (x==1){
             for (int j = 1; j <3 ; j++) {
                 if (chessboard[x+j][y].getChessColor()==ChessColor.NONE){
                     point.add(new ChessboardPoint(x+j,y));
                 }
             }
             if (chessboard[x-1][y+1].getChessColor()==ChessColor.WHITE){
                 point.add(new ChessboardPoint(x-1,y+1));
             }
             if (chessboard[x+1][y+1].getChessColor()==ChessColor.WHITE){
                 point.add(new ChessboardPoint(x+1,y+1));
             }
         }else {
             if (chessboard[x+1][y].getChessColor()==ChessColor.NONE){
                 point.add(new ChessboardPoint(x+1,y));
             }
             if (chessboard[x-1][y+1].getChessColor()==ChessColor.WHITE){
                 point.add(new ChessboardPoint(x-1,y+1));
             }
             if (chessboard[x+1][y+1].getChessColor()==ChessColor.WHITE){
                 point.add(new ChessboardPoint(x+1,y+1));
             }
         }
        }
        if (this.getChessColor()==ChessColor.WHITE){
            if (x==6){
                for (int j = 1; j <3 ; j++) {
                    if (chessboard[x-j][y].getChessColor()==ChessColor.NONE){
                        point.add(new ChessboardPoint(x-j,y));
                    }
                }
                if (chessboard[x-1][y-1].getChessColor()==ChessColor.BLACK){
                    point.add(new ChessboardPoint(x-1,y-1));
                }
                if (chessboard[x+1][y-1].getChessColor()==ChessColor.BLACK){
                    point.add(new ChessboardPoint(x+1,y-1));
                }
            }else {
                if (chessboard[x-1][y].getChessColor()==ChessColor.NONE){
                    point.add(new ChessboardPoint(x-1,y));
                }
                if (chessboard[x-1][y-1].getChessColor()==ChessColor.BLACK){
                    point.add(new ChessboardPoint(x-1,y-1));
                }
                if (chessboard[x+1][y-1].getChessColor()==ChessColor.BLACK){
                    point.add(new ChessboardPoint(x+1,y-1));
                }
            }

        }

        return point;
    }
}

import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
       if (getChessColor()==ChessColor.BLACK){
           List<ChessboardPoint>go=new ArrayList<>();
           int x=this.getSource().getX();
           int y=this.getSource().getY();
           if (x==1){
               if (getChessComponents()[2][y].getChessColor()==ChessColor.NONE){
                   go.add(new ChessboardPoint(2,y));
               }
               if (getChessComponents()[3][y].getChessColor()==ChessColor.NONE){
                   go.add(new ChessboardPoint(3,y));
               }
               if (y-1>=0){
                   if (getChessComponents()[2][y-1].getChessColor()==ChessColor.WHITE){
                       go.add(new ChessboardPoint(2,y-1));
                   }
               }
               if (y+1<8) {
                   if (getChessComponents()[2][y + 1].getChessColor() == ChessColor.WHITE) {
                       go.add(new ChessboardPoint(2, y + 1));
                   }
               }
           }
           else {
               if (x+1<8){
                   if (getChessComponents()[x+1][y].getChessColor()==ChessColor.NONE){
                   go.add(new ChessboardPoint(x+1,y));
                   }
                   if (y-1>=0){
                       if (getChessComponents()[x+1][y-1].getChessColor()==ChessColor.WHITE){
                           go.add(new ChessboardPoint(x+1,y-1));
                       }
                   }
                   if (y+1<8){
                       if (getChessComponents()[x+1][y+1].getChessColor()==ChessColor.WHITE){
                           go.add(new ChessboardPoint(x+1,y+1));
                       }
                   }
               }
           }
           return go;
       }
      else if (getChessColor()==ChessColor.WHITE){
           List<ChessboardPoint>go=new ArrayList<>();
           int x=this.getSource().getX();
           int y=this.getSource().getY();
           if (x==6){
               if (getChessComponents()[5][y].getChessColor()==ChessColor.NONE){
                   go.add(new ChessboardPoint(5,y));
               }
               if (getChessComponents()[4][y].getChessColor()==ChessColor.NONE){
                   go.add(new ChessboardPoint(4,y));
               }
               if (y-1>=0){
                   if (getChessComponents()[5][y-1].getChessColor()==ChessColor.BLACK){
                       go.add(new ChessboardPoint(5,y-1));
                   }
               }
               if (y+1<8) {
                   if (getChessComponents()[5][y + 1].getChessColor() == ChessColor.BLACK) {
                       go.add(new ChessboardPoint(5, y + 1));
                   }
               }
           }
           else {
               if (x-1>=0){
                   if (getChessComponents()[x-1][y].getChessColor()==ChessColor.NONE){
                       go.add(new ChessboardPoint(x-1,y));
                   }
                   if (y-1>=0){
                       if (getChessComponents()[x-1][y-1].getChessColor()==ChessColor.BLACK){
                           go.add(new ChessboardPoint(x-1,y-1));
                       }
                   }
                   if (y+1<8){
                       if (getChessComponents()[x-1][y+1].getChessColor()==ChessColor.BLACK){
                           go.add(new ChessboardPoint(x-1,y+1));
                       }
                   }
               }
           }
           return go;
       }
      return null;
    }
}

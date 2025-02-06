

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
       List<ChessboardPoint>move= new ArrayList<>();
       int a = getSource().getX();
       int b = getSource().getY();
       if(a==6&&getChessColor()==ChessColor.WHITE) {
           if(b-1>=0){
           ChessComponent EAT= chessboard[a-1][b-1];
           if(EAT.getChessColor()==ChessColor.BLACK){
               move.add(new ChessboardPoint(a-1,b-1));
           }
           }
           if(b+1<=7){
               ChessComponent EAT= chessboard[a-1][b+1];
               if(EAT.getChessColor()==ChessColor.BLACK){
                   move.add(new ChessboardPoint(a-1,b+1));
               }
           }
           ChessComponent chess = chessboard[a-1][b];
           boolean check = chess instanceof EmptySlotComponent;
           if (check) {
               move.add(new ChessboardPoint(a-1, b));
               if (b + 1 <= 7) {
                   ChessComponent eat1 = chessboard[a -2][b +1];
                   if (eat1.getChessColor() == ChessColor.BLACK) {
                       move.add(new ChessboardPoint(a -2, b +1));
                   }
               }
               if (b - 1 >= 0) {
                   ChessComponent eat2 = chessboard[a-2][b - 1];
                   if (eat2.getChessColor() == ChessColor.BLACK) {
                       move.add(new ChessboardPoint(a -2, b -1));
                   }
               }
           }
           ChessComponent chess2 = chessboard[a-2][b];
           boolean check2 = chess2 instanceof EmptySlotComponent;
           if (check && check2) {
               move.add(new ChessboardPoint(a-2, b));
               if (b + 1 <= 7) {
                   ChessComponent eat3 = chessboard[a -3][b+1];
                   if (eat3.getChessColor() == ChessColor.BLACK) {
                       move.add(new ChessboardPoint(a -3, b+1));
                   }
               }
               if (b- 1 >= 0) {
                   ChessComponent eat4 = chessboard[a - 3][b - 1];
                   if (eat4.getChessColor() == ChessColor.BLACK) {
                       move.add(new ChessboardPoint(a - 3, b - 1));
                   }
               }
           }
       }
        else if(a==1&&getChessColor()==ChessColor.BLACK) {
            if(b+1<=7){
                ChessComponent EAT= chessboard[a+1][b+1];
                if(EAT.getChessColor()==ChessColor.WHITE){
                    move.add(new ChessboardPoint(a+1,b+1));
                }
            }
            if(b-1>=0){
                ChessComponent EAT = chessboard[a+1][b-1];
                if(EAT.getChessColor()==ChessColor.WHITE){
                    move.add(new ChessboardPoint(a+1,b-1));
                }
            }
            ChessComponent chess = chessboard[a+1][b];
            boolean check = chess instanceof EmptySlotComponent;
            if (check) {
                move.add(new ChessboardPoint(a+1,b));
                if(b+1<=7){
                    ChessComponent eat1 = chessboard[a+2][b+1];
                    if(eat1.getChessColor()==ChessColor.WHITE){
                        move.add(new ChessboardPoint(a+2,b+1));
                    }
                }
                if(b-1>=0) {
                    ChessComponent eat3 = chessboard[a+2][b-1];
                    if (eat3.getChessColor() == ChessColor.WHITE) {
                        move.add(new ChessboardPoint(a+2, b -1));
                    }
                }
            }
            ChessComponent chess2= chessboard[a+2][b];
            boolean check2 = chess2 instanceof EmptySlotComponent;
            if(check&&check2){
                move.add(new ChessboardPoint(a+2,b));
                if(b+1<=7){
                    ChessComponent eat2 = chessboard[a+3][b+1];
                    if(eat2.getChessColor()==ChessColor.WHITE){
                        move.add(new ChessboardPoint(a+3,b+1));
                    }
                }
                if(b-1>=0){
                    ChessComponent eat4 = chessboard[a+3][b-1];
                    if(eat4.getChessColor()==ChessColor.WHITE){
                        move.add(new ChessboardPoint(a+3,b-1));
                    }
                }
            }
        }
        else {
           if (getChessColor() == ChessColor.BLACK) {
               if (a + 1 <=7 ) {
                   ChessComponent chess = chessboard[a+1][b];
                   boolean check = chess instanceof EmptySlotComponent;
                   if (check) {
                       move.add(new ChessboardPoint(a+1, b));
                       if (a+2<=7) {
                           if (b - 1 >= 0) {
                               ChessComponent eat1 = chessboard[a +2][b -1];
                               if (eat1.getChessColor() == ChessColor.WHITE) {
                                   move.add(new ChessboardPoint(a +2, b -1));
                               }
                           }
                           if (b + 1 <= 7) {
                               ChessComponent eat2 = chessboard[a+2][b + 1];
                               if (eat2.getChessColor() == ChessColor.WHITE) {
                                   move.add(new ChessboardPoint(a + 2, b + 1));
                               }
                           }
                       }
                   }
               }
           }
           else if (getChessColor() == ChessColor.WHITE) {
               if (a - 1 >= 0) {
                   ChessComponent chess = chessboard[a-1][b];
                   boolean check = chess instanceof EmptySlotComponent;
                   if (check) {
                       move.add(new ChessboardPoint(a-1, b));
                       if (a -2>=0) {
                           if (b- 1 >= 0) {
                               ChessComponent eat1 = chessboard[a-2][b -1];
                               if (eat1.getChessColor() == ChessColor.BLACK) {
                                   move.add(new ChessboardPoint(a - 2, b - 1));
                               }
                           }
                           if (b + 1 <= 7) {
                               ChessComponent eat2 = chessboard[a -2][b+1];
                               if (eat2.getChessColor() == ChessColor.BLACK) {
                                   move.add(new ChessboardPoint(a -2, b +1));
                               }
                           }
                       }
                   }
               }
           }
       }
        move.sort(Comparator.comparing(ChessboardPoint::getY));
        move.sort(Comparator.comparing(ChessboardPoint::getX));
       return move;
    }
}

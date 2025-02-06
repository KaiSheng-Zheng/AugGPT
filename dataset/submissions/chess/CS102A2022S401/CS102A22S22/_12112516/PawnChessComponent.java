import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
       List<ChessboardPoint> destinations = new ArrayList<>();
       ChessboardPoint source = this.getSource();


       if(this.getChessColor() == ChessColor.BLACK){

           if(source.getX() == 1){
               for(int i = source.getX() + 1; i <= source.getX() + 2; i++){
                   if(chessComponents[i][source.getY()].getChessColor() == ChessColor.NONE){
                       destinations.add(new ChessboardPoint(i, source.getY()));
                       if(chessComponents[i][source.getY()].getChessColor() == ChessColor.WHITE){
                           break;
                       }
                   }else break;
               }

               if(source.getY() - 1 >= 0){
                   if(chessComponents[source.getX() + 1][source.getY() - 1].getChessColor() == ChessColor.WHITE){
                       destinations.add(new ChessboardPoint(source.getX() + 1, source.getY() - 1));
                   }
               }
               if(source.getY() + 1 <= 7){
                   if(chessComponents[source.getX() + 1][source.getY() + 1].getChessColor() == ChessColor.WHITE){
                       destinations.add(new ChessboardPoint(source.getX() + 1, source.getY() + 1));
                   }
               }

           }

           if(source.getX() >= 2 && source.getX() <= 6){
               if(chessComponents[source.getX() + 1][source.getY()].getChessColor() == ChessColor.NONE){
                   destinations.add(new ChessboardPoint(source.getX() + 1, source.getY()));
               }
               if(source.getY() - 1 >= 0){
                   if(chessComponents[source.getX() + 1][source.getY() - 1].getChessColor() == ChessColor.WHITE){
                       destinations.add(new ChessboardPoint(source.getX() + 1, source.getY() - 1));
                   }
               }
               if(source.getY() + 1 <= 7){
                   if(chessComponents[source.getX() + 1][source.getY() + 1].getChessColor() == ChessColor.WHITE){
                       destinations.add(new ChessboardPoint(source.getX() + 1, source.getY() + 1));
                   }
               }
           }

       }



       if(this.getChessColor() == ChessColor.WHITE){

           if(source.getX() == 6){
               for(int i = source.getX() - 1; i >= source.getX() - 2; i--){
                   if(chessComponents[i][source.getY()].getChessColor() == ChessColor.NONE){
                       destinations.add(new ChessboardPoint(i, source.getY()));
                       if(chessComponents[i][source.getY()].getChessColor() == ChessColor.BLACK){
                           break;
                       }
                   }else break;
               }

               if(source.getY() - 1 >= 0){
                   if(chessComponents[source.getX() - 1][source.getY() - 1].getChessColor() == ChessColor.BLACK){
                       destinations.add(new ChessboardPoint(source.getX() - 1, source.getY() - 1));
                   }
               }
               if(source.getY() + 1 <= 7){
                   if(chessComponents[source.getX() - 1][source.getY() + 1].getChessColor() == ChessColor.BLACK){
                       destinations.add(new ChessboardPoint(source.getX() - 1, source.getY() + 1));
                   }
               }
           }


           if(source.getX() >= 1 && source.getX() <= 5){
               if(chessComponents[source.getX() - 1][source.getY()].getChessColor() == ChessColor.NONE){
                   destinations.add(new ChessboardPoint(source.getX() - 1, source.getY()));
               }
               if(source.getY() - 1 >= 0){
                   if(chessComponents[source.getX() - 1][source.getY() - 1].getChessColor() == ChessColor.BLACK){
                       destinations.add(new ChessboardPoint(source.getX() - 1, source.getY() - 1));
                   }
               }
               if(source.getY() + 1 <= 7){
                   if(chessComponents[source.getX() - 1][source.getY() + 1].getChessColor() == ChessColor.BLACK){
                       destinations.add(new ChessboardPoint(source.getX() - 1, source.getY() + 1));
                   }
               }
           }
       }


       return destinations;
    }
}

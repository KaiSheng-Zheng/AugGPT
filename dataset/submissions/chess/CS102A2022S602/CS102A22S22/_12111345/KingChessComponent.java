import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent (ChessboardPoint source,ChessColor chessColor, char name){
      super(source,chessColor,name);
    }
    public KingChessComponent(ChessColor chessColor){
        super.setChessColor(chessColor);
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> points = new ArrayList<>();
        int currentCoordinateX = super.getSource().getX();
        int currentCoordinateY = super.getSource().getY();

        if (currentCoordinateY<7){
            if (chessboard[currentCoordinateX][currentCoordinateY+1] instanceof EmptySlotComponent){
                points.add(new ChessboardPoint(currentCoordinateX,currentCoordinateY+1));
            }
            else if (chessboard[currentCoordinateX][currentCoordinateY+1].getChessColor()!=this.getChessColor()){
                points.add(new ChessboardPoint(currentCoordinateX,currentCoordinateY+1));
            }
        }

        if (currentCoordinateX<7){
            if (chessboard[currentCoordinateX+1][currentCoordinateY] instanceof EmptySlotComponent){
                points.add(new ChessboardPoint(currentCoordinateX+1,currentCoordinateY));
            }
            else if (chessboard[currentCoordinateX+1][currentCoordinateY].getChessColor()!=this.getChessColor()){
                points.add(new ChessboardPoint(currentCoordinateX+1,currentCoordinateY));
            }
        }


        if(currentCoordinateX>0){
            if (chessboard[currentCoordinateX-1][currentCoordinateY] instanceof EmptySlotComponent){
                points.add(new ChessboardPoint(currentCoordinateX-1,currentCoordinateY));
            }
            else if (chessboard[currentCoordinateX-1][currentCoordinateY].getChessColor()!=this.getChessColor()){
                points.add(new ChessboardPoint(currentCoordinateX-1,currentCoordinateY));

            }
                  }


        if(currentCoordinateY>0){
            if (chessboard[currentCoordinateX][currentCoordinateY-1] instanceof EmptySlotComponent){
                points.add(new ChessboardPoint(currentCoordinateX,currentCoordinateY-1));
            }
            else if (chessboard[currentCoordinateX][currentCoordinateY-1].getChessColor()!=this.getChessColor()){
                points.add(new ChessboardPoint(currentCoordinateX,currentCoordinateY-1));
            }
        }

        if (currentCoordinateX<7&&currentCoordinateY<7){
            if (chessboard[currentCoordinateX+1][currentCoordinateY+1] instanceof EmptySlotComponent){
                points.add(new ChessboardPoint(currentCoordinateX+1,currentCoordinateY+1));
            }
            else if (chessboard[currentCoordinateX+1][currentCoordinateY+1].getChessColor()!=this.getChessColor()){
                points.add(new ChessboardPoint(currentCoordinateX+1,currentCoordinateY+1));
            }
        }

        if(currentCoordinateX>0&&currentCoordinateY>0){
            if (chessboard[currentCoordinateX-1][currentCoordinateY-1] instanceof EmptySlotComponent){
                points.add(new ChessboardPoint(currentCoordinateX-1,currentCoordinateY-1));
            }
            else if (chessboard[currentCoordinateX-1][currentCoordinateY-1].getChessColor()!=this.getChessColor()){
                points.add(new ChessboardPoint(currentCoordinateX-1,currentCoordinateY-1));
            }
                 }


        if(currentCoordinateX<7&&currentCoordinateY>0){
            if (chessboard[currentCoordinateX+1][currentCoordinateY-1] instanceof EmptySlotComponent){
                points.add(new ChessboardPoint(currentCoordinateX+1,currentCoordinateY-1));
            }
            else if (chessboard[currentCoordinateX+1][currentCoordinateY-1].getChessColor()!=this.getChessColor()){
                points.add(new ChessboardPoint(currentCoordinateX+1,currentCoordinateY-1));

            }
               }

        if(currentCoordinateX>0&&currentCoordinateY<7){
            if (chessboard[currentCoordinateX-1][currentCoordinateY+1] instanceof EmptySlotComponent){
                points.add(new ChessboardPoint(currentCoordinateX-1,currentCoordinateY+1));
            }
            else if (chessboard[currentCoordinateX-1][currentCoordinateY+1].getChessColor()!=this.getChessColor()){
                points.add(new ChessboardPoint(currentCoordinateX-1,currentCoordinateY+1));
            }

          }
      return points;
    }

}

import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{


    public RookChessComponent (ChessboardPoint source,ChessColor chessColor, char name){
        super(source,chessColor,name);
    }
    public RookChessComponent(ChessColor chessColor){
        super.setChessColor(chessColor);
    }
    public List<ChessboardPoint> canMoveTo(){
     List<ChessboardPoint> points = new ArrayList<>();
     int currentCoordinateX = super.getSource().getX();
     int currentCoordinateY = super.getSource().getY();
        for (int i = currentCoordinateX + 1; i < 8; i++) {
            if (chessboard[i][currentCoordinateY] instanceof EmptySlotComponent){
            points.add(new ChessboardPoint(i,currentCoordinateY));}
            else {
                if (chessboard[i][currentCoordinateY].getChessColor() != this.getChessColor()){
                    points.add(new ChessboardPoint(i,currentCoordinateY));
                }
                else {
                break;}
            }
        }
        for (int i = currentCoordinateX - 1; i >= 0 ; i--) {
            if (chessboard[i][currentCoordinateY] instanceof EmptySlotComponent){
            points.add(new ChessboardPoint(i,currentCoordinateY));}
            else {
                if (chessboard[i][currentCoordinateY].getChessColor() != this.getChessColor()){
                    points.add(new ChessboardPoint(i,currentCoordinateY));
                }
                else {
                break;}
            }
        }

        for (int i = currentCoordinateY + 1; i < 8; i++) {
            if (chessboard[currentCoordinateX][i] instanceof EmptySlotComponent){
            points.add(new ChessboardPoint(currentCoordinateX,i));}
            else {
                if (chessboard[currentCoordinateX][i].getChessColor()!= this.getChessColor()){
                    points.add(new ChessboardPoint(currentCoordinateX,i));
                }
                else {
                break;}
            }
        }

        for (int i = currentCoordinateY - 1; i >= 0 ; i--) {
            if (chessboard[currentCoordinateX][i] instanceof EmptySlotComponent){
            points.add(new ChessboardPoint(currentCoordinateX,i));}
            else {
                if (chessboard[currentCoordinateX][i].getChessColor() != this.getChessColor()){
                    points.add(new ChessboardPoint(currentCoordinateX,i));
                }
                break;
            }
        }


        return points;
    }
}

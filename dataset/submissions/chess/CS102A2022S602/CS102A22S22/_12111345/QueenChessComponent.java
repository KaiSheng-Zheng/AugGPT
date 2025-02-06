import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent (ChessboardPoint source,ChessColor chessColor, char name){
        super(source,chessColor,name);
    }
    public QueenChessComponent(ChessColor chessColor){
        super.setChessColor(chessColor);
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> points = new ArrayList<>();
        int currentCoordinateX = super.getSource().getX();
        int currentCoordinateY = super.getSource().getY();
        for (int i = currentCoordinateX + 1; i < 8; i++) {
            if (chessboard[i][currentCoordinateY] instanceof EmptySlotComponent){
            points.add(new ChessboardPoint(i,currentCoordinateY));}
            else{
                if (chessboard[i][currentCoordinateY].getChessColor() != this.getChessColor()){
                    points.add(new ChessboardPoint(i,currentCoordinateY));
                    break;
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
                    break;
                }
                else {
                break;}
            }
        }
        for (int i = currentCoordinateY + 1; i < 8; i++) {
            if (chessboard[currentCoordinateX][i] instanceof EmptySlotComponent){
            points.add(new ChessboardPoint(currentCoordinateX,i));}
            else {
                if (chessboard[currentCoordinateX][i].getChessColor()!=this.getChessColor()){
                    points.add(new ChessboardPoint(currentCoordinateX,i));
                    break;
                }else{
                break;
            }}
        }
        for (int i = currentCoordinateY - 1; i >= 0 ; i--) {
            if (chessboard[currentCoordinateX][i] instanceof EmptySlotComponent){
            points.add(new ChessboardPoint(currentCoordinateX,i));}
            else {
                if (chessboard[currentCoordinateX][i].getChessColor()!=this.getChessColor()){
                    points.add(new ChessboardPoint(currentCoordinateX,i));
                    break;
                }
                else {
                break;
            }}
        }
        for (int i = 1; i+currentCoordinateX<8 && i+currentCoordinateY < 8; i++) {
            if (chessboard[i+currentCoordinateX][i+currentCoordinateY] instanceof EmptySlotComponent){
            points.add(new ChessboardPoint(i+currentCoordinateX,i+currentCoordinateY));}
            else {
                if (chessboard[i+currentCoordinateX][i+currentCoordinateY].getChessColor()!=this.getChessColor())
                {
                    points.add(new ChessboardPoint(i+currentCoordinateX,i+currentCoordinateY));
                    break;
            }
                else {
                break;
            }}
        }

        for (int i = 1; currentCoordinateX-i>=0&&currentCoordinateY-i>=0; i++) {
            if (chessboard[currentCoordinateX-i][currentCoordinateY-i] instanceof EmptySlotComponent){
            points.add(new ChessboardPoint(currentCoordinateX-i,currentCoordinateY-i));}
            else {
                if (chessboard[currentCoordinateX-i][currentCoordinateY-i].getChessColor()!=this.getChessColor()){
                    points.add(new ChessboardPoint(currentCoordinateX-i,currentCoordinateY-i));
                    break;
            }else{
                break;}
            }
        }
        for (int i = 1; currentCoordinateX+i<8&&currentCoordinateY-i>=0 ; i++) {
            if (chessboard[currentCoordinateX+i][currentCoordinateY-i] instanceof EmptySlotComponent){
            points.add(new ChessboardPoint(currentCoordinateX+i,currentCoordinateY-i));}
            else {
                if (chessboard[currentCoordinateX+i][currentCoordinateY-i].getChessColor()!=this.getChessColor()){
                    points.add(new ChessboardPoint(currentCoordinateX+i,currentCoordinateY-i));
                    break;}
                else {
                break;
            }}
        }
        for (int i = 1; currentCoordinateX-i>=0&&currentCoordinateY+i<8 ; i++) {
            if (chessboard[currentCoordinateX-i][currentCoordinateY+i] instanceof EmptySlotComponent){
            points.add(new ChessboardPoint(currentCoordinateX-i,currentCoordinateY+i));}
            else {
                if (chessboard[currentCoordinateX-i][currentCoordinateY+i].getChessColor()!=this.getChessColor()){
                    points.add(new ChessboardPoint(currentCoordinateX-i,currentCoordinateY+i));
                    break;
            }else{
                break;
            }}
        }
        return points;
    }
}

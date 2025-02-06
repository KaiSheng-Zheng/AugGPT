import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public  List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        if (x-1>=0){
            if (whetherhava(x-1,y)){
                chessboardPoints.add(new ChessboardPoint(x-1,y));
            }else if (getChessColor() != getChessComponents()[x-1][y].getChessColor()){
                chessboardPoints.add(new ChessboardPoint(x-1,y));
            }
        }
        if (x+1<8){
            if (whetherhava(x+1,y)){
                chessboardPoints.add(new ChessboardPoint(x+1,y));
            }else if (getChessColor() != getChessComponents()[x+1][y].getChessColor()){
                chessboardPoints.add(new ChessboardPoint(x+1,y));
            }
        }
        if (y-1>=0){
            if (whetherhava(x,y-1)){
                chessboardPoints.add(new ChessboardPoint(x,y-1));
            }else if (getChessColor() != getChessComponents()[x][y-1].getChessColor()){
                chessboardPoints.add(new ChessboardPoint(x,y-1));
            }
        }
        if (x-1>=0 && y-1>=0){
            if (whetherhava(x-1,y-1)){
                chessboardPoints.add(new ChessboardPoint(x-1,y-1));
            }else if (getChessColor() != getChessComponents()[x-1][y-1].getChessColor()){
                chessboardPoints.add(new ChessboardPoint(x-1,y-1));
            }
        }
        if (x-1>=0 && y+1<8){
            if (whetherhava(x-1,y+1)){
                chessboardPoints.add(new ChessboardPoint(x-1,y+1));
            }else if (getChessColor() != getChessComponents()[x-1][y+1].getChessColor()){
                chessboardPoints.add(new ChessboardPoint(x-1,y+1));
            }
        }
        if (x+1<8 && y-1>=0){
            if (whetherhava(x+1,y-1)){
                chessboardPoints.add(new ChessboardPoint(x+1,y-1));
            }else if (getChessColor() != getChessComponents()[x+1][y-1].getChessColor()){
                chessboardPoints.add(new ChessboardPoint(x+1,y-1));
            }
        }
        if (x+1<8 && y+1<8){
            if (whetherhava(x+1,y+1)){
                chessboardPoints.add(new ChessboardPoint(x+1,y+1));
            }else if (getChessColor() != getChessComponents()[x+1][y+1].getChessColor()){
                chessboardPoints.add(new ChessboardPoint(x+1,y+1));
            }
        }
        if (y+1<8){
            if (whetherhava(x,y+1)){
                chessboardPoints.add(new ChessboardPoint(x,y+1));
            }else if (getChessColor() != getChessComponents()[x][y+1].getChessColor()){
                chessboardPoints.add(new ChessboardPoint(x,y+1));
            }
        }
        return chessboardPoints;
    }
}
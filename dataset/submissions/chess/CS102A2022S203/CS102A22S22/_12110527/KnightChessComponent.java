import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        if(x+2<8 &&y-1>=0){
            if (whetherhava(x+2,y-1)){
                chessboardPoints.add(new ChessboardPoint(x+2,y-1));
            }else if (getChessColor() != getChessComponents()[x+2][y-1].getChessColor()){
                chessboardPoints.add(new ChessboardPoint(x+2,y-1));
            }
        }
        if(x+2<8 &&y+1<8){
            if (whetherhava(x+2,y+1)){
                chessboardPoints.add(new ChessboardPoint(x+2,y+1));
            }else if (getChessColor() != getChessComponents()[x+2][y+1].getChessColor()){
                chessboardPoints.add(new ChessboardPoint(x+2,y+1));
            }
        }
        if(x-2>=0 &&y-1>=0){
            if (whetherhava(x-2,y-1)){
                chessboardPoints.add(new ChessboardPoint(x-2,y-1));
            }else if (getChessColor() != getChessComponents()[x-2][y-1].getChessColor()){
                chessboardPoints.add(new ChessboardPoint(x-2,y-1));
            }
        }
        if(x-2>=0 &&y+1<8){
            if (whetherhava(x-2,y+1)){
                chessboardPoints.add(new ChessboardPoint(x-2,y+1));
            }else if (getChessColor() != getChessComponents()[x-2][y+1].getChessColor()){
                chessboardPoints.add(new ChessboardPoint(x-2,y+1));
            }
        }
        if(x+1<8 &&y+2<8){
            if (whetherhava(x+1,y+2)){
                chessboardPoints.add(new ChessboardPoint(x+1,y+2));
            }else if (getChessColor() != getChessComponents()[x+1][y+2].getChessColor()){
                chessboardPoints.add(new ChessboardPoint(x+1,y+2));
            }
        }
        if(x-1>=0 &&y+2<8){
            if (whetherhava(x-1,y+2)){
                chessboardPoints.add(new ChessboardPoint(x-1,y+2));
            }else if (getChessColor() != getChessComponents()[x-1][y+2].getChessColor()){
                chessboardPoints.add(new ChessboardPoint(x-1,y+2));
            }
        }
        if(x+1<8 &&y-2>=0){
            if (whetherhava(x+1,y-2)){
                chessboardPoints.add(new ChessboardPoint(x+1,y-2));
            }else if (getChessColor() != getChessComponents()[x+1][y-2].getChessColor()){
                chessboardPoints.add(new ChessboardPoint(x+1,y-2));
            }
        }
        if(x-1>=0 &&y-2>=0){
            if (whetherhava(x-1,y-2)){
                chessboardPoints.add(new ChessboardPoint(x-1,y-2));
            }else if (getChessColor() != getChessComponents()[x-1][y-2].getChessColor()){
                chessboardPoints.add(new ChessboardPoint(x-1,y-2));
            }
        }
        return chessboardPoints;
    }
}

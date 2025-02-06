import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public  List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
              int y1=y;
        int y2=y;
        int y3=y;
        int y4=y;
        int y5=y;
        int y6=y;
        int y7=y;
        int y8=y;
        		
        int x1 =x;
        int x2 =x;
        int x3 =x;
        int x4 =x;
        int x5 =x;
        int x6 =x;
        int x7 =x;
        int x8 =x;
        x1=x1-1;
       if (x1>=0){
            if (whetherhava(x1,y1)){
                chessboardPoints.add(new ChessboardPoint(x1,y1));
            }else if (getChessColor() != getChessComponents()[x1][y1].getChessColor()){
                chessboardPoints.add(new ChessboardPoint(x1,y1));
            }
        }
         x2=x2+1;
        if (x2<8){
            if (whetherhava(x2,y2)){
                chessboardPoints.add(new ChessboardPoint(x2,y2));
            }else if (getChessColor() != getChessComponents()[x2][y2].getChessColor()){
                chessboardPoints.add(new ChessboardPoint(x2,y2));
            }
        }
        
        y3=y3-1;
        if (y3>=0){
            if (whetherhava(x3,y3)){
                chessboardPoints.add(new ChessboardPoint(x3,y3));
            }else if (getChessColor() != getChessComponents()[x3][y3].getChessColor()){
                chessboardPoints.add(new ChessboardPoint(x3,y3));
            }
        }
        x4=x4-1;y4=y4-1;
        if (x4>=0 && y4>=0){
            if (whetherhava(x4,y4)){
                chessboardPoints.add(new ChessboardPoint(x4,y4));
            }else if (getChessColor() != getChessComponents()[x4][y4].getChessColor()){
                chessboardPoints.add(new ChessboardPoint(x4,y4));
            }
        }
        x5=x5-1;y5=y5+1;
        if (x5>=0 && y5<8){
            if (whetherhava(x5,y5)){
                chessboardPoints.add(new ChessboardPoint(x5,y5));
            }else if (getChessColor() != getChessComponents()[x5][y5].getChessColor()){
                chessboardPoints.add(new ChessboardPoint(x5,y5));
            }
        }
        x6=x6+1;y6=y6-1;
        if (x6<8 && y6>=0){
            if (whetherhava(x6,y6)){
                chessboardPoints.add(new ChessboardPoint(x6,y6));
            }else if (getChessColor() != getChessComponents()[x6][y6].getChessColor()){
                chessboardPoints.add(new ChessboardPoint(x6,y6));
            }
        }
        x7=x7+1;y7=y7+1;
        if (x7<8 && y7<8){
            if (whetherhava(x7,y7)){
                chessboardPoints.add(new ChessboardPoint(x7,y7));
            }else if (getChessColor() != getChessComponents()[x7][y7].getChessColor()){
                chessboardPoints.add(new ChessboardPoint(x7,y7));
            }
        }
        y8=y8+1;
        if (y8<8){
            if (whetherhava(x8,y8)){
                chessboardPoints.add(new ChessboardPoint(x8,y8));
            }else if (getChessColor() != getChessComponents()[x8][y8].getChessColor()){
                chessboardPoints.add(new ChessboardPoint(x8,y8));
            }
        }
        return chessboardPoints;
    }
}

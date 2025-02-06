import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public List<ChessboardPoint> canMoveTo(){
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
        for (int i = x+1;i < 8 && i >= 0;i++){
        	x1++;
            if (whetherhava(x1,y1)){
                chessboardPoints.add(new ChessboardPoint(i,y1));
            }else if (getChessColor() == getChessComponents()[x1][y1].getChessColor()){
                break;
            }else {
                chessboardPoints.add(new ChessboardPoint(i,y1));
                break;
            }
        }
        for (int i = x-1;i < 8 && i >= 0;i--){
        	x2++;
            if (whetherhava(x2,y2)){
                chessboardPoints.add(new ChessboardPoint(x2,y2));
           
            }else {
                chessboardPoints.add(new ChessboardPoint(x2,y2));
                break;
            }
        }
        for (int i = y+1;i < 8 && i >= 0;i++){
        	y3++;
            if (whetherhava(x3,y3)){
                chessboardPoints.add(new ChessboardPoint(x3,y3));
           
            }else {
                chessboardPoints.add(new ChessboardPoint(x3,y3));
                break;
            }
        }int d = 8;
       
            d--;
            
        
        return chessboardPoints;
    }
}

import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
	
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
        for (int i = 1;i<8;i++) {
        	x1++;y1++;
        	boolean sameone = getChessColor() != getChessComponents()[x1][y1].getChessColor();
            if (x1 < 8 && y1 < 8) {
                if (whetherhava(x1, y1)) {
                    chessboardPoints.add(new ChessboardPoint(x1, y1));
                } else if (sameone) {
                    chessboardPoints.add(new ChessboardPoint(x1, y1));
                    break;
                }else {
                    break;
                }
            }
        }
       for (int i = x;i < 8;i++){
       x2--;  y2++;
       boolean sameone = (getChessColor() == ((ChessComponent) getChessComponents()[x2][y2]).getChessColor());
        	if (whetherhava(x2,y2)){
                chessboardPoints.add(new ChessboardPoint(x2,y2));
            }else if (sameone){
                break;
            }else {
                chessboardPoints.add(new ChessboardPoint(x2,y2));
                break;
            }
    
        }
       
       for (int i = x;i>=0;i--){
    	   x3++;  y3--;
           boolean sameone = (getChessColor() == ((ChessComponent) getChessComponents()[x3][y3]).getChessColor());
            	if (whetherhava(x3,y3)){
                    chessboardPoints.add(new ChessboardPoint(x3,y3));
                }else if (sameone){
                    break;
                }else {
                    chessboardPoints.add(new ChessboardPoint(x3,y3));
                    break;
                }
            	
            }
      
       for (int i = x;i<8;i++){
    	   x4--;  y4--;
           boolean sameone = (getChessColor() == ((ChessComponent) getChessComponents()[x4][y4]).getChessColor());
            	if (whetherhava(x4,y4)){
                    chessboardPoints.add(new ChessboardPoint(x4,y4));
                }else if (sameone){
                    break;
                }else {
                    chessboardPoints.add(new ChessboardPoint(x4,y4));
                    break;
                }
            	
            }

      
         return chessboardPoints;
     }

    }
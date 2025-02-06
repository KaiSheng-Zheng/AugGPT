import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
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
            if (x1 < 8 && y1 < 8) {
                if (whetherhava(x1, y + i)) {
                    chessboardPoints.add(new ChessboardPoint(x1, y1));
                } else if (getChessColor() != getChessComponents()[x1][y1].getChessColor()) {
                    chessboardPoints.add(new ChessboardPoint(x1, y1));
                    break;
                }else {
                    break;
                }
            }
        }

        for (int i = 1;i<8;i++) {
        	x2++;y2--;
            if (x2< 8 && y2>= 0) {
                if (whetherhava(x2, y2)) {
                    chessboardPoints.add(new ChessboardPoint(x2, y2));
                } else if (getChessColor() != getChessComponents()[x2][y2].getChessColor()) {
                    chessboardPoints.add(new ChessboardPoint(x2, y2));
                    break;
                }else {
                    break;
                }
            }
        }
        for (int i = 1;i<8;i++) {
        	x3--;y3++;
            if (x3>= 0 && y3< 8) {
                if (whetherhava(x3, y3)) {
                    chessboardPoints.add(new ChessboardPoint(x3, y3));
                } else if (getChessColor() != getChessComponents()[x3][y3].getChessColor()) {
                    chessboardPoints.add(new ChessboardPoint(x3, y3));
                    break;
                }else {
                    break;
                }
            }
        }
        for (int i = 1;i<8;i++) {
        	x4--;y4--;
            if(x4>=0 && y4>=0){
                if (whetherhava(x4,y4)){
                    chessboardPoints.add(new ChessboardPoint(x4,y4));
                }else if (getChessColor() != getChessComponents()[x4][y4].getChessColor()){
                    chessboardPoints.add(new ChessboardPoint(x4,y4));
                    break;
                }else {
                    break;
                }
            }
        }
        x5=x5+1;
        for (int i = x5;i < 8 && i >= 0;i++){
            if (whetherhava(i,y)){
                chessboardPoints.add(new ChessboardPoint(i,y));
            }else if (getChessColor() == getChessComponents()[i][y].getChessColor()){
                break;
            }else {
                chessboardPoints.add(new ChessboardPoint(i,y));
                break;
            }
        }
        x6=x6-1;
        for (int i = x6;i < 8 && i >= 0;i--){
            if (whetherhava(i,y)){
                chessboardPoints.add(new ChessboardPoint(i,y));
            }else if (getChessColor() == getChessComponents()[i][y].getChessColor()){
                break;
            }else {
                chessboardPoints.add(new ChessboardPoint(i,y));
                break;
            }
        }
        y6=y6+1;
        for (int i = y6;i < 8 && i >= 0;i++){
        	
            if (whetherhava(x,i)){
                chessboardPoints.add(new ChessboardPoint(x,i));
            }else if (getChessColor() == getChessComponents()[x][i].getChessColor()){
                break;
            }else {
                chessboardPoints.add(new ChessboardPoint(x,i));
                break;
            }
        }
        y5=y5-1;
        for (int i = y5;i < 8 && i >= 0;i--){
            if (whetherhava(x,i)){
                chessboardPoints.add(new ChessboardPoint(x,i));
            }else if (getChessColor() == getChessComponents()[x][i].getChessColor()){
                break;
            }else {
                chessboardPoints.add(new ChessboardPoint(x,i));
                break;
            }
        }
        return chessboardPoints;
    }
}

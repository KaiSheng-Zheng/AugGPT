import java.util.ArrayList;

import java.util.List;

public class PawnChessComponent extends ChessComponent{

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
        if (name == 'p'){
        	x1=x1-1;
            if (x1 >= 0){
                if(whetherhava(x1,y)){
                    chessboardPoints.add(new ChessboardPoint(x1,y));
                    if (x == 6 && whetherhava(x1-1,y)){
                        chessboardPoints.add(new ChessboardPoint(x1-1,y));
                    }
                }
                y1=y1-1;x2=x-1;
                if (y1 >= 0){
                    if (getChessColor() != getChessComponents()[x2][y1].getChessColor() && !whetherhava(x2,y1)){
                        chessboardPoints.add(new ChessboardPoint(x2,y1));
                    }
                }
                y2=y2+1;x3=x3-1;
                if (y2 < 8){
                    if (getChessColor() != getChessComponents()[x3][y2].getChessColor() && !whetherhava(x3,y2)){
                        chessboardPoints.add(new ChessboardPoint(x3,y2));
                    }
                }
            }
        }else if (name == 'P'){
        	x4=x4+1;
            if (x+1 < 8){
                if(whetherhava(x4,y)){
                    chessboardPoints.add(new ChessboardPoint(x4,y));
                    if (x == 1 && whetherhava(x+2,y)){
                        chessboardPoints.add(new ChessboardPoint(x+2,y));
                    }
                }y4=y4-1;
                if (y4 >= 0){
                    if (getChessColor() != getChessComponents()[x+1][y4].getChessColor() && !whetherhava(x+1,y4)){
                        chessboardPoints.add(new ChessboardPoint(x+1,y4));
                    }
                }
                y5=y5+1;x5=x5+1;
                if (y5 < 8){
                    if (getChessColor() != getChessComponents()[x5][y5].getChessColor() && !whetherhava(x5,y5)){
                        chessboardPoints.add(new ChessboardPoint(x5,y5));
                    }
                }
            }

        }
        return chessboardPoints;
    }
}



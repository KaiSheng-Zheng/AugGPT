import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        if (name == 'p'){
            if (x-1 >= 0){
                if(whetherhava(x-1,y)){
                    chessboardPoints.add(new ChessboardPoint(x-1,y));
                    if (x == 6 && whetherhava(x-2,y)){
                        chessboardPoints.add(new ChessboardPoint(x-2,y));
                    }
                }
                if (y-1 >= 0){
                    if (getChessColor() != getChessComponents()[x-1][y-1].getChessColor() && !whetherhava(x-1,y-1)){
                        chessboardPoints.add(new ChessboardPoint(x-1,y-1));
                    }
                }
                if (y+1 < 8){
                    if (getChessColor() != getChessComponents()[x-1][y+1].getChessColor() && !whetherhava(x-1,y+1)){
                        chessboardPoints.add(new ChessboardPoint(x-1,y+1));
                    }
                }
            }

        }else if (name == 'P'){
            if (x+1 < 8){
                if(whetherhava(x+1,y)){
                    chessboardPoints.add(new ChessboardPoint(x+1,y));
                    if (x == 1 && whetherhava(x+2,y)){
                        chessboardPoints.add(new ChessboardPoint(x+2,y));
                    }
                }
                if (y-1 >= 0){
                    if (getChessColor() != getChessComponents()[x+1][y-1].getChessColor() && !whetherhava(x+1,y-1)){
                        chessboardPoints.add(new ChessboardPoint(x+1,y-1));
                    }
                }
                if (y+1 < 8){
                    if (getChessColor() != getChessComponents()[x+1][y+1].getChessColor() && !whetherhava(x+1,y+1)){
                        chessboardPoints.add(new ChessboardPoint(x+1,y+1));
                    }
                }
            }

        }
        return chessboardPoints;
    }
}
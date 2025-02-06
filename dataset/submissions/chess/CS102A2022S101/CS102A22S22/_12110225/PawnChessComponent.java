import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint){
        this.setChessColor(chessColor);
        this.setSource(chessboardPoint);
    }

    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> chessboardPoints = new ArrayList<ChessboardPoint>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        if (this.getChessColor() == ChessColor.BLACK){
            if (x+1 < 8 && y+1 < 8 && Character.isLowerCase(getChessBoard().getChess(x+1,y+1).getName())){
                chessboardPoints.add(new ChessboardPoint(x+1,y+1));
            }
            if (x+1 < 8 && y-1 >=0 && Character.isLowerCase(getChessBoard().getChess(x+1,y-1).getName())){
                chessboardPoints.add(new ChessboardPoint(x+1,y-1));
            }
            if (x+1 < 8 && getChessBoard().getChess(x+1,y).getName() == '_'){
                chessboardPoints.add(new ChessboardPoint(x+1,y));
            }
            if (x == 1 && getChessBoard().getChess(x+2,y).getName() == '_'){
                chessboardPoints.add(new ChessboardPoint(x+2,y));
            }
        } else {
            if (x-1 >= 0 && y+1 < 8 && Character.isUpperCase(getChessBoard().getChess(x-1,y+1).getName())){
                chessboardPoints.add(new ChessboardPoint(x-1,y+1));
            }
            if (x-1 >= 0 && y-1 >=0 && Character.isUpperCase(getChessBoard().getChess(x-1,y-1).getName())){
                chessboardPoints.add(new ChessboardPoint(x-1,y-1));
            }
            if (x-1 < 8 && getChessBoard().getChess(x-1,y).getName() == '_'){
                chessboardPoints.add(new ChessboardPoint(x-1,y));
            }
            if (x == 6 && getChessBoard().getChess(x-2,y).getName() == '_'){
                chessboardPoints.add(new ChessboardPoint(x-2,y));
            }
        }

        Collections.sort(chessboardPoints);
        return chessboardPoints;
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint){
        this.setChessColor(chessColor);
        this.setSource(chessboardPoint);
    }
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> chessboardPoints = new ArrayList<ChessboardPoint>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        if (this.getSource().offset(1,2) != null && !checkOccupied(this.getChessColor(), getChessBoard().getChess(x+1,y+2))){
            chessboardPoints.add(new ChessboardPoint(x+1,y+2));
        }
        if (this.getSource().offset(2,1) != null && !checkOccupied(this.getChessColor(), getChessBoard().getChess(x+2,y+1))){
            chessboardPoints.add(new ChessboardPoint(x+2,y+1));
        }
        if (this.getSource().offset(-1,2) != null && !checkOccupied(this.getChessColor(), getChessBoard().getChess(x-1,y+2))){
            chessboardPoints.add(new ChessboardPoint(x-1,y+2));
        }
        if (this.getSource().offset(2,-1) != null && !checkOccupied(this.getChessColor(), getChessBoard().getChess(x+2,y-1))){
            chessboardPoints.add(new ChessboardPoint(x+2,y-1));
        }
        if (this.getSource().offset(-2,1) != null && !checkOccupied(this.getChessColor(), getChessBoard().getChess(x-2,y+1))){
            chessboardPoints.add(new ChessboardPoint(x-2,y+1));
        }
        if (this.getSource().offset(1,-2) != null && !checkOccupied(this.getChessColor(), getChessBoard().getChess(x+1,y-2))){
            chessboardPoints.add(new ChessboardPoint(x+1,y-2));
        }
        if (this.getSource().offset(-1,-2) != null && !checkOccupied(this.getChessColor(), getChessBoard().getChess(x-1,y-2))){
            chessboardPoints.add(new ChessboardPoint(x-1,y-2));
        }
        if (this.getSource().offset(-2,-1) != null && !checkOccupied(this.getChessColor(), getChessBoard().getChess(x-2,y-1))){
            chessboardPoints.add(new ChessboardPoint(x-2,y-1));
        }
        Collections.sort(chessboardPoints);
        return chessboardPoints;

    }
}

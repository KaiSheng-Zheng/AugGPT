import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint){
        this.setChessColor(chessColor);
        this.setSource(chessboardPoint);
    }

    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> chessboardPoints = new ArrayList<ChessboardPoint>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        if (this.getSource().offset(1,1) != null && !checkOccupied(this.getChessColor(), getChessBoard().getChess(x+1,y+1))){
            chessboardPoints.add(this.getSource().offset(1,1));
        }
        if (this.getSource().offset(1,0) != null && !checkOccupied(this.getChessColor(), getChessBoard().getChess(x+1,y))){
            chessboardPoints.add(this.getSource().offset(1,0));
        }
        if (this.getSource().offset(1,-1) != null && !checkOccupied(this.getChessColor(), getChessBoard().getChess(x+1,y-1))){
            chessboardPoints.add(this.getSource().offset(1,-1));
        }
        if (this.getSource().offset(0,1) != null && !checkOccupied(this.getChessColor(), getChessBoard().getChess(x,y+1))){
            chessboardPoints.add(this.getSource().offset(0,1));
        }
        if (this.getSource().offset(0,-1) != null && !checkOccupied(this.getChessColor(), getChessBoard().getChess(x,y-1))){
            chessboardPoints.add(this.getSource().offset(0,-1));
        }
        if (this.getSource().offset(-1,1) != null && !checkOccupied(this.getChessColor(), getChessBoard().getChess(x-1,y+1))){
            chessboardPoints.add(this.getSource().offset(-1,1));
        }
        if (this.getSource().offset(-1,0) != null && !checkOccupied(this.getChessColor(), getChessBoard().getChess(x-1,y))){
            chessboardPoints.add(this.getSource().offset(-1,0));
        }
        if (this.getSource().offset(-1,-1) != null && !checkOccupied(this.getChessColor(), getChessBoard().getChess(x-1,y-1))){
            chessboardPoints.add(this.getSource().offset(-1,-1));
        }
        Collections.sort(chessboardPoints);
        return chessboardPoints;
    }
}

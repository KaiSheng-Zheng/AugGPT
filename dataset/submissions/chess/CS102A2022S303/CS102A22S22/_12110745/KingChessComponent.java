import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        super(source,chessColor);
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        if (this.getSource().isInChessboard(0,1)){
            if (isEnemy(chessboard[x][y+1])){move.add(this.getSource().offset(0,1));}
        }
        if (this.getSource().isInChessboard(0,-1)){
            if (isEnemy(chessboard[x][y-1])){move.add(this.getSource().offset(0,-1));}
        }
        if (this.getSource().isInChessboard(1,0)){
            if (isEnemy(chessboard[x+1][y])){move.add(this.getSource().offset(1,0));}
        }
        if (this.getSource().isInChessboard(-1,0)){
            if (isEnemy(chessboard[x-1][y])){move.add(this.getSource().offset(-1,0));}
        }
        if (this.getSource().isInChessboard(1,1)){
            if (isEnemy(chessboard[x+1][y+1])){move.add(this.getSource().offset(1,1));}
        }
        if (this.getSource().isInChessboard(-1,-1)){
            if (isEnemy(chessboard[x-1][y-1])){move.add(this.getSource().offset(-1,-1));}
        }
        if (this.getSource().isInChessboard(1,-1)){
            if (isEnemy(chessboard[x+1][y-1])){move.add(this.getSource().offset(1,-1));}
        }
        if (this.getSource().isInChessboard(-1,1)){
            if (isEnemy(chessboard[x-1][y+1])){move.add(this.getSource().offset(-1,1));}
        }
        return move;
    }




}

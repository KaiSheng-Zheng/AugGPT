import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(){

    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        int x = getSource().getX();
        int y = getSource().getY();
        List<ChessboardPoint> canMoveTo = new ArrayList<>();
        ChessColor currentColor = getChessColor();
        if(getSource().offset(0,1) != null){
            if(currentColor != chessComponents[x][y+1].getChessColor())
                canMoveTo.add(chessComponents[x][y+1].getSource());
        }
        if(getSource().offset(0,-1) != null){
            if(currentColor != chessComponents[x][y-1].getChessColor())
                canMoveTo.add(chessComponents[x][y-1].getSource());
        }
        if(getSource().offset(1,0) != null){
            if(currentColor != chessComponents[x+1][y].getChessColor())
                canMoveTo.add(chessComponents[x+1][y].getSource());
        }
        if(getSource().offset(1,1) != null){
            if(currentColor != chessComponents[x+1][y+1].getChessColor())
                canMoveTo.add(chessComponents[x+1][y+1].getSource());
        }
        if(getSource().offset(1,-1) != null){
            if(currentColor != chessComponents[x+1][y-1].getChessColor())
                canMoveTo.add(chessComponents[x+1][y-1].getSource());
        }
        if(getSource().offset(-1,1) != null){
            if(currentColor != chessComponents[x-1][y+1].getChessColor())
                canMoveTo.add(chessComponents[x-1][y+1].getSource());
        }
        if(getSource().offset(-1,0) != null){
            if(currentColor != chessComponents[x-1][y].getChessColor())
                canMoveTo.add(chessComponents[x-1][y].getSource());
        }
        if(getSource().offset(-1,-1) != null){
            if(currentColor != chessComponents[x-1][y-1].getChessColor())
                canMoveTo.add(chessComponents[x-1][y-1].getSource());
        }


        if(canMoveTo.size() != 0){
            return canMoveTo;
        }
        else return new ArrayList<>();
    }
}

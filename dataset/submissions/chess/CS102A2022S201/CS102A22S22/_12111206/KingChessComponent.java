import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    //private ChessboardPoint source;
    //private ChessColor chessColor;
    @Override
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> list = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        if(withinBoard(x+1,y+1)){
            if(isOurChess(x + 1, y + 1)){
                list.add(new ChessboardPoint(x+1, y+1));
            }
        }
        if(withinBoard(x+1,y)){
            if(isOurChess(x + 1, y)){
                list.add(new ChessboardPoint(x+1, y));
            }
        }
        if(withinBoard(x+1,y-1)){
            if(isOurChess(x + 1, y - 1)){
                list.add(new ChessboardPoint(x+1, y-1));
            }
        }
        if(withinBoard(x,y+1)){
            if(isOurChess(x, y + 1)){
                list.add(new ChessboardPoint(x, y+1));
            }
        }
        if(withinBoard(x,y-1)){
            if(isOurChess(x, y - 1)){
                list.add(new ChessboardPoint(x, y-1));
            }
        }
        if(withinBoard(x-1,y+1)) {
            if (isOurChess(x - 1, y + 1)) {
                list.add(new ChessboardPoint(x - 1, y + 1));
            }
        }
        if(withinBoard(x-1,y)){
            if(isOurChess(x - 1, y)){
                list.add(new ChessboardPoint(x-1, y));
            }
        }
        if(withinBoard(x-1,y-1)){
            if(isOurChess(x - 1, y - 1)){
                list.add(new ChessboardPoint(x-1, y-1));
            }
        }
        return list;
    }
    public KingChessComponent(ChessColor chessColor , ChessboardPoint source){
        setChessColor(chessColor);
       setSource(source);
        if (chessColor == ChessColor.BLACK){
            this.name = 'K';
        }
        else
            this.name = 'k';
    }
    @Override
    public String toString(){
        return String.valueOf(this.name);
    }
    /*public void setSourceX(int x){
        source.setX(x);
    }
    public void setSourceY(int y){
        source.setY(y);
    }*/
}

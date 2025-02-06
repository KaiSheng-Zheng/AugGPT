import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> list = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        if(withinBoard(x+2, y+1)){
            if(isOurChess(x + 2, y + 1)){
                list.add(new ChessboardPoint(x+2, y+1));
            }
        }
        if(withinBoard(x+2, y-1)){
            if(isOurChess(x + 2, y - 1)){
                list.add(new ChessboardPoint(x+2, y-1));
            }
        }
        if(withinBoard(x-2, y+1)){
            if(isOurChess(x - 2, y + 1)){
                list.add(new ChessboardPoint(x-2, y+1));
            }
        }
        if(withinBoard(x-2, y-1)){
            if(isOurChess(x - 2, y - 1)){
                list.add(new ChessboardPoint(x-2, y-1));
            }
        }
        if(withinBoard(x+1, y+2)){
            if(isOurChess(x + 1, y + 2)){
                list.add(new ChessboardPoint(x+1, y+2));
            }
        }
        if(withinBoard(x-1, y+2)){
            if(isOurChess(x - 1, y + 2)){
                list.add(new ChessboardPoint(x-1, y+2));
            }
        }
        if(withinBoard(x+1, y-2)){
            if(isOurChess(x + 1, y - 2)){
                list.add(new ChessboardPoint(x+1, y-2));
            }
        }
        if(withinBoard(x-1, y-2)){
            if(isOurChess(x - 1, y - 2)){
                list.add(new ChessboardPoint(x-1, y-2));
            }
        }
        return list;
    }
    public KnightChessComponent(ChessColor chessColor, ChessboardPoint source){
        setChessColor(chessColor);
        setSource(source);
        if(chessColor == ChessColor.BLACK)
            this.name = 'N';
        else
            this.name = 'n';
    }
    public String toString(){
        return String.valueOf(this.name);
    }
    public boolean isOurChess(int x, int y){
        if(chessboard[x][y].getChessColor() != chessboard[getSource().getX()][getSource().getY()].getChessColor() )
            return true;
        return false;
    }

}

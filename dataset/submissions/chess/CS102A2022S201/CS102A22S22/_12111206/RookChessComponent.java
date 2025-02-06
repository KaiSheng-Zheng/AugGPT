import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> list = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
        for (int i = x - 1; i >= 0 ; i--) {
            if(withinBoard(i,y)){
                if(isOurChess(i, y)){
                    list.add(new ChessboardPoint(i, y));
                    if(chessboard[i][y].getChessColor()!=ChessColor.NONE)
                        break;
                }
                else {
                    break;
                }
            }
        }
        for (int i = x+1; i <= 8; i++) {
            if (withinBoard(i, y)) {
                if (isOurChess(i, y)) {
                    list.add(new ChessboardPoint(i, y));
                    if(chessboard[i][y].getChessColor()!=ChessColor.NONE)
                        break;
                } else {
                    break;
                }
            }
        }
        for (int i = y-1; i >= 0; i--) {
            if (withinBoard(x, i)) {
                if (isOurChess(x, i)) {
                    list.add(new ChessboardPoint(x, i));
                    if(chessboard[x][i].getChessColor()!=ChessColor.NONE)
                        break;
                } else {
                    break;
                }
            }
        }
        for (int i = y+1; i <= 8; i++) {
            if (withinBoard(x, i)) {
                if (isOurChess(x, i)) {
                    list.add(new ChessboardPoint(x, i));
                    if(chessboard[x][i].getChessColor()!=ChessColor.NONE)
                        break;
                } else {
                    break;
                }
            }
        }
        return list;
    }
    public RookChessComponent(ChessColor chessColor , ChessboardPoint source){
        setChessColor(chessColor);
        setSource(source);
        if(chessColor == ChessColor.BLACK){
            this.name = 'R';
        }else
            this.name = 'r';

    }
    public String toString(){
        return String.valueOf(this.name);
    }
}

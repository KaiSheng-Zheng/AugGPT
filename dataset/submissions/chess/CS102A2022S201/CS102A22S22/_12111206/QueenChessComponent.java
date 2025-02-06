import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
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
        for (int i = -1; i >= -8 ; i--) {
            if(withinBoard(x+i, y+i)){
                if(isOurChess(x+i, y+i)){
                    list.add(new ChessboardPoint(x+i, y+i));
                    if(chessboard[x+i][y+i].getChessColor() != ChessColor.NONE)
                        break;
                }else{
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if(withinBoard(x+i, y+i)){
                if(isOurChess(x+i, y+i)){
                    list.add(new ChessboardPoint(x+i, y+i));
                    if(chessboard[x+i][y+i].getChessColor() != ChessColor.NONE)
                        break;
                }else{
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if(withinBoard(x+i, y-i)){
                if(isOurChess(x+i, y-i)){
                    list.add(new ChessboardPoint(x+i, y-i));
                    if(chessboard[x+i][y-i].getChessColor() != ChessColor.NONE)
                        break;
                }else {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if(withinBoard(x-i, y+i)){
                if(isOurChess(x-i, y+i)){
                    list.add(new ChessboardPoint(x-i, y+i));
                    if(chessboard[x-i][y+i].getChessColor() != ChessColor.NONE)
                        break;
                }else{
                    break;
                }
            }
        }
        return list;
    }
    public QueenChessComponent(ChessColor chessColor, ChessboardPoint source){
       setChessColor(chessColor);
        setSource(source);
        if(chessColor == ChessColor.BLACK)
            this.name = 'Q';
        else
            this.name = 'q';
    }
    @Override
    public String toString(){
        return String.valueOf(this.name);
    }
}

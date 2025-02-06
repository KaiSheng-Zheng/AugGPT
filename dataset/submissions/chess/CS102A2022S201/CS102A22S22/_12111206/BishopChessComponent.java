import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    private ChessColor chessColor;
    private ChessboardPoint source;

    @Override
    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> list = new ArrayList<>();
        int x = getSource().getX();
        int y = getSource().getY();
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
    public BishopChessComponent(ChessColor chessColor, ChessboardPoint source){
        setChessColor(chessColor);
        setSource(source);
        if(chessColor == ChessColor.BLACK)
            this.name = 'B';
        else
            this.name = 'b';
    }
    public String toString(){
        return String.valueOf(this.name);
    }
}

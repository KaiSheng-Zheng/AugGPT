import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    ChessComponent[][] chessComponents;
    public KingChessComponent(ChessColor chessColor,int x,int y,ChessComponent[][] chessComponent) {
        super(chessColor);
        if (chessColor == ChessColor.BLACK ){
            this.name='K';
        }else if (chessColor == ChessColor.WHITE){
            this.name='k';
        }
        this.x = x;
        this.y = y;
        this.chessComponents = chessComponent;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> res = new ArrayList<>();
        if (x+1<8 && y+1<8 && x+1>=0 && y+1>=0){
            if (chessComponents[x + 1][y + 1] instanceof EmptySlotComponent ||
                    chessComponents[x + 1][y + 1].getChessColor() != chessComponents[x][y].getChessColor()){
                res.add(new ChessboardPoint(x+1,y+1));
            }
        }
        if (x+1<8 && y-1<8 && x+1>=0 && y-1>=0){
            if (chessComponents[x + 1][y - 1] instanceof EmptySlotComponent ||
                    chessComponents[x + 1][y - 1].getChessColor() != chessComponents[x][y].getChessColor()) {
                res.add(new ChessboardPoint(x + 1, y - 1));
            }
        }
        if (x+1<8 && y<8 && x+1>=0 && y>=0){
            if (chessComponents[x + 1][y] instanceof EmptySlotComponent||
                    chessComponents[x + 1][y].getChessColor() != chessComponents[x][y].getChessColor()) {
                res.add(new ChessboardPoint(x + 1, y));
            }
        }
        if (x-1<8 && y+1<8 && x-1>=0 && y+1>=0){
            if (chessComponents[x - 1][y + 1] instanceof EmptySlotComponent||
                    chessComponents[x - 1][y + 1].getChessColor() != chessComponents[x][y].getChessColor()) {
                res.add(new ChessboardPoint(x - 1, y + 1));
            }
        }
        if (x-1<8 && y-1<8 && x-1>=0&& y-1>=0){
            if (chessComponents[x - 1][y - 1] instanceof EmptySlotComponent||
                    chessComponents[x - 1][y - 1].getChessColor() != chessComponents[x][y].getChessColor()) {
                res.add(new ChessboardPoint(x - 1, y - 1));
            }
        }
        if (x-1<8 && y<8 && x-1>=0 && y>=0){
            if (chessComponents[x - 1][y] instanceof EmptySlotComponent||
                    chessComponents[x - 1][y].getChessColor() != chessComponents[x][y].getChessColor()) {
                res.add(new ChessboardPoint(x - 1, y));
            }
        }
        if (x<8 && y+1<8 && x>=0 && y+1>=0){
            if (chessComponents[x][y + 1] instanceof EmptySlotComponent||
                    chessComponents[x][y + 1].getChessColor() != chessComponents[x][y].getChessColor()) {
                res.add(new ChessboardPoint(x, y + 1));
            }
        }
        if (x<8 && y-1<8 && x>=0 && y-1>=0){
            if (chessComponents[x][y - 1] instanceof EmptySlotComponent||
                    chessComponents[x][y - 1].getChessColor() != chessComponents[x][y].getChessColor()) {
                res.add(new ChessboardPoint(x, y - 1));
            }
        }
        return res;
    }
}

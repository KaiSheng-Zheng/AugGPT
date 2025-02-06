import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    ChessComponent[][] chessComponents;
    public KnightChessComponent(ChessColor chessColor,int x,int y,ChessComponent[][] chessComponent) {
        super(chessColor);
        if (chessColor == ChessColor.BLACK ){
            this.name='N';
        }else if (chessColor == ChessColor.WHITE){
            this.name='n';
        }
        this.x = x;
        this.y = y;
        this.chessComponents = chessComponent;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> res = new ArrayList<>();
        if (x+1<8 && y+2<8 && x+1>=0 && y+2>=0){
            if (chessComponents[x + 1][y + 2] instanceof EmptySlotComponent ||
                    chessComponents[x + 1][y + 2].getChessColor() != chessComponents[x][y].getChessColor()){
                res.add(new ChessboardPoint(x+1,y+2));
            }
        }
        if (x+2<8 && y+1<8 && x+2>=0 && y+1>=0){
            if (chessComponents[x + 2][y + 1] instanceof EmptySlotComponent ||
                    chessComponents[x + 2][y + 1].getChessColor() != chessComponents[x][y].getChessColor()){
                res.add(new ChessboardPoint(x+2,y+1));
            }
        }
        if (x-1<8 && y+2<8 && x-1>=0 && y+2>=0){
            if (chessComponents[x - 1][y + 2] instanceof EmptySlotComponent ||
                    chessComponents[x - 1][y + 2].getChessColor() != chessComponents[x][y].getChessColor()){
                res.add(new ChessboardPoint(x-1,y+2));
            }
        }
        if (x-2<8 && y+1<8 && x-2>=0 && y+1>=0){
            if (chessComponents[x-2][y + 1] instanceof EmptySlotComponent ||
                    chessComponents[x-2][y + 1].getChessColor() != chessComponents[x][y].getChessColor()){
                res.add(new ChessboardPoint(x-2,y+1));
            }
        }
        if (x+1<8 && y-2<8 && x+1>=0 && y-2>=0){
            if (chessComponents[x + 1][y-2] instanceof EmptySlotComponent ||
                    chessComponents[x + 1][y-2].getChessColor() != chessComponents[x][y].getChessColor()){
                res.add(new ChessboardPoint(x+1,y-2));
            }
        }
        if (x+2<8 && y-1<8 && x + 2>=0 && y-1>=0){
            if (chessComponents[x + 2][y-1] instanceof EmptySlotComponent ||
                    chessComponents[x + 2][y-1].getChessColor() != chessComponents[x][y].getChessColor()){
                res.add(new ChessboardPoint(x + 2,y-1));
            }
        }
        if (x-1<8 && y-2<8 && x-1>=0 && y-2>=0){
            if (chessComponents[x-1][y-2] instanceof EmptySlotComponent ||
                    chessComponents[x-1][y-2].getChessColor() != chessComponents[x][y].getChessColor()){
                res.add(new ChessboardPoint(x-1,y-2));
            }
        }
        if (x-2<8 && y-1<8 && x-2>=0 && y-1>=0){
            if (chessComponents[x-2][y-1] instanceof EmptySlotComponent ||
                    chessComponents[x-2][y-1].getChessColor() != chessComponents[x][y].getChessColor()){
                res.add(new ChessboardPoint(x-2,y-1));
            }
        }
        return res;
    }
}

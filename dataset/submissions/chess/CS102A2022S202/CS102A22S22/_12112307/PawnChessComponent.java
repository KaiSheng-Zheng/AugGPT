import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    ChessComponent[][] chessComponents;
    public PawnChessComponent(ChessColor chessColor,int x,int y,ChessComponent[][] chessComponent) {
        super(chessColor);
        if (chessColor == ChessColor.BLACK ){
            this.name='P';
        }else if (chessColor == ChessColor.WHITE){
            this.name='p';
        }
        this.x = x;
        this.y = y;
        this.chessComponents = chessComponent;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> res = new ArrayList<>();
        if (chessComponents[x][y].getChessColor() == ChessColor.BLACK){
            if (x == 1){
                if (chessComponents[x+1][y]instanceof EmptySlotComponent){
                    res.add(new ChessboardPoint(x+1,y));
                }
                if (y+1<8 && chessComponents[x+1][y+1].getChessColor() == ChessColor.WHITE){
                    res.add(new ChessboardPoint(x+1,y+1));
                }
                if (y-1>=0 && chessComponents[x+1][y-1].getChessColor() == ChessColor.WHITE){
                    res.add(new ChessboardPoint(x+1,y-1));
                }
                if (chessComponents[x+2][y]instanceof EmptySlotComponent){
                    res.add(new ChessboardPoint(x+2,y));
                }
            }else {
                if (x+1<8 && chessComponents[x+1][y]instanceof EmptySlotComponent){
                    res.add(new ChessboardPoint(x+1,y));
                }
                if (x+1<8 && y+1<8 && chessComponents[x+1][y+1].getChessColor() == ChessColor.WHITE){
                    res.add(new ChessboardPoint(x+1,y+1));
                }
                if (x+1<8 && y-1>=0 && chessComponents[x+1][y-1].getChessColor() == ChessColor.WHITE){
                    res.add(new ChessboardPoint(x+1,y-1));
                }
            }
        }else if (chessComponents[x][y].getChessColor() == ChessColor.WHITE){
            if (x == 6){
                if (chessComponents[x-1][y]instanceof EmptySlotComponent){
                    res.add(new ChessboardPoint(x-1,y));
                }
                if (y+1<8 && chessComponents[x-1][y+1].getChessColor() == ChessColor.BLACK){
                    res.add(new ChessboardPoint(x-1,y+1));
                }
                if (y-1>=0 && chessComponents[x-1][y-1].getChessColor() == ChessColor.BLACK){
                    res.add(new ChessboardPoint(x-1,y-1));
                }
                if (chessComponents[x-2][y]instanceof EmptySlotComponent){
                    res.add(new ChessboardPoint(x-2,y));
                }
            }else {
                if (x-1>=0 && chessComponents[x-1][y]instanceof EmptySlotComponent){
                    res.add(new ChessboardPoint(x-1,y));
                }
                if (x-1>=0 && y+1<8 && chessComponents[x-1][y+1].getChessColor() == ChessColor.BLACK){
                    res.add(new ChessboardPoint(x-1,y+1));
                }
                if (x-1>=0 && y-1>=0 && chessComponents[x-1][y-1].getChessColor() == ChessColor.BLACK){
                    res.add(new ChessboardPoint(x-1,y-1));
                }
            }
        }
        return res;
    }
}

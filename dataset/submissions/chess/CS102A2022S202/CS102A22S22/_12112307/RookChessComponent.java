import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    ChessComponent[][] chessComponents;
    public RookChessComponent(ChessColor chessColor,int x,int y,ChessComponent[][] chessComponent) {
        super(chessColor);
        if (chessColor == ChessColor.BLACK ){
            this.name='R';
        }else if (chessColor == ChessColor.WHITE){
            this.name='r';
        }
        this.x = x;
        this.y = y;
        this.chessComponents = chessComponent;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> res = new ArrayList<>();
        int i=1;
        int j=-1;
        while (x+i<8){
            if (chessComponents[x+i][y] instanceof EmptySlotComponent){
                res.add(new ChessboardPoint(x+i,y));
            }else if (chessComponents[x+i][y].getChessColor() != chessComponents[x][y].getChessColor() ){
                res.add(new ChessboardPoint(x+i,y));
                break;
            }else {
                break;
            }
            i++;
        }
        while (x+j>=0){
            if (chessComponents[x+j][y] instanceof EmptySlotComponent){
                res.add(new ChessboardPoint(x+j,y));
            }else if (chessComponents[x+j][y].getChessColor() != chessComponents[x][y].getChessColor() ){
                res.add(new ChessboardPoint(x+j,y));
                break;
            }else {
                break;
            }
            j--;
        }
        int a=1;
        int b=-1;
        while (y+a<8){
            if (chessComponents[x][y+a] instanceof EmptySlotComponent){
                res.add(new ChessboardPoint(x,y+a));
            }else if (chessComponents[x][y+a].getChessColor() != chessComponents[x][y].getChessColor() ){
                res.add(new ChessboardPoint(x,y+a));
                break;
            }else {
                break;
            }
            a++;
        }
        while (y+b>=0){
            if (chessComponents[x][y+b] instanceof EmptySlotComponent){
                res.add(new ChessboardPoint(x,y+b));
            }else if (chessComponents[x][y+b].getChessColor() != chessComponents[x][y].getChessColor() ){
                res.add(new ChessboardPoint(x,y+b));
                break;
            }else {
                break;
            }
            b--;
        }
        return res;
    }
}

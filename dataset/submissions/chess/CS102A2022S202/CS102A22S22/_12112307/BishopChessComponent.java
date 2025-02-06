import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    ChessComponent[][] chessComponents;
    public BishopChessComponent(ChessColor chessColor,int x,int y,ChessComponent[][] chessComponent) {
        super(chessColor);
        if (chessColor == ChessColor.BLACK ){
            this.name='B';
        }else if (chessColor == ChessColor.WHITE){
            this.name='b';
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
        while (x+i<8 && y+i<8){
            if (chessComponents[x+i][y+i] instanceof EmptySlotComponent){
                res.add(new ChessboardPoint(x+i,y+i));
            }else if (chessComponents[x+i][y+i].getChessColor() != chessComponents[x][y].getChessColor() ){
                res.add(new ChessboardPoint(x+i,y+i));
                 break;
            }else {
                break;
            }
            i++;
        }
        while (x+j>=0&&y+j>=0){
            if (chessComponents[x+j][y+j] instanceof EmptySlotComponent){
                res.add(new ChessboardPoint(x+j,y+j));
            }else if (chessComponents[x+j][y+j].getChessColor() != chessComponents[x][y].getChessColor() ){
                res.add(new ChessboardPoint(x+j,y+j));
                break;
            }else {
                break;
            }
            j--;
        }
        int a=1;
        int b=-1;
        while (x+a<8 && y+b>=0){
            if (chessComponents[x+a][y+b] instanceof EmptySlotComponent){
                res.add(new ChessboardPoint(x+a,y+b));
            }else if (chessComponents[x+a][y+b].getChessColor() != chessComponents[x][y].getChessColor() ){
                res.add(new ChessboardPoint(x+a,y+b));
                break;
            }else {
                break;
            }
            a++;
            b--;
        }
        int c=1;
        int d=-1;
        while (x+d>=0 && y+c<8){
            if (chessComponents[x+d][y+c] instanceof EmptySlotComponent){
                res.add(new ChessboardPoint(x+d,y+c));
            }else if (chessComponents[x+d][y+c].getChessColor() != chessComponents[x][y].getChessColor() ){
                res.add(new ChessboardPoint(x+d,y+c));
                break;
            }else {
                break;
            }
            c++;
            d--;
        }
        return res;
    }
}

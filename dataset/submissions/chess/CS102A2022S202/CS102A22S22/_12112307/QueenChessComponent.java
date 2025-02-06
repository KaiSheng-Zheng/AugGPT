import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    ChessComponent[][] chessComponents;
    public QueenChessComponent(ChessColor chessColor,int x,int y,ChessComponent[][] chessComponent) {
        super(chessColor);
        if (chessColor == ChessColor.BLACK ){
            this.name='Q';
        }else if (chessColor == ChessColor.WHITE){
            this.name='q';
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
        int c=1;
        int d=-1;
        while (x+c<8 && y+c<8){
            if (chessComponents[x+c][y+c] instanceof EmptySlotComponent){
                res.add(new ChessboardPoint(x+c,y+c));
            }else if (chessComponents[x+c][y+c].getChessColor() != chessComponents[x][y].getChessColor() ){
                res.add(new ChessboardPoint(x+c,y+c));
                break;
            }else {
                break;
            }
            c++;
        }
        while (x+d>=0&&y+d>=0){
            if (chessComponents[x+d][y+d] instanceof EmptySlotComponent){
                res.add(new ChessboardPoint(x+d,y+d));
            }else if (chessComponents[x+d][y+d].getChessColor() != chessComponents[x][y].getChessColor() ){
                res.add(new ChessboardPoint(x+d,y+d));
                break;
            }else {
                break;
            }
            d--;
        }
        int e=1;
        int f=-1;
        while (x+e<8 && y+f>=0){
            if (chessComponents[x+e][y+f] instanceof EmptySlotComponent){
                res.add(new ChessboardPoint(x+e,y+f));
            }else if (chessComponents[x+e][y+f].getChessColor() != chessComponents[x][y].getChessColor() ){
                res.add(new ChessboardPoint(x+e,y+f));
                break;
            }else {
                break;
            }
            e++;
            f--;
        }
        int g=1;
        int h=-1;
        while (x+h>=0 && y+g<8){
            if (chessComponents[x+h][y+g] instanceof EmptySlotComponent){
                res.add(new ChessboardPoint(x+h,y+g));
            }else if (chessComponents[x+h][y+g].getChessColor() != chessComponents[x][y].getChessColor() ){
                res.add(new ChessboardPoint(x+h,y+g));
                break;
            }else {
                break;
            }
            g++;
            h--;
        }
        return res;
    }
}

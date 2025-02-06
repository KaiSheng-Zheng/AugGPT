import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
     KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source,chessColor,name);
    }
    KnightChessComponent() {
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        // CAN cross other different from Chinese Chess
        List<ChessboardPoint> ans = new ArrayList<>();
        int x = this.getSource().getX();
        int y = this.getSource().getY();
        //NOT consider if the position after move is out of bound
        if (x+1<8 && y+2<8 && !chessComponents[x+1][y+2].getChessColor().equals(this.getChessColor()) ){
            ans.add(new ChessboardPoint(x+1,y+2));
        }
        if (y-2>=0 && x+1<8 && !chessComponents[x+1][y-2].getChessColor().equals(this.getChessColor())  ){
            ans.add(new ChessboardPoint(x+1,y-2));
        }
        if (x-1>=0 && y+2<8 && !chessComponents[x-1][y+2].getChessColor().equals(this.getChessColor())  ){
            ans.add(new ChessboardPoint(x-1,y+2));
        }
        if (x-1>=0 && y-2>=0 && !chessComponents[x-1][y-2].getChessColor().equals(this.getChessColor()) ){
            ans.add(new ChessboardPoint(x-1,y-2));
        }
        if (x+2<8 && y+1<8 && !chessComponents[x+2][y+1].getChessColor().equals(this.getChessColor())){
            ans.add(new ChessboardPoint(x+2,y+1));
        }
        if (y-1>=0 && x+2<8 && !chessComponents[x+2][y-1].getChessColor().equals(this.getChessColor())  ){
            ans.add(new ChessboardPoint(x+2,y-1));
        }
        if (x-2>=0 &&  y+1<8 && !chessComponents[x-2][y+1].getChessColor().equals(this.getChessColor())){
            ans.add(new ChessboardPoint(x-2,y+1));
        }
        if (x-2>=0 && y-1>=0 && !chessComponents[x-2][y-1].getChessColor().equals(this.getChessColor())){
            ans.add(new ChessboardPoint(x-2,y-1));
        }
       return ans;
    }
}
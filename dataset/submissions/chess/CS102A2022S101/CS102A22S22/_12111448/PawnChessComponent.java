import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
     PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source,chessColor,name);
    }
    PawnChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
         int x=this.getSource().getX();
         int y=this.getSource().getY();
         List<ChessboardPoint> ans = new ArrayList<>();
        if (this.getChessColor().equals(ChessColor.WHITE)){
            if (x==6){
                if (x-1>=0 && chessComponents[x-1][y].getChessColor().equals(ChessColor.NONE)){
                    ans.add(new ChessboardPoint(x-1,y));
                    if (chessComponents[x-2][y].getChessColor().equals(ChessColor.NONE)){
                        ans.add(new ChessboardPoint(x-2,y));
                    }
                }
            }
            else {
                if (x-1>=0 && chessComponents[x-1][y].getChessColor().equals(ChessColor.NONE) ){
                    //x-1>=0 is always true ??????????
                    ans.add(new ChessboardPoint(x-1,y));
                }
            }
            if (x-1>=0 && y+1<8  && chessComponents[x-1][y+1].getChessColor().equals(ChessColor.BLACK)){
                ans.add(new ChessboardPoint(x-1,y+1));
            }
            if (x-1>=0 && y-1>=0 && chessComponents[x-1][y-1].getChessColor().equals(ChessColor.BLACK)){
                ans.add(new ChessboardPoint(x-1,y-1));
            }
        }
        if (this.getChessColor().equals(ChessColor.BLACK)){
            if (x==1){
                if (chessComponents[x+1][y].getChessColor().equals(ChessColor.NONE)){
                    ans.add(new ChessboardPoint(x+1,y));
                    if (chessComponents[x+2][y].getChessColor().equals(ChessColor.NONE)){
                        ans.add(new ChessboardPoint(x+2,y));
                    }
                }
            }
            else {
                if (x+1<8 && chessComponents[x+1][y].getChessColor().equals(ChessColor.NONE) ){
                    //x-1>=0 is always true ??????????
                    ans.add(new ChessboardPoint(x+1,y));
                }
            }
            if (x+1<8 && y+1<8 && chessComponents[x+1][y+1].getChessColor().equals(ChessColor.WHITE)){
                ans.add(new ChessboardPoint(x+1,y+1));
            }
            if (x+1<8 && y-1>=0 && chessComponents[x+1][y-1].getChessColor().equals(ChessColor.WHITE)){
                ans.add(new ChessboardPoint(x+1,y-1));
            }
        }
        return ans;
//        if (ans.size()==0){
//            return new ArrayList<>();
//        }
//        else {
//            return
//        }
    }
}
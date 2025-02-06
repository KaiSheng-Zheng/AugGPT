import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessComponent[][] chessComponents;



    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
    private ChessColor chessColor;
    public ChessboardPoint getSource() {
        return source;
    }

    private ChessboardPoint source;
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int i5 = source.getX(), i6 = source.getY();
        List<ChessboardPoint> canMovePoints = new ArrayList<>();
         if(i5!=0) {
             if(i6!=0){
                 ChessboardPoint a = new ChessboardPoint(i5 - 1, i6-1);
                 if(chessComponents[i5-1][i6-1]instanceof EmptySlotComponent||(chessComponents[i5-1][i6-1].getChessColor() != ChessColor.NONE && chessComponents[i5-1][i6-1].getChessColor() != getChessColor()))
                     canMovePoints.add(a);
             }

             ChessboardPoint b = new ChessboardPoint(i5 - 1, i6);
             if(chessComponents[i5-1][i6]instanceof EmptySlotComponent||(chessComponents[i5-1][i6].getChessColor() != ChessColor.NONE && chessComponents[i5-1][i6].getChessColor() != getChessColor()))
       canMovePoints.add(b);

             if(i6!=7){
                 ChessboardPoint c = new ChessboardPoint(i5 - 1, i6+1);
                 if(chessComponents[i5-1][i6+1]instanceof EmptySlotComponent||(chessComponents[i5-1][i6+1].getChessColor() != ChessColor.NONE && chessComponents[i5-1][i6+1].getChessColor() != getChessColor()))
                     canMovePoints.add(c);
             }
         }

        if(i6!=0){
            ChessboardPoint d = new ChessboardPoint(i5 , i6-1);
            if(chessComponents[i5][i6-1]instanceof EmptySlotComponent||(chessComponents[i5][i6-1].getChessColor() != ChessColor.NONE && chessComponents[i5][i6-1].getChessColor() != getChessColor()))
                canMovePoints.add(d);
        }
        if(i6!=7){
            ChessboardPoint e = new ChessboardPoint(i5  , i6+1);
            if(chessComponents[i5][i6+1]instanceof EmptySlotComponent||(chessComponents[i5][i6+1].getChessColor() != ChessColor.NONE && chessComponents[i5][i6+1].getChessColor() != getChessColor()))
                canMovePoints.add(e);
        }

        if(i5!=7) {
            if(i6!=0){
                ChessboardPoint g = new ChessboardPoint(i5 +1, i6-1);
                if(chessComponents[i5+1][i6-1]instanceof EmptySlotComponent||(chessComponents[i5+1][i6-1].getChessColor() != ChessColor.NONE && chessComponents[i5+1][i6-1].getChessColor() != getChessColor()))
                    canMovePoints.add(g);
            }

            ChessboardPoint h = new ChessboardPoint(i5 + 1, i6);
            if(chessComponents[i5+1][i6]instanceof EmptySlotComponent||(chessComponents[i5+1][i6].getChessColor() != ChessColor.NONE && chessComponents[i5+1][i6].getChessColor() != getChessColor()))
                canMovePoints.add(h);

            if(i6!=7){
                ChessboardPoint i = new ChessboardPoint(i5 + 1, i6+1);
                if(chessComponents[i5+1][i6+1]instanceof EmptySlotComponent||(chessComponents[i5+1][i6+1].getChessColor() != ChessColor.NONE && chessComponents[i5+1][i6+1].getChessColor() != getChessColor()))
                    canMovePoints.add(i);
            }
        }


        return canMovePoints;


    }



}

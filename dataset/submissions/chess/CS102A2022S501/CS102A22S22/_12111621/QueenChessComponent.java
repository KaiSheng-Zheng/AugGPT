import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
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

        ok://
        for (int i2 = 0; i2<i5; i2++) {
            ChessboardPoint a = new ChessboardPoint(i2, i6);
//            if (chessComponents[i2][i6] instanceof EmptySlotComponent
//                    || (chessComponents[i2][i6].getChessColor() != ChessColor.NONE && chessComponents[i2][i6].getChessColor() != getChessColor())) {
            if(i2+1!=i5){
                for (int i4 = i2 +1; i4 <i5; i4++) {
                    if (!(chessComponents[i4][i6] instanceof EmptySlotComponent))
                        break ok;
                }}
            canMovePoints.add(a);
        }
        //    }

        mark:
        for(int i2=0;i2<i6;i2++){
            ChessboardPoint a=new ChessboardPoint(i5,i2);
//            if(chessComponents[i5][i2] instanceof EmptySlotComponent
//
//                   ||(chessComponents[i5][i2].getChessColor()!=ChessColor.NONE&&chessComponents[i5][i2].getChessColor()!=getChessColor())) {
            if(i2+1!=i6){
                for(int i4=i2+1;i4<i6;i4++) {
                    if(!(chessComponents[i5][i4] instanceof EmptySlotComponent))
                        break mark;
                }}
            canMovePoints.add(a);
        }
        //    }



        p:
        for(int i2=i6+1;i2<8;i2++){
            ChessboardPoint a=new ChessboardPoint(i5,i2);
            //   ||(chessComponents[i5][i2].getChessColor()!=ChessColor.NONE&&chessComponents[i5][i2].getChessColor()!=getChessColor())) {
            if(i2!=i6+1){
                for(int i4=i6+1;i4<i2;i4++) {
                    if(!(chessComponents[i5][i4] instanceof EmptySlotComponent))
                        break p;
                }}
            canMovePoints.add(a);
        }
        //   }
        o:
        for(int i2=i5+1;i2<8;i2++){
            ChessboardPoint a=new ChessboardPoint(i2,i6);
            //    if(chessComponents[i2][i6] instanceof EmptySlotComponent
            //           ||(chessComponents[i2][i6].getChessColor()!=ChessColor.NONE&&chessComponents[i2][i6].getChessColor()!=getChessColor())) {
            if(i2!=i5+1){
                for(int i4=i5+1;i4<i2;i4++) {
                    if(!(chessComponents[i4][i6] instanceof EmptySlotComponent))
                        break o;
                }}
            canMovePoints.add(a);
        }
        //    }


        return canMovePoints;


    }
}

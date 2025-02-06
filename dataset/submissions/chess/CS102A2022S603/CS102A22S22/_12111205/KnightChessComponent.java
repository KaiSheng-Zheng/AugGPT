import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    private ChessColor chessColor;


    public KnightChessComponent() {
        super();
    }


    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint location0 = getSource();
        ChessColor color = chessColor;
        int Y = location0.getX(); int X = location0.getY();
        ChessboardPoint location=new ChessboardPoint(X,Y);
        List<ChessboardPoint> a = new ArrayList<>();
        if(location.offset(-1,-2)!=null ){
            if(chessComponents[X-1][Y-2] instanceof EmptySlotComponent || (!(chessComponents[X-1][Y-2] instanceof EmptySlotComponent)&&!(chessComponents[X-1][Y-2].getChessColor().equals(color))))
            a.add(location.offset(-1,-2));
        }
        if(location.offset(1,-2)!=null){
            if(chessComponents[X+1][Y-2] instanceof EmptySlotComponent || (!(chessComponents[X+1][Y-2] instanceof EmptySlotComponent)&&!(chessComponents[X+1][Y-2].getChessColor().equals(color))))
            a.add(location.offset(1,-2));
        }
        if(location.offset(-1,2)!=null){
            if(chessComponents[X-1][Y+2] instanceof EmptySlotComponent || (!(chessComponents[X-1][Y+2] instanceof EmptySlotComponent)&&!(chessComponents[X-1][Y+2].getChessColor().equals(color))))
            a.add(location.offset(-1,2));
        }
        if(location.offset(1,2)!=null){
            if(chessComponents[X+1][Y+2] instanceof EmptySlotComponent || (!(chessComponents[X+1][Y+2] instanceof EmptySlotComponent)&&!(chessComponents[X+1][Y+2].getChessColor().equals(color))))
            a.add(location.offset(1,2));
        }
        if(location.offset(-2,-1)!=null){
            if(chessComponents[X-2][Y-1] instanceof EmptySlotComponent || (!(chessComponents[X-2][Y-1] instanceof EmptySlotComponent)&&!(chessComponents[X-2][Y-1].getChessColor().equals(color))))
            a.add(location.offset(-2,-1));
        }
        if(location.offset(-2,1)!=null){
            if(chessComponents[X-2][Y+1] instanceof EmptySlotComponent || (!(chessComponents[X-2][Y+1] instanceof EmptySlotComponent)&&!(chessComponents[X-2][Y+1].getChessColor().equals(color))))
            a.add(location.offset(-2,1));
        }
        if(location.offset(2,-1)!=null){
            if(chessComponents[X+2][Y-1] instanceof EmptySlotComponent || (!(chessComponents[X+2][Y-1] instanceof EmptySlotComponent)&&!(chessComponents[X+2][Y-1].getChessColor().equals(color))))
            a.add(location.offset(2,-1));
        }
        if(location.offset(2,1)!=null){
            if(chessComponents[X+2][Y+1] instanceof EmptySlotComponent || (!(chessComponents[X+2][Y+1] instanceof EmptySlotComponent)&&!(chessComponents[X+2][Y+1].getChessColor().equals(color))))
            a.add(location.offset(2,1));
        }
        return a;
    }
}
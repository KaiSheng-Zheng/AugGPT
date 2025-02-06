import java.util.*;

public class PawnChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo(){
        return realCanMoveTo(chessComponents);
    }
    public List<ChessboardPoint> realCanMoveTo(ChessComponent[][] X){
        List<ChessboardPoint> x=new ArrayList<>();
        int i=0;
        int u=source.getX();int v=source.getY();
        if(chessColor==ChessColor.WHITE&&u==6){
            i=1;
            if(isEmpty(X,u-1,v)){x.add(new ChessboardPoint(u-1,v));};
            if(isEmpty(X,u-2,v)&&isEmpty(X,u-1,v)){x.add(new ChessboardPoint(u-2,v));};
        }
        if(chessColor==ChessColor.BLACK&&u==1){
            i=1;
            if(isEmpty(X,u+1,v)){x.add(new ChessboardPoint(u+1,v));}
            if(isEmpty(X,u+2,v)&&isEmpty(X,u+2,v)){x.add(new ChessboardPoint(u+2,v));}
        }
        if(chessColor==ChessColor.WHITE&&i==0) {
            if(inBoard(u-1,v)&&isEmpty(X,u-1,v)){
                x.add(new ChessboardPoint(u-1,v));
            }
        }
        if(chessColor==ChessColor.BLACK&&i==0) {
            if(inBoard(u+1,v)&&isEmpty(X,u+1,v)){
                x.add(new ChessboardPoint(u+1,v));
            }
        }
        if(chessColor==ChessColor.WHITE) {
            if(inBoard(u-1,v+1)&&isOppositeColor(X,u-1,v+1)){
                x.add(new ChessboardPoint(u-1,v+1));
            }
        }
        if(chessColor==ChessColor.BLACK) {
            if(inBoard(u+1,v+1)&&isOppositeColor(X,u+1,v+1)){
                x.add(new ChessboardPoint(u+1,v+1));
            }
        }
        if(chessColor==ChessColor.WHITE) {
            if(inBoard(u-1,v-1)&&isOppositeColor(X,u-1,v-1)){
                x.add(new ChessboardPoint(u-1,v-1));
            }
        }
        if(chessColor==ChessColor.BLACK) {
            if(inBoard(u+1,v-1)&&isOppositeColor(X,u+1,v-1)){
                x.add(new ChessboardPoint(u+1,v-1));
            }
        }
        return x;
    }

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

}
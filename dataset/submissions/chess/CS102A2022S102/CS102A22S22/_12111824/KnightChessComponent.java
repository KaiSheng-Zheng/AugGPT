import java.util.*;

public class KnightChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo(){
        return realCanMoveTo(chessComponents);
    }
    public List<ChessboardPoint> realCanMoveTo(ChessComponent[][] X){
        List<ChessboardPoint> x=new ArrayList<>();
        int u=source.getX();int v=source.getY();
        if(inBoard(u+2,v+1)&&!isSameColor(X,u+2,v+1)){
            x.add(new ChessboardPoint(u+2,v+1));
        }
        if(inBoard(u+2,v-1)&&!isSameColor(X,u+2,v-1)){
            x.add(new ChessboardPoint(u+2,v-1));
        }
        if(inBoard(u-2,v+1)&&!isSameColor(X,u-2,v+1)){
            x.add(new ChessboardPoint(u-2,v+1));
        }
        if(inBoard(u-2,v-1)&&!isSameColor(X,u-2,v-1)){
            x.add(new ChessboardPoint(u-2,v-1));
        }
        if(inBoard(u+1,v+2)&&!isSameColor(X,u+1,v+2)){
            x.add(new ChessboardPoint(u+1,v+2));
        }
        if(inBoard(u+1,v-2)&&!isSameColor(X,u+1,v-2)){
            x.add(new ChessboardPoint(u+1,v-2));
        }
        if(inBoard(u-1,v+2)&&!isSameColor(X,u-1,v+2)){
            x.add(new ChessboardPoint(u-1,v+2));
        }
        if(inBoard(u-1,v-2)&&!isSameColor(X,u-1,v-2)){
            x.add(new ChessboardPoint(u-1,v-2));
        }
        return x;
    }

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }
}
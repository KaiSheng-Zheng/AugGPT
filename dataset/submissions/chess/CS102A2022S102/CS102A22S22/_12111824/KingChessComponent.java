import java.util.*;

public class KingChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo(){
        return realCanMoveTo(chessComponents);
    }

    public List<ChessboardPoint> realCanMoveTo(ChessComponent[][] X){
        List<ChessboardPoint> x=new ArrayList<>();
        int u=source.getX();int v=source.getY();
        if(inBoard(u+1,v+1)&&!isSameColor(X,u+1,v+1)){
            x.add(new ChessboardPoint(u+1,v+1));
        }
        if(inBoard(u-1,v-1)&&!isSameColor(X,u-1,v-1)){
            x.add(new ChessboardPoint(u-1,v-1));
        }
        if(inBoard(u+1,v)&&!isSameColor(X,u+1,v)){
            x.add(new ChessboardPoint(u+1,v));
        }
        if(inBoard(u-1,v)&&!isSameColor(X,u-1,v)){
            x.add(new ChessboardPoint(u-1,v));
        }
        if(inBoard(u,v+1)&&!isSameColor(X,u,v+1)){
            x.add(new ChessboardPoint(u,v+1));
        }
        if(inBoard(u,v-1)&&!isSameColor(X,u,v-1)){
            x.add(new ChessboardPoint(u,v-1));
        }
        if(inBoard(u+1,v-1)&&!isSameColor(X,u+1,v-1)){
            x.add(new ChessboardPoint(u+1,v-1));
        }
        if(inBoard(u-1,v+1)&&!isSameColor(X,u-1,v+1)){
            x.add(new ChessboardPoint(u-1,v+1));
        }
        return x;
    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }
}
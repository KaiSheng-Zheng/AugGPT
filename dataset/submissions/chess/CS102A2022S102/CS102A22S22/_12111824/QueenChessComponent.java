import java.util.*;

public class QueenChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo(){
        return realCanMoveTo(chessComponents);
    }
    public List<ChessboardPoint> realCanMoveTo(ChessComponent[][] X){
        List<ChessboardPoint> x=new ArrayList<>() ;
        int u=source.getX();int v=source.getY();
        for (int i=1;i<8;i++){
            if(inBoard(u+i,v)){
            if(isSameColor(X,u+i,v)){break;}
            x.add(new ChessboardPoint(u+i,v));
            if(isOppositeColor(X,u+i,v)){break;}}
        }
        for (int i=1;i<8;i++){
            if(inBoard(u-i,v)){
            if(isSameColor(X,u-i,v)){break;}
            x.add(new ChessboardPoint(u-i,v));
            if(isOppositeColor(X,u-i,v)){break;}}
        }
        for (int i=1;i<8;i++){
            if(inBoard(u,v+i)){
            if(isSameColor(X,u,v+i)){break;}
            x.add(new ChessboardPoint(u,v+i));
            if(isOppositeColor(X,u,v+i)){break;}}
        }
        for (int i=1;i<8;i++){
            if(inBoard(u,v-i)){
            if(isSameColor(X,u,v-i)){break;}
            x.add(new ChessboardPoint(u,v-i));
            if(isOppositeColor(X,u,v-i)){break;}}
        }
        for (int i=1;i<8;i++){
            if(inBoard(u+i,v+i)){
            if(isSameColor(X,u+i,v+i)){break;}
            x.add(new ChessboardPoint(u+i,v+i));
            if(isOppositeColor(X,u+i,v+i)){break;}}
        }
        for (int i=1;i<8;i++){
            if(inBoard(u+i,v-i)){
            if(isSameColor(X,u+i,v-i)){break;}
            x.add(new ChessboardPoint(u+i,v-i));
            if(isOppositeColor(X,u+i,v-i)){break;}}
        }
        for (int i=1;i<8;i++){
            if(inBoard(u-i,v+i)){
            if(isSameColor(X,u-i,v+i)){break;}
            x.add(new ChessboardPoint(u-i,v+i));
            if(isOppositeColor(X,u-i,v+i)){break;}}
        }
        for (int i=1;i<8;i++){
            if(inBoard(u-i,v-i)){
            if(isSameColor(X,u-i,v-i)){break;}
            x.add(new ChessboardPoint(u-i,v-i));
            if(isOppositeColor(X,u-i,v-i)){break;}}
        }
        return x;
    }

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }
}
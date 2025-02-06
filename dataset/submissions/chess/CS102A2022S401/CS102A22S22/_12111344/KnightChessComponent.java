import java.util.ArrayList;
import java.util.List;
public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor chessColor,ChessboardPoint source,char name){
        super(chessColor,source,name);
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> canMoveTo=new ArrayList<ChessboardPoint>();
        if(source.getX()+1<8&&source.getY()+2<8){
            if(!ConcreteChessGame.chessComponent[source.getX()+1][source.getY()+2].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor)){
                canMoveTo.add(new ChessboardPoint(source.getX()+1,source.getY()+2));}
        }
        if(source.getX()+2<8&&source.getY()+1<8){
            if(!ConcreteChessGame.chessComponent[source.getX()+2][source.getY()+1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor)){
                canMoveTo.add(new ChessboardPoint(source.getX()+2,source.getY()+1));}
        }
        if(source.getX()-1>=0&&source.getY()+2<8){
            if(!ConcreteChessGame.chessComponent[source.getX()-1][source.getY()+2].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor)){
                canMoveTo.add(new ChessboardPoint(source.getX()-1,source.getY()+2));}
        }
        if(source.getX()+2<8&&source.getY()-1>=0){
            if(!ConcreteChessGame.chessComponent[source.getX()+2][source.getY()-1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor)){
                canMoveTo.add(new ChessboardPoint(source.getX()+2,source.getY()-1));}
        }
        if(source.getX()-2>=0&&source.getY()-1>=0){
            if(!ConcreteChessGame.chessComponent[source.getX()-2][source.getY()-1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor)){
                canMoveTo.add(new ChessboardPoint(source.getX()-2,source.getY()-1));}
        }
        if(source.getX()-1>=0&&source.getY()-2>=0){
            if(!ConcreteChessGame.chessComponent[source.getX()-1][source.getY()-2].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor)){
                canMoveTo.add(new ChessboardPoint(source.getX()-1,source.getY()-2));}
        }
        if(source.getX()-2>=0&&source.getY()+1<8){
            if(!ConcreteChessGame.chessComponent[source.getX()-2][source.getY()+1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor)){
                canMoveTo.add(new ChessboardPoint(source.getX()-2,source.getY()+1));}
        }
        if(source.getX()+1<8&&source.getY()-2>=0){
            if(!ConcreteChessGame.chessComponent[source.getX()+1][source.getY()-2].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor)){
                canMoveTo.add(new ChessboardPoint(source.getX()+1,source.getY()-2));}
        }
        return canMoveTo;}
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }


}

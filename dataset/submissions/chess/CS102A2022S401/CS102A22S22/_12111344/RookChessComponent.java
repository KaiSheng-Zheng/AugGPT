import java.util.ArrayList;
import java.util.List;
public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessColor chessColor,ChessboardPoint source,char name){
        super(chessColor,source,name);
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> canMoveTo=new ArrayList<ChessboardPoint>();
        for(int i=1;i<8;i++){
            if(source.getX()+i<8&&source.getY()<8){
                if(!ConcreteChessGame.chessComponent[source.getX()+i][source.getY()].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor)){
                    canMoveTo.add(new ChessboardPoint(source.getX()+i,source.getY()));}
                if(!ConcreteChessGame.chessComponent[source.getX()+i][source.getY()].chessColor.equals(ChessColor.NONE)){break;}
            }else{break;}
        }
        for(int i=1;i<8;i++){
            if(source.getX()<8&&source.getY()+i<8){
                if(!ConcreteChessGame.chessComponent[source.getX()][source.getY()+i].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor)){
                    canMoveTo.add(new ChessboardPoint(source.getX(),source.getY()+i));}
                if(!ConcreteChessGame.chessComponent[source.getX()][source.getY()+i].chessColor.equals(ChessColor.NONE)){break;}
            }else{break;}
        }
        for(int i=1;i<8;i++){
            if(source.getX()-i>=0&&source.getY()>=0){
                if(!ConcreteChessGame.chessComponent[source.getX()-i][source.getY()].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor)){
                    canMoveTo.add(new ChessboardPoint(source.getX()-i,source.getY()));}
                if(!ConcreteChessGame.chessComponent[source.getX()-i][source.getY()].chessColor.equals(ChessColor.NONE)){break;}
            }else{break;}
        }
        for(int i=1;i<8;i++){
            if(source.getX()>=0&&source.getY()-i>=0){
                if(!ConcreteChessGame.chessComponent[source.getX()][source.getY()-i].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor)){
                    canMoveTo.add(new ChessboardPoint(source.getX(),source.getY()-i));}
                if(!ConcreteChessGame.chessComponent[source.getX()][source.getY()-i].chessColor.equals(ChessColor.NONE)){break;}
            }else{break;}
        }
        return canMoveTo;}
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}

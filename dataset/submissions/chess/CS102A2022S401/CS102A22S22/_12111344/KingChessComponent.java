import java.util.List;
import java.util.ArrayList;
public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessColor chessColor,ChessboardPoint source,char name){
        super(chessColor,source,name);
    }
    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> canMoveTo=new ArrayList<ChessboardPoint>();
        if(!(ConcreteChessGame.chessComponent[source.getX()][source.getY()].equals(ConcreteChessGame.chessComponent[7][source.getY()])&&!ConcreteChessGame.chessComponent[source.getX()][source.getY()].equals(ConcreteChessGame.chessComponent[0][source.getY()])&& !ConcreteChessGame.chessComponent[source.getX()][source.getX()].equals(ConcreteChessGame.chessComponent[source.getX()][0])&& !ConcreteChessGame.chessComponent[source.getX()][source.getY()].equals(ConcreteChessGame.chessComponent[source.getX()][7]) ) )
        {
            if (!ConcreteChessGame.chessComponent[source.getX() + 1][source.getY()].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
            canMoveTo.add(new ChessboardPoint(source.getX()+1,source.getY()));}
            if (!ConcreteChessGame.chessComponent[source.getX()][source.getY()+1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX(),source.getY()+1));}
            if (!ConcreteChessGame.chessComponent[source.getX()+1][source.getY()+1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()+1,source.getY()+1));}
            if (!ConcreteChessGame.chessComponent[source.getX()-1][source.getY()].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()-1,source.getY()));}
            if (!ConcreteChessGame.chessComponent[source.getX()][source.getY()-1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX(),source.getY()-1));}
            if (!ConcreteChessGame.chessComponent[source.getX()-1][source.getY()-1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()-1,source.getY()-1));}
            if (!ConcreteChessGame.chessComponent[source.getX()+1][source.getY()-1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()+1,source.getY()-1));}
            if (!ConcreteChessGame.chessComponent[source.getX()-1][source.getY()+1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()-1,source.getY()+1));}

        }
        if(ConcreteChessGame.chessComponent[source.getX()][source.getY()].equals(ConcreteChessGame.chessComponent[7][source.getY()])&!ConcreteChessGame.chessComponent[source.getX()][source.getY()].equals(ConcreteChessGame.chessComponent[7][7])&!ConcreteChessGame.chessComponent[source.getX()][source.getY()].equals(ConcreteChessGame.chessComponent[7][0])){
            if (!ConcreteChessGame.chessComponent[source.getX()][source.getY()+1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX(),source.getY()+1));}
            if (!ConcreteChessGame.chessComponent[source.getX()-1][source.getY()].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()-1,source.getY()));}
            if (!ConcreteChessGame.chessComponent[source.getX()][source.getY()-1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX(),source.getY()-1));}
            if (!ConcreteChessGame.chessComponent[source.getX()-1][source.getY()-1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()-1,source.getY()-1));}
            if (!ConcreteChessGame.chessComponent[source.getX()-1][source.getY()+1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()-1,source.getY()+1));}
        }
        if(ConcreteChessGame.chessComponent[source.getX()][source.getY()].equals(ConcreteChessGame.chessComponent[source.getX()][7])&!ConcreteChessGame.chessComponent[source.getX()][source.getY()].equals(ConcreteChessGame.chessComponent[7][7])&!ConcreteChessGame.chessComponent[source.getX()][source.getY()].equals(ConcreteChessGame.chessComponent[0][7])) {
            if (!ConcreteChessGame.chessComponent[source.getX() + 1][source.getY()].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()+1,source.getY()));}
            if (!ConcreteChessGame.chessComponent[source.getX()-1][source.getY()].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()-1,source.getY()));}
            if (!ConcreteChessGame.chessComponent[source.getX()][source.getY()-1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX(),source.getY()-1));}
            if (!ConcreteChessGame.chessComponent[source.getX()-1][source.getY()-1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()-1,source.getY()-1));}
            if (!ConcreteChessGame.chessComponent[source.getX()+1][source.getY()-1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()+1,source.getY()-1));}
        }
        if(ConcreteChessGame.chessComponent[source.getX()][source.getY()].equals(ConcreteChessGame.chessComponent[source.getX()][0])&!ConcreteChessGame.chessComponent[source.getX()][source.getY()].equals(ConcreteChessGame.chessComponent[7][0])&!ConcreteChessGame.chessComponent[source.getX()][source.getY()].equals(ConcreteChessGame.chessComponent[0][0])) {
            if (!ConcreteChessGame.chessComponent[source.getX() + 1][source.getY()].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()+1,source.getY()));}
            if (!ConcreteChessGame.chessComponent[source.getX()][source.getY()+1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX(),source.getY()+1));}
            if (!ConcreteChessGame.chessComponent[source.getX()+1][source.getY()+1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()+1,source.getY()+1));}
            if (!ConcreteChessGame.chessComponent[source.getX()-1][source.getY()].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()-1,source.getY()));}
            if (!ConcreteChessGame.chessComponent[source.getX()-1][source.getY()+1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()-1,source.getY()+1));}
        }
        if(ConcreteChessGame.chessComponent[source.getX()][source.getY()].equals(ConcreteChessGame.chessComponent[0][source.getY()])&!ConcreteChessGame.chessComponent[source.getX()][source.getY()].equals(ConcreteChessGame.chessComponent[0][0])&!ConcreteChessGame.chessComponent[source.getX()][source.getY()].equals(ConcreteChessGame.chessComponent[0][7])) {
            if (!ConcreteChessGame.chessComponent[source.getX() + 1][source.getY()].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()+1,source.getY()));}
            if (!ConcreteChessGame.chessComponent[source.getX()][source.getY()+1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX(),source.getY()+1));}
            if (!ConcreteChessGame.chessComponent[source.getX()+1][source.getY()+1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()+1,source.getY()+1));}
            if (!ConcreteChessGame.chessComponent[source.getX()][source.getY()-1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX(),source.getY()-1));}
            if (!ConcreteChessGame.chessComponent[source.getX()+1][source.getY()-1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()+1,source.getY()-1));}
        }
        if(ConcreteChessGame.chessComponent[source.getX()][source.getY()].equals(ConcreteChessGame.chessComponent[0][0])){
            if (!ConcreteChessGame.chessComponent[source.getX() + 1][source.getY()].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()+1,source.getY()));}
            if (!ConcreteChessGame.chessComponent[source.getX()][source.getY()+1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX(),source.getY()+1));}
            if (!ConcreteChessGame.chessComponent[source.getX()+1][source.getY()+1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()+1,source.getY()+1));}
        }
        if(ConcreteChessGame.chessComponent[source.getX()][source.getY()].equals(ConcreteChessGame.chessComponent[7][7])){
            if (!ConcreteChessGame.chessComponent[source.getX()-1][source.getY()].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()-1,source.getY()));}
            if (!ConcreteChessGame.chessComponent[source.getX()][source.getY()-1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX(),source.getY()-1));}
            if (!ConcreteChessGame.chessComponent[source.getX()-1][source.getY()-1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()-1,source.getY()-1));}
        }
        if(ConcreteChessGame.chessComponent[source.getX()][source.getY()].equals(ConcreteChessGame.chessComponent[7][0])){
            if (!ConcreteChessGame.chessComponent[source.getX()][source.getY()+1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX(),source.getY()+1));}
            if (!ConcreteChessGame.chessComponent[source.getX()-1][source.getY()].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()-1,source.getY()));}
            if (!ConcreteChessGame.chessComponent[source.getX()-1][source.getY()+1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()-1,source.getY()+1));}
        }
        if(ConcreteChessGame.chessComponent[source.getX()][source.getY()].equals(ConcreteChessGame.chessComponent[0][7])){
            if (!ConcreteChessGame.chessComponent[source.getX() + 1][source.getY()].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()+1,source.getY()));}
            if (!ConcreteChessGame.chessComponent[source.getX()][source.getY()-1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX(),source.getY()-1));}
            if (!ConcreteChessGame.chessComponent[source.getX()+1][source.getY()-1].chessColor.equals(ConcreteChessGame.chessComponent[source.getX()][source.getY()].chessColor) ){
                canMoveTo.add(new ChessboardPoint(source.getX()+1,source.getY()-1));}
        }return canMoveTo;}
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}

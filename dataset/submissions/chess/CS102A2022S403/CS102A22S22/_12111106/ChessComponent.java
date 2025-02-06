import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public ChessComponent(){}

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }
}

class KingChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> can = new ArrayList<>();
        if(getChessColor()==ChessColor.BLACK){
            if(new ChessboardPoint(getSource().getX(),getSource().getY()).can(-1,-1) ){
                if(!(ConcreteChessGame.chess[getSource().getX()-1][getSource().getY()-1].getChessColor()==ChessColor.BLACK))
                can.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
            }
            if(new ChessboardPoint(getSource().getX(),getSource().getY()).can(-1,0) ){
                if(!(ConcreteChessGame.chess[getSource().getX()-1][getSource().getY()].getChessColor()==ChessColor.BLACK))
                can.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
            }
            if(new ChessboardPoint(getSource().getX(),getSource().getY()).can(-1,1) ){
                if(!(ConcreteChessGame.chess[getSource().getX()-1][getSource().getY()-1].getChessColor()==ChessColor.BLACK))
                can.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
            }
            if(new ChessboardPoint(getSource().getX(),getSource().getY()).can(0,-1) ){
                if(!(ConcreteChessGame.chess[getSource().getX()][getSource().getY()-1].getChessColor()==ChessColor.BLACK))
                can.add(new ChessboardPoint(getSource().getX(),getSource().getY()-1));
            }
            if(new ChessboardPoint(getSource().getX(),getSource().getY()).can(0,1)){
                if(!(ConcreteChessGame.chess[getSource().getX()][getSource().getY()+1].getChessColor()==ChessColor.BLACK))
                can.add(new ChessboardPoint(getSource().getX(),getSource().getY()+1));
            }
            if(new ChessboardPoint(getSource().getX(),getSource().getY()).can(1,-1) ){
                if(!(ConcreteChessGame.chess[getSource().getX()+1][getSource().getY()-1].getChessColor()==ChessColor.BLACK))
                can.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
            }
            if(new ChessboardPoint(getSource().getX(),getSource().getY()).can(1,0)){
                if(!(ConcreteChessGame.chess[getSource().getX()+1][getSource().getY()].getChessColor()==ChessColor.BLACK))
                can.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
            }
            if(new ChessboardPoint(getSource().getX(),getSource().getY()).can(1,1) ){
                if(!(ConcreteChessGame.chess[getSource().getX()+1][getSource().getY()+1].getChessColor()==ChessColor.BLACK))
                can.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
            }
        }else {
            if(new ChessboardPoint(getSource().getX(),getSource().getY()).can(-1,-1)){
                if(!(ConcreteChessGame.chess[getSource().getX()-1][getSource().getY()-1].getChessColor()==ChessColor.WHITE))
                can.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
            }
            if(new ChessboardPoint(getSource().getX(),getSource().getY()).can(-1,0)  ){
                if(!(ConcreteChessGame.chess[getSource().getX()-1][getSource().getY()].getChessColor()==ChessColor.WHITE))
                can.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
            }
            if(new ChessboardPoint(getSource().getX(),getSource().getY()).can(-1,1)  ){
                if(!(ConcreteChessGame.chess[getSource().getX()-1][getSource().getY()+1].getChessColor()==ChessColor.WHITE))
                can.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
            }
            if(new ChessboardPoint(getSource().getX(),getSource().getY()).can(0,-1) ){
                if(!(ConcreteChessGame.chess[getSource().getX()][getSource().getY()-1].getChessColor()==ChessColor.WHITE))
                can.add(new ChessboardPoint(getSource().getX(),getSource().getY()-1));
            }
            if(new ChessboardPoint(getSource().getX(),getSource().getY()).can(0,1) ){
                if(!(ConcreteChessGame.chess[getSource().getX()][getSource().getY()+1].getChessColor()==ChessColor.WHITE))
                can.add(new ChessboardPoint(getSource().getX(),getSource().getY()+1));
            }
            if(new ChessboardPoint(getSource().getX(),getSource().getY()).can(1,-1) ){
                if(!(ConcreteChessGame.chess[getSource().getX()+1][getSource().getY()-1].getChessColor()==ChessColor.WHITE))
                can.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
            }
            if(new ChessboardPoint(getSource().getX(),getSource().getY()).can(1,0) ){
                if(!(ConcreteChessGame.chess[getSource().getX()+1][getSource().getY()].getChessColor()==ChessColor.WHITE))
                can.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
            }
            if(new ChessboardPoint(getSource().getX(),getSource().getY()).can(1,1) ){
                if(!(ConcreteChessGame.chess[getSource().getX()+1][getSource().getY()+1].getChessColor()==ChessColor.WHITE))
                can.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
            }
        }
        return can;
    }
}

class QueenChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}

class RookChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}

class BishopChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}

class KnightChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}

class PawnChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}

class EmptySlotComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}

import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public char getName() {
        return name;
    }

    @Override
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public ChessboardPoint getSource() {
        return source;
    }

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        this.name=name;
        this.source=source;
        this.chessColor=chessColor;
    }
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMoveTo=new ArrayList<ChessboardPoint>();
        if (getChessColor()==ChessColor.WHITE){
            if (source.offset(-1,0)!=null&&ConcreteChessGame.getStaticChessColor(source.offset(-1,0))==ChessColor.NONE){
                canMoveTo.add(source.offset(-1,0));
                if (source.offset(-2,0)!=null&&ConcreteChessGame.getStaticChessColor(source.offset(-2,0))==ChessColor.NONE&&getSource().getX()==6){
                    canMoveTo.add(source.offset(-2, 0));
                }
            }
            if (source.offset(-1,1)!=null&&ConcreteChessGame.getStaticChessColor(source.offset(-1,1))==ChessColor.BLACK){
                canMoveTo.add(source.offset(-1,1));
            }
            if (source.offset(-1,-1)!=null&&ConcreteChessGame.getStaticChessColor(source.offset(-1,-1))==ChessColor.BLACK){
                canMoveTo.add(source.offset(-1,-1));
            }
        }
        if (getChessColor()==ChessColor.BLACK) {
            if (source.offset(1,0)!=null&&ConcreteChessGame.getStaticChessColor(source.offset(1,0))==ChessColor.NONE){
                canMoveTo.add(source.offset(1,0));
                if (source.offset(2,0)!=null&&ConcreteChessGame.getStaticChessColor(source.offset(2,0))==ChessColor.NONE&&getSource().getX()==1){
                    canMoveTo.add(source.offset(2, 0));
                }
            }
            if (source.offset(1,1)!=null&&ConcreteChessGame.getStaticChessColor(source.offset(1,1))==ChessColor.WHITE){
                canMoveTo.add(source.offset(1,1));
            }
            if (source.offset(1,-1)!=null&&ConcreteChessGame.getStaticChessColor(source.offset(1,-1))==ChessColor.WHITE){
                canMoveTo.add(source.offset(1,-1));
            }
        }
        return canMoveTo;
    }
}
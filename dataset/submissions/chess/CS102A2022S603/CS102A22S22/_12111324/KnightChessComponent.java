import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
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

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        this.name=name;
        this.source=source;
        this.chessColor=chessColor;
    }
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMoveTo=new ArrayList<ChessboardPoint>();
        if (source.offset(1,2)!=null&&ConcreteChessGame.getStaticChessColor(source.offset(1,2))!=getChessColor())
            canMoveTo.add(source.offset(1,2));
        if (source.offset(2,1)!=null&&ConcreteChessGame.getStaticChessColor(source.offset(2,1))!=getChessColor())
            canMoveTo.add(source.offset(2,1));
        if (source.offset(-1,2)!=null&&ConcreteChessGame.getStaticChessColor(source.offset(-1,2))!=getChessColor())
            canMoveTo.add(source.offset(-1,2));
        if (source.offset(2,-1)!=null&&ConcreteChessGame.getStaticChessColor(source.offset(2,-1))!=getChessColor())
            canMoveTo.add(source.offset(2,-1));
        if (source.offset(1,-2)!=null&&ConcreteChessGame.getStaticChessColor(source.offset(1,-2))!=getChessColor())
            canMoveTo.add(source.offset(1,-2));
        if (source.offset(-2,1)!=null&&ConcreteChessGame.getStaticChessColor(source.offset(-2,1))!=getChessColor())
            canMoveTo.add(source.offset(-2,1));
        if (source.offset(-1,-2)!=null&&ConcreteChessGame.getStaticChessColor(source.offset(-1,-2))!=getChessColor())
            canMoveTo.add(source.offset(-1,-2));
        if (source.offset(-2,-1)!=null&&ConcreteChessGame.getStaticChessColor(source.offset(-2,-1))!=getChessColor())
            canMoveTo.add(source.offset(-2,-1));
        return canMoveTo;
    }
}

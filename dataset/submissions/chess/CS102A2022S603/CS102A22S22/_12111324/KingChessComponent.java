import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
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
    public ChessboardPoint getSource() {
        return source;
    }

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        this.name=name;
        this.source=source;
        this.chessColor=chessColor;
    }
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMoveTo=new ArrayList<ChessboardPoint>();
        if (source.offset(1,0)!=null&&ConcreteChessGame.getStaticChessColor(source.offset(1,0))!=getChessColor())
            canMoveTo.add(source.offset(1,0));
        if (source.offset(0,1)!=null&&ConcreteChessGame.getStaticChessColor(source.offset(0,1))!=getChessColor())
            canMoveTo.add(source.offset(0,1));
        if (source.offset(-1,0)!=null&&ConcreteChessGame.getStaticChessColor(source.offset(-1,0))!=getChessColor())
            canMoveTo.add(source.offset(-1,0));
        if (source.offset(0,-1)!=null&&ConcreteChessGame.getStaticChessColor(source.offset(0,-1))!=getChessColor())
            canMoveTo.add(source.offset(0,-1));
        if (source.offset(1,1)!=null&&ConcreteChessGame.getStaticChessColor(source.offset(1,1))!=getChessColor())
            canMoveTo.add(source.offset(1,1));
        if (source.offset(1,-1)!=null&&ConcreteChessGame.getStaticChessColor(source.offset(1,-1))!=getChessColor())
            canMoveTo.add(source.offset(1,-1));
        if (source.offset(-1,-1)!=null&&ConcreteChessGame.getStaticChessColor(source.offset(-1,-1))!=getChessColor())
            canMoveTo.add(source.offset(-1,-1));
        if (source.offset(-1,1)!=null&&ConcreteChessGame.getStaticChessColor(source.offset(-1,1))!=getChessColor())
            canMoveTo.add(source.offset(-1,1));
        return canMoveTo;
    }
}

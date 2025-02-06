import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public char getName() {
        return name;
    }

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public ChessboardPoint getSource() {
        return source;
    }

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        this.name=name;
        this.source=source;
        this.chessColor=chessColor;
    }

    @Override
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canMoveTo = new ArrayList<ChessboardPoint>();
        ChessboardPoint target;
        for (int i=1;source.offset(i,0)!=null;i++){
            if (ConcreteChessGame.getStaticChessColor(source.offset(i,0))!=getChessColor()) {
                target = source.offset(i, 0);
                canMoveTo.add(target);
                if (ConcreteChessGame.getStaticChessColor(source.offset(i,0))!=ChessColor.NONE)
                    break;
            }else break;
        }
        for (int i=1;source.offset(0,i)!=null;i++){
            if (ConcreteChessGame.getStaticChessColor(source.offset(0,i))!=getChessColor()) {
                target = source.offset(0, i);
                canMoveTo.add(target);
                if (ConcreteChessGame.getStaticChessColor(source.offset(0,i))!=ChessColor.NONE)
                    break;
            }else break;
        }
        for (int i=1;source.offset(-i,0)!=null;i++){
            if (ConcreteChessGame.getStaticChessColor(source.offset(-i,0))!=getChessColor()) {
                target = source.offset(-i, 0);
                canMoveTo.add(target);
                if (ConcreteChessGame.getStaticChessColor(source.offset(-i,0))!=ChessColor.NONE)
                    break;
            }else break;
        }
        for (int i=1;source.offset(0,-i)!=null;i++){
            if (ConcreteChessGame.getStaticChessColor(source.offset(0,-i))!=getChessColor()) {
                target = source.offset(0,-i);
                canMoveTo.add(target);
                if (ConcreteChessGame.getStaticChessColor(source.offset(0,-i))!=ChessColor.NONE)
                    break;
            }else break;
        }
        return canMoveTo;
    }
}

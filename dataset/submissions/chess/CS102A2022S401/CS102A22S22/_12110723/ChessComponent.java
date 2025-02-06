import java.util.List;

public abstract class ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;

    public ChessComponent(){}

    public abstract List<ChessboardPoint> canMoveTo();

    public void setChessComponents(ChessComponent[][] chessComponent){
        this.chessComponents=chessComponent;
    }

    @Override
    public String toString() {
        return null;
    }

    public ChessColor getChessColor(){return chessColor;}

    public void setS(int x,int y){};

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChessComponent that = (ChessComponent) o;

        return source.equals(that.source);
    }

    @Override
    public int hashCode() {
        return source.hashCode();
    }
}

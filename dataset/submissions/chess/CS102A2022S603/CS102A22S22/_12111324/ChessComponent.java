import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public char getName() {
        return name;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessComponent(){}

    public abstract List<ChessboardPoint> canMoveTo();

    public String toString(){
        StringBuilder result=new StringBuilder();
        result.append(getName());
        return result.toString();
    }
}

import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source=new ChessboardPoint(0,0);
    private ChessColor chessColor=ChessColor.NONE;
    protected char name;
    protected ConcreteChessGame g;
    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }



    public ChessboardPoint getSource() {
        return source;
    }


    public ChessComponent(){;}

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public abstract List<ChessboardPoint> canMoveTo();


    public char getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
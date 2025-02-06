import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private int power;

    //should design
    public ChessComponent(){}

    public ChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor,char name){
        source=chessboardPoint;this.chessColor=chessColor;this.name=name;
    }

    // should design
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

    public char getName() {
        return name;
    }

    public int getPower(){
        return 0;
    }
}

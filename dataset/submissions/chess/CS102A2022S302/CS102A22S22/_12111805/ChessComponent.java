import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public ChessComponent(){}

    public void setChessColor(ChessColor chessColor) {this.chessColor = chessColor;}
    public void setSource(ChessboardPoint source) {this.source = source;}
    public void setName(char name) {this.name = name;}

    public ChessColor getChessColor() {return chessColor;}
    public ChessboardPoint getSource() {return source;}
    public char getName() {return name;}

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
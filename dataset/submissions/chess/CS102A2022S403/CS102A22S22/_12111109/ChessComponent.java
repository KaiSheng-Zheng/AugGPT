import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public ChessComponent(){
    }
    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    public void setSource(ChessboardPoint source){
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setName(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }
    public void setC(ChessComponent[][] c){

    }
}

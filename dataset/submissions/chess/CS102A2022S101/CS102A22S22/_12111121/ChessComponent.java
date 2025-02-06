import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor = ChessColor.WHITE;
    protected char name ='_';
    public ChessComponent() {
    }
    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    public void setName(char a) {
        this.name = a;
    }
    public void setchessColor(ChessColor a) {
        this.chessColor = a;
    }
    public void setSource(int x,int y) {
        this.source = new ChessboardPoint(x,y);
    }
    public ChessboardPoint getSource() {
        return source;
    }
    public ChessColor getChessColor() {
        return chessColor;
    }
    public void setQP(ChessComponent[][] chessComponent){

    }
}

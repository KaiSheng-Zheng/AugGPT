import java.util.List;

public abstract class ChessComponent {
    protected ChessboardPoint source;
    protected ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;
    protected int cnt=1;
    public ChessComponent(){}
    public abstract List<ChessboardPoint> canMoveTo();

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getCnt() {
        return cnt;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setName(char name) {
        this.name = name;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
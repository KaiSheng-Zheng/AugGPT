import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;

    public ChessComponent(){};

    public ChessComponent(int x, int y , ChessColor chessColor, char name, ChessComponent[][] chessboard){
        this.source = new ChessboardPoint(x, y);
        this.chessColor = chessColor;
        this.name = name;
        this.chessboard = chessboard;
    };

    public abstract List<ChessboardPoint> canMoveTo();

    public boolean ableToMoveTo(ChessComponent b){
        return false;
    }

    public String toString(){
        return String.valueOf(this.name);
    }

    public void setName(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessComponent[][] getChessboard() {
        return chessboard;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
}

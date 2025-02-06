import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;
    public ChessComponent() {
    }

    public ChessComponent[][] getChessboard() {
        return chessboard;
    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    public boolean ss(ChessComponent[][] chessboard, ChessboardPoint destination) {
        return true;
    }

    public ChessboardPoint getSource() {
        return source;
    }
    public boolean samecolor(ChessColor s1,ChessColor s2){
        return s1==s2;
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

    public void setName(char name) {
        this.name = name;
    }

    public abstract List<ChessboardPoint> canMoveTo();



        public String toString() {
            return String.valueOf(this.name);
        }

}

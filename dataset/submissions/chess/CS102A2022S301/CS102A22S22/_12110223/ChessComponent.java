import java.util.List;

public abstract class ChessComponent<chees> {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;  // What's the color
    protected char name;			// What's the name
    protected ChessComponent[][]chees=new ChessComponent[8][8];


    public void setChees(ChessComponent[][]p) {
       chees=p;
    }

    public ChessComponent getChees(int f,int k) {
        return chees[f][k];
    }

    public ChessComponent(){
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

    public void setName(char name) {
        this.name = name;
    }

    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}

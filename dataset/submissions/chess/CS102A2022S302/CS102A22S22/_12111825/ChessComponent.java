import java.util.List;
public abstract class ChessComponent {
    private ChessboardPoint source; // Where the chess is set
    private ChessColor chessColor; // What's the color
    protected char name; // What's the name
    protected ChessComponent[][] chessboard;


    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
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

    public void setName(char name) {
        this.name = name;
    }

    public  char getName(){
     return name;
    }

    public  ChessComponent(){}

    public ChessComponent getChess(int x, int y) {
        if (x>=0&&x<=7&&y>=0&&y<=7){
        return chessboard[x][y];}
        else return null;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}

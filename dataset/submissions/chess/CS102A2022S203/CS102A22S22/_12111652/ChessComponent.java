import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    protected char name;
    protected ChessComponent chessComponent[][];
    public ChessComponent(){

    }
    public ChessComponent(int x,int y,ChessColor color){
source=new ChessboardPoint(x,y);
chessColor=color;
    }
    public ChessboardPoint getSource() {
        return source;
    }


    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setChessComponent(ChessComponent[][] chessComponent) {
        this.chessComponent = chessComponent;
    }

    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public char getName() {
        return name;
    }
}


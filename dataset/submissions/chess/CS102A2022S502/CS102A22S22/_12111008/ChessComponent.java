import java.util.List;

public abstract class ChessComponent {

    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessBoard;
    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }


    public void setChessBoard(ChessComponent[][] chessBoard) {
        this.chessBoard = chessBoard;
    }


    public ChessComponent(char name) {this.name=name;}

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessComponent(){};

    public abstract List<ChessboardPoint> canMoveTo();

    public void setSource(int x, int y){source.setX(x);source.setY(y);}
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}


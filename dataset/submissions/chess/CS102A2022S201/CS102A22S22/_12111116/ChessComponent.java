import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source = new ChessboardPoint(0, 0);
    private ChessColor chessColor;
    protected char name;
    public int x;
    public int y;
    protected ChessComponent[][] chessboard;
    public ChessComponent(){

    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessComponent(ChessColor chessColor, ChessboardPoint chessboardPoint, char name){
        this.name=name;
        this.chessColor=chessColor;
        this.source=chessboardPoint;

    }

    public void setChessboard(ChessComponent[][] chessboard, ChessColor a){
        this.chessboard=chessboard;
        this.chessColor=a;
    }
    public void setChessboard(ChessComponent[][] chessboard, ChessColor a, char name, ChessboardPoint chessboardPoint){
        this.name=name;
        this.chessboard=chessboard;
        this.chessColor=a;
        this.source=chessboardPoint;
    }
    public void setChessboard(ChessComponent[][] chessboard, ChessColor a, char name){
        this.name=name;
        this.chessboard=chessboard;
        this.chessColor=a;
    }

    public char getName(){return name;}
    public ChessComponent getChess(int x, int y) {
        return chessboard[x][y];
    }
    public ChessColor getChessColor(){return chessColor;}
    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}


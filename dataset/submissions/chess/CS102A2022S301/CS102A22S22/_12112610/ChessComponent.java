import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;

    //should design


    public ChessComponent() {}
    public ChessComponent(char c,ChessColor chessColor,ChessboardPoint chessboardPoint,ChessComponent[][] chessComponents){
        name = c;
        this.chessColor = chessColor;
        this.source = chessboardPoint;
        this.chessboard = chessComponents;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    public  ChessColor getChessColor;

    public  void setSetChessColor(ChessColor setChessColor) {
        this.chessColor = chessColor;
    }

    public void setX(int i) {

    }

    public char getName() {
        return name;
    }

    public void setY(int j) {
    }
public  void  setChessboard(ChessComponent[][] chessboard){this.chessboard = chessboard;}
    public ChessComponent[][] getChessboard(){return chessboard;}
    public void setSource(ChessboardPoint r) {
        this.source = source;
    }
    public ChessboardPoint getSource(){
        return source;
    }


    public ChessColor getChessColor() {
        return chessColor;
    }
}
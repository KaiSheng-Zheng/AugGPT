import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;

    //should design
    public ChessComponent(){}

    public void setChessBoard(ChessComponent[][] chessboard){
        this.chessboard = chessboard;
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
    public boolean withinBoard(int x , int y){
        if(x >= 0 && x <= 7 && y >= 0 && y <= 7 ){
            return true;
        }
        return false;
    }
    public boolean isOurChess(int x, int y){
        if(chessboard[x][y].getChessColor() != chessboard[source.getX()][source.getY()].getChessColor() )
            return true;
        return false;
    }
    public char getName(){
        return this.name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor(){
        return this.chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }
}

import java.util.List;

public abstract class ChessComponent implements Cloneable{
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard=new ChessComponent[8][8];

    public boolean onBoard(int x,int y){
        if(x<8&&x>=0&&y<8&&y>=0){
            return true;
        }else return false;
    }
    public ChessColor getColor(int x,int y){
        return chessboard[x][y].getChessColor();
    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public char getName() {
        return name;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessComponent(){}

    public ChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor){}

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}

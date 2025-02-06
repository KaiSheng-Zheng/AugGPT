import java.util.*;
public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public ChessComponent(){};
    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    public ChessboardPoint getChessboardPoint(){
        return this.source;
    }
    public ChessColor getChessColor(){
        return this.chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
    protected static Boolean isOutOfBound(int x, int y){
        if((x>0||x==0) && x<8 && (y>0||y==0) && y<8){
            return false;
        }else {
            return true;
        }
    }
}

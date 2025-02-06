import java.util.*;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public void setChessColor(ChessColor chessColor){
        this.chessColor=chessColor;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessComponent(){}

    public abstract List<ChessboardPoint> canMoveTo();

    public String toString(){
        return String.valueOf(this.name);
    }
}


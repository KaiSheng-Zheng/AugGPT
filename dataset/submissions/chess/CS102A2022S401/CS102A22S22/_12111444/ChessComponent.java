
import java.util.List;

public abstract class ChessComponent {
    ChessboardPoint source;
    ChessColor chessColor;
    protected char name;
    public ChessComponent(){
    }
    public void setName(){
        this.name = name;
    }

    public char getName() {
        return name;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessboardPoint getSource(){
        return source;
    }

    public void setChessColor(ChessColor chessColor){
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public abstract List<ChessboardPoint> canMoveTo(); //method
    @Override
    public String toString(){
        return String.valueOf(this.name);
    }
}
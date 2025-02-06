import java.util.ArrayList;
import java.util.List;
public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected static ChessComponent[][] chessComponents;
    protected static ChessColor color;
    protected static ChessboardPoint chessboardPoint;
    public ChessComponent(){
    }
    public  ChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.chessColor=chessColor;
        this.source=source;
        this.name=name;
    }
    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }
}

import java.util.Arrays;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;


    public void loadChessGame(ChessComponent[][] chessComponents){
        this.chessComponents=chessComponents;
    }
    public ChessboardPoint getSource() {
        return source;
    }
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
    public ChessColor getChessColor() {
        return chessColor;
    }
    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
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

    //should design
    public ChessComponent(){}

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
    public boolean findNone(ChessColor a,ChessColor b){
        if (b == ChessColor.NONE){
            return true;
        }else{
            return false;
        }
    }
    public boolean findOpposite(ChessColor a,ChessColor b){
        if (a!=b&&a!=ChessColor.NONE&&b!=ChessColor.NONE){
            return true;
        }
        return false;
    }
    public boolean findSame(ChessColor a,ChessColor b){
        if (a == b){
            return true;
        }
        return false;
    }


}

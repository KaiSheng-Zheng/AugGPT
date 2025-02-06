import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    ChessComponent[][] chessComponents;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
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

    public ChessComponent(){
    }

    public ChessComponent(int x,int y,ChessColor chessColor,char name,ChessComponent[][] chessComponents){
        setSource(new ChessboardPoint(x,y));
        this.chessColor=chessColor;
        this.name=name;
        this.chessComponents=chessComponents;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    public String toString() {
        return String.valueOf(this.name);
    }

    protected ChessComponent[][] chessboard;

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }
}


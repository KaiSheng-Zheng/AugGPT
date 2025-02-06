import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    private static ChessComponent[][]chessComponents;
    protected char name;

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public static void setChessComponents(ChessComponent[][] chessComponents) {
        ChessComponent.chessComponents = chessComponents;
    }

    public static ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }
    public ChessColor getChessColor() {
        return chessColor;
    }
    public ChessComponent(){}
    public abstract List<ChessboardPoint> canMoveTo();
    public String toString(){
        return String.valueOf(this.name);
    }

    public void setName(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    public ChessboardPoint getSource() {
        return source;
    }
}


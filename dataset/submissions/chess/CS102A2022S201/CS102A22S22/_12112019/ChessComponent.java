

import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;

    public ChessComponent() {


    }

    public abstract List<ChessboardPoint> canMoveTo();

    public void setSource(int x, int y) {
        ChessboardPoint source = new ChessboardPoint(x, y);
        this.source = source;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public char getName() {
        return name;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setName(char name) {
        this.name = name;
    }


    public ChessColor getChessColor() {
        return chessColor;
    }
}
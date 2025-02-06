import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    protected ChessboardPoint source;
    protected ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;



    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name,ChessComponent[][] chessComponents) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
        this.chessComponents = chessComponents;
    }


    public ChessComponent() {
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}


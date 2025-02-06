import java.util.List;

public abstract class ChessComponent {
    //Variables
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    //Constructor
    public ChessComponent(){}
    
    public ChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.source = source;
        this.chessColor = chessColor;
    }

    public ChessComponent(ChessboardPoint source, char name) {
        this.source = source;
        this.name = name;
    }

    //Methods
    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    //Setters and Getters
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
}

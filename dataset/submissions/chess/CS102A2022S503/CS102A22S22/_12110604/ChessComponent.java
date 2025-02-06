import java.util.List;

public abstract class ChessComponent extends ConcreteChessGame{
    //should design
    public ChessboardPoint source;
    public ChessColor chessColor;
    public char name;


    //should design
    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public ChessboardPoint getSource() {
        return source;
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

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public void setSource(ChessboardPoint source) {
        this.source=source;
    }

}

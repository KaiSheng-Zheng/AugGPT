import java.util.List;

public abstract class ChessComponent {
    //should design TODO
    public ChessboardPoint source;
    public ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;

    //should design
    public ChessComponent(){}
    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
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

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public void setName(char name) {
        this.name = name;
    }

    /**
     * should design
     *
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);

    }

    public  ChessColor comChessColor(char name) {
        if (name >= 65 && name <= 90) {
            return ChessColor.BLACK;
        } else if (name <= 122 && name >= 97) {
            return ChessColor.WHITE;
        }else {
            return ChessColor.NONE;
        }
    }

}
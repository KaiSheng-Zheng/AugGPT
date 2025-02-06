import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name = '\0';
    public  int serialNumber=-1;
    private ChessComponent[][] chessComponents= new ChessComponent[8][8];

    //should design
    public ChessComponent(){
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public void setName(char name) {
        this.name = name;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public String getName() {
        return String.valueOf(name);
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(name);
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChessComponent)) return false;

        ChessComponent that = (ChessComponent) o;

        if (name != that.name) return false;
        return chessColor == that.chessColor;
    }

    @Override
    public int hashCode() {
        int result = chessColor != null ? chessColor.hashCode() : 0;
        result = 31 * result + (int) name;
        return result;
    }
}

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;// What's the color
    protected char name;//What's the name
    protected ChessComponent[][] chessboard;
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

    public char getName() {
        return name;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessComponent[][] getChessboard() {
        return chessboard;
    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

//    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
//        this.source = source;
//        this.chessColor = chessColor;
//        this.name = name;
//    }


    public void setName(char name) {
        this.name = name;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ChessComponent that = (ChessComponent) o;
//        return name == that.name && Objects.equals(source, that.source) && chessColor == that.chessColor && Arrays.equals(chessboard, that.chessboard);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = Objects.hash(source, chessColor, name);
//        result = 31 * result + Arrays.hashCode(chessboard);
//        return result;
//    }
}

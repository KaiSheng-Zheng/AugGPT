import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;  // What's the color
    protected char name;			// What's the name
    private  ChessboardPoint chessboardPoint;
    public   static ChessComponent[][] chessComponents1 ;

    public ChessComponent[][] getChessComponents() {
        return chessComponents1;
    }

    public static void setChessComponents(ChessComponent[][] chessComponents) {
        chessComponents1 = chessComponents;
    }

    public ChessComponent(){}

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


    public void setChessboardPoint(ChessboardPoint chessboardPoint) {
        this.chessboardPoint = chessboardPoint;
    }


    public ChessboardPoint getChessboardPoint() {
        return chessboardPoint;
    }

    public abstract List<ChessboardPoint> canMoveTo();


    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}

import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;  // What's the color
    protected char name;
    static ChessComponent[][] chessComponents = new ChessComponent[8][8];


    public void setSource(ChessboardPoint chessboardPoint) {
        this.source = chessboardPoint;
    }


    public void setChessComponent(int i, int j, ChessComponent chessComponent) {
        chessComponents[i][j] = chessComponent;
    }

    public ChessComponent() {
    }

    public void setChessColor(ChessColor color) {
        this.chessColor = color;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    public void setName(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void swapLocation(ChessComponent another) {
        ChessboardPoint chessboardPoint1 = getSource(), chessboardPoint2 = another.getSource();
        ChessboardPoint record = chessboardPoint2;
        chessboardPoint2 = chessboardPoint1;
        chessboardPoint1 = record;
        setSource(chessboardPoint1);
        another.setSource(chessboardPoint2);
    }







}
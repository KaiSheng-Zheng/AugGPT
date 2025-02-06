import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private int Status;
    private static int count;
    private static int Quantity;

    public static int getQuantity() {
        return Quantity;
    }

    public static void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        ChessComponent.count = count;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setName(char name) {
        this.name = name;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    //should design
    public ChessComponent(){count=0;}

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public char getName() {
        return name;
    }

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
}

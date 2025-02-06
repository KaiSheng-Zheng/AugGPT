import java.util.List;
public abstract class ChessComponent {
    protected ChessboardPoint source; // Where the chess is
    protected ChessColor chessColor; // What's the color
    protected char name; // What's the name
    protected ChessComponent[][] chessComponents;

    public ChessComponent(){}

    public abstract List<ChessboardPoint> canMoveTo();
    //If no ChessboardPoint can be moved to, return a reference of empty List instead of null.

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}

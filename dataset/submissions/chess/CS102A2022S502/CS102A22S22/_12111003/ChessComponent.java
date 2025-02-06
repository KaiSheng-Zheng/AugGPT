import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    protected char name; // What's the name
    public ChessComponent(char name) {this.name = name;}
    public ChessComponent(){}
    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {return String.valueOf(this.name);}
}

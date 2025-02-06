import java.util.List;

public abstract class ChessComponent {

    private ChessboardPoint source;// Where the chess is
    private ChessColor chessColor;// What's the color
    protected char name;// What's the name

    public ChessComponent() {
    }
    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }


    public abstract List<ChessboardPoint> canMoveTo();

    protected char getName(){
        return this.name;
    }

    public ChessboardPoint getSource() {
        return source;
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
        return String.valueOf(this.name);
    }




}

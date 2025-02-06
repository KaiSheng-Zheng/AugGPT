import java.util.List;

public abstract class ChessComponent {

    // did not use the field "source" completely, instead, the component all defines the field "point"
    // does not follow the instruction of inheritance.
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public ChessComponent(ChessboardPoint source,ChessColor chessColor){
        this.chessColor=chessColor;
        this.source=source;
    }
    public ChessComponent(){
    }
    public ChessColor getChessColor(){
        return chessColor;
    }
    public ChessboardPoint getSource(){
        return source;
    }
    public char getName(){
        return name;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    public String toString() {
        return String.valueOf(this.name);
    }
    public void moveTo(ChessboardPoint target) {}

}

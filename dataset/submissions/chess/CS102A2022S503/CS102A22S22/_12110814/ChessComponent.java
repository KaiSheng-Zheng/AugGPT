import java.util.List;

public abstract class ChessComponent {
    protected ChessboardPoint source;
    protected ChessColor chessColor;
    protected char name;

    protected ChessComponent[][] chessComponents;


    public ChessComponent(){
    }


    public abstract List<ChessboardPoint> canMoveTo();


    @Override
    public String toString() {
        return name + "";
    }
}

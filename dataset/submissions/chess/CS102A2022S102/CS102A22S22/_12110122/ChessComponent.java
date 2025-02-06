import java.util.List;

public abstract class ChessComponent {

    public List<ChessboardPoint> getD() {
        return d;
    }

    private List<ChessboardPoint> d = new ArrayList<>();
    
    private ChessboardPoint source;

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    private ChessColor chessColor;
    protected char name;

    public ChessComponent(){};

    public void constructor (ChessboardPoint source,ChessColor chessColor,char name){
        this.name = name;
        this.chessColor = chessColor;
        this.source = source;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString(){
        return String.valueOf(this.name);
    }
}

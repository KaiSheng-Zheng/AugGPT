import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;

    public ChessComponent() {
    }

    public void init(int x,int y,char c){
        this.source=new ChessboardPoint(x, y);
        this.name=c;
        if(c-'a'>=0&&'z'-c>=0){
            this.chessColor=ChessColor.WHITE;
            return;
        }
        if(c=='_') {
            this.chessColor = ChessColor.NONE;
            return;
        }
        this.chessColor=ChessColor.BLACK;
    }

    public ChessboardPoint getChessboardPoint() {
        return this.source;
    }

    public ChessColor getChessColor() {
        return this.chessColor;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}

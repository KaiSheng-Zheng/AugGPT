import java.util.List;

public abstract class ChessComponent {
    protected ChessComponent[][] chessComponents;
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }
    public void refresh(int x,int y,char c){
        this.source=new ChessboardPoint(x, y);
        this.name=c;
        if(c>='a'&&'z'>=c){
            this.chessColor=ChessColor.WHITE;
        }else if(c=='_') {
            this.chessColor = ChessColor.NONE;
        }else{
        this.chessColor=ChessColor.BLACK;}
    }

    public ChessComponent(){}

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessboardPoint getChessboardPoint() {
        return this.source;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

}
import java.util.List;
public abstract class  ChessComponent {
    public ChessboardPoint source;
    public ChessColor chessColor;
    public ChessComponent[][] chessComponents;
    public ChessComponent( int  x, int y  , ChessColor chessColor,char name,ChessComponent[][] e){
        source= new ChessboardPoint(x, y );
        this.chessColor = chessColor;
        this.name=  name;
        chessComponents=e;
    }
    public ChessColor getChessColor() {
        return chessColor;
    }
   public ChessComponent( ){}
    protected char name;
    public abstract List<ChessboardPoint> canMoveTo();
    public String toString() {
        return String.valueOf(this.name);
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public  void setChessComponents(ChessComponent[][] chessComponents) {
       this.chessComponents = chessComponents;
    }
}
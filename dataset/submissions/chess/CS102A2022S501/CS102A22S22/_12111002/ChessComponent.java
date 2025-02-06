import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source; // Where the chess is

    private ChessColor chessColor; // What's the color

    protected char name; // What's the name

    protected ChessComponent[][] chessComponents;

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessComponent(){
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
    public void setSource(int x,int y){
    }

    @Override
    public boolean equals(Object object){
        if (this==object){
            return true;
        }
        if (object==null||getClass()!=object.getClass()){
            return false;
        }
        ChessComponent Object=(ChessComponent) object;
        return source.equals(Object.source);
    }
    @Override
    public int hashCode(){
        return source.hashCode();
    }
}

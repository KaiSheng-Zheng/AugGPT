import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] chessComponents;

    //should design
    public ChessComponent(){};

    protected ChessComponent[][] getChessComponents(){
        return this.chessComponents;
    }

    public void setChessComponent(ChessComponent[][] x){
        this.chessComponents=x;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public ChessColor getChessColor(){
        return chessColor;
    }

    protected void setName(char x){
        this.name=x;
    }

    protected char getName(){
        return this.name;
    }

    public void setSource(ChessboardPoint x){
        this.source=x;
    }

    public void setChessColor(ChessColor x){
        this.chessColor=x;
    }

    public ChessboardPoint getChessboardPoint(){
        return source;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
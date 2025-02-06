import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public ChessComponent() {
    }

    public abstract List<ChessboardPoint> canMoveTo();


    public void setSource(ChessboardPoint c){
        this.source=c;
    }

    public void setName(char c){
        this.name=c;
    }

    public void setchessColor(ChessColor color){
        this.chessColor=color;
    }
    public ChessColor getchessColor(){
        return chessColor;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
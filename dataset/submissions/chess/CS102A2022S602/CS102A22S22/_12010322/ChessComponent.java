import java.util.List;
public abstract class ChessComponent {

    private ChessboardPoint source;

    private ChessColor chessColor;

    protected char name;

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setName(char name) {
        this.name = name;
    }
    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        this.setSource(source);
        this.setChessColor(chessColor);
        this.name=name;

    }

    public ChessboardPoint getSource() {
        return this.source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }


    public  List<ChessboardPoint> canMoveTo(){return null;}

    public  boolean canMoveTo(int x2, int y2){return true;}


    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}

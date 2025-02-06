import java.util.List;

public  abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;


    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessComponent() {
this.source=getSource();
this.chessColor=getChessColor();
this.name=getName();
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {

        return String.valueOf(this.name);
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setSource(int targetX, int targetY) {
        this.source=new ChessboardPoint(targetX,targetY);
    }
}

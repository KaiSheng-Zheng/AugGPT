import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public ChessColor getColor() {
        return chessColor;
    }
    protected ChessComponent[][] chessboard = new ChessComponent[8][8];

    public void setPos(int x, int y){
        this.source = new ChessboardPoint(x, y);
    }

    public void setColor(ChessColor chessColor){
        this.chessColor = chessColor;
    }

    public ChessComponent(){}

    public ChessComponent(ChessColor chessColor){
        this.chessColor = chessColor;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    public void beEaten(){}

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessboardPoint getSource(){
        return source;
    }
     public boolean isValid(int i) {
        if (i >= 0 && i < 8){
            return true;
        }else{
            return false;
        }
     }
     public void cleanup(){}
}


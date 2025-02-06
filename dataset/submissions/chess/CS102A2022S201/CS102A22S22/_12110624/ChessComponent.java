import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ConcreteChessGame game;

    public ChessComponent(){}
    public abstract List<ChessboardPoint> canMoveTo();

    public void setSource(ChessboardPoint source){
        this.source = source;
    }
    public ChessboardPoint getSource(){return source;}
    public void setChessColor(ChessColor chessColor){
        this.chessColor = chessColor;
    }
    public ChessColor getChessColor(){
        return chessColor;
    }
    public void setChessboard(ConcreteChessGame game){
        this.game = game;
    }
    public ConcreteChessGame getChessboard(){
        return game;
    }

    public void changePoint(int x, int y){
        source.setX(x);
        source.setY(y);
    }

    @Override
    public String toString(){
        return String.valueOf(this.name);
    }
}

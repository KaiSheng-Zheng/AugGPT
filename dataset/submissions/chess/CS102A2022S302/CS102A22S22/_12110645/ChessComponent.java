import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ConcreteChessGame concreteChessGame;

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessComponent(){

    }
    public ChessComponent(ChessboardPoint source,ChessColor chessColor,char name) {
        this.name = name;
        this.chessColor = chessColor;
        this.source = source;
    }
    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
        }


    public void setSource(int targetX, int targetY) {
        source.setX(targetX);
        source.setY(targetY);
    }

    public void setConcreteGame(ConcreteChessGame concreteChessGame) {
        this.concreteChessGame=concreteChessGame;
    }
    public ConcreteChessGame getConcreteGame(){
        return this.concreteChessGame;
    }

    public void setConcreteChessGame(ConcreteChessGame concreteChessGame) {
        this.concreteChessGame = concreteChessGame;
    }
}

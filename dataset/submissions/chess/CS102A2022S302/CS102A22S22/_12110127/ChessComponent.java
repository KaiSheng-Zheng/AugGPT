import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ConcreteChessGame fatherGame;

    //should design
    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        this.source = source;
        this.name = name;
        this.chessColor = chessColor;
    }
    public ChessComponent(){

    }


    public void setFatherGame(ConcreteChessGame Game){
        this.fatherGame = Game;
    }

    public ConcreteChessGame getFatherGame(){
        return this.fatherGame;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public ChessboardPoint getSource() {
        return this.source;
    }

    public void setSource (int x, int y) {
        this.source = new ChessboardPoint(x,y);
    }
    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessColor getChessColor() {
        return this.chessColor;
    }
}

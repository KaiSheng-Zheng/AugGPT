import java.util.List;

public abstract class ChessComponent {
    //should design
    protected ChessboardPoint source;
    protected ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;


    //should design
    public ChessComponent(){}
    public void setName(char name){
        this.name=name;
    }
    public ChessColor getChessColor() {
        return this.chessColor;
    }
    public void setChessComponents(ChessComponent[][] chessComponent){
        this.chessComponents=chessComponent;
    }
    // should design
    public abstract List<ChessboardPoint> canMoveTo();


    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}

import java.util.List;

public abstract class ChessComponent {
    //should design
    protected ChessboardPoint source=new ChessboardPoint(0,0);
    protected ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponent = new ChessComponent[8][8];


    //should design
    public ChessComponent(){}

    public ChessboardPoint getSource() {return source;}

    public void setSource(int x, int y) {
        this.source.setX(x);
        this.source.setY(y);
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {return chessColor;}

    public void setName(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    public void setChessComponent(ChessComponent[][] chessComponents) {this.chessComponent = chessComponents;}

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

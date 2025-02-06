import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public void setName(char name){this.name=name;}

    //should design
    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }



    public ChessColor getChessColor() {
        return chessColor;
    }
     public void setSource(ChessboardPoint source){this.source=source;}

    public ChessboardPoint getSource(){return this.source;}
    public void setChessColor(ChessColor chessColor){this.chessColor=chessColor;}
    public char getName(){return this.name;}
    // should design
    public abstract List<ChessboardPoint> canMoveTo();



    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}
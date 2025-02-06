import java.util.List;

public abstract class ChessComponent {

    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor;  // What's the color
    protected ChessColor chessColor1;
    protected ChessboardPoint source1;
    protected char name;			// What's the name
    protected ChessComponent[][] chessComponents=new ChessComponent[8][8];

    public ChessComponent(){}


    public abstract List<ChessboardPoint> canMoveTo();

    public void getChesComponents(ChessComponent[][] chessComponents){
        this.chessComponents=chessComponents;
    }

    public char getName(){
        return name;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessColor getChessColor(){
        return chessColor1;
    }

    public ChessboardPoint getSource(){
        return source1;
    }

}

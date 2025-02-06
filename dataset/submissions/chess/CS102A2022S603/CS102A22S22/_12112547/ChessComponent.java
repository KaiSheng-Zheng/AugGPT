import java.util.List;

public abstract class ChessComponent  {
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    protected char name; // What's the name
    public static ChessComponent[][] chessComponentsNew  = new ChessComponent[8][8];

    public ChessComponent(char name,ChessColor c,ChessboardPoint s){
        this.name = name;
        chessColor = c;
        source = s;
    }

    public ChessComponent(){}

    public ChessComponent(char name){

        this.name = name;

    }

    public ChessboardPoint getChessBoardPoint(){
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor(){
        return chessColor;
    }



    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public char getName(){
        return this.name;
    }

    public void setName(char name) {
        this.name = name;
    }



}


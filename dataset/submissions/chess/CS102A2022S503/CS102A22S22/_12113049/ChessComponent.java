import java.util.List;

public abstract class ChessComponent {
    //should design
    ChessboardPoint source; // Where the chess is
    ChessColor chessColor;// What's the color
    protected char name;// What's the name
    ChessComponent[][] chessboard;

    final int[][] move = new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
    //should design
    public ChessComponent(){}

    public ChessComponent(ChessboardPoint source, ChessColor chessColor ){
        this.source = source;
        this.chessColor = chessColor;
    }

    public void loadChessboard(ChessComponent[][] chessboard){this.chessboard = chessboard;}

    public ChessboardPoint getSource(){return source;}

    public ChessColor getComponentColor (char chess){
        if(chess == '_'){
            return ChessColor.NONE;
        }
        if(chess >='A' && chess <='Z'){
            return ChessColor.BLACK;
        }else{
            return ChessColor.WHITE;
        }
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

    protected ChessColor getChessColor(){return chessColor;}

    public void setChessboard(ChessComponent[][] chessComponents) {
        this.chessboard = chessComponents;
    }
}
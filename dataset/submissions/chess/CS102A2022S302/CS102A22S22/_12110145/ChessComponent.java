import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;   // Where the chess is
    private ChessColor chessColor;  // What's the color
    protected char name;  // What's the name

    //should design
    public ChessComponent(){}

    protected ChessComponent[][] chessboard;

    public ChessComponent(ChessComponent[][] chessboard){
        this.chessboard = chessboard;
    }

    public ChessComponent(int i, int j, char name){
        this.source = new ChessboardPoint(i,j);
        if (name<='Z' && name>='A'){
            chessColor = ChessColor.BLACK;
        }else if (name<='z' && name>='a'){
            chessColor = ChessColor.WHITE;
        }else {
            chessColor = ChessColor.NONE;
        }
    }

    public void setChessboard (ChessComponent[][] chessboard){
        this.chessboard = chessboard;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        if(this.getChessColor()==ChessColor.WHITE){
            return String.valueOf((char)(this.name-'B'+'b'));
        }
        else {
        return String.valueOf(this.name);}
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

}



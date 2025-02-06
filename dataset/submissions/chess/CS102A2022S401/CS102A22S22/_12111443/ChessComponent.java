import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source = new ChessboardPoint(0,0); // Where the chess is
    private ChessColor chessColor;  // What's the color
    protected char name;			// What's the name
    protected ChessComponent[][] currentChessboard;

    public ChessComponent(){}

    public void setSource(int x,int y){
        source.setX(x);
        source.setY(y);
    }

    public ChessboardPoint getSource(){
        return source;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    //setColor
    public void setChessColor(ChessColor color){
        this.chessColor=color;
    }

    public ChessColor getChessColor(){
        return chessColor;
    }

    public void setName(){}

    public char getName() {
        return name;
    }


    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public void setCurrentChessboard(ChessComponent[][] currentChessboard) {
        this.currentChessboard = currentChessboard;
    }

    public void clearCurrentChessboard(){
        this.currentChessboard = null;
    }


}

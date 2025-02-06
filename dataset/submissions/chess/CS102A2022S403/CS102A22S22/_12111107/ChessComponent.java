import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private static final Color[] BACKGROUND_COLORS = {Color.WHITE, Color.BLACK};
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public void setChessboardPoint(ChessboardPoint source) {
        this.source = source;
    }
    public ChessboardPoint getSource() {
        return source;
    }

    public void setChessColor(ChessColor chessColor){
        this.chessColor = chessColor;
    }
    public ChessColor getChessColor(){return chessColor;}

    protected ChessComponent[][] chessboard;

    public ChessComponent (ChessComponent[][] chessboard){
        this.chessboard = chessboard;
    }

    public void  setName(char name){
        this.name = name;
    }
    public char getName() {
        return name;
    }

    public ChessComponent(){
    }
    //should design
    public ChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
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
public void setSource(ChessboardPoint chessboardPoint) {
        this.source = chessboardPoint;
    }

}
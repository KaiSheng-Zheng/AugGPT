import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {

    protected List<ChessboardPoint> cmt=new ArrayList<>();
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    protected ChessComponent[][] chessComponents;

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessComponent(){}
    //should design

    public ChessComponent(char c, int x, int y,ChessComponent[][] chessComponents){
        this.chessComponents=chessComponents;
        setChessColor(!(c=='_')?c>'a'&&c<'z'?ChessColor.WHITE:ChessColor.BLACK:ChessColor.NONE);
        setSource(new ChessboardPoint(x,y));
        name=c;
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

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessComponent getChessComponent(ChessboardPoint chessboardPoint){
        return chessComponents[chessboardPoint.getX()][chessboardPoint.getY()];
    }
}

import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private int cnt;

    //should design
    public ChessComponent(){}

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

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

    public ChessColor getChessColor(){
        return ChessColor.WHITE;
    }

    public  int getCnt(){
        return 0;
    }

    public char getName(){return name;}


}

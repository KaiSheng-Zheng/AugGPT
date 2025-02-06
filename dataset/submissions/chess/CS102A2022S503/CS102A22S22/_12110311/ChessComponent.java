import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    PriSort priSort = new PriSort();


    ChessComponent[][] chessComponents;


    public ChessComponent(){}

    public ChessComponent(char name, ChessColor chessColor,ChessboardPoint source,ChessComponent[][] chessComponents) {
        this.name = name;
        this.chessColor = chessColor;
        this.source = source;
        this.chessComponents = chessComponents;
    }

    public ChessComponent(char name, ChessColor chessColor,ChessboardPoint source){
        this.name = name;
        this.chessColor = chessColor;
        this.source = source;
    }


    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessboardPoint getSource(){return this.source;}

    public ChessColor getChessColor(){return this.chessColor;}

    public void setChessboardPoint(int x,int y){
        source = new ChessboardPoint(x,y);
    }
}
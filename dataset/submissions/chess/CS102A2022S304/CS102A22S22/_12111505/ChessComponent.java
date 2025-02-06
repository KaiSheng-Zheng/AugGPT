import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    private ConcreteChessGame game;

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setGame(ConcreteChessGame game) {
        this.game = game;
    }

    public ConcreteChessGame getGame() {
        return this.game;
    }

    protected char name;

    //should design
    public ChessComponent(ChessColor chessColor,ChessboardPoint source,char name){
        this.chessColor=chessColor;
        this.source=source;
        this.name=name;
    }
    public ChessComponent() {
    }

    public abstract List<ChessboardPoint> canMoveTo();

    public char getName() {
        return this.name;
    }
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    public ChessboardPoint getSource() {
        return this.source;
    }
    public void setSource(ChessboardPoint p) {
        this.source=p;
    }


}

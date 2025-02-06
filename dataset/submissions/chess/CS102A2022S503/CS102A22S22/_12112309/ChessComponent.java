import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent  {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
protected ConcreteChessGame concreteChessGame;
    //should design
    public ChessComponent(){}

    public void setConcreteChessGame(ConcreteChessGame concreteChessGame) {
        this.concreteChessGame = concreteChessGame;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }



    public ChessComponent(char name, ChessColor color, ChessboardPoint source) {
        this.name=name;
        this.chessColor = color;
        this.source=source;
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

    public ChessColor getChessColor() {
        return chessColor;
    }
}

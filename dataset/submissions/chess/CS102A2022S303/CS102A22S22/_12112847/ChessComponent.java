import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public ConcreteChessGame game;
    List<ChessboardPoint> re = new ArrayList<>();

    public ChessboardPoint getSource() {
        return source;
    }

    //should design
    public ChessComponent(){}

//    public ChessboardPoint getSource() {
//        return source;
//    }

    public ChessComponent(char name, ConcreteChessGame game, ChessboardPoint source){
        this.name=name;
        this.game = game;
        this.source = source;
        if (name >= 65 && name <= 90){
            this.chessColor = ChessColor.BLACK;
        } else if (name >= 97 && name <= 122){
            this.chessColor = ChessColor.WHITE;
        } else {
            this.chessColor = ChessColor.NONE;
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
        return String.valueOf(name);
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
}

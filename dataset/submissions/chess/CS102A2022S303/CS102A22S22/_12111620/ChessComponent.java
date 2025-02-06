import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ChessComponent[][] now;


    //should design
    public ChessComponent(){}
    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
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

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public ChessComponent[][] getNow() {
        return now;
    }

    public void setNow(ChessComponent[][] now) {
        this.now = now;
    }

    public List<ChessboardPoint> sort(List<ChessboardPoint> canChessMove){
        ArrayList<ChessboardPoint> newCanChessMove = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < canChessMove.size(); k++) {
                    if (canChessMove.get(k).getX() == i && canChessMove.get(k).getY() == j){
                        newCanChessMove.add(canChessMove.get(k));
                    }
                }
            }
        }
        return newCanChessMove;
    }
}

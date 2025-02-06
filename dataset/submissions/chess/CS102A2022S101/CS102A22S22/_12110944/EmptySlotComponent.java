import java.util.ArrayList;
import java.util.List;

public class EmptySlotComponent extends ChessComponent{
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    protected char name; // What's the name
    private ChessComponent[][] chesscomponents;
    public EmptySlotComponent(char name, ChessColor chessColor,ChessComponent[][] chesscomponents, ChessboardPoint source) {
        super(name, chessColor, chesscomponents,source);
        this.name=name;
        this.source=source;
        this.chessColor = chessColor;
        this.chesscomponents=chesscomponents;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {

        return new ArrayList<>();
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        return false;
    }
}

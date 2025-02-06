import java.util.*;

public class EmptySlotComponent extends ChessComponent{
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    protected char name; // What's the name

    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source,chessColor,name);
        this.source = super.getSource();
        this.chessColor = super.getChessColor();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {


        List<ChessboardPoint> canmove = new ArrayList<>();
        return canmove;
    }
}
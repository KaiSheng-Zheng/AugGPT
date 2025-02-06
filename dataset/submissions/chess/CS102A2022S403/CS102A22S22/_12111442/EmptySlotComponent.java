import java.util.ArrayList;
import java.util.List;

class EmptySlotComponent extends ChessComponent{
    private ChessboardPoint source; // Where the chess is
    private ChessColor chessColor; // What's the color
    public EmptySlotComponent(ChessColor chessColor,ChessboardPoint source){
        this.chessColor=chessColor;
        this.source=source;
        name='_';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
    public ChessColor getChessColor() {
        return chessColor;
    }
}

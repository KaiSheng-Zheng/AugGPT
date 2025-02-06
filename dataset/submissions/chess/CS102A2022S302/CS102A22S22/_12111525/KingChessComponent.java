import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    public KingChessComponent(ChessboardPoint source,ChessColor chessColor) {
        super(source,chessColor);
        this.chessColor = chessColor;
        this.source = source;
        if (chessColor == ChessColor.BLACK){
            name = 'K';
        }
        if (chessColor == ChessColor.WHITE){
            name = 'k';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> F = new ArrayList<>();

        return F;
    }
}

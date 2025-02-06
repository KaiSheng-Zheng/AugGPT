import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor,char name) {
        this.source = source;
        this.chessColor = chessColor;
        if (chessColor.equals(ChessColor.BLACK)){
            name='K';
        }
        if (chessColor.equals(ChessColor.WHITE)){
            name='k';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arry = new ArrayList<>();
        return arry;
    }
}
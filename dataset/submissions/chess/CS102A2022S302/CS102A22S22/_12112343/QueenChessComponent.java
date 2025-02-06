import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent() {
    }

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char c) {
        this.setSource(source);
        this.setChessColor(chessColor);
        this.name = c;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent c1 = new RookChessComponent(this.getSource(),this.getChessColor(),'R');
        c1.setChessComponents(chessComponents);
        ChessComponent c2 = new BishopChessComponent(this.getSource(),this.getChessColor(),'B');
        c2.setChessComponents(chessComponents);
        List<ChessboardPoint> result = new ArrayList<>(c1.canMoveTo());
        result.addAll(c2.canMoveTo());
        return result;
    }
}
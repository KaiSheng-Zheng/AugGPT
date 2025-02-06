
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessColor color){
        this.setChessColor(color);
        if (color==ChessColor.WHITE) {
            this.name = 'b';
        }else if (color == ChessColor.BLACK){
            this.name = 'B';
        }else{
            this.name = '_';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}
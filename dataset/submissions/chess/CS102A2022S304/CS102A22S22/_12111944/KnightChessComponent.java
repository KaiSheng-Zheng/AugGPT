
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessColor color){
        this.setChessColor(color);
        if (color==ChessColor.WHITE) {
            this.name = 'n';
        }else if (color==ChessColor.BLACK){
            this.name = 'N';
        }else{
            this.name = '_';
        }
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}

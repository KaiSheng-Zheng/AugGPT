
import java.util.List;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessColor color){
        this.setChessColor(color);
        if (color==ChessColor.WHITE) {
            this.name = 'r';
        }else if (color==ChessColor.BLACK){
            this.name = 'R';
        }
        else{
            this.name = '_';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return null;
    }
}


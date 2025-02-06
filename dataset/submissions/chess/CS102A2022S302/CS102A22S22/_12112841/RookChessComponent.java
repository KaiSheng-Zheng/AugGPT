import java.util.List;
import java.util.ArrayList;

public class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessboardPoint chessboardPoint,ChessColor color) {
        super(chessboardPoint,color);
        if (color == ChessColor.BLACK){
            this.name = 'R';
        }else{
            this.name = 'r';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canmoveto = new ArrayList<>();
        for (int i = 1; i < 8; i += 2) {
            int x = source.getX();
            int y = source.getY();
            x += destination[i][0];
            y += destination[i][1];
            for (x = 0; x < 8; x += destination[i][0]) {
                for (y = 0; y < 8; y += destination[i][1]) {
                    if (PlayerColor(chessComponents[x][y].toString().charAt(0)) == chessColor) {
                        canmoveto.add(new ChessboardPoint(x, y));
                        break;
                    }
                    else break;
                }
            }
        }
        return canmoveto;
    }
}
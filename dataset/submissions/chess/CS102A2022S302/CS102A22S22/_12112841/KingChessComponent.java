import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
       public KingChessComponent(ChessboardPoint source,ChessColor color) {
        super(source, color);
        if (color == ChessColor.WHITE) {
            this.name = 'k';
        } else {
            this.name = 'K';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canmoveto = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int x = destination[i][0];
            int y = destination[i][1];
            ChessboardPoint moveto = source.offset(x,y);
//            ChessComponent newcomponent = chessComponents[moveto.getX()][moveto.getY()];
//            char player = newcomponent.toString().charAt(0);
//            ChessColor newcolor = PlayerColor(player);
            if (moveto != null ){
                if (PlayerColor(chessComponents[moveto.getX()][moveto.getY()].toString().charAt(0)) != chessColor){
                    canmoveto.add(moveto);
                }
            }
        }
        return canmoveto;
    }        
}
import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {


    public KingChessComponent(ChessColor color, int x, int y) {
        super.setChessColor(color);
        if (color == ChessColor.WHITE) {
            name = 'k';
        } else {
            name = 'K';
        }
        super.setSource(new ChessboardPoint(x,y));
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Chessboard.chessboard[i][j].getChessColor() != super.getChessColor()){
                    if (Math.abs(i- super.getSource().getX())+Math.abs(j-super.getSource().getY())==1
                            ||(Math.abs(i- super.getSource().getX())==1&&Math.abs(j-super.getSource().getY())==1)){
                        list.add(new ChessboardPoint(i,j));
                    }
                }
            }
        }
        return list;
    }
}

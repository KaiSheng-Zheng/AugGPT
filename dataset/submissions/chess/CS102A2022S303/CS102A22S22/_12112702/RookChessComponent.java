import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> can = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Math.abs(super.getSource().getX() - i) == 2 && Math.abs(super.getSource().getY() - j) == 1) {
                    can.add(new ChessboardPoint(i,j));
                }
                if (Math.abs(super.getSource().getX() - i) == 1 && Math.abs(super.getSource().getY() - j) == 2) {
                    can.add(new ChessboardPoint(i,j));
                }
            }
        }
        return can;
    }

    public RookChessComponent (int x, int y, boolean player) {
        ChessboardPoint location = new ChessboardPoint(x,y);
        super.setSource(location);
        if (player){
            super.setChessColor(ChessColor.BLACK);
            super.setName('R');
        }else {
            super.setChessColor(ChessColor.WHITE);
            super.setName('r');
        }
    }
}
